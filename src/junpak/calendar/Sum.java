package junpak.calendar;

import java.util.Scanner;

public class Sum {
	public static void main(String[] args) {
		// 나의 풀이
		System.out.println("두 수를 입력하세요.");
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		String[] nums = str.split(" ");
		int firstNum = Integer.parseInt(nums[0]);
		int secondNum = Integer.parseInt(nums[1]);
		System.out.printf("두 수의 합은 %d 입니다. %n", firstNum + secondNum);
		scanner.close();

		// 강의 설명
		int a, b;

		//입력: 키보드로 두 수의 입력을 받는다.
		Scanner scanner1 = new Scanner(System.in);
		String s1, s2;
		System.out.println("두 수를 입력하세요.");
		s1 = scanner1.next();
		s2 = scanner1.next();
		a = Integer.parseInt(s1);
		b = Integer.parseInt(s2);

		// 출력: 화면에 두 수의 합을 출력한다.
		// System.out.println("두 수의 합은 " + (a + b) + " 입니다.");
		System.out.printf("%d와 %d의 합은 %d%n 입니다.", a, b, a + b);
		scanner1.close();
	}
}
