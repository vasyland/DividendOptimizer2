package com.stock.services;

import java.util.List;

import com.stock.model.Action;

public interface ActionService {
	Action save(Action a);
	
	Action update(Action a);
	void deleteById(Long id);
	Action findById(Long id);
	
	List<Action> findByScenarioId(Long id);
	int deleteByScenarioId(Long id);
}
