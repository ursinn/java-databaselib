/*
 * MIT License
 *
 * Copyright (c) 2020 Ursin Filli
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */

package dev.ursinn.java.databaselib.sql;

import java.sql.*;

/**
 * SQL Database Template
 *
 * @author Ursin Filli
 * @version 1.0
 * @since 1.0
 */
public class Sql implements ISql {

    protected Connection connection;

    /**
     * Constructor.
     */
    public Sql() {
        this.connection = null;
    }

    @Override
    public void connect() throws SQLException {
        if (isConnected()) {
            close();
        }
        connection = null;
    }

    @Override
    public final void close() throws SQLException {
        if (isConnected()) {
            connection.close();
        }
    }

    @Override
    public final boolean isConnected() throws SQLException {
        if (connection != null) {
            return !connection.isClosed();
        }
        return false;
    }

    @Override
    public final int update(String sql) throws SQLException {
        if (!isConnected()) {
            connect();
        }
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            return ps.executeUpdate();
        }
    }

    @Override
    public final long updateId(String sql) throws SQLException {
        if (!isConnected()) {
            connect();
        }
        try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                return rs.getLong(1);
            }
        }
        return 0;
    }

    @Override
    public final ResultSet get(String sql) throws SQLException {
        if (!isConnected()) {
            connect();
        }
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            return ps.executeQuery();
        }
    }
}
