package com.simulation.dice.model;

public class DiceRollSimulationsInfo {
    private Integer numberOfDice;
    private Integer numberOfSides;
    private Integer totalSimulations;
    private Integer totalSimulationsRoll;
    private Double relativeDistribution;

    public DiceRollSimulationsInfo() {
    }

    public DiceRollSimulationsInfo(Integer numberOfDice, Integer numberOfSides, Integer totalSimulations, Integer totalSimulationsRoll) {
        this.numberOfDice = numberOfDice;
        this.numberOfSides = numberOfSides;
        this.totalSimulations = totalSimulations;
        this.totalSimulationsRoll = totalSimulationsRoll;
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

    public Integer getTotalSimulations() {
        return totalSimulations;
    }

    public void setTotalSimulations(Integer totalSimulations) {
        this.totalSimulations = totalSimulations;
    }

    public Integer getTotalSimulationsRoll() {
        return totalSimulationsRoll;
    }

    public void setTotalSimulationsRoll(Integer totalSimulationsRoll) {
        this.totalSimulationsRoll = totalSimulationsRoll;
    }

    public Double getRelativeDistribution() {
        return relativeDistribution;
    }

    public void setRelativeDistribution(Double relativeDistribution) {
        this.relativeDistribution = relativeDistribution;
    }
}
