package com.simulation.dice.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.simulation.dice.endpoint.DiceSimulator;
import com.simulation.dice.exception.InternalServerException;
import com.simulation.dice.exception.InvalidInputException;
import com.simulation.dice.handler.DiceRepository;
import com.simulation.dice.model.Dice;
import com.simulation.dice.model.DiceRollSimulationsInfo;
import com.simulation.dice.payload.DiceRollResponse;
import com.simulation.dice.payload.DiceRollSimulationResponse;
import com.simulation.dice.util.DiceSimulatorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class DiceSimulatorImpl implements DiceSimulator {

    @Autowired
    DiceRepository diceRepository;

    @Override
    public DiceRollResponse simulateDiceRoll(Integer numberOfDice, Integer numberOfSides, Integer numberOfRolls) throws InvalidInputException, InternalServerException {
        DiceSimulatorUtil.validateSimulationInput(numberOfDice, numberOfSides, numberOfRolls);

        DiceRollResponse response = new DiceRollResponse();
        ObjectMapper mapper = new ObjectMapper();
        Map<Integer, Integer> diceRollDistribution = new HashMap<>();

        DiceSimulatorUtil.generateDiceRollDistribution(numberOfDice, numberOfSides, numberOfRolls, diceRollDistribution);
        Dice dice = null;
        try {
            dice = new Dice(numberOfDice, numberOfSides, numberOfRolls, mapper.writeValueAsString(diceRollDistribution));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new InternalServerException("Json Processing Failed");
        }
        Long id = diceRepository.insertSimulation(dice);

        DiceSimulatorUtil.mapDiceRollResponse(response, id, numberOfDice, numberOfSides, numberOfRolls, diceRollDistribution);

        return response;
    }

    @Override
    public DiceRollSimulationResponse getSimulationInfo(Integer numberOfDice, Integer numberOfSides) {
        DiceSimulatorUtil.validateSimulationInput(numberOfDice, numberOfSides);
        DiceRollSimulationResponse diceRollSimulationResponse = new DiceRollSimulationResponse();
        List<DiceRollSimulationsInfo> diceRollSimulationsInfo = diceRepository.fetchSimulationsInfo(numberOfDice, numberOfSides);
        diceRollSimulationResponse.setSimulationInfo(diceRollSimulationsInfo);
        return diceRollSimulationResponse;
    }

}
