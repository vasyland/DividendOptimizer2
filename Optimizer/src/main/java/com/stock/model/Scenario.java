package com.stock.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


/**
 * 
 * @author va
 * db: horse2 
 */
@Entity
@Table(name = "SCENARIO")
public class Scenario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID", nullable=false, updatable=false)
	private Long id;
	@Column(name="USER_ID")
	private Long user_id;
	@Column(name="SCENARIO_NAME")
	private String scenarioName;
	@Column(name="INVESTED_AMOUNT")
	private BigDecimal investedAmount;
	@Column(name="AVAILABLE_CASH")
	private BigDecimal availableCash;
	@Column(name = "CREATED_ON")
	private LocalDateTime createdOn;
	@Column(name = "UPDATED_ON")
	private LocalDateTime updatedOn;
	
	public Scenario() {
		super();
	}

	public Scenario(Long id, Long user_id, String scenarioName, BigDecimal investedAmount, BigDecimal availableCash,
			LocalDateTime createdOn, LocalDateTime updatedOn) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.scenarioName = scenarioName;
		this.investedAmount = investedAmount;
		this.availableCash = availableCash;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
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

	@Override
	public String toString() {
		return "Scenarios [id=" + id + ", user_id=" + user_id + ", scenarioName=" + scenarioName + ", investedAmount="
				+ investedAmount + ", availableCash=" + availableCash + ", createdOn=" + createdOn + ", updatedOn="
				+ updatedOn + "]";
	}
	
	
}
