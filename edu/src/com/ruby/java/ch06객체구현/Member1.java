package com.ruby.java.ch06객체구현;

public class Member1 {
	
	private String name;
	private int age;
	
	public Member1() {
		this("guest");
	}
	
	public Member1(String name) {
		this(name, 0);
	}
	
	public Member1(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String toStirng() {
		return name + ":" + age;
	}
	
	public static void main(String[] args) {
	
		Member1 m1 = new Member1();
		Member1 m2 = new Member1("Amy");
		Member1 m3 = new Member1("Amy", 23);
		
		System.out.println(m1.toStirng());
		System.out.println(m2.toStirng());
		System.out.println(m3.toStirng());
		
	}
}
