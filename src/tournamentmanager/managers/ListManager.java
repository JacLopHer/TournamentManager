/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tournamentmanager.managers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import tournamentmanager.database.ConnectionWrapper;
import tournamentmanager.entities.Player;

/**
 *
 * @author Jacinto López Hernández
 */
public class ListManager {

    Connection cnx;

    public ListManager() {
        cnx = ConnectionWrapper.mySQLConnector.getCnx();
    }
   
    public String getPlayerList(File list) {
        String textList = "";
        Scanner sc = new Scanner(System.in);
        try {
            sc = new Scanner(list);         
            while(sc.hasNextLine()){
                textList += sc.nextLine();
            }      
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ListManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sc.close();
        }
        return textList;
    }
}
