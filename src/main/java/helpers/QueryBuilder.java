/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helpers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import utils.DbConnection;

/**
 *
 * @author Vishva Kulathunga
 */
public class QueryBuilder {

    private String QUERY;
    private ResultSet GET_DATA;

    public static enum TYPE {
        MANIPULATE,
        FETCH
    }

    private String getQUERY() {
        return QUERY;
    }

    private void setQUERY(String QUERY) {
        this.QUERY = QUERY;
    }

    public ResultSet getGET_DATA() {
        return GET_DATA;
    }

    private void setGET_DATA(ResultSet GET_DATA) {
        this.GET_DATA = GET_DATA;
    }

    public QueryBuilder(String query, TYPE methodType) {
        if (query.isEmpty()) {
            System.err.println("Query parameter is empty");
        } else {
            this.setQUERY(query);
            if (methodType.FETCH == TYPE.FETCH) {
                executeFetchQuerries();
            } else if (methodType.MANIPULATE == TYPE.MANIPULATE) {
                executeManipulateQuerries();
            } else {
                System.err.println("Type param is invalid");
            }
        }
    }

    private void executeManipulateQuerries() {
        try {

            DbConnection connection = new DbConnection();
            Statement st = connection.getConnection().createStatement();
            st.executeUpdate(this.getQUERY());
            connection.getConnection().close();

        } catch (SQLException e) {

            System.err.println("Error running manipulate query " + e);
        }
    }

    private void executeFetchQuerries() {
        try {

            DbConnection connection = new DbConnection();
            Statement st = connection.getConnection().createStatement();
            this.setGET_DATA(st.executeQuery(this.getQUERY()));
//            connection.getConnection().close();

        } catch (SQLException e) {
            
            System.err.println("Error running fetch query " + e);
        }
    }

}
