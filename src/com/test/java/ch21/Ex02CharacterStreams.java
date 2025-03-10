package com.test.java.ch21;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;


public class Ex02CharacterStreams {
	public static void main(String[] args) {
		try (
				InputStreamReader in = new InputStreamReader(new FileInputStream("./src/com/test/java/ch21/TTEE.txt"));
				OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream("./src/com/test/java/ch21/out2-inputstreamwriter.txt"));
			) {
				int c;
				while ((c = in.read()) != -1) {
					out.write(c);
				}
				System.out.println("< ByteStream -> CharacterStream >");
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println();
		
		try (
			FileReader in = new FileReader("./src/com/test/java/ch21/TTEE.txt");
			FileWriter out = new FileWriter("./src/com/test/java/ch21/out2-filewriter.txt");
		) {
			int c;
			while ((c = in.read()) != -1) {
				out.write(c);
			}
			System.out.println("< FileReader / FileWriter >");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println();
		
		try (
			BufferedReader in = new BufferedReader(new FileReader("./src/com/test/java/ch21/TTEE1.txt"));
			BufferedWriter out = new BufferedWriter(new FileWriter("./src/com/test/java/ch21/out2-bufferedwriter.txt"));
		) {
			String line;
			while ((line = in.readLine()) != null) {
				out.write(line);
				out.newLine();
			}
			System.out.println("< File Reader/Writer -> Buffered Reader/Writer >");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println();
		
		try (
			BufferedReader in = new BufferedReader(new FileReader("./src/com/test/java/ch21/TTEE1.txt"));
			PrintWriter out = new PrintWriter(new FileWriter("./src/com/test/java/ch21/out2-printwriter.txt"));
		) {
			String line;
			while ((line = in.readLine()) != null) {
				out.println(line);
			}
			System.out.println("< FileWriter -> PrintWriter >");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println();
		
		System.out.println("< FileReader -> Scanner >");
		try (
			Scanner s = new Scanner(new FileReader("./src/com/test/java/ch21/TTEE1.txt"));
		) {
			while (s.hasNext()) {
				System.out.println(s.next());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println();
		
		System.out.println("< BufferedReader -> Scanner >");
		try (
			Scanner s = new Scanner(new BufferedReader(new FileReader("./src/com/test/java/ch21/TTEE1.txt")));
		) {
			while (s.hasNext()) {
				System.out.println(s.next());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

/*
문제 1.
문장들이 적힌 텍스트 파일을 생성하세요.
버퍼를 사용해 텍스트 파일을 읽어 들인 후 줄 번호와 함께 내용들을 출력하세요.
예) 
1. 안녕하세요.
2. Hello.
*/