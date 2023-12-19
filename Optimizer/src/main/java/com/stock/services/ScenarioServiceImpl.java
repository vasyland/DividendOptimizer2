package com.stock.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.stock.exceptions.ScenarioNotFoundException;
import com.stock.model.Scenario;
import com.stock.model.ScenarioDetails;
import com.stock.repositories.ScenarioDetailsRepository;
import com.stock.repositories.ScenarioRepository;

@Service
public class ScenarioServiceImpl implements ScenarioService {

	private final ScenarioRepository scenarioRepository;
	private final ScenarioDetailsRepository scenarioDetailsRepository;

	public ScenarioServiceImpl(ScenarioRepository scenarioRepository,
			ScenarioDetailsRepository scenarioDetailsRepository) {
		super();
		this.scenarioRepository = scenarioRepository;
		this.scenarioDetailsRepository = scenarioDetailsRepository;
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

	@Override
	public List<ScenarioDetails> getByScenarioIds(List<Long> idList) {
		return scenarioDetailsRepository.getByScenarioIds(idList);
	}	
}
