package com.test.java.ch10;

public class Ex04AnonymousClass {
	public static void main(String[] args) { 
		Book b1 = new Book();
		b1.setTitle("자바 익명클래스란");
		b1.setAuthor("엘컴퓨터학원");
		
		
		b1.createBook(new Device() {
			
			public void create() {
				System.out.println("이북 생성");
			}
		});
		
		b1.createBook(new Device() {
			
			public void create() {
				System.out.println("종이책 생성");
			}
		});
		
		
		
		
		PrintService ps = new PrintServiceForPrinter();
		b1.printInfo(ps);
		
		b1.printInfo(new PrintService() {
			
			@Override
			public void print() {
				System.out.println("- FAX로 전송 -");
				System.out.println(b1.getTitle() + "," + b1.getAuthor());
				System.out.println();
			}

			@Override
			public void print(Book book) {
				System.out.println("- FAX로 전송 -");
				System.out.println(b1.getTitle() + "," + b1.getAuthor());
				System.out.println();
			}
			
		});
		
		b1.printInfo(new PrintService() {

			@Override
			public void print(Book book) {
				System.out.println("- 앱 알림으로 전송 -");
				System.out.println(b1.getTitle() + "," + b1.getAuthor());
				System.out.println();
			}
			
		});
	}

}

interface PrintService {
	public default void print() {
		
	}
	public abstract void print(Book book);
	
}

class PrintServiceForPrinter implements PrintService {
	
	@Override
	public void print() {
		System.out.println("- 프린터로 출력 -");
		// (1)
		System.out.println("책 인스턴스가 필요합니다.");	
		System.out.println();
	}

	@Override
	public void print(Book book) {
		System.out.println("- 프린터로 출력 -");
		System.out.println(book.getTitle() + "," + book.getAuthor());
		System.out.println("책 인스턴스가 필요합니다.");	
		System.out.println();
	}
	

	
}

interface Device {
	public abstract void create();
}

class Book  {
	String title;
	String author;
	
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
	
	public void printInfo(PrintService ps) {
		ps.print(this);
	}
	
	public void createBook (Device d) {
		d.create();
	}
}
/*
문제 1.
(1)에 책 정보가 출력될 수 있도록 코딩하세요.
힌트) 인터페이스에 print(Book book) 메소드 오버로딩이 필요 합니다.

문제 2.
Book 클래스에 createBook 메소드를 추가하세요.
Device 인터페이스를 작성하세요.
Device 인터페이스에 create 추상 메소드를 선언하세요. 
main 메소드에서 익명클래스를 사용하여 "이북 생성", "종이책 생성"을 출력하세요.
*/