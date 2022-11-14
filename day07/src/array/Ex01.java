package array;

import java.util.Scanner;

public class Ex01 {
	
	// 출력 함수
	
	static void show(int[] arr) {
		System.out.printf("arr[%d] : { ", arr.length);
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			System.out.print(i == arr.length - 1 ? " }\n" : ", ");
		}
	}
	
	public static void main(String[] args) {
		// 길이가 자동으로 증가하는 배열 만들어보기
		// Reference Type의 이해
		
		// 자바에서 primitive를 제외한 모든 유형의 데이터는 참조 변수를 활용한다.
		// 참조변수는 그 자체가 본체는 아니고, 참조하는 대상을 바꿀 수 있다.
		
		Scanner sc = new Scanner(System.in);
		int length = 3;
		int[] arr = new int[length];
		int[] tmp;	// 새로운 배열을 위한 참조변수 (초기값은 없음)
		int input;	// 사용자가 입력하는 정수를 받는 변수
	
		show(arr);
		
		// C언어의 배열은 길이에 변수를 넣을 수 없음. But, 자바는 가능함
		
		// 조건 1) 사용자가 0을 입력할 때 까지, 정수를 입력받는다.
		// 조건 2) 입력받은 정수는 모두 배열에 저장되어야 한다.
		// 조건 3) 순서를 유지하기 위해, 정렬은 수행하지 않는다.
		// 조건 4) 만약, 배열의 모든 값을 입력 받았다면, 단위 길이만큼 증가시킨 새로운 배열을 생성하고
		// 조건 5) 새로운 배열은 기존 배열의 숫자를 모두 복사하여 가지고 있어야 한다.
		
		while(true) {
			System.out.print("정수 입력 : ");
			input = sc.nextInt();
			if(input == 0) {
				break;
			}
			for(int i = 0; i < arr.length; i++) {
				if(arr[i] == 0) {			// 빈칸을 찾아서
					arr[i] = input;			// 입력 값을 저장하고,
					break;					// for문 탈출
					
				}	
			}
			
			show(arr);
			
			if(arr[arr.length - 1] != 0) {				// 배열이 꽉 찼으면,
				tmp = new int[arr.length + length];		// 새로운 배열을 생성하고
				for(int i = 0; i < arr.length; i++) {	
					tmp[i] = arr[i];					// 기존 배열 값을 신규 배열에 복사한다.
				}
				arr = tmp;
			}
		}
		
		System.out.println("끝");
		
		sc.close();
		
	}
}
