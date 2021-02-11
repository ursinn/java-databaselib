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

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * SQL Database Interface
 *
 * @author Ursin Filli
 * @version 1.0
 * @since 1.0
 */
public interface ISql {

    /**
     * Connect to Database
     *
     * @throws SQLException in Case of Error
     * @since 1.0
     */
    void connect() throws SQLException;

    /**
     * Close Connection to Database
     *
     * @throws SQLException in Case of Error
     * @since 1.0
     */
    void close() throws SQLException;

    /**
     * Check if a Database Connection Exists
     *
     * @return Status of Connection
     * @throws SQLException in Case of Error
     * @since 1.0
     */
    boolean isConnected() throws SQLException;

    /**
     * Execute SQL on Database
     *
     * @param sql SQL to Execute
     * @return Amount of Changed Data
     * @throws SQLException in Case of Error
     * @since 1.0
     */
    int update(String sql) throws SQLException;

    /**
     * Execute SQL on Database and Return Id of new Row
     *
     * @param sql SQL to Execute
     * @return PrimaryKey ID of new Row
     * @throws SQLException in Case of Error
     * @since 1.0
     */
    long updateId(String sql) throws SQLException;

    /**
     * Return Data from Database
     *
     * @param sql SQL to Execute
     * @return ResultSet with Data
     * @throws SQLException in Case of Error
     * @since 1.0
     */
    ResultSet get(String sql) throws SQLException;
}
