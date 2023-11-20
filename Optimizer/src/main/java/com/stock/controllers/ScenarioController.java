package com.stock.controllers;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.stock.data.Symbol;
import com.stock.model.Scenario;
import com.stock.model.SymbolStatus;
import com.stock.services.ScenarioService;
import com.stock.services.SymbolService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class ScenarioController {

	private static Logger logger = LogManager.getLogger(ScenarioController.class);
	
	@Autowired
	private final SymbolService symbolService;
	@Autowired
	private final ScenarioService scenarioService;
	
	public ScenarioController(ScenarioService scenarioService, SymbolService symbolService) {
		super();
		this.scenarioService = scenarioService;
		this.symbolService = symbolService;
	}

	@GetMapping("/process-symbols")
	public ResponseEntity<List<String>> getProcessSymbols() {
		List<String> s = symbolService.getSymbols();
//		if (s == null || s.size() == 0) {
//		      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Data Not Found");
//		}
		//return new ResponseEntity<>(s, HttpStatus.OK);
		return new ResponseEntity<List<String>>(s, HttpStatus.OK);
	}
	
	@GetMapping("/recommended-symbols")
	public @ResponseBody List<SymbolStatus> getBuyRecommendedSymbols() {
		List<SymbolStatus> s = symbolService.getRecomendedBuySymbols();
//		if (s == null || s.size() == 0) {
//		      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Data Not Found");
//		}
		//return new ResponseEntity<>(s, HttpStatus.OK);
		return s;
	}
	
	@GetMapping("/allscenarios")
	public ResponseEntity<List<Scenario>> getAllScenarios() {
		List<Scenario> scenarios = scenarioService.findAllScenarios();
//		if (scenarios == null || scenarios.size() == 0) {
//		      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Data Not Found");
//		}
		return new ResponseEntity<>(scenarios, HttpStatus.OK);
	}
	
	@GetMapping("/scenario/{id}")
	public ResponseEntity<Scenario> getScenariById(@PathVariable("id") Long id) {
		Scenario scenario = scenarioService.findScenarioById(id);
		if (scenario == null) {
		      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Data Not Found");
		}
		return new ResponseEntity<>(scenario, HttpStatus.OK);
	}
	
	@PostMapping("/add-scenario")
	public ResponseEntity<Scenario> addScenario(@RequestBody Scenario s) {
		Scenario scenario = scenarioService.addScenario(s);
		return new ResponseEntity<>(scenario, HttpStatus.CREATED);
	}
	
	@PutMapping("/update-scenario")
	public ResponseEntity<Scenario> updateScenario(@RequestBody Scenario s) {
		Scenario scenario = scenarioService.updateScenario(s);
		return new ResponseEntity<>(scenario, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete-scenario/{id}")
	public ResponseEntity<?> deleteScenario(@PathVariable("id") Long id) {
		scenarioService.deleteScenario(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
