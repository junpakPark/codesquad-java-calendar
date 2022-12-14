package junpak.calendar;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class Calendar {

	private static final int[] MAX_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	private static final int[] LEAP_MAX_DAYS = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	private static final String SAVE_FILE = "calendar.dat";
	private final HashMap<Date, PlanItem> planMap;

	public Calendar() {
		planMap = new HashMap<Date, PlanItem>();
		File file = new File(SAVE_FILE);
		if (!(file.exists())) {
			System.err.println("no save file");
			return;
		}
		try {
			Scanner scanner = new Scanner(file);
			while (scanner.hasNext()) {
				String line = scanner.nextLine();
				String[] words = line.split(",");
				String date = words[0];
				String detail = words[1].replaceAll("\"", "");
				PlanItem planItem = new PlanItem(date, detail);
				planMap.put(planItem.getDate(), planItem);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public int getMaxDaysOfMonth(int year, int month) {
		if (isLeapYear(year)) {
			return LEAP_MAX_DAYS[month - 1];
		}
		return MAX_DAYS[month - 1];
	}

	public void registerPlan(String strDate, String plan) {
		PlanItem planItem = new PlanItem(strDate, plan);
		planMap.put(planItem.getDate(), planItem);

		File file = new File(SAVE_FILE);
		String item = planItem.saveString();
		try {
			FileWriter fileWriter = new FileWriter(file, true);
			fileWriter.write(item);
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public PlanItem searchPlan(String strDate) {
		Date date = PlanItem.getDateFromString(strDate);
		return planMap.get(date);
	}

	public boolean isLeapYear(int year) {
		return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
	}

	public void printCalendar(int year, int month) {
		System.out.printf("    <<%4d년 %3d월>>%n", year, month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println("---------------------");

		//get weekday automatically
		int weekday = getWeekDay(year, month);

		//print blank space
		for (int i = 0; i < weekday; i++) {
			System.out.print("   ");
		}

		int maxDay = getMaxDaysOfMonth(year, month);
		int count = 7 - weekday;
		int delim = count < 7 ? count : 0;

		//print first line
		for (int i = 1; i <= count; i++) {
			System.out.printf("%3d", i);
		}
		System.out.println();

		//print from second line to last line
		for (int i = count + 1; i <= maxDay; i++) {
			System.out.printf("%3d", i);
			if (i % 7 == delim) {
				System.out.println();
			}
		}

		System.out.println();
		System.out.println();
		// System.out.println("1  2  3  4  5  6  7");
		// System.out.println("8  9  10 11 12 13 14");
		// System.out.println("15 16 17 18 19 20 21");
		// System.out.println("22 23 24 25 26 27 28");
	}

	private int getWeekDay(int year, int month) {
		final int STANDARD_YEAR = 1970;
		final int STANDARD_WEEKDAY = 4; // 1970/1/1 Thursday
		int count = 0;

		for (int i = STANDARD_YEAR; i < year; i++) {
			int delta = isLeapYear(i) ? 366 : 365;
			count += delta;
		}

		for (int i = 1; i < month; i++) {
			int delta = getMaxDaysOfMonth(year, i);
			count += delta;
		}

		return (count + STANDARD_WEEKDAY) % 7;
	}

}
