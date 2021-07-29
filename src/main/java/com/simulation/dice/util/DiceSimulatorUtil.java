package com.simulation.dice.util;

import com.simulation.dice.exception.InvalidInputException;
import com.simulation.dice.payload.DiceRollResponse;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class DiceSimulatorUtil {
    public static void validateSimulationInput(int numberOfDice, int numberOfSides, int numberOfRolls) throws InvalidInputException {
        StringBuilder message = new StringBuilder();
        validateNumberOfDice(message, numberOfDice);
        validateNumberOfRolls(message, numberOfRolls);
        validateNumberOfSides(message, numberOfSides);
        if (message.length() != 0)
            throw new InvalidInputException(message.toString());
    }

    public static void validateSimulationInput(Integer numberOfDice, Integer numberOfSides) throws InvalidInputException {
        StringBuilder message = new StringBuilder();
        if(numberOfDice!=null)
        validateNumberOfDice(message, numberOfDice);
        if(numberOfSides!=null)
        validateNumberOfSides(message, numberOfSides);
        if (message.length() != 0)
            throw new InvalidInputException(message.toString());
    }

    public static void validateNumberOfDice(StringBuilder message, Integer numberOfDice) {
        if (numberOfDice < 1)
            message.append("Number of Dice cannot be less than 1");
    }

    public static void validateNumberOfRolls(StringBuilder message, Integer numberOfRolls) {
        if (numberOfRolls < 1)
            message.append("Number of Rolls cannot be less than 1");
    }

    public static void validateNumberOfSides(StringBuilder message, Integer numberOfSides) {
        if (numberOfSides < 4)
            message.append("Number of Sides cannot be less than 4");
    }

    public static void mapDiceRollResponse(DiceRollResponse response, long id, Integer numberOfDice, Integer numberOfSides, Integer numberOfRolls, Map<Integer, Integer> diceRollDistribution) {
        response.setId(id);
        response.setNumberOfDice(numberOfDice);
        response.setNumberOfSides(numberOfSides);
        response.setNumberOfRolls(numberOfRolls);
        response.setDiceDistribution(diceRollDistribution);
    }

    public static void generateDiceRollDistribution(Integer numberOfDice, Integer numberOfSides, Integer numberOfRolls, Map<Integer, Integer> diceRollDistribution) {
        IntStream.range(0, numberOfRolls).forEach((i) -> {
            int diceRollsSum = IntStream.range(0, numberOfDice).parallel().
                    map(j -> ThreadLocalRandom.current().nextInt(1, numberOfSides + 1)).sum();
            diceRollDistribution.computeIfAbsent(diceRollsSum, (k) -> 0);
            diceRollDistribution.computeIfPresent(diceRollsSum, (k, v) -> v + 1);
        });
    }
}
