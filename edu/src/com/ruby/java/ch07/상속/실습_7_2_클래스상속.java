package com.ruby.java.ch07.상속;

//Item 클래스
class Item2 {
	private String name;
	private double price;
	private int stockQuantity;

	// 생성자
	public Item2(String name, double price, int stockQuantity) {
		this.name = name;
		this.price = price;
		this.stockQuantity = stockQuantity;
	}

	@Override
	public String toString() {
		return "이름 : " + this.name + ", 가격 : " + price + "주문수량 : " + stockQuantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getPrice() {
		// TODO Auto-generated method stub
		return price;
	}

	
}

//Electronics 클래스 (Item 클래스를 상속)
class Electronics extends Item2 {
	private int warranty; // 제품 보증 기간

	// 생성자
	
	public Electronics(String string, double d, int i, int j) {
		super(string, d, i);
		warranty = j;
	}

	@Override
	public String toString() {
		return super.toString() + "제품 보증 기간 : " + warranty;
	}
	
}

//Clothing 클래스 (Item 클래스를 상속)
class Clothing extends Item2 {
	private String size;
	private String color;

	// 생성자
	
	public Clothing(String string, double d, int i, String string2, String string3) {
		super(string, d, i);
		this.size = string2;
		this.color = string3;
	}

	@Override
	public String toString() {
		return super.toString() + "사이즈 : " + this.size + ", 색상 : " + this.color;
	}

}

//Customer 추상 클래스 정의
abstract class Customer2 {
	private String cname;
	private String city;
	private int age;

	public Customer2(String name, String city2, int age2) {
		// TODO Auto-generated constructor stub
		this.cname = name;
		this.city = city2;
		this.age = age2;
	}

	// 생성자
	

	@Override
	public String toString() {
		return "이름 : " +cname+  "도시 : " +this.city +  "나이 : " + this.age;
	}

	abstract double getDiscountRate();
	abstract double applyDiscount(double totalAmount);

}

//RegularCustomer 클래스: Customer 클래스를 상속받음
class RegularCustomer extends Customer2 {
	static final double REGULARDISCOUNT_RATE = 0.03;

	public RegularCustomer(String name, String city, int age) {
		super(name, city, age);
	}

	@Override
	double applyDiscount(double totalAmount) {
		// 일반 고객 할인 적용
		totalAmount = - (totalAmount * REGULARDISCOUNT_RATE);
		return totalAmount;
	}

	@Override
	double getDiscountRate() {
		return REGULARDISCOUNT_RATE;
	}
}

//PremiumCustomer 클래스: Customer 클래스를 상속받음
class PremiumCustomer extends Customer2 {
	static final double PREMIUMDISCOUNT_RATE = 0.1;

	public PremiumCustomer(String string, String string2, int i) {
		// TODO Auto-generated constructor stub
		super(string, string2, i);
	}

	@Override
	public double applyDiscount(double totalAmount) {
		totalAmount = -(totalAmount * PREMIUMDISCOUNT_RATE);
		return totalAmount;
	}
	
	@Override
	public double getDiscountRate() {
		return PREMIUMDISCOUNT_RATE;
	}
}

//Order 클래스
class Order2 {
	private Customer2 customer;
	private Item2[] items;
	private int[] quantities;
	private int itemCount;

	// 생성자
	
	
	public Order2(Customer2 customer, int i) {
		// TODO Auto-generated constructor stub
		this.customer = customer;
		items = new Item2[i];
		quantities = new int[i];
		this.itemCount = 0;
	}


	public void addItem(Item2 item, int quantity) {
		items[itemCount] = item;
		quantities[itemCount] = quantity;
		itemCount ++;
	}

	private double calculateTotal() {
		double total = 0.0;
		for(int i = 0; i < itemCount; i++) {
			total += (items[i].getPrice() * quantities[i]);
		}
		return total;
	}

	private double calculateDiscountedTotal() {
		double totalAmount = calculateTotal();
		return customer.applyDiscount(totalAmount);
	}

	public void printOrderSummary() {
		/*
		 * 할인된 가격의 합계 출력 할인 금액 합계 출력
		 */
		System.out.println("고객정보 : " + customer.toString());
		for(int i = 0; i < itemCount; i++) {
			System.out.println("제품명 : " + items[i].getName() + ", 단가 : " + items[i].getPrice() + ", 개수 : " + items[i].getStockQuantity() + " => 가격 : " + items[i].getPrice());
		}
		System.out.println("총액 : " + calculateTotal() + "할인율 : " + customer.getDiscountRate() + "할인금액 : " + calculateDiscountedTotal());
		System.out.println("할인 후 총액 : " + String.format("%.1f",(calculateTotal() - calculateDiscountedTotal())));
		System.out.println("-".repeat(25));
		
	}
	
//	Premium Customer Order:
//		고객정보 : 고객명:홍길동, 도시:부산, 나이:30
//		제품명 : 노트북, 단가 : 1200.0, 개수 : 1 ==> 가격 : 1200.0
//		제품명 : 티셔츠, 단가 : 20.0, 개수 : 2 ==> 가격 : 40.0
//		총액:1240.0, 할인율:0.1, 할인금액:-124.0
//		할인 후 총액:1116.0
}

public class 실습_7_2_클래스상속 {

	public static void main(String[] args) {

		// 의류 및 전자제품 생성
		Item2 laptop = new Electronics("노트북", 1200.00, 10, 24);
		Electronics phone = new Electronics("휴대폰", 800.00, 30, 12);
		Clothing tshirt = new Clothing("티셔츠", 20.00, 50, "M", "Blue");
		Clothing jacket = new Clothing("자켓", 80.00, 20, "L", "Black");

		// 고객 생성
		PremiumCustomer premiumCustomer = new PremiumCustomer("홍길동", "부산", 30);
		RegularCustomer regularCustomer = new RegularCustomer("계백", "양산", 25);

		// 주문 생성
		Order2 order1 = new Order2(premiumCustomer, 4);
		order1.addItem(laptop, 1);
		order1.addItem(tshirt, 2);

		Order2 order2 = new Order2(regularCustomer, 4);
		order2.addItem(phone, 1);
		order2.addItem(jacket, 1);

		// 주문 요약 출력
		System.out.println("Premium Customer Order:");
		order1.printOrderSummary();

		System.out.println("Regular Customer Order:");
		order2.printOrderSummary();

		/*
		 * 출력 결과 예시
		 * 
		Premium Customer Order:
		고객정보 : 고객명:홍길동, 도시:부산, 나이:30
		제품명 : 노트북, 단가 : 1200.0, 개수 : 1 ==> 가격 : 1200.0
		제품명 : 티셔츠, 단가 : 20.0, 개수 : 2 ==> 가격 : 40.0
		총액:1240.0, 할인율:0.1, 할인금액:-124.0
		할인 후 총액:1116.0
		-------------------------------------------------------
		Regular Customer Order:
		고객정보 : 고객명:계백, 도시:양산, 나이:25
		제품명 : 휴대폰, 단가 : 800.0, 개수 : 1 ==> 가격 : 800.0
		제품명 : 자켓, 단가 : 80.0, 개수 : 1 ==> 가격 : 80.0
		총액:880.0, 할인율:0.03, 할인금액:-26.399999999999977
		할인 후 총액:853.6
		-------------------------------------------------------
		*/
	}
}