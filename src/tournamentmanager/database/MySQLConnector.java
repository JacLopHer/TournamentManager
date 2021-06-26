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

    final String SERVER = "jdbc:mysql://localhost:3306/adeptusluditorum?";
    final String USER = "root";
    final String PWD = "changeme";
    Connection cnx;

    public MySQLConnector() {
        try {
            cnx = DriverManager.getConnection(SERVER, USER, PWD);
        } catch (SQLException ex) {
            Logger.getLogger(MySQLConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getCnx() {
        return cnx;
    }

    public void cnxCommit() {
        try {
            cnx.commit();
        } catch (SQLException ex) {
            Logger.getLogger(MySQLConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cnxClose() {
        try {
            cnx.close();
        } catch (SQLException ex) {
            Logger.getLogger(MySQLConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
