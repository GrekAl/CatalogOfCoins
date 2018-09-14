package org.numismat.springboot.model;

public class Coin {
	
	private Integer id;
	private String currency;
	private Integer value;
	private Integer year;
	private String mint;
	
	public Coin() {
		
	}
	public Coin(Integer id, String currency, Integer value, Integer year, String mint) {
		super();
		this.id = id;
		this.currency = currency;
		this.value = value;
		this.year = year;
		this.mint = mint;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public String getMint() {
		return mint;
	}
	public void setMint(String mint) {
		this.mint = mint;
	}	
}
