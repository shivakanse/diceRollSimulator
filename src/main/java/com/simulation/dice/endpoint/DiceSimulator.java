package com.simulation.dice.endpoint;

import com.simulation.dice.exception.InternalServerException;
import com.simulation.dice.exception.InvalidInputException;
import com.simulation.dice.payload.DiceRollResponse;
import com.simulation.dice.payload.DiceRollSimulationResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/dice")
public interface DiceSimulator {
    @GetMapping(value = "/simulateDiceDistribution", produces = "application/json")
    public DiceRollResponse simulateDiceRoll(
            @RequestParam(value = "numberOfDice", defaultValue = "3") Integer numberOfDice,
            @RequestParam(value = "numberOfSides", defaultValue = "6") Integer numberOfSides,
            @RequestParam(value = "numberOfRolls", defaultValue = "100")
                    Integer numberOfRolls)
            throws InvalidInputException, InternalServerException;

    @GetMapping(value = "/getSimulationInfo", produces = "application/json")
    public DiceRollSimulationResponse getSimulationInfo(
            @RequestParam(value = "numberOfDice" , required = false) Integer numberOfDice,
            @RequestParam(value = "numberOfSides", required = false) Integer numberOfSides)
            throws InvalidInputException;
}
