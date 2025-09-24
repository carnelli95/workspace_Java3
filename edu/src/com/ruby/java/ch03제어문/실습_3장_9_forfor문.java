package com.ruby.java.ch03제어문;

import java.util.Scanner;

public class 실습_3장_9_forfor문 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("레벨 입력 : ");
		int level = sc.nextInt();
		
		System.out.println("실습1: 역삼각형");
		for(int i = level; i >= 1; i--) {
			for(int j = 1; j <= i; j++) {
				System.out.print("$");
			}
			System.out.println();
		}
		System.out.println();
	}
}