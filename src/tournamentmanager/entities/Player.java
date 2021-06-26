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
    private String faction;
    private int score;
    private int secondaryScore;
    private ArrayList<String> opponents;
    private int byeRound;
    private int index;

    public Player(String name, String nickname, String faction) {
        this.name = name;
        this.nickname = nickname;
        this.faction = faction;
        this.secondaryScore = 0;
        this.score = 0;
        this.byeRound = -1;
        this.opponents = new ArrayList<>();
    }

    
    
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
    public String getFactions() {
        return faction;
    }

    /**
     * @param faction the factions to set
     */
    public void setFactions(String faction) {
        this.faction = faction;
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
            } else if (other.secondaryScore < secondaryScore) {
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

    enum Factions {
        AstraMilitarum,
        Necrons, 
        Tau, 
        ThousandSons,
        Craftworlds,
        Drukhari,
        Harlequins,
        Orks,
        DeathGuard, 
        ChaosSpaceMarines, 
        Daemons,
        ChaosKnights,
        BloodAngels,
        Ultramarines,
        SpaceMarines,
        Salamanders,
        Ironhands,
        ImperialFist,
        CrimsonFist,
        RavenGuard,
        SpaceWolves,
        DarkAngels,
        DeathWatch,
        AdeptusMechanicus,
        WhiteScar, 
        BlackTemplars,
        AdeptasSororitas,
        GreyKnights,
        Ynnari,
        Tyranids,
        GenestealersCult,
        ImperialKnights,
        Custodes
    }

}
