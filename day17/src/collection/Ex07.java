package collection;

import java.util.ArrayList;
import java.util.Comparator;

class Item {
	String name;
	int price;
	
	Item(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	@Override
	public String toString() {
		
		return String.format("%s : %,d원", name, price);
	}
}

// 비교하는 객체를 직접 만들어서 사용해보기
class MyComparator implements Comparator<Item> {	
	
	// Comparator 인터페이스에는 미구현 추상 메서드가 하나임
	// -> 함수형 인터페이스임

	@Override
	public int compare(Item o1, Item o2) {
		return o1.price - o2.price;	
		
		// o1.price - o2.price > 0
		// -> o1.price > o2.price
		// 반환값이 0보다 큰지 아닌지에 따라서 자리바꿈을 판별한다.

	}
	
}

public class Ex07 {
	public static void main(String[] args) {
		
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		ArrayList<Item> list2 = new ArrayList<Item>();
		
		list1.add(2);
		list1.add(7);
		list1.add(8);
		list1.add(4);
		list1.add(6);
		
		System.out.println(list1);
		list1.sort(null);
		System.out.println(list1);
		System.out.println();
		
		
		list2.add(new Item("오레오", 2000));
		list2.add(new Item("몽쉘", 3000));
		list2.add(new Item("초코파이", 2500));
		list2.add(new Item("오예스", 2700));
		list2.add(new Item("빅파이", 2900));
		
//		System.out.println(list2);
		list2.forEach(System.out::println);
		System.out.println();
		
		
		// 가격 순 오름차순 정렬 (MyComparator implement Comparator의 객체를 생성하여 전달)
		System.out.println("가격 오름차순 정렬");
		MyComparator priceCmp = new MyComparator();
		list2.sort(priceCmp);
		
		list2.forEach(System.out::println);
		System.out.println();
		
		
		// 이름 순 오름차순 정렬 (익명 클래스 활용)
		System.out.println("이름 오름차순 정렬");
		list2.sort(new Comparator<Item>() {

			@Override
			public int compare(Item o1, Item o2) {
				return o1.name.compareTo(o2.name);
				// 문자열끼리 비교하여, 그 차이를 int 타입으로 반환하는 함수 compareTo(s1, s2)
			}
		});
		
		list2.forEach(System.out::println);
		System.out.println();
		
		
		// 가격 순 내림차순 정렬 (람다식)
		System.out.println("가격 내림차순 정렬");
										
		list2.sort((o1, o2) -> {		// 매개변수가 2개라서 소괄호는 생략 불가능
			return o2.price - o1.price;	// 실행 내용과 실행 결과가 한줄이기 때문에 중괄호와 return은 생략할 수 있음
		});
		
		list2.forEach(System.out::println);
		System.out.println();
		
		
		
	}
}
