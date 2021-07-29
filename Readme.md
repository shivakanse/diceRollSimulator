#Prerequisite
Maven and Java 8 required.
Please build project using --> "mvn clean install"
Run Application using CMD --> "java -jar target\simulator-0.0.1-SNAPSHOT.jar com.simulation.SimulatorApplication"
Once you see " Started SimulatorApplication in 6.024 seconds (JVM running for 6.519)" application is up and running and following rest endpoints can be called.

#Two Endpoints exposed

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

#Database used -->
Here we are using H2 in memory database for storage. Data will remain untill Application server is up. Once server is restarted data will be lost.
use "http://localhost:8080/h2-console/" to login to h2 console.
configuration for H2 can be found in "diceRollSimulator-master\src\main\resources\application.properties"

#Main Files and there purpose -->
	SimulatorApplication(Main Class for startup),
	DiceSimulator.java (Rest Endpoints Exposed),
	DiceSimulatorImpl (Rest Implementation),
	DiceSimulatorUtil.java (Utility class where dice roll distribution resides)
				
#Validation
Basic Validation done -->
	Number of Dice cannot be less than 1,
	Number of Rolls cannot be less than 1,
	Number of Sides cannot be less than 4


