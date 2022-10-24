package junpak.calendar;

import java.util.Scanner;

public class Calendar {

	private static final int[] MAX_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

	public int getMaxDaysOfMonth(int month) {
		return MAX_DAYS[month - 1];
	}

	public void printSampleCalendar() {
		System.out.println("일 월 화 수 목 금 토");
		System.out.println("--------------------");
		System.out.println("1  2  3  4  5  6  7");
		System.out.println("8  9 10 11 12 13 14");
		System.out.println("15 16 17 18 19 20 21");
		System.out.println("22 23 24 25 26 27 28");
	}

	public static void main(String[] args) {

		//나의 풀이 (입력월의 최대 일수 출력)
		// int[] monthLength = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		// System.out.println("달을 입력하세요.");
		// Scanner scanner = new Scanner(System.in);
		// int month = scanner.nextInt();
		// if (month < 1 || month > 12) {
		// 	System.out.println("입력한 값을 확인해 주세요.");
		// } else {
		// 	System.out.printf("%d월은 %d 일까지 있습니다. %n", month, monthLength[month - 1]);
		// }

		//강의 설명 (입력월의 최대 일수 출력)
		// Scanner scanner = new Scanner(System.in);
		// Calendar cal = new Calendar();
		// System.out.println("달을 입력하세요.");
		// int month = scanner.nextInt();
		// System.out.printf("%d월은 %d 일까지 있습니다. \n", month, cal.getMaxDaysOfMonth(month));
		// cal.printSampleCalendar();
		// scanner.close();

		//나의 풀이 (n번 반복 가능하도록 프로그램 변경)
		// Scanner scanner = new Scanner(System.in);
		// System.out.println("반복 횟수를 입력하세요.");
		// int repeat = scanner.nextInt();
		// Calendar cal = new Calendar();
		// System.out.println("달을 입력하세요.");
		// for (int i = 0; i < repeat ; i++) {
		// 	int month = scanner.nextInt();
		// 	System.out.printf("%d월은 %d 일까지 있습니다. \n", month, cal.getMaxDaysOfMonth(month));
		// }
		// cal.printSampleCalendar();
		// scanner.close();

		//강의 설명 (n번 반복 가능하도록 프로그램 변경)
		// Scanner scanner = new Scanner(System.in);
		// Calendar cal = new Calendar();
		//
		// System.out.println("반복 횟수를 입력하세요.");
		// int repeat = scanner.nextInt();
		//
		// for (int i = 0; i < repeat; i++) {
		// 	System.out.println("달을 입력하세요.");
		// 	int month = scanner.nextInt();
		// 	System.out.printf("%d월은 %d 일까지 있습니다. \n", month, cal.getMaxDaysOfMonth(month));
		// }
		//
		// System.out.println("Bye~");
		// scanner.close();

		//나의 풀이 (종료 조건을 이용해 반복하기)
		// Scanner scanner = new Scanner(System.in);
		// Calendar cal = new Calendar();
		//
		// while (true) {
		// 	System.out.println("달을 입력하세요.");
		// 	int month = scanner.nextInt();
		// 	if (month == -1) {
		// 		break;
		// 	} else if (month < 1 || month > 12 ) {
		// 		System.out.println("입력된 값을 확인해주세요");
		// 		continue;
		// 	}
		//
		// 	System.out.printf("%d월은 %d 일까지 있습니다. \n", month, cal.getMaxDaysOfMonth(month));
		// }
		//
		// System.out.println("Bye~");
		// scanner.close();

		//강의 설명(종료 조건을 이용해 반복하기)
		String PROMPT = "cal>";
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();

		int month = 1;

		while (true) {
			System.out.println("달을 입력하세요.");
			System.out.print(PROMPT);
			month = scanner.nextInt();
			if (month == -1) {
				break;
			}
			if (month > 12){
				continue;
			}
			System.out.printf("%d월은 %d 일까지 있습니다. \n", month, cal.getMaxDaysOfMonth(month));
		}

		System.out.println("Bye~");
		scanner.close();
	}
}
