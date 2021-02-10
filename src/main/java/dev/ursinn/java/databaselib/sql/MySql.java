/*
 * MIT License
 *
 * Copyright (c) 2020 - 2021 Ursin Filli
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

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * MySQL / MariaDB Database Implementation
 *
 * @author Ursin Filli
 * @version 1.0
 * @since 1.0
 */
public class MySql extends Sql {

    private final String host;
    private final String port;
    private final String database;
    private final String username;
    private final String password;

    /**
     * Constructor.
     *
     * @param host     Host
     * @param port     Port
     * @param database Database
     * @param username Username
     * @param password Password
     * @since 1.0
     */
    public MySql(String host, String port, String database, String username, String password) {
        this.host = host;
        this.port = port;
        this.database = database;
        this.username = username;
        this.password = password;
    }

    @Override
    public void connect() throws SQLException {
        if (isConnected()) {
            close();
        }
        connection = DriverManager.getConnection(
                "jdbc:mysql://" + this.host + ":" + this.port + "/" + this.database,
                this.username, this.password);
    }
}
