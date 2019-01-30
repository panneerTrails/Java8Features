package com.michael.java8.practice.model;

public class Modem {
	
	private Double price;
	 
    public Modem(Double price) {
        this.price = price;
    }
    
    /**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}    
    
}