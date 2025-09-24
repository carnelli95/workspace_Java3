package com.ruby.java.ch07.상속;

class Person3 {
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String toString() {
		return name + ", ";
	}
}

class Employee3 extends Person3 {
	private String dept;
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	} 
	// method overriding
	@Override
	public String toString() {
//		return name + ", "+age + "," + dept;//오류 발생: 이유는 name,age가 Person의 private이기 때문
		//283페이지 하단 문단 이해
		return super.toString()+ ", "+ dept;
	}
}
class Professor3 extends Person3 {
	private String subject;
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	// method overriding
	public String toString() {
//		return name + ", "+age + "," + subject;
		return super.toString()+ ", "+ subject;
	}
}
class Student3 extends Person3 {
	private String major;
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	// method overriding - 285페이지 중간: 1,,2,3,4 설명 암기
	public String toString() {
//		return name + ", "+age + "," + major;
//		return this.getName() + ", "+getAge() + "," + major;
		//아직도 중복 코딩 발생
		return super.toString() + major;
	}
}
	

public class 클래스_메소드오버라이딩_7_2_1절 {
	public static void main(String[] args) {
		
		System.out.println();
		Employee3 e = new Employee3();
		Professor3 p = new Professor3();
		Student3 s = new Student3();

		e.setName("오정임");
		e.setAge(47);
		e.setDept("입학처");

		p.setName("김푸름");
		p.setAge(52);
		p.setSubject("빅데이터");

		s.setName("김유빈");
		s.setAge(20);
		s.setMajor("컴퓨터과학");

		System.out.println(e.toString());
		System.out.println(p.toString());
		System.out.println(s.toString());
	}
}
