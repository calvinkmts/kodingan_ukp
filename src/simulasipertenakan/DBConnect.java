/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulasipertenakan;

import java.sql.*;

/**
 *
 * @author calvi
 */
public class DBConnect {
    
    private Connection con;
    private Statement statement;
    private ResultSet resultQuery;
    
    public DBConnect() {
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/simulasi_peternakan", "root", "");
            statement = con.createStatement();
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: "+e);
        }
    }
    
    public void getData() {
        try {
            
            String query = "SELECT * FROM history";
            resultQuery = statement.executeQuery(query);
            
            
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
    }
    
    public void insertData(Integer sapi, Integer ayam, Integer domba, Integer hari, Integer total) {
        try {
            
            String query = "INSERT INTO `history` (`id`, `sapi`, `ayam`, `domba`, `hari`, `total`) "
                    + "VALUES (NULL, '" + sapi + "', '" + ayam + "', '" + domba + "', '" + hari + "', '" + total + "')";
            statement.executeUpdate(query);
            
        } catch (SQLException e) {
            System.out.println("Error Insert: "+e);
        }
    }
}
