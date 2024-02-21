package com.stock.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.stock.model.Scenario;

public interface ScenarioRepository extends CrudRepository<Scenario, Long> {
	
	@Query(value="select * from scenario where user_id = :id", nativeQuery=true)
	Optional<List<Scenario>> findByUserId(@Param("id") Long id);
}
