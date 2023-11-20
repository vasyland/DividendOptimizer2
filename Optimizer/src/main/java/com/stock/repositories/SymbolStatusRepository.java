package com.stock.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.stock.model.SymbolStatus;

@Repository
public interface SymbolStatusRepository extends JpaRepository<SymbolStatus, String> {

	@Query(value="SELECT * FROM SYMBOL_STATUS WHERE RECOMMENDED_ACTION = :action", nativeQuery=true)
	List<SymbolStatus> getSymbolsByRecommendedAction(@Param("action") String action);
	
}
