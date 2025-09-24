package com.ruby.java.ch05객체;


  class Box {
    // 필드 (속성)
    double width;  // 가로
    double height; // 세로
    double depth;  // 높이
    // 부피 계산 메소드
    double getVolume(double width, double height, double depth) {
        return width * height * depth;
    }

	// 둘레 길이 계산 메소드
    double getPerimeter(double width, double height) {
        return 2 *(width + height);
    }
    
    // 박스 크기 조정 (메소드 오버로딩)
    void resize(double newWidth, double newHeight, double newDepth) {
        //박스의 가로,세로,높이를 변경
    	width = newWidth;
    	height = newHeight;
    	depth = newDepth;
    }

    void resize(double scale) {
        //박스의 가로,세로,높이를 scale 비율로 변경
    	width *= scale;
    	height *= scale;
    	depth *= depth;
    }
    
    void show() {
    	System.out.println("width="+width+ ", height = " + height + ", depth = " + depth);
    }
    
    @Override
    public String toString() {
       return "width="+width+ ", height = " + height + ", depth = " + depth;
    }
  	}
public class 실습_5_2_상자클래스 {
	public static void main(String[] args) {
        // 박스 객체 생성
//        Box box1 = new Box(10, 5, 3);
		Box box1 = new Box();
		box1.width = 10;
		box1.height = 5;
		box1.depth = 3;
        // 박스 정보 출력
        box1.show();
        System.out.println(box1.getVolume(box1.width, box1.height, box1.depth));
        // 박스 크기 변경
        box1.resize(15, 8, 5);
        box1.show();
        System.out.println(box1.getPerimeter(box1.width, box1.height));
        // 박스를 2배 확대
        box1.resize(0.5);
        box1.show();
        
//        Box box2 = new Box(4, 7, 3);
        Box box2 = new Box();
		box2.width = 30;
		box2.height = 8;
		box2.depth = 2.7;
        System.out.println(box2);
        box2.show();
     // 박스 크기 변경
        box2.resize(9, 3, 8);
        System.out.println(box2);
        box2.show();

        // 박스를 2배 확대
        box2.resize(1.5);
        System.out.println(box2);
        box2.show();
        
    }
}
