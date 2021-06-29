/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tournamentmanager.view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import javax.swing.UIManager;
import tournamentmanager.entities.Player;

/**
 *
 * @author Jacinto López Hernández
 */
public class ValidationMethods {

    /**
     * Checks wether a jtextfield is empty or not
     * @param jtxt to check
     * @return true - if it's empty, false otherwise
     */
    public static boolean isInputEmpty(JTextField jtxt) {
        if (jtxt.getText().equals("")) {
            jtxt.setBackground(new java.awt.Color(156, 56, 35));
            jtxt.putClientProperty("JComponent.outline", "error");
            return true;
        }
        jtxt.setBackground(UIManager.getLookAndFeelDefaults().getColor(jtxt));
        return false;
    }
    
    /**
     * Checks wether a list roster is valid or not
     * @param list to be checked
     * @return true - if the list is valid, false - otherwise
     */
    public static boolean isListValid(File list) {
        BufferedReader bw = null;
        if (list.canRead()) {
            try {
                bw = new BufferedReader(new FileReader(list));
                String lastLine;
                while ((lastLine = bw.readLine()) != null) {
                    if (lastLine.contains("Created with BattleScribe")) {
                        return true;
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(ValidationMethods.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    if (bw != null) {
                        bw.close();
                    }
                } catch (IOException ex) {
                    Logger.getLogger(ValidationMethods.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }
    
    public static boolean isPlayerLoaded(Player player){
        return MainView.players.contains(player);
    }
}
