package com.stock.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "scenario_details")
public class ScenarioDetails implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable=false, updatable=false)
	private Long id;
	
	@Column(name="scenario_id")
	private Long scenario_id;
	
	@Column(name="symbol")
	private String symbol;
	@Column(name="shares")
	private int shares; 
	@Column(name="action")
	private String action;
	@Column(name="price")
	private BigDecimal price;
	@Column(name="commisions")
	private BigDecimal commisions; 
	@Column(name = "action_date")
	private LocalDateTime action_date;
	@Column(name = "created_on")
	private LocalDateTime created_on;
	@Column(name = "updated_on")
	private LocalDateTime updated_on;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="scenario_id",referencedColumnName="id", insertable=false, updatable=false)
	private Scenario scenario;
	
	public ScenarioDetails() {
		super();
	}

	public Long getScenario_id() {
		return scenario_id;
	}

	public void setScenario_id(Long scenario_id) {
		this.scenario_id = scenario_id;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	
	public Scenario getScenario() {
		return scenario;
	}
	public void setScenario(Scenario scenario) {
		this.scenario = scenario;
	}
}
