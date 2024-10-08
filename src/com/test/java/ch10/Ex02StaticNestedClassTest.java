package com.test.java.ch10;

public class Ex02StaticNestedClassTest {
	public static void main(String[] args) {
		Book33 book = new Book33();
        book.printInfo();
        
        int discountedPrice = Book33.Discount.getDiscount("october", 10000);
        System.out.println("할인된 가격: " + discountedPrice);
    }
}

class Book33 {
    String title;
    String author;
    static int price;

    static class Discount {
        private static float discount;

        public static int getDiscount(String season, int price) {
            switch (season) {
                case "august":
                    discount = 0.25f;
                    break;
                case "september":
                    discount = 0.3f;
                    break;
                case "october":
                    discount = 0.35f;
                    break;
                default:
                    discount = 0f;
                    break; 
            }
            
            return (int) (price - ( price * discount ));
        }
    }


    Book33() {
        title = "자바강의";
        author = "엘컴퓨터학원";
        price = 40000;
    }

    void printInfo() {
        System.out.printf("제목: %s%n저자: %s%n가격: %d%n", title, author, price);
    }
}

/*
문제 1.
static 중첩 클래스를 사용한 예제를 작성하세요.

*/