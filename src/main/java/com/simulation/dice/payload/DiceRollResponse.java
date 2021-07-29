package com.simulation.dice.payload;

import java.util.HashMap;
import java.util.Map;

public class DiceRollResponse {
    private Long id;
    private Integer numberOfDice;
    private Integer numberOfSides;
    private Integer numberOfRolls;
    private Map<Integer, Integer> diceDistribution = new HashMap<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Map<Integer, Integer> getDiceDistribution() {
        return diceDistribution;
    }

    public void setDiceDistribution(Map<Integer, Integer> diceDistribution) {
        this.diceDistribution = diceDistribution;
    }
}
