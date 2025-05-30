package com.test.java.ch18;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Ex14Comparator {
	public static void main (String[] args) {
		List<Book4> books = new ArrayList<>(); 
		Collections.addAll(books, new Book4(1, "자바 문법"), new Book4(1, "파이썬 문법"), new Book4(3, "자바 컬렉션"));
		
		System.out.println("< 번호 오름차순 정렬, 제목 오름차순 정렬 >");
		Collections.sort(books, new AscendingNo());
		System.out.println(books);
		System.out.println(); 
		
		System.out.println("< 번호 내림차순 정렬, 제목 내림차순 정렬 >"); 
		Collections.sort(books, new Comparator<Book4> () {
			@Override
			public int compare(Book4 b1, Book4 b2) {
				int result = Integer.valueOf(b1.getNo()).compareTo(b2.getNo());
				if ( result == 0) {
					return  b1.getTitle().compareTo(b2.getTitle()) * -1;
				}
				return result;
			}
		});
		System.out.println(books);
		System.out.println(); 
		
		System.out.println("< Comparator.reverseOrder >");
		Collections.sort(books, Comparator.reverseOrder());
		System.out.println(books);
		System.out.println(); 
		
		List<String> list = new ArrayList<>(); 
		Collections.addAll(list, "Z", "e", "a", "c", "b", "D"); 
		
		System.out.println("< 알파뱃 내림차순 정렬 >");
		Collections.sort(list, Comparator.reverseOrder());
		System.out.println(list);
		System.out.println(); 
	
		System.out.println("< 대소문자 상관없이 알파벳 오름차순 정렬 >"); 
		Collections.sort(list, String.CASE_INSENSITIVE_ORDER);
		System.out.println(list);
		
	
	}
}

class AscendingNo implements Comparator<Book4>{
	@Override
	public int compare(Book4 b1, Book4 b2) {
		int result = Integer.valueOf(b1.getNo()).compareTo(b2.getNo()); 
		if (result == 0) {
			return b1.getTitle().compareTo(b2.getTitle());
		}
		return result;
	}
}

class DescendingTitle implements Comparator<Book4>{
	@Override 
	public int compare(Book4 b1, Book4 b2) {
		int result = Integer.valueOf(b1.getNo()).compareTo(b2.getNo());
		if ( result == 0) {
			return  b1.getTitle().compareTo(b2.getTitle());
		}
		return result;
	}
}

class Book4 implements Comparable<Book4>{
	private int no; 
	private String title; 
	public Book4(int no, String title) {
		this.no = no; 
		this.title = title;
	}
	public int getNo() {
		return no; 
	}
	public String getTitle() {
		return title; 
	}
	
	//번호 내림차순 정렬, 제목 오름차순 정렬
	@Override
	public int compareTo(Book4 book) {
		int result = Integer.valueOf(no).compareTo(book.getNo()) * -1;
		if (result == 0) {
			result = title.compareTo(book.title);
			return title.compareTo(book.title);
		}
		return result; 
	}
	@Override 
	public String toString() {
		return "(" + no + ", "  + title + ")"; 
	}
	
}