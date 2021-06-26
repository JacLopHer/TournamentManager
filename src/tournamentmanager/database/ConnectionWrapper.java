/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tournamentmanager.database;

/**
 *
 * @author Jacinto López Hernández
 */
public class ConnectionWrapper {
    public static MySQLConnector mySQLConnector;
    
    public static MySQLConnector initConnection(){
        mySQLConnector = new MySQLConnector();
        return mySQLConnector;
    }
}
