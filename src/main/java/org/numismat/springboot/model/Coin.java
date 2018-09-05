package org.numismat.springboot.model;

public class Coin {
	
	private int id;
	private String currency;
	private int value;
	private int year;
	private String mint;
	
	public Coin() {
		
	}
	public Coin(int id, String currency, int value, int year, String mint) {
		super();
		this.id = id;
		this.currency = currency;
		this.value = value;
		this.year = year;
		this.mint = mint;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getMint() {
		return mint;
	}
	public void setMint(String mint) {
		this.mint = mint;
	}
	
	
}
