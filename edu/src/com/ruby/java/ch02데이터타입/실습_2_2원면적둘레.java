package com.ruby.java.ch02데이터타입;

public class 실습_2_2원면적둘레 {
	
	public static void main(String[] args) {
		
		double radius = 7.5;
		double area = Math.PI * radius * radius;
		double circumference = 2 * Math.PI * radius;
		
		System.out.printf("원의 면적 = %.2f", area);
		System.out.printf("원의 둘레 = %.2f", circumference);
		
	}
}
