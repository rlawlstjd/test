package com.test.java.ch10;

public class Ex02StaticNestedClass {
	public static void main(String[] args) {
		int price = EBook2.TaxCalculator.getTotalDollarPrice(30000, EBook2.TaxCalculator.USA);
		System.out.println(price);
		
		EBook2 eb = new EBook2();
		eb.setTitle("자바 기본문법");
		eb.setAuthor("엘컴퓨터학원");
		eb.setPrice(50000);
		eb.print();
	}

}

class EBook2 {
	private String title;
	private String author;
	private int price;
	
	static class TaxCalculator {
		private static float tax;
		public static final int KOREA = 1;
		public static final int USA = 2;
		public static final int UK = 3;
		public String calcName;
		
		static int getTotalDollarPrice(int price, int country) {
			switch (country) {
				case KOREA:
					tax = 1f;
					break;
				case USA:
					tax = 1.1f;
					break;
				case UK:
					tax = 1.2f;
					break;
				default:
					tax = 1.3f;
			}
			
			
			//System.out.println(EBook2.this.price);
			EBook2 eb = new EBook2 ();
			System.out.println(eb.price);
			
			
			return (int)(price * tax);
		}
		
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void print() {
		System.out.println("책이름: " + title);
		System.out.println("저자: " + author);
		System.out.println("가격: " + TaxCalculator.getTotalDollarPrice(price, TaxCalculator.KOREA));
	}
	
}