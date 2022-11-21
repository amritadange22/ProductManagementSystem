package com.jbk.SpringBoot_ProductManagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Product {

	@Id
	@Column(nullable=false)                               //nullable= false is related to mysql
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int product_id;
	
	@Column(unique = true)
	@NotBlank(message = "Name is mandatory")				//for notBlank, do not give value
	private String product_name;
	
	private int supplier_id;
	
	@NotNull(message = "Quantity should not null")          //notnull is for validation (applicable on non primitive)
	private String quantity_per_unit;						//for notNull, do not give var name as well as value
	
	@NotEmpty(message = "Product price should not empty")   
	private Integer product_price;
	private int product_in_stock;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int product_id, @NotNull String product_name, int supplier_id, String quantity_per_unit,
			Integer product_price, int product_in_stock) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.supplier_id = supplier_id;
		this.quantity_per_unit = quantity_per_unit;
		this.product_price = product_price;
		this.product_in_stock = product_in_stock;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getSupplier_id() {
		return supplier_id;
	}

	public void setSupplier_id(int supplier_id) {
		this.supplier_id = supplier_id;
	}

	public String getQuantity_per_unit() {
		return quantity_per_unit;
	}

	public void setQuantity_per_unit(String quantity_per_unit) {
		this.quantity_per_unit = quantity_per_unit;
	}

	public Integer getProduct_price() {
		return product_price;
	}

	public void setProduct_price(Integer product_price) {
		this.product_price = product_price;
	}

	public int getProduct_in_stock() {
		return product_in_stock;
	}

	public void setProduct_in_stock(int product_in_stock) {
		this.product_in_stock = product_in_stock;
	}

	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", product_name=" + product_name + ", supplier_id=" + supplier_id
				+ ", quantity_per_unit=" + quantity_per_unit + ", product_price=" + product_price
				+ ", product_in_stock=" + product_in_stock + "]";
	}
}
