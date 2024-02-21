package com.stock.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.stock.model.Action;

import jakarta.transaction.Transactional;

public interface ActionRepository extends CrudRepository<Action, Long> {

	@Query(value="select * from action where scenario_id = :id", nativeQuery=true)
	Optional<List<Action>> findByScenarioId(@Param("id") Long id);
	
	/**
	 * Delete all transactions for the given scenario
	 * @param scenarioId
	 * @return - number of deleted records
	 */
	@Modifying
	@Transactional
    @Query(value="delete from Action where scenario_id = :id", nativeQuery=true)
    int deleteByScenarioId(@Param("id") Long id);
}
