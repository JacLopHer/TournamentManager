/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tournamentmanager.managers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import tournamentmanager.database.ConnectionWrapper;
import tournamentmanager.entities.Player;
import tournamentmanager.entities.Tournament;

/**
 *
 * @author Jacinto López Hernández
 */
public class PlayerManager {

    private Connection cnx;

    public PlayerManager() {
        cnx = ConnectionWrapper.mySQLConnector.getCnx();
    }

    public void addPlayer(Player player) {

    }

    public boolean hasPlayer() {
        return false;
    }

    public ArrayList<Player> getPlayers(){
        ArrayList<Player> players = new ArrayList<>();
        try {
            Statement sta = cnx.createStatement();
            String query = "SELECT p.name,p.nickname,p.factions FROM players as p";
            ResultSet rs = sta.executeQuery(query);
            if (rs.first()) {
                do {
                    String name = rs.getString(1);
                    String nickname = rs.getString(2);
                    String faction = rs.getString(3);
                    Player player = new Player(name, nickname, faction);
                    players.add(player);
                } while (rs.next());
            }
            rs.close();
            return players;
        } catch (SQLException ex) {
            Logger.getLogger(PlayerManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return players;
    }
    
    public ArrayList<Player> getTournamentPlayers(Tournament tourney) {
        ArrayList<Player> players = new ArrayList<>();
        try {
            String query = "SELECT p.name,p.nickname,p.factions,pt.list FROM `player_tourney` as pt \n" +
                            "inner join players as p \n" +
                            "on p.nickname = pt.player_id\n" +
                            "where pt.tourney_id = ?";
            
            PreparedStatement sta = cnx.prepareStatement(query);
            sta.setInt(1, tourney.getRowid());
            try (ResultSet rs = sta.executeQuery()) {
                if (rs.first()) {
                    do {
                        String name = rs.getString(1);
                        String nickname = rs.getString(2);
                        String faction = rs.getString(3);
                        String list = rs.getString(4);
                        Player player = new Player(name, nickname, faction,list);
                        players.add(player);
                    } while (rs.next());
                }
            }
            return players;
        } catch (SQLException ex) {
            Logger.getLogger(PlayerManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return players;
    }

}
