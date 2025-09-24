package com.ruby.java.ch04배열;

import java.util.Arrays;
import java.util.Random;

public class MergeArray {
	
	public static void main(String[] args) {
		
		int n = 5;
		Random rd = new Random();
		int [] a = new int[n];
		int [] b = new int[n];
		int [] c = new int[a.length + b.length];
		
		for(int i = 0; i < a.length; i++) {
			a[i] = rd.nextInt(10);
			b[i] = rd.nextInt(10); 
		}
		
		System.out.println("A : " + Arrays.toString(a));
		System.out.println("B : " + Arrays.toString(b));
		
		for(int i = 0; i < a.length; i++) {
			c[i] = a[i];
			c[i + a.length] = b[i];
		}
		System.out.println("C:" + Arrays.toString(c));
	}
}