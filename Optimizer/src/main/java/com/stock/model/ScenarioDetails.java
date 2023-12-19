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

@Entity
@Table(name = "SCENARIO_DETAILS")
public class ScenarioDetails implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID", nullable=false, updatable=false)
	private Long id;
	@Column(name="SCENARIO_ID")
	private Long scenario_id;
	@Column(name="SYMBOL")
	private String symbol;
	@Column(name="SHARES")
	private int shares; 
	@Column(name="ACTION")
	private String action;
	@Column(name="PRICE")
	private BigDecimal price;
	@Column(name="COMMISIONS")
	private BigDecimal commisions; 
	private LocalDateTime action_date;
	@Column(name = "CREATED_ON")
	private LocalDateTime created_on;
	@Column(name = "UPDATED_ON")
	private LocalDateTime updated_on;
	public ScenarioDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ScenarioDetails(Long id, Long scenario_id, String symbol, int shares, String action, BigDecimal price,
			BigDecimal commisions, LocalDateTime action_date, LocalDateTime created_on, LocalDateTime updated_on) {
		super();
		this.id = id;
		this.scenario_id = scenario_id;
		this.symbol = symbol;
		this.shares = shares;
		this.action = action;
		this.price = price;
		this.commisions = commisions;
		this.action_date = action_date;
		this.created_on = created_on;
		this.updated_on = updated_on;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getScenario_id() {
		return scenario_id;
	}
	public void setScenario_id(Long scenario_id) {
		this.scenario_id = scenario_id;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public int getShares() {
		return shares;
	}
	public void setShares(int shares) {
		this.shares = shares;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public BigDecimal getCommisions() {
		return commisions;
	}
	public void setCommisions(BigDecimal commisions) {
		this.commisions = commisions;
	}
	public LocalDateTime getAction_date() {
		return action_date;
	}
	public void setAction_date(LocalDateTime action_date) {
		this.action_date = action_date;
	}
	public LocalDateTime getCreated_on() {
		return created_on;
	}
	public void setCreated_on(LocalDateTime created_on) {
		this.created_on = created_on;
	}
	public LocalDateTime getUpdated_on() {
		return updated_on;
	}
	public void setUpdated_on(LocalDateTime updated_on) {
		this.updated_on = updated_on;
	}
	@Override
	public String toString() {
		return "ScenarioDetails [id=" + id + ", scenario_id=" + scenario_id + ", symbol=" + symbol + ", shares="
				+ shares + ", action=" + action + ", price=" + price + ", commisions=" + commisions + ", action_date="
				+ action_date + ", created_on=" + created_on + ", updated_on=" + updated_on + "]";
	}
	
	
}
