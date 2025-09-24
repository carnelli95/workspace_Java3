package com.ruby.java.ch04배열;

public class Test39 {
	
	public static void main(String[] args) {
		
		int[][] arr = new int[5][5];
		int num = 1;
		int sum = 0;
		for(int i = 0 ; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				arr[i][j] = num++;
			}
		}
		
		for(int i = 0; i < arr.length; i++) {
					sum += arr[i][i];
		}
		System.out.println(sum);
	}
}
