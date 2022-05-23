package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "ORDER_MGNT")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntity  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5630276123788930728L;
	@Id
	@Column(name = "ORDER_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer order_id;
	@Column(name = "ORDER_NAME")
	private String order_name;
	@Column(name = "ORDER_PRICE")
	private Double order_price;
	@Column(name = "BRAND")
	private String brand;
}
