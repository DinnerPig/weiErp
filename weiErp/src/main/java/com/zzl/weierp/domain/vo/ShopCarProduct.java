package com.zzl.weierp.domain.vo;

public class ShopCarProduct {

	private Long id;
	
	private String name;
	
	private Integer amount;
	
	private Double price;
	
	private Double preferPrice;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getPreferPrice() {
		return preferPrice;
	}

	public void setPreferPrice(Double preferPrice) {
		this.preferPrice = preferPrice;
	}
	
}
