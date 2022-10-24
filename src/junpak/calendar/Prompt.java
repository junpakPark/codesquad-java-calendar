package junpak.calendar;

import java.util.Scanner;

public class Prompt {

	public void runPrompt() {
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();

		while (true) {
			System.out.println("연도를 입력하세요.");
			System.out.print("Year> ");
			int year = scanner.nextInt();
			System.out.println("달을 입력하세요.");
			System.out.print("Month> ");
			int month = scanner.nextInt();
			if (month == -1) {
				break;
			}
			if (month > 12 || month < 1) {
				System.out.println("입력값을 확인해주세요.");
				continue;
			}
			cal.printCalendar(year, month);
		}

		System.out.println("Bye~");
		scanner.close();
	}

	public static void main(String[] args) {
		//셀 실행
		Prompt p = new Prompt();
		p.runPrompt();
	}
}
