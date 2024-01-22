package com.stock.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


/**
 * 
 * @author va
 *
 */
@Entity
@Table(name = "scenario")
public class Scenario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable=false, updatable=false)
	private Long id;
	
	@Column(name="user_id")
	private Long userId;
	@Column(name="scenario_name")
	private String scenarioName;
	@Column(name="invested_amount")
	private BigDecimal investedAmount;
	@Column(name="available_cash")
	private BigDecimal availableCash;
	@Column(name = "created_on")
	private LocalDateTime createdOn;
	@Column(name = "updated_on")
	private LocalDateTime updatedOn;
	
	//@JsonIgnore
	@JsonManagedReference
	@OneToMany(mappedBy = "scenario", fetch = FetchType.EAGER)
	private Set<ScenarioDetails> details;
		
	public Scenario() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getScenarioName() {
		return scenarioName;
	}

	public void setScenarioName(String scenarioName) {
		this.scenarioName = scenarioName;
	}

	public BigDecimal getInvestedAmount() {
		return investedAmount;
	}

	public void setInvestedAmount(BigDecimal investedAmount) {
		this.investedAmount = investedAmount;
	}

	public BigDecimal getAvailableCash() {
		return availableCash;
	}

	public void setAvailableCash(BigDecimal availableCash) {
		this.availableCash = availableCash;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public LocalDateTime getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(LocalDateTime updatedOn) {
		this.updatedOn = updatedOn;
	}

	public Set<ScenarioDetails> getDetails() {
		return details;
	}

	public void setDetails(Set<ScenarioDetails> details) {
		this.details = details;
	}

	
}
