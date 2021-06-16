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
public class Player implements Comparable<Player> {

    private String name;
    private String nickname;
    private ArrayList<String> factions;
    private int score;
    private int secondaryScore;
    private ArrayList<String> opponents;
    private int byeRound;
    private int index;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * @param nickname the nickname to set
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * @return the factions
     */
    public ArrayList<String> getFactions() {
        return factions;
    }

    /**
     * @param factions the factions to set
     */
    public void setFactions(ArrayList<String> factions) {
        this.factions = factions;
    }

    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * @return the opponents
     */
    public ArrayList<String> getOpponents() {
        return opponents;
    }

    /**
     * @param opponents the opponents to set
     */
    public void setOpponents(ArrayList<String> opponents) {
        this.opponents = opponents;
    }

    /**
     * @return the secondaryScore
     */
    public int getSecondaryScore() {
        return secondaryScore;
    }

    /**
     * @param secondaryScore the secondaryScore to set
     */
    public void setSecondaryScore(int secondaryScore) {
        this.secondaryScore = secondaryScore;
    }

    @Override
    public int compareTo(Player other) {
        if (other.score > score) {
            return 1;
        } else if (other.score < score) {
            return -1;
        } else {
            if (other.secondaryScore > secondaryScore) {
                return 1;
            } else if (other.secondaryScore < secondaryScore){
                return -1;
            }
        }
        return 0;
    }

    /**
     * @return the byeRound
     */
    public int getByeRound() {
        return byeRound;
    }

    /**
     * @param byeRound the byeRound to set
     */
    public void setByeRound(int byeRound) {
        this.byeRound = byeRound;
    }

    /**
     * @return the index
     */
    public int getIndex() {
        return index;
    }

    /**
     * @param index the index to set
     */
    public void setIndex(int index) {
        this.index = index;
    }

}
