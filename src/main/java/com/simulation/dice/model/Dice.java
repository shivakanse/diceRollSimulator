package com.simulation.dice.model;

import java.util.Map;

public class Dice {
    private String id;
    private Integer numberOfDice;
    private Integer numberOfSides;
    private Integer numberOfRolls;
    private String diceDistribution;

    public Dice() {
    }

    public Dice(Integer numberOfDice, Integer numberOfSides, Integer numberOfRolls, String diceDistribution) {
        this.numberOfDice = numberOfDice;
        this.numberOfSides = numberOfSides;
        this.numberOfRolls = numberOfRolls;
        this.diceDistribution = diceDistribution;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getNumberOfDice() {
        return numberOfDice;
    }

    public void setNumberOfDice(Integer numberOfDice) {
        this.numberOfDice = numberOfDice;
    }

    public Integer getNumberOfSides() {
        return numberOfSides;
    }

    public void setNumberOfSides(Integer numberOfSides) {
        this.numberOfSides = numberOfSides;
    }

    public Integer getNumberOfRolls() {
        return numberOfRolls;
    }

    public void setNumberOfRolls(Integer numberOfRolls) {
        this.numberOfRolls = numberOfRolls;
    }

    public String getDiceDistribution() {
        return diceDistribution;
    }

    public void setDiceDistribution(String diceDistribution) {
        this.diceDistribution = diceDistribution;
    }
}
