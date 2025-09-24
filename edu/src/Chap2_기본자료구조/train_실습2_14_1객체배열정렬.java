package Chap2_기본자료구조;

/*
 * 2장 제출 과제 
 * Comparable 인터페이스의 구현 
 * 5번 실습 - 2장 실습 2-10를 수정하여 객체 배열의 정렬 구현
 */
import java.util.Arrays;

//5번 실습 - 2장 실습 2-14를 수정하여 객체 배열의 정렬 구현
class PhyscData2 implements Comparable<PhyscData2> {
	String name;
	int height;
	double vision;
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public double getVision() {
		return vision;
	}

	public void setVision(double vision) {
		this.vision = vision;
	}

	public PhyscData2(String string, int i, double d) {
		this.name = string;
		this.height = i;
		this.vision = d;
	}

	public int compareTo(PhyscData2 p) {
		if (name.compareTo(p.name) == 0) {
			if (height > p.height) {
				return height - p.height;
			}
			else return p.height - height;
		}
		else {
			return name.compareTo(p.name);
		}
	}
}

public class train_실습2_14_1객체배열정렬 {

	static void swap(PhyscData2[] data, int i, int j) {
		PhyscData2 temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}

	static void sortData(PhyscData2[] data) {
		for (int i = 0; i < data.length; i++)
			for (int j = 0; j < data.length; j++) {
				if (data[i].compareTo(data[j]) > 0)
					swap(data, i, j);
			}
	}

	static void showData(String string, PhyscData2[] data) {
		System.out.println(string);
		for (int i = 0; i < data.length; i++) {
				System.out.println("이름 : " + data[i].getName() + ", 키 : " + data[i].getHeight() + ", 시력 : " + data[i].getVision());
			}
	}

	static int binarySearch(PhyscData2[] data, String string) {
		    int left = 0;
		    int right = data.length - 1;

		    while (left <= right) {
		        int mid = (left + right) / 2;
		        int searchData = data[mid].getName().compareTo(string);

		        if (searchData == 0) {      
		            return mid;
		        } else if (searchData < 0) { 
		            left = mid + 1;
		        } else {             
		            right = mid - 1;
		        }
		    }
		    return -1; 
		}
	
	static PhyscData2[] insertObject(PhyscData2[] data, PhyscData2 newObj) {
		
		PhyscData2[] newData = new PhyscData2[data.length + 1];
		
		for(int i = 0; i < data.length; i++) {
			newData[i] = data[i];
		}
		
		newData[data.length] = newObj;
		
		sortData(newData);
		
		return newData;
	}

	
	public static void main(String[] args) {

		PhyscData2[] data = { 	new PhyscData2("홍길동", 162, 0.3), 
								new PhyscData2("홍동", 164, 1.3),
								new PhyscData2("홍길", 152, 0.7), 
								new PhyscData2("김홍길동", 172, 0.3), 
								new PhyscData2("이길동", 182, 0.6),
								new PhyscData2("박길동", 167, 0.2), 
								new PhyscData2("최길동", 169, 0.5), };
		
		showData("정렬전", data);
		sortData(data);
		showData("정렬후", data);

		Arrays.sort(data);// comparator가 필요하다
		showData("Arrays.sort() 실행후", data);

		int resultIndex = binarySearch(data, "이길동");

		if (resultIndex >= 0)
			System.out.println("이길동이 존재하면 인덱스 = " + resultIndex);
		else
			System.out.println("이길동은 존재하지 않는다");

		PhyscData2[] newData = insertObject(data, new PhyscData2("소주다", 179, 1.5));
		
		showData("삽입후", newData);
	}
}

