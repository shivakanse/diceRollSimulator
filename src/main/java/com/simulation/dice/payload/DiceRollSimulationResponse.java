package com.simulation.dice.payload;

import com.simulation.dice.model.DiceRollSimulationsInfo;

import java.util.ArrayList;
import java.util.List;

public class DiceRollSimulationResponse {
    private List<DiceRollSimulationsInfo> simulationInfo = new ArrayList<>();

    public List<DiceRollSimulationsInfo> getSimulationInfo() {
        return simulationInfo;
    }

    public void setSimulationInfo(List<DiceRollSimulationsInfo> simulationInfo) {
        this.simulationInfo = simulationInfo;
    }
}
