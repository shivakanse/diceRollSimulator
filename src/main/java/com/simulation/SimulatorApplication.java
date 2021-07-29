package com.simulation;

import com.simulation.dice.handler.DiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SimulatorApplication {

	@Autowired
	DiceRepository diceRepository;

	public static void main(String[] args) {
		SpringApplication.run(SimulatorApplication.class, args);
	}

}
