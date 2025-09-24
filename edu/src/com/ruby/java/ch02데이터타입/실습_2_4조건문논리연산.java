package com.ruby.java.ch02데이터타입;

import java.util.Scanner;

public class 실습_2_4조건문논리연산 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("나이 입력 : ");
		int n = sc.nextInt();
		
		System.out.print("지역 입력 : ");
		String st = sc.next();	
		
		boolean isYoung = (st.equals("부산") && 20 <= n && n <= 30);
		System.out.println("나이 = " + n + ", 도시 = " 
				+ st + "부산청년여부 = " + (isYoung ? "참" : "거짓"));	
	}
}
