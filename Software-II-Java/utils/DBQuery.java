/**
 * @author Toni Fields
 *
 * Student: Toni Fields
 * Student ID: #001307628
 * Course: C195 - Software II
 * Project: Scheduling Application
 */

package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBQuery {

    // create Statement reference
    private static PreparedStatement statement;

    //create Statement object
    public static void setPreparedStatement(Connection conn, String sqlStatement) throws SQLException {
        statement = conn.prepareStatement(sqlStatement);
    }

    //return Statement object
    public static PreparedStatement getPreparedStatement() {
        return statement;
    }
}
