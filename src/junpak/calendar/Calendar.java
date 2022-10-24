package junpak.calendar;

public class Calendar {

	private static final int[] MAX_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	private static final int[] LEAP_MAX_DAYS = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

	public int getMaxDaysOfMonth(int year, int month) {
		if (isLeapYear(year)) {
			return LEAP_MAX_DAYS[month - 1];
		}
		return MAX_DAYS[month - 1];
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
		final int STANDARD_WEEKDAY = 3; // 1970/1/1 Thursday
		int count = 0;

		for (int i = STANDARD_YEAR; i < year; i++) {
			int delta = isLeapYear(i) ? 366 : 365;
			count += delta;
		}

		for (int i = 1; i < month; i++) {
			int delta = getMaxDaysOfMonth(year, i);
			count += delta;
		}

		count += 1;

		return (count + STANDARD_WEEKDAY) % 7;
	}

}
