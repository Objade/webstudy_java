package day05;

public class Ex07_Quiz3 {
	// 배열이나 문자열의 인덱스는, 항상 0부터 시작하여 (길이 -1)까지 존재한다.

	
	// 문제 1)
	static int min(int... args) {
	
		int min = args[0];
		
		for(int i = 0; i < args.length; i++) {
			if(min >= args[i]) {
				min = args[i];
			}
		}
		
		return min;
	}
	
	// 문제 1 풀이 ) 
	static int mini(int... args) {	// args -> 배열
		int ret = 10000000;
		for(int i = 0; i < args.length; i++) {
			int num = args[i];
			if(ret > num) {
				ret = num;
			}
		
		}
		return ret;
	}
	
	
	
	// 문제 2)
	static int count(String str, char a) {
		int cnt = 0;
		
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == a) {
				cnt += 1;
			}	
		} 
		return cnt;
	}
	
	
	// 문제 2 풀이)
	static int counter(String str, char ch) {	// str -> 문자열
		int cnt = 0;
		for(int i = 0; i < str.length(); i++) {
			char current = str.charAt(i);		// ch와 current의 자료형은 char(primitive)
			if(current == ch) {
				cnt++;
			}
		}
		
		return cnt;
	}
	
	
	static boolean check(String str) {
		boolean flag = true;
		
		// 1) 길이가 일치하는가?
		if(str.length() != 19) {
			flag = false;
		}
		
		// 2) -의 개수가 일치하는가?		-> 함수의 재사용
		if(count(str, '-') != 3){
			flag = false;
		}
		
		// 3) split으로 분리했을 때, 분리된 요소가 4개이고, 각 요소의 자릿수가 4인가
		
		int cnt = 0;
		
		String[] a1 = str.split("-");
		
		for(int i = 0; i < a1.length; i++) {
			cnt++;
			
			if(a1[i].length() != 4) {
				flag = false;
			}	
		}
		
		if(cnt != 4) {
			flag = false;
		}
		
		return flag;
		
		/*
		 * String[] arr = str.split("-");		// split으로 분리했을 때, 분리된 요소가 4개인가
			if(arr.length != 4) flag = false;
	
			for(int i = 0; i < arr.length; i++) {	// split으로 분리했을 때, 각 요소의 자릿수가 4인가
				String s = arr[i];
				System.out.println("s : " + s);
				if(s.length() != 4)
				flag = false;
	}
		 * */
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		
		// 1) 정수를 여러개 전달 받아서, 최소값을 반환하는 함수를 작성하세요.
		
		int n1 = min(10, 5, 11);
		System.out.println("n1 : " + n1);
		
		n1 = mini(10, 5, 11);
		System.out.println("n1 : " + n1);
		
		
		// 2) 문자열에서 특정 글자가 몇개 포함되어 있는지 반환하는 함수를 작성하세요.
		int n2 = count("Life is too short, you need python", 'e');
		System.out.println("n2 : " + n2);
		
		n2 = counter("Life is too short, you need python", 'e');
		System.out.println("n2 : " + n2);
		
		
		// 3) 문자열 형태로 카드번호를 입력받아서, 길이에 맞는지 확인하는 함수를 작성하세요.
		// 일치해야 하는 것 : 전체 길이, -의 개수, 분리했을 때 각 단위의 길이
		
		boolean b1 = check("1234-1234-1234-1234");	// true
		boolean b2 = check("867-2356123-1234567");	// false
		boolean b3 = check("930516-2345678");		// false
		boolean b4 = check("123-45678-9-1234567");	// false
		System.out.printf("%b, %b, %b, %b\n", b1, b2, b3, b4);
		
		
	}
}	