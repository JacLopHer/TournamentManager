/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tournamentmanager.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author Jacinto López Hernández
 */
public class Tournament {
    private String tournament_name;
    private ArrayList<Player> players = new ArrayList<>();
    private ArrayList<Match> allMatches = new ArrayList<>();
    private ArrayList<RoundMatching> allPairings = new ArrayList<>();
    private int currentRound = 0;
    private int rounds;
    private LocalDate date;
    private boolean itsOver = false;
    private Random random = new Random();

    public Tournament(int rounds, LocalDate date, String tournament_name) {
        this.rounds = rounds;
        this.date = date;
        this.tournament_name = tournament_name;
    }

    /**
     * Sorts the players by score
     */
    public void SortPlayers(){
        Collections.sort(getPlayers());
    }
    
    /**
     * Checks wether the match has already happened or not
     * @param player1
     * @param player2
     * @return true - if the match has already happened
     */
    public boolean allMatchesContainsMatch(Player player1, Player player2){
        for(Match match : getAllMatches()){
            if(match.hasPlayers(player1, player2)){
                return true;
            }
        }
        return false;
    }
    
    public void generateRandomPairings(String mission){
        RoundMatching newPairings = new RoundMatching(currentRound);
        ArrayList<Player> notPaired = new ArrayList<>(players);
       
        Random newRandom = new Random();
        
        while(notPaired.size() > 1){
            int player1Index = newRandom.nextInt(notPaired.size());
            Player player1 = notPaired.get(player1Index);
            notPaired.remove(player1Index);
            
            int player2Index = newRandom.nextInt(notPaired.size());
            Player player2 = notPaired.get(player2Index);
            notPaired.remove(player2Index);
            
            Match newMatch = new Match(player1, player2, mission);
            allMatches.add(newMatch);
            newPairings.addMatch(newMatch);
        }
        if(notPaired.size() == 1){
            Player playerBye = notPaired.get(0);
            playerBye.setByeRound(currentRound +1);
            playerBye.setScore(3);
            playerBye.setSecondaryScore(60);
        }
        allPairings.add(newPairings);
    }
    
    public void generateRegularPairings(String mission){
        RoundMatching currentRoundPairings = new RoundMatching(currentRound);
        ArrayList<Match> roundMatches = new ArrayList<>();
        ArrayList<Player> notPaired = new ArrayList<>();
        
        while(notPaired.size() > 1){
            Player bestPlayer = notPaired.get(0);
            notPaired.remove(0);
            int nextPlayerIndex = 0;
            Player nextPlayer = notPaired.get(nextPlayerIndex);
            while(allMatchesContainsMatch(bestPlayer, nextPlayer) && nextPlayerIndex < notPaired.size()){
                nextPlayerIndex++;
                nextPlayer = notPaired.get(nextPlayerIndex);
            }
            notPaired.remove(nextPlayerIndex);
            Match newMatch = new Match(bestPlayer, nextPlayer, mission);
            roundMatches.add(newMatch);
            currentRoundPairings.addMatch(newMatch);
            allMatches.add(newMatch);
        }
        allPairings.add(currentRoundPairings);
        
        if(notPaired.size() == 1){
            Player playerBye = notPaired.get(0);
            playerBye.setByeRound(currentRound +1);
            playerBye.setScore(3);
            playerBye.setSecondaryScore(60);
        }
        allPairings.add(currentRoundPairings);
    }
    
    public void generatePairings(String mission){
        if(currentRound == 0){
            generateRandomPairings(mission);
        } else {
            generatePairings(mission);
        }
    }
    
    public void resolveRound(String mission){
        if(!itsOver){
            generatePairings(mission);
            RoundMatching currentRoundPairings = allPairings.get(currentRound);
            //TODO ADD SCORES
            //currentRoundPairings.resolveRoundPairings(scores);
            for(int i = 0 ; i < players.size() ; i++){
                players.get(i).setIndex(i+1);
            }
            currentRound++;
            if(currentRound == rounds){
                itsOver = true;
            }
        }
    }

    /**
     * @return the players
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }

    /**
     * @param players the players to set
     */
    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    /**
     * @return the allMatches
     */
    public ArrayList<Match> getAllMatches() {
        return allMatches;
    }

    /**
     * @param allMatches the allMatches to set
     */
    public void setAllMatches(ArrayList<Match> allMatches) {
        this.allMatches = allMatches;
    }

    /**
     * @return the allPairings
     */
    public ArrayList<RoundMatching> getAllPairings() {
        return allPairings;
    }

    /**
     * @param allPairings the allPairings to set
     */
    public void setAllPairings(ArrayList<RoundMatching> allPairings) {
        this.allPairings = allPairings;
    }

    /**
     * @return the currentRound
     */
    public int getCurrentRound() {
        return currentRound;
    }

    /**
     * @param currentRound the currentRound to set
     */
    public void setCurrentRound(int currentRound) {
        this.currentRound = currentRound;
    }

    /**
     * @return the rounds
     */
    public int getRounds() {
        return rounds;
    }

    /**
     * @param rounds the rounds to set
     */
    public void setRounds(int rounds) {
        this.rounds = rounds;
    }

    /**
     * @return the date
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * @return the itsOver
     */
    public boolean isItsOver() {
        return itsOver;
    }

    /**
     * @param itsOver the itsOver to set
     */
    public void setItsOver(boolean itsOver) {
        this.itsOver = itsOver;
    }

    /**
     * @return the random
     */
    public Random getRandom() {
        return random;
    }

    /**
     * @param random the random to set
     */
    public void setRandom(Random random) {
        this.random = random;
    }

    /**
     * @return the tournament_name
     */
    public String getTournament_name() {
        return tournament_name;
    }

    /**
     * @param tournament_name the tournament_name to set
     */
    public void setTournament_name(String tournament_name) {
        this.tournament_name = tournament_name;
    }
    
    
    
    
}
