package com.cg.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="S1Order")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="odate")
	private Date OrderDate;
	
//	@NotNull(message = "order should not null")
	@Column(name="oNo.")
	private String OrderNo;		
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(int orderId, Date orderDate, String orderNo) {
		super();
		id = orderId;
		OrderDate = orderDate;
		OrderNo = orderNo;
	}

	public int getOrderId() {
		return id;
	}

	public void setOrderId(int orderId) {
		id = orderId;
	}

	public Date getOrderDate() {
		return OrderDate;
	}

	public void setOrderDate(Date orderDate) {
		OrderDate = orderDate;
	}

	public String getOrderNo() {
		return OrderNo;
	}

	public void setOrderNo(String orderNo) {
		OrderNo = orderNo;
	}

	@Override
	public String toString() {
		return "Order [OrderId=" + id + ", OrderDate=" + OrderDate + ", OrderNo=" + OrderNo + "]";
	}

	
}
