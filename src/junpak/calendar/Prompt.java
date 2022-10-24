package junpak.calendar;

import java.util.Objects;
import java.util.Scanner;

public class Prompt {

	public int parseDay(String day) {
		if (Objects.equals(day, "su"))
			return 0;
		else if (Objects.equals(day, "mo"))
			return 1;
		else if (Objects.equals(day, "tu"))
			return 2;
		else if (Objects.equals(day, "we"))
			return 3;
		else if (Objects.equals(day, "th"))
			return 4;
		else if (Objects.equals(day, "fr"))
			return 5;
		else if (Objects.equals(day, "sa"))
			return 6;
		else
			return 0;
	}

	public void runPrompt() {
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();

		while (true) {
			System.out.println("연도를 입력하세요.(exit: -1)");
			System.out.print("Year> ");
			int year = scanner.nextInt();
			if (year == -1) {
				break;
			}
			System.out.println("달을 입력하세요.");
			System.out.print("Month> ");
			int month = scanner.nextInt();
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
