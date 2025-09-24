package com.ruby.java.ch06객체구현;

class Armor {
	String name;
	int height;

	public String getName() { // getter
		return name;
	}

//	public void setName(String value) { // setter
//		name = value;
//	}
	
	public void setName(String name) { // setter
		this.name = name;
	}

	public int getHeight() {
		return height;
	}

//	public void setHeight(int value) {
//		height = value;
//	}
	
	public void setHeight(int height) {
		this.height = height;
	}
}