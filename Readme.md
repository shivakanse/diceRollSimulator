Two Endpoints exposed

1> http://localhost:8080/dice/simulateDiceDistribution
	When above rest api is called, distribution logic will execute.
	Parameters supported are numberOfDice, numberOfSides, numberOfRolls.
	If above parameters are not passed on default value are as following:-
	numberOfDice = 3
	numberOfSides = 6
	numberOfRolls = 100

	For Example --> http://localhost:8080/dice/simulateDiceDistribution?numberOfDice=4&numberOfSides=4&numberOfRolls=6
	necessary validations are handled.

	Sample Response -->

	{
	  "id": 4,
	  "numberOfDice": 4,
	  "numberOfSides": 4,
	  "numberOfRolls": 6,
	  "diceDistribution": {
	    "8": 1,
	    "9": 2,
	    "11": 1,
	    "12": 1,
	    "13": 1
	  }
	}

2> http://localhost:8080/dice/getSimulationInfo
	When above rest api is called, simulation information will be presented grouped by number of Dice and number of Sides.
	if no query parameters are passed all information will be represented by group of number of Dice and number of Sides.
	This api accepts numberOfDice & numberOfSides both are optional.
	
	For Example --> http://localhost:8080/dice/getSimulationInfo?numberOfDice=4&numberOfSides=4

	Sample Response -->

	{
	  "simulationInfo": [
	    {
	      "numberOfDice": 4,
	      "numberOfSides": 4,
	      "totalSimulations": 1,
	      "totalSimulationsRoll": 6,
	      "relativeDistribution": 2.912621359223301
	    }
	  ]
	}

3> To Run Application click on application.bat
	When you see " Started SimulatorApplication in 6.152 seconds (JVM running for 6.734)" that means server is up and rest api can be called.