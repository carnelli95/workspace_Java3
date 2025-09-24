package com.ruby.java.ch06객체구현;

class Student3 {
	// 필드
	/*
	 * name, age, subjects[], scores[], passFail[], count를 private으로 선언 count는 배열의
	 * index로 사용 numberStudents를 정적 필드로 선언
	 */

	private String name;
	private int age;
	private String[] subjects;
	private int[] scores;
	private int[] passFail;
	int count;
	static int numberStudents = 0;
	
	// 생성자
	/*
	 * name, age, subjects[], scores[], passFail[], count를 매개변수로 전달받는 생성자 정의
	 * 
	 */

	public Student3(String name, int age, String subjects[], int scores[], int passFail[], int count) {
		this.name = name;
		this.age = age;
		this.subjects = subjects;
		this.scores = scores;
		this.passFail = passFail;
		this.count = count;
	}

	// setter 메소드: setName(String name), setAge(int age), setSubjects(String
	// subjects[]), setScores(int scores[]), setCount(int num)

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setSubjects(String subjects[]) {
		this.subjects = subjects;
	}

	public void setScores(int scores[]) {
		this.scores = scores;
	}

	public void setCount(int count) {
		this.count = count;
	}

	// 학생 수를 반환하는 정적 메소드getNumberStudents()

	public static int getCount(Student3[] students) {
		for(Student3 s : students) {
			numberStudents ++;
		}
		return numberStudents;
	}

	// 학생 정보를 출력하는 메소드 (예시용)
	public void printStudent() {
		/*
		 * 이름 = **, 나이 = ** 과목1 = **, 점수1 = ** 과목2 = **, 점수2 = ** ... 등으로 출력
		 */
		System.out.println("이름 = " + this.name + ", " + "나이 = " + this.age);
		for (int i = 0; i < this.count; i++) {
			System.out.println("과목" + i + " = " + subjects[i] + ", " + "점수" + i + " = " + scores[i]);
		}
		;
	}

	// 학생 정보를 출력하는 메소드 (예시용)
	public void printStudentInfo(Student3[] students) {
		/*
		 * 이름 = **, 나이 = ** 과목1 = **, 점수1 = **, 통과여부=pass 과목2 = **, 점수2 = **, 통과여부=fail
		 * ... 등으로 출력
		 */
		System.out.println("이름 = " + this.name + ", " + "나이 = " + this.age);
		for (int i = 0; i < this.count; i++) {
			System.out.println("과목" + i + " = " + subjects[i] + ", " + "점수" + i + " = " + scores[i] + ", " + "통과여부 = "
					+ passFail[i]);
		}
		;
	}

	// 통과 여부 (모든 과목을 통과했는지 확인)
	public boolean isPassed() {
		// 주어진 학생이 모든 과목 통여 여부를 반환
		for (int i = 0; i < this.count; i++) {
			if (this.passFail[i] == 1)
				continue;
			else
				return false;
		}
		return true;
	}

	// 6.2.2 각 학생의 성적 테이블을 출력하는 정적 메소드
	public static void printAllStudents(Student3[] students) {
		// 학생 이름 + 과목명, 과목 점수 .... + 과목통과여부:pass or fail
		for (int i = 0; i < students.length; i++) {
			for (int y = 0; i < students[i].count; i++) {
				System.out.println("이름 : " + students[i].name + "과목명 : " + students[i].subjects[y]);
			};
		};
	}

	// 6.2.2 과목별 최대/최소 점수 및 해당 학생을 출력하는 정적 메소드
	public static void printSubjectStats(Student3[] students) {
		int max = 0;
		int min = 100;
		int numMax = 0;
		int numMin = 0;
		for(int i = 0 ; i < students.length; i++) {
			for(int y = 0; y < students[y].scores.length; i++) {
				
				if(students[i].scores[y] > max) {
					max = students[i].scores[y];
					numMax = i;
				}
				if(students[i].scores[y] < min) {
					min = students[i].scores[y];
					numMin = i;
				}
				System.out.println(students[i].subjects[y] + "최대점수 : " + "학생 이름 : " + students[numMax].name);
				System.out.println(students[i].subjects[y] + "최소점수 : " + "학생 이름 : " + students[numMin]);
			}
		};
		
}

public class 실습_6_3정적메소드 {

	public static void main(String[] args) {
		String[] subjects = {"수학", "국어", "영어", "과학", "역사"};
		int []passFails = {40,70,60,55,80};
		Student3[] students = { 
				  new Student3 ("홍길동", 21, subjects, new int[]{85, 90, 78, 88, 92},passFails, -1),
				  new Student3 ("김유신", 22, subjects, new int[]{75, 80, 85, 90, 95}, passFails,-1),
				  new Student3 ("계백", 23, subjects, new int[]{65, 70, 75, 80, 85}, passFails,-1),
				  new Student3 ("강감찬", 24, subjects, new int[]{95, 92, 88, 84, 91}, passFails,-1),
				  new Student3 ("을지문덕", 25, subjects, new int[]{88, 76, 85, 79, 90}, passFails,-1)
		};
		// 학생 수를 정적 메소드 호출로 처리
		

		// 학생 정보 출력 (예시)
//		Student3.printStudentInfo(students);

		// 각 학생의 성적 테이블 출력
		Student3.printAllStudents(students);

		// 과목별 최대/최소 점수 및 해당 학생 출력
		Student3.printSubjectStats(students);
		}
}}
