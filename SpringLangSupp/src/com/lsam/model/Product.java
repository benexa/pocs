package com.lsam.model;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class Product {
	
	//@Pattern(regexp="^[0-9]",message="Only Numeric values allowed")
	private long id;
	
	@NotEmpty(message="NAME is a required field")
	private String name;
	
	@Length(max=250, message="Only 250 characters are allowed")
	private String description;
	
	@Pattern(regexp="^[0-9]", message="Only Numeric values allowed")
	private String price;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

}
