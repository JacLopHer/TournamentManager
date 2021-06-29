/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tournamentmanager.managers;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import tournamentmanager.entities.Tournament;

/**
 *
 * @author Jacinto López Hernández
 */
public class TournamentManager {

    Connection cnx = tournamentmanager.database.ConnectionWrapper.mySQLConnector.getCnx();

    public boolean createTournament(Tournament tourney) {

        return false;
    }

    public ArrayList<Tournament> getTournaments() {
        Statement sta;
        ArrayList<Tournament> tournaments = new ArrayList<>();
        try {
            sta = cnx.createStatement();
            String query = "SELECT * from tournaments";
            ResultSet rs = sta.executeQuery(query);
            if(rs.first()){
                do{
                    int rowid = rs.getInt(1);
                    String name = rs.getString(2);
                    Date date = rs.getDate(3);
                    int rounds = rs.getInt(4);
                    int num_players = rs.getInt(5);
                    Tournament newTourney = new Tournament(rounds, date, name, num_players,rowid);
                    tournaments.add(newTourney);
                }while (rs.next());
            }
            rs.close();
            return tournaments;
        } catch (SQLException ex) {
            Logger.getLogger(TournamentManager.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return tournaments;
    }
}
