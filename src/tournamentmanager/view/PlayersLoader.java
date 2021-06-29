/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tournamentmanager.view;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import tournamentmanager.entities.Player;

/**
 *
 * @author Jacinto López Hernández
 */
public class PlayersLoader extends JTable {
    ArrayList<Player> players;

    public PlayersLoader(ArrayList<Player> players) {
        this.players = players;
    }
    
    public DefaultTableModel getModelPlayers(){
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Name");
        tableModel.addColumn("Nickname");
        tableModel.addColumn("Faction");
        
        for(Player player : players){
            Object [] row = {player.getName(),player.getNickname(),player.getFactions()};
            tableModel.addRow(row);
        }
        return tableModel;
        
    }
}
