package com.stock.controllers;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.stock.model.Action;
import com.stock.services.ActionService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/action")
public class ActionResource {
	
	private static Logger log = LogManager.getLogger(ActionResource.class);
	
	private final ActionService actionService;

	public ActionResource(ActionService actionService) {
		super();
		this.actionService = actionService;
	}
	
	@DeleteMapping("/delete-by-scenario/{id}")
	public ResponseEntity<String> deleteByScenarioID(@PathVariable("id") Long id) {
		int i = actionService.deleteByScenarioId(id);
		return ResponseEntity.ok("Transactions deleted successfully! Number of deleted records = " + i);
	}
	
	/* 
	 * Find all actions by scenario id 
	 * */
	@GetMapping("/scenario/{scenarioId}")
	public ResponseEntity<List<Action>> getByScenarioId(@PathVariable("scenarioId") Long scenarioId) {
		List<Action> actions = actionService.findByScenarioId(scenarioId);
		if (actions == null || actions.size() == 0) {
		      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Data Not Found");
		}
		return new ResponseEntity<>(actions, HttpStatus.OK);
	}	

	/**
	 * Create a new Action
	 * @param a
	 * @return
	 */
	@PostMapping("/add")
	public ResponseEntity<Action> addAction(@RequestBody Action a) {
		Action action = actionService.save(a);
		return new ResponseEntity<>(action, HttpStatus.CREATED);
	}
	
	/**
	 * Update existing action
	 * @param a
	 * @return
	 */
	@PutMapping("/update")
	public Action update(@RequestBody final Action a) {
		return actionService.update(a);
	}

	/**
	 * Get Action by its Id
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Action> getActionById(@PathVariable("id") Long id) {
		log.info("Requested Action id for update is: " + id);
		Action action = actionService.findById(id);
		if (action == null) {
		      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Data Not Found");
		}
		return new ResponseEntity<>(action, HttpStatus.OK);
	}
}
