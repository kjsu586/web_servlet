package re_exam;

import java.util.Random;
import java.util.Scanner;

//Random : 자동으로 PC가 생성하는 원리 -> 기본 소수점
//Math.random() : 클래스가 아니고 함수! / Java, JS 둘 다 있다.
public class exam1 {

	public static void main(String[] args) {
		/* 보안코드 만들 때 문자 만드는법
		for(int i =0; i < 5; i++) {
			double rd = Math.random();
			char word = (char)((rd*26) + 65);
			System.out.println(word);
		}
		*/

		Random rand = new Random();
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자 하나를 입력하세요 : ");
		int no = sc.nextInt();
		for(int f=1; f<=no; f++) {
			int free = rand.nextInt(99);
			System.out.println(free);
		}
		sc.close();
	}

}
