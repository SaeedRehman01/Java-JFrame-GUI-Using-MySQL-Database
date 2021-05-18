/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sports.activities.gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author saeed
 */
public class DatabaseManager {

    private final String userName = "";
    private final String userPassword = "";
    private final String databaseName = "SportsActivities";

    private Connection con;

    /**
     * this method will connect the java program to the necessary database in
     * mySQL
     *
     * @return the connection con will be returned with a result whether the
     * program is connected or not.
     * @throws SQLException if the connection is not connected the catch block
     * will return an error.
     */
    private Connection connectionSQL() throws SQLException {

        try {

            if (con == null) {

                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + databaseName, userName, userPassword);
            }

        } catch (Exception e) {
            System.out.println("Not Connected, Error : " + e.getMessage());

        }
        return con;
    }

    /**
     *
     * @param query - executes mySQL quires
     * @return table model based on the query
     * @throws SQLException
     */
    public DefaultTableModel TableModel(String query) throws SQLException {
        Statement stmt = connectionSQL().createStatement();
        ResultSet rs = stmt.executeQuery(query);
        DefaultTableModel tblModel = buildTableModel(rs);
        rs.close();
        stmt.close();
        return tblModel;
    }

    /**
     * creates a mySQL insert query for the Activity Type table, which will be used in
     * the DatabaseGUI
     *
     * @param at - uses the getters from the ActivityTypeTable class to set the
     * strings in the insert positions
     * @return mySQL query for inserting a row
     * @throws SQLException
     */
    public String insertActivity(ActivityTypeTable at) throws SQLException {

        String sql = "INSERT INTO ActivityType (activityType, startDate, endDate) VALUES ( ?, ?, ?)";
        PreparedStatement insertStm = connectionSQL().prepareStatement(sql);
        insertStm.setString(1, at.getActivityType());
        insertStm.setString(2, at.getActivityStartDate());
        insertStm.setString(3, at.getActivityEndDate());
        insertStm.executeUpdate();
        insertStm.close();
        return sql;
    }

    /**
     * creates an mySQL delete query based on the activityType attribute
     * for the Activity Type table
     *
     * @param at - uses the getActivityType() method in the ActivityTypeTable class 
     * to initialise the delete statement
     * @return mySQL query for deleting a row
     * @throws SQLException
     */
    public String deleteActivity(ActivityTypeTable at) throws SQLException {
        String sql = "DELETE FROM ActivityType WHERE activityType = ?";
        PreparedStatement deleteStm = connectionSQL().prepareStatement(sql);
        deleteStm.setString(1, at.getActivityType());
        deleteStm.execute();
        deleteStm.close();
        return sql;
    }

    /**
     * creates a mySQL update query for the Activity Type table
     *
     * @param at takes the getters from the ActivityTypeTable class to create the
     * update statements and set the attributes to their positions.
     * @return mySQL query for updating a row
     * @throws SQLException
     */
    public String updateActivity(ActivityTypeTable at) throws SQLException {
        String sql = "UPDATE ActivityType SET startDate = ?, endDate = ? WHERE activityType = ?";
        PreparedStatement updateStm = connectionSQL().prepareStatement(sql);
        updateStm.setString(3, at.getActivityType());
        updateStm.setString(1, at.getActivityStartDate());
        updateStm.setString(2, at.getActivityEndDate());
        updateStm.executeUpdate();
        updateStm.close();
        return sql;
    }

    /**
     * builds a table model to view the result set
     * table model size will differ according to the queries
     *
     * @param rs retrieving the ResultSet object
     * @throws SQLException 
     */
    public static DefaultTableModel buildTableModel(ResultSet rs) throws SQLException {

        ResultSetMetaData metaData = rs.getMetaData();
        Vector<String> columnNames = new Vector<String>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<Object>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(rs.getObject(columnIndex));
            }
            data.add(vector);
        }
        return new DefaultTableModel(data, columnNames);
    }
}
