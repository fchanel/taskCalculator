package LifetimeSpent;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class LifetimeTasks implements Comparable<LifetimeTasks> {
	protected String taskName;
	protected int ageStartedTask;
	protected int endAge;
	protected double minutesPerTask;
	protected static int totalMinsOfTaskLifetime;
	protected double totalHoursOfTaskLifetime;
	protected double totalDaysOfTaskLifetime;
	protected double totalSecondsOfTaskLifetime;
	protected static String grandTotalOfTaskLifetime;

	public enum TimeUnit {
		SECONDS, MINUTES, HOURS, DAYS;

		public static double convert(int totalMinutes, TimeUnit unit) {
			switch (unit) {
			case SECONDS:
				return totalMinutes * 60.0;
			case MINUTES:
				return totalMinutes;
			case HOURS:
				return totalMinutes / 60.0;
			case DAYS:
				return totalMinutes / (60.0 * 24);
			default:
				throw new IllegalArgumentException("Unknown time unit: " + unit);
			}
		}
	}

	public LifetimeTasks(String taskName, int ageStartedTask, int endAge, double minutesPerTask) {
		this.taskName = taskName;
		this.ageStartedTask = ageStartedTask;
		this.endAge = endAge;
		this.minutesPerTask = minutesPerTask;
		calculateTaskTime();
	}

	public LifetimeTasks(int endAge, double minutesPerTask) {
		this("Custom Task", 0, endAge, minutesPerTask);
	}

	public void calculateTaskTime() {
		int totalMinutes = (int) ((endAge - ageStartedTask) * 365 * minutesPerTask);
		totalMinsOfTaskLifetime = totalMinutes;
		totalHoursOfTaskLifetime = TimeUnit.convert(totalMinutes, TimeUnit.HOURS);
		totalDaysOfTaskLifetime = TimeUnit.convert(totalMinutes, TimeUnit.DAYS);
		totalSecondsOfTaskLifetime = TimeUnit.convert(totalMinutes, TimeUnit.SECONDS);
	}

	public static int getTotalMinsOfTaskLifetime() {
		return totalMinsOfTaskLifetime;
	}

	@Override
	public String toString() {
		return "Task calculator\n"
				+ "Start age: " + ageStartedTask + "n/End age: " + endAge;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		LifetimeTasks that = (LifetimeTasks) obj;
		return ageStartedTask == that.ageStartedTask && endAge == that.endAge;
	}

	@Override
	public int compareTo(LifetimeTasks other) {
		return Integer.compare(LifetimeTasks.totalMinsOfTaskLifetime, LifetimeTasks.totalMinsOfTaskLifetime);
	}

	public static int getValidIntInput(Scanner scanner, String isValidInt) {
		int input = 0;
		while (true) {
			try {
				System.out.println(isValidInt);
				input = scanner.nextInt();
				if (input < 0) {
					throw new IllegalArgumentException("Input must be greater than or equal to 0.");
				}
				break;
			} catch (InputMismatchException excpt) {
				System.out.println("Invalid input. Please enter a valid number.");
				scanner.next(); // Clear invalid input
			} catch (IllegalArgumentException excpt) {
				System.out.println(excpt.getMessage());
			}
		}
		return input;
	}

	public static double getValidDoubleInput(Scanner scanner, String isValidDouble) {
		double validInput = 0;
		while (true) {
			try {
				System.out.println(isValidDouble);
				validInput = scanner.nextDouble();
				if (validInput < 0) {
					throw new IllegalArgumentException("Input must be greater than or equal to 0.");
				}
				break;
			} catch (InputMismatchException excpt) {
				System.out.println("Invalid input. Please enter a valid number.");
				scanner.next(); // Clear invalid input
			} catch (IllegalArgumentException excpt) {
				System.out.println(excpt.getMessage());
			}
		}
		return validInput;
	}

	public static int convertTime(int totalMinutes) {
		//int totalSeconds = totalMinutes * 60;
		int totalHours = totalMinutes / 60;
		int totalDays = totalMinutes / (60 * 24);

		int remainingMinutes = totalMinutes % 60;
		int remainingHours = totalHours % 24;

		System.out.println("\n\t Which comes to roughly:\n\t " + totalDays + " days\n\t " + remainingHours + " hours,\n\t " + "and " + remainingMinutes
				+ " minutes of your life you will spend preforming these task/s\n\n\n\n");
		return totalMinutes;
	}
}