package com.test.java.ch08.ex06;

class Book {
	public String title ; 
	private String author; 
	private int price; 
	private int dollarPrice; 
	int edittion; 
	protected float tax ; 
	
	void setTitle(String title) {
		this.title= title ; 
	}
	
	public String getTitle() {
		return title ; 
	}
	
	public void setAuthor(String author) {
		this.author = author; 
	}
	
	public void setPrice(int price) {
		this.price = price ; 
		setDollarPrice(price);
	}
	
	public int getPrice() {
		return price; 
	}
	
	private void setDollarPrice(int price) {
		dollarPrice = (int)(price/1000f);
	}
	
	public int getDollarPrice() {
		return dollarPrice;
	}
	
	protected void setTax(float tax) {
		this.tax = tax;
	}
	
	protected float getTax() {
		return tax;
	}
}
	


