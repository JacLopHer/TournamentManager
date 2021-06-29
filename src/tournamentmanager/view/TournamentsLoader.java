/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tournamentmanager.view;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import tournamentmanager.entities.Tournament;

/**
 *
 * @author Jacinto López Hernández
 */
public class TournamentsLoader {
    ArrayList<Tournament> tournaments;

    public TournamentsLoader(ArrayList<Tournament> tournaments) {
        this.tournaments = tournaments;
    }
    
    /**
     * Builds the Model for the tournament Table
     * @return DefaultTableModel 
     */
    public DefaultTableModel getTournamentsModel(){
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Name");
        dtm.addColumn("Date");
        dtm.addColumn("Núm. Rounds");
        dtm.addColumn("Num. Players");
        
        for(Tournament tournament : tournaments){
            Object [] row = {tournament.getTournament_name(), tournament.getDate(), tournament.getRounds(), tournament.getNumPlayers()};
            dtm.addRow(row);
        } 
        return dtm;      
    }
}
