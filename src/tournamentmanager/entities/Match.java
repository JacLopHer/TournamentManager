/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tournamentmanager.entities;

/**
 *
 * @author Jacinto López Hernández
 */
public class Match {
    private Player player1;
    private Player player2;
    private String mission;
    private String player_who_started;
    private int player1Score;
    private int player2Score;

    public Match(Player player1, Player player2, String mission) {
        this.player1 = player1;
        this.player2 = player2;
        this.mission = mission;
    }

    /**
     * Check if a match between both players already happened
     * @param player1
     * @param player2
     * @return true - if this match has happened
     */
    public boolean hasPlayers(Player player1, Player player2){
        return player1.equals(this.player1) && player2.equals(this.player2)
                || player1.equals(this.player2) && player2.equals(this.player1);
    }
    
    
    /**
     * Assigns the score to the players after the match
     * @param player1Score
     * @param player2Score 
     */
    public void assignMatchScore(int player1Score, int player2Score){
        this.player1Score = player1Score;
        this.player2Score = player2Score;
        player1.setSecondaryScore(player1Score);
        player2.setSecondaryScore(player2Score);
        
        if(player1Score > player2Score){
            player1.setScore(3);
        } else if (player2Score > player1Score){
            player2.setScore(3);
        } else {
            player1.setScore(1);
            player2.setScore(1);
        }
    }
    
    /**
     * @return the player1
     */
    public Player getPlayer1() {
        return player1;
    }

    /**
     * @param player1 the player1 to set
     */
    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    /**
     * @return the player2
     */
    public Player getPlayer2() {
        return player2;
    }

    /**
     * @param player2 the player2 to set
     */
    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    /**
     * @return the mission
     */
    public String getMission() {
        return mission;
    }

    /**
     * @param mission the mission to set
     */
    public void setMission(String mission) {
        this.mission = mission;
    }

    /**
     * @return the player_who_started
     */
    public String getPlayer_who_started() {
        return player_who_started;
    }

    /**
     * @param player_who_started the player_who_started to set
     */
    public void setPlayer_who_started(String player_who_started) {
        this.player_who_started = player_who_started;
    }

    /**
     * @return the player1Score
     */
    public int getPlayer1Score() {
        return player1Score;
    }

    /**
     * @param player1Score the player1Score to set
     */
    public void setPlayer1Score(int player1Score) {
        this.player1Score = player1Score;
    }

    /**
     * @return the player2Score
     */
    public int getPlayer2Score() {
        return player2Score;
    }

    /**
     * @param player2Score the player2Score to set
     */
    public void setPlayer2Score(int player2Score) {
        this.player2Score = player2Score;
    }

    
}
