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

import com.stock.model.Scenario;
import com.stock.model.SymbolStatus;
import com.stock.services.ScenarioService;
import com.stock.services.SymbolService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/scenario")
public class ScenarioController {

	private static Logger log = LogManager.getLogger(ScenarioController.class);
	
	@Autowired
	private final SymbolService symbolService;
	@Autowired
	private final ScenarioService scenarioService;
	
	public ScenarioController(ScenarioService scenarioService, SymbolService symbolService) {
		super();
		this.scenarioService = scenarioService;
		this.symbolService = symbolService;
	}

	@PostMapping("/add")
	public ResponseEntity<Scenario> addScenario(@RequestBody Scenario s) {
		Scenario scenario = scenarioService.save(s);
		return new ResponseEntity<>(scenario, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Scenario> updateScenario(@RequestBody Scenario s) {
		Scenario scenario = scenarioService.update(s);
		return new ResponseEntity<>(scenario, HttpStatus.OK);
	}
	
	/* TODO: There is a dependency table */ 
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteScenario(@PathVariable("id") Long id) {
		
		/* Check existing Action transactions for this scenario */
		
		scenarioService.deleteById(id);
		log.info("Scenario id = " + id + " was deleted.");
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Scenario> getScenarioById(@PathVariable("id") Long id) {
		Scenario scenario = scenarioService.findById(id);
		if (scenario == null) {
		      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Data Not Found");
		}
		return new ResponseEntity<>(scenario, HttpStatus.OK);
	}
	
	/**
	 * Getting all user scenarios with details
	 * @return
	 */
	@GetMapping("/all")
	public ResponseEntity<List<Scenario>> getAllScenarios() {
		List<Scenario> scenarios = scenarioService.findAll();
//		if (scenarios == null || scenarios.size() == 0) {
//		      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Data Not Found");
//		}
		return new ResponseEntity<>(scenarios, HttpStatus.OK);
	}	
	
	/* 
	 * Find all scenarios by user id 
	 * */
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Scenario>> getByUserId(@PathVariable("userId") Long userId) {
		List<Scenario> scenarios = scenarioService.findByUserId(userId);
		if (scenarios == null || scenarios.size() == 0) {
		      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Data Not Found");
		}
		return new ResponseEntity<>(scenarios, HttpStatus.OK);
	}		
	
	
	
	
	//TODO: ERROR - investigate and delete
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
}
