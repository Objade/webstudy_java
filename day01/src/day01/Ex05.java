package day01;

import java.util.Random;

public class Ex05 {
	public static void main(String[] args) {
		
		// 제어문 (control statement)
		// 프로그램의 진행 흐름을 제어하는 구문 (진행이 일률적이지 않다.)
		
	
		// 아래에 코드를 작성하여 3개의 정수 중 가장 작은 수를 화면에 출력하세요.
		
		Random ran = new Random();
		int n1 = ran.nextInt(10) + 1;
		int n2 = ran.nextInt(10) + 1;
		int n3 = ran.nextInt(10) + 1;
		
		int min;
		
		
		if(n1 > n2) {
			min = n2;
		} else {
			min = n1;
		}
		
		if (min > n3) {
			min = n3;
		}

		
		System.out.printf("%d, %d, %d\n", n1, n2, n3);
		System.out.println("가장 작은 값 : " + min);
	
		
		
		// 풀이
		
		if(n1 <= n2 && n1 <= n3) {
			min = n1;
		}
		else if(n2 <= n1 && n2 <= n3) {
			min = n2;
		}
		
		else if(n3 <= n1 && n3 <= n2) {
			min = n3;
		}
		
		System.out.println("최소값 : " + min);
		
		
		
		// 다른 풀이
		
		
		min = n1; 		// n1이 최소값이라고 가정하고
		if(n2 < min)	// 만약, n2가 현재 최소값보다 더 작으면
			min = n2;	// n2의 값을 최소값에 저장
		if(n3 < min)	// 만약, n3가 현재 최소값보다 더 작으면
			min = n3;	// n3의 값을 최소값에 저장
		
		System.out.println("최소값 : " + min);
		
	}
}
