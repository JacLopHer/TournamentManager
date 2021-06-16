/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tournamentmanager.entities;

import java.util.ArrayList;

/**
 *
 * @author Jacinto López Hernández
 */
public class RoundMatching {
    private ArrayList<Match> matches = new ArrayList<>();
    private int round;

    public RoundMatching(int round) {
        this.round = round;
    }
    
    public void addMatch(Match match){
        matches.add(match);
    }
    
    public void resolveRoundPairings(int[] scores){
        for(int i = 0, matchIndex = 0 ; i < scores.length ; i = i + 2, matchIndex++){
            int scorePlayer1 = scores[i];
            int scorePlayer2 = scores[i+1];
            matches.get(matchIndex).assignMatchScore(scorePlayer1, scorePlayer2);
        }
    }

    /**
     * @return the matches
     */
    public ArrayList<Match> getMatches() {
        return matches;
    }

    /**
     * @param matches the matches to set
     */
    public void setMatches(ArrayList<Match> matches) {
        this.matches = matches;
    }

    /**
     * @return the round
     */
    public int getRound() {
        return round;
    }

    /**
     * @param round the round to set
     */
    public void setRound(int round) {
        this.round = round;
    }
}
