package com.test.java.ch12;

import java.util.Scanner;

public class Ex05ThrowTest1 {
	public static void main(String[] args) {
		while(true) {
			Beverage b = null; 
			
			b = Machine.form();
			Machine.machineService(b);
			
		}
	}
}

class Machine {
	static int amount ; 
	static Beverage beverage; 
	static int needMoney; 
	
	
	public static void machineService(Beverage b) {
		try {
			
			if (amount < b.beveragePrice) {
				throw new NeedMoneyException ("잔액이 부족합니다."); 
			} else {
				System.out.println(b.name()+ "을 구매해 주셔서 감사합니다.");
			}
			
		
		} catch (NeedMoneyException e) {
			e.printStackTrace(); 
			System.out.println("금액을 확인해 주세요.");
			needMoney = b.beveragePrice - amount; 
			System.out.println("부족한 금액: " + needMoney);
		
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("예외 발생!!");
		}
	}
	
	
	public static Beverage form() {
		Scanner s = new Scanner(System.in);
		
		System.out.println("--자판기--"); 
		System.out.println("음료를 선택해 주세요."); 
		System.out.println("1. 오렌지(500)  2. 포도(600)  3. 콜라(700)  4. 사이다(800)  5. 초콜렛(990)");
		beverage = Beverage.values()[s.nextInt()-1];
		System.out.println("금액을 넣어주세요."); 
		amount = s.nextInt();
	
		return beverage; 
	}
}

enum Beverage{
	orange(500),
	grape(600),
	cock(700),
	soda(800),
	chocolate(900);
	
	public final int beveragePrice;
	
	
	Beverage (int price) {
		this.beveragePrice = price; 
	}
}

class NeedMoneyException extends Exception {
	public NeedMoneyException (String message) {
		super(message); 
	}
}