package com.simulation.dice.handler;

import com.simulation.dice.model.Dice;
import com.simulation.dice.model.DiceRollSimulationsInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

@Repository
public class DiceRepository {

    private static final String INSERT_SIMULATION = "insert into dice " +
            "(number_of_dice, number_of_sides, number_of_rolls, dice_distribution) " +
            "values(:numberOfDice,  :numberOfSides, :numberOfRolls, :diceDistribution)";
    private static final String SELECT_SIMULATIONS_DATA = "select " +
            "number_of_dice as numberOfDice, " +
            "number_of_sides as numberOfSides, " +
            "sum(Number_of_rolls) as totalSimulationsRoll, " +
            "count(id) as totalSimulations, " +
            "convert(sum(Number_of_rolls), double)/" +
            "convert((select sum(Number_of_rolls) from dice), double)*100 as relativeDistribution " +
            "from dice ";
    private static final String SELECT_SIMULATIONS_DATA_GROUP_BY = "group by number_of_dice, number_of_sides";

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public long insertSimulation(Dice dice) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        SqlParameterSource params = new MapSqlParameterSource().
            addValue("numberOfDice", dice.getNumberOfDice()).
            addValue("numberOfSides", dice.getNumberOfSides()).
            addValue("numberOfRolls", dice.getNumberOfRolls()).
            addValue("diceDistribution", dice.getDiceDistribution());

        namedParameterJdbcTemplate.update(INSERT_SIMULATION, params, keyHolder);
        return (long) keyHolder.getKey();
    }

    public List<DiceRollSimulationsInfo> fetchSimulationsInfo(Integer numberOfDice, Integer numberOfSides) {
        StringJoiner where = new StringJoiner(" AND ", " WHERE ", "").setEmptyValue("");
        if (numberOfDice!=null && numberOfDice != 0)
            where.add("number_of_dice = :numberOfDice ");
        if (numberOfSides!=null && numberOfSides != 0)
            where.add("number_of_sides = :numberOfSides ");
        Map<String, Object> params = new HashMap<>();
        params.put("numberOfDice", numberOfDice);
        params.put("numberOfSides", numberOfSides);
        String sqlQuery = SELECT_SIMULATIONS_DATA + where + SELECT_SIMULATIONS_DATA_GROUP_BY;
        return namedParameterJdbcTemplate.query(
                sqlQuery, params,
                new BeanPropertyRowMapper<DiceRollSimulationsInfo>(DiceRollSimulationsInfo.class));
    }
}
