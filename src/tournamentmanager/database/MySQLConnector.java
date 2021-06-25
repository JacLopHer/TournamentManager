/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tournamentmanager.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jacinto López Hernández
 */
public class MySQLConnector {
    final String SERVER = "jdbc:mysql://sql11.freemysqlhosting.net:3306/sql11419899?zeroDateTimeBehavior=convertToNull" ;
    final String USER = "sql11419899";
    final String PWD = "vJuNjlZCtu";
    Connection cnx;

    public MySQLConnector() {
        try {
            Class.forName("com.mysql.jdbc");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySQLConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            cnx = DriverManager.getConnection(SERVER, USER, PWD);
            
            System.out.println(cnx.getCatalog());
                    } catch (SQLException ex) {
            Logger.getLogger(MySQLConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
    
    public Connection getCnx(){
        return cnx;
    }
    
    public void cnxCommit(){
        try {
            cnx.commit();
        } catch (SQLException ex) {
            Logger.getLogger(MySQLConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void cnxClose(){
        try {
            cnx.close();
        } catch (SQLException ex) {
            Logger.getLogger(MySQLConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
