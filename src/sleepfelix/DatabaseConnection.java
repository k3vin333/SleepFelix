/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sleepfelix;

/**
 *
 * @author k3vin
 */

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    public Connection databaseLink;
    
    public Connection getConnection(){
  
        String databaseName = "usersdb";
        String databaseUser = "root";
        String databasePassword = "!felix20";
        
        String url = "jdbc:mysql://localhost/" + databaseName;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
        } catch (Exception e){
            e.printStackTrace();
        }
        return databaseLink;
    }
    
}
