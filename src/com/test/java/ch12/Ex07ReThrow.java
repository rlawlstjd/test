package com.test.java.ch12;

import java.util.Scanner;

public class Ex07ReThrow {
	public static void main(String[] args) {
		while (true) {
			User3 user = null ; 
			
			user = LoginService3.form(); 
		
			try {
				LoginService3.login(user);
				
			} catch (IDMismatchException3 e) {
				System.out.println("문의사항은 000-000-0000 로 연락주세요. \n"); 
				
			} catch (PasswordMismatchException3 e) {
				System.out.println("문의사항은 000-000-0000 로 연락주세요 \n"); 
			} 
			
			if (user.isLogin()) {
				LoginService3.success(user);
				break;
			}
			
			System.out.println("로그인에 실패하였습니다.\n");
		}
		
		System.out.println("1. 회원정보");
		System.out.println("2. 커뮤니티"); 
		System.out.println("3. 쇼핑");
		System.out.println("4. 로그아웃");
	
	}
}

class LoginService3{
	private static final String DB_ID = "admin";
	private static final String DB_PW = "1234";
	private static int count = 0 ; 
	
	public static void login(User3 user) throws IDMismatchException3, PasswordMismatchException3 {
		try {
				if (!DB_ID.equals(user.getId())) {
					throw new IDMismatchException3("잘못된 아이디를 입력하였습니다.");
					
				} else if (!DB_PW.equals(user.getPassword())) {
					throw new PasswordMismatchException3("잘못된 패스워드를 입력하였습니다.");
					
				} else {
					user.setLogin(true); 
				}
		
		} catch (IDMismatchException3 e) {
			System.out.println("아이디 찾기를 원하시면 클릭해 주세요.");
			throw e; 
			
		} catch (PasswordMismatchException3 e) { 
			System.out.println("비밀번호 찾기를 원하시면 클릭해 주세요."); 
			throw e;
			
		} finally {
			increaseCount(); 
		}
	}
	
	public static User3 form() {
		Scanner scan = new Scanner(System.in); 
		User3 user = new User3() ; 
		
		
		System.out.println("- 로그인 화면 -"); 
		System.out.print("아이디를 입력하세요.");
		user.setId(scan.nextLine());
		System.out.println("비밀번호를 입력하세요."); 
		user.setPassword(scan.nextLine());
		
		return user ; 
	}
	
	public static void success(User3 user) {
		System.out.println(user.getId() + "님 환영합니다. \n");
	}
	
	public static void increaseCount() {
		count++;
		System.out.println("로그인 시도" + count + "회 ");
	}
}

class User3{
	private String id; 
	private String password; 
	private boolean login; 
	
	public String getId() {
		return id; 
	}
	
	public void setId(String id) {
		this.id= id; 
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isLogin () {
		return login ; 
	}
	
	public void setLogin(boolean login) {
		this.login = login ; 
	}
	
}
	
class IDMismatchException3 extends Exception {
	public IDMismatchException3 (String message) {
		super(message);
	}
}

class PasswordMismatchException3 extends Exception {
	public PasswordMismatchException3 (String message) {
		super(message);
	}
}