package junpak.calendar;

import java.util.Objects;
import java.util.Scanner;

public class Prompt {

	public void printMenu() {
		System.out.println("+----------------------+");
		System.out.println("| 1. 일정 등록");
		System.out.println("| 2. 일정 검색");
		System.out.println("| 3. 달력 보기");
		System.out.println("| h. 도움말 q. 종료");
		System.out.println("+----------------------+");
	}

	public void runPrompt() {
		printMenu();
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();

		label:
		while (true) {
			System.out.println("명령 (1, 2, 3, h, q)");
			String cmd = scanner.next();
			switch (cmd) {
				case "1":
					cmdRegister();
					break;
				case "2":
					cmdPlan();
					break;
				case "3":
					cmdCalendar(scanner, cal);
					break;
				case "h":
					printMenu();
					break;
				case "q":
					break label;
			}

		}

		System.out.println("Thank you, Bye~");
		scanner.close();
	}

	private void cmdCalendar(Scanner scanner, Calendar cal) {
		System.out.println("연도를 입력하세요.");
		System.out.print("Year> ");
		int year = scanner.nextInt();

		System.out.println("달을 입력하세요.");
		System.out.print("Month> ");
		int month = scanner.nextInt();

		if (month > 12 || month < 1) {
			System.out.println("입력값을 확인해주세요.");
			return;
		}
		cal.printCalendar(year, month);
	}

	private void cmdPlan() {
	}

	private void cmdRegister() {
	}

	public static void main(String[] args) {
		//셀 실행
		Prompt p = new Prompt();
		p.runPrompt();
	}
}
