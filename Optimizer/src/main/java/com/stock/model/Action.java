package com.stock.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "action")
public class Action implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable=false, updatable=false)
	private Long id;
	
	@Column(name="scenario_id")
	private Long scenario_id;
	
	@Column(name="symbol")
	private String symbol;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="activity")
	private String activity;
	
	@Column(name="price")
	private BigDecimal price;
	
	@Column(name="commisions")
	private BigDecimal commisions; 
	
	@Column(name="currency")
	private String currency;
	
	@Column(name = "activity_date")
	private LocalDateTime activity_date;
	
	@Column(name = "created_on")
	@CreationTimestamp
	private LocalDateTime created_on;

	
//	@JsonBackReference
//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name="scenario_id",referencedColumnName="id", insertable=false, updatable=false)
//	private Scenario scenario;
	
	public Action() {
		super();
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
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

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public LocalDateTime getActivity_date() {
		return activity_date;
	}

	public void setActivity_date(LocalDateTime activity_date) {
		this.activity_date = activity_date;
	}

	public LocalDateTime getCreated_on() {
		return created_on;
	}

	public void setCreated_on(LocalDateTime created_on) {
		this.created_on = created_on;
	}
}
