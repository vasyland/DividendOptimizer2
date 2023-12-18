package com.stock.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.stock.exceptions.ScenarioNotFoundException;
import com.stock.model.Scenario;
import com.stock.repositories.ScenarioRepository;

@Service
public class ScenarioServiceImpl implements ScenarioService {

	private final ScenarioRepository scenarioRepository;
	
	public ScenarioServiceImpl(ScenarioRepository scenarioRepository) {
		super();
		this.scenarioRepository = scenarioRepository;
	}

	@Override
	public Scenario addScenario(Scenario scenario) {
		return scenarioRepository.save(scenario);
	}

	@Override
	public List<Scenario> findAll() {
		return scenarioRepository.findAll();
	}

	@Override
	public Scenario updateScenario(Scenario scenario) {
		return scenarioRepository.save(scenario);
	}

	@Override
	public Scenario findScenarioById(Long id) {
		return scenarioRepository
				.findById(id)
				.orElseThrow(() -> new ScenarioNotFoundException("Scenario by id " + id + " was not found"));
	}

	@Override
	public void deleteScenario(Long scenario_id) {
		scenarioRepository.deleteById(scenario_id);
	}	
}
