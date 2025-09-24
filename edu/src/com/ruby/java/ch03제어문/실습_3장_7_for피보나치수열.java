package com.ruby.java.ch03제어문;

import java.util.Scanner;

public class 실습_3장_7_for피보나치수열 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("피보나치 수열 항 수 입력 : ");
		int n = sc.nextInt();
		
		int first = 0;
		int second = 1;
		
		if(n >= 1) System.out.println(first + " ");
		if(n >= 2) System.out.println(second + " ");
		
		int next;
		for(int i =3; i <= n; i++) {
			next = first + second;
			System.out.println(next + " ");
			first = second;
			second = next;
		}
		
		sc.close();
	}
}