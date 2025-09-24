package com.ruby.java.ch04배열;
/*
 * 난수 배열의 최대, 최소, 평균 구하기
 * 0부터 100까지의 정수 난수 10개를 생성하여 배열에 저장
 * 배열에서 최대값, 최소값, 평균을 구하기
 *   >> for문을 사용한 최대값 찾기 - 교재 149 페이지의 배열 길이: length 사용
 * 출력 내용:
 *   배열 price는 확장형 for 문으로 출력, 출력 형태는 다음과 같다:
 *   [1,2,3,4,5]
 *   최대값 출력은 다음과 같다
 *   최대값 = **
 *   최소값, 평균값 출력은 최대값 출력과 같다.
 *   


 */

import java.util.Random;

public class 실습_4_4_배열생성최대값 {
	
	public static void main(String[] args) {
		
		Random rd = new Random();
		int num[] = new int[10];
		
		int sum = 0;
		double avg = 0;
		int max = 0;
		int min = 999;
		
		
		for(int i = 0; i < num.length; i++) {
			num[i] = rd.nextInt(100);
		}
		
		
		for(int i = 0; i < num.length; i++) {
			if(max < num[i]) max = num[i];
		}
		
		for(int i = 0; i < num.length; i++) {
			if(min > num[i]) min = num[i];
		}
		
		for(int i = 0; i < num.length; i++) {
			sum += num[i];
		}
		
		avg = (double)sum / num.length;
		
		System.out.println("최대값 : " + max);
		System.out.println("최소값 : " + min);
		System.out.println("평균값 : " + avg);
	}
}
