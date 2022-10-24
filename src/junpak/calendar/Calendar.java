package junpak.calendar;

import java.util.Scanner;

public class Calendar {
	public static void main(String[] args) {
		System.out.println("일 월 화 수 목 금 토");
		System.out.println("--------------------");
		System.out.println("1  2  3  4  5  6  7");
		System.out.println("8  9 10 11 12 13 14");
		System.out.println("15 16 17 18 19 20 21");
		System.out.println("22 23 24 25 26 27 28");

		//나의 풀이
		int[] monthLength = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		System.out.println("달을 입력하세요.");
		Scanner scanner = new Scanner(System.in);
		int month = scanner.nextInt();
		if (month < 1 || month > 12) {
			System.out.println("입력한 값을 확인해 주세요.");
		} else {
			System.out.printf("%d월은 %d 일까지 있습니다. %n", month, monthLength[month - 1]);
		}

		//강의 설명
		Scanner scanner1 = new Scanner(System.in);
		System.out.println("달을 입력하세요.");
		int month1 = scanner.nextInt();
		int[] maxDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		System.out.printf("%d월은 %d 일까지 있습니다. \n", month1, maxDays[month1 - 1]);
		scanner1.close();
	}
}
