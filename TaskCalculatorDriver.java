package finalProject;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TaskCalculatorDriver {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int currentAge = getValidIntInput(scanner, "How old are you?");
		int endAge = getValidIntInput(scanner, "How old do you plan on living until?");

		// ArrayList to hold TaskCalculator objects
		ArrayList<TimeTakesTask> tasks = new ArrayList<>();
		int totalTime = 0;
//		TaskCalculator taskCalculator = new TaskCalculator(currentAge, endAge); // Example instantiation of parent class
//		System.out.println(taskCalculator.toString());

		while (true) {
			System.out.println(
					"Choose a task (1: TyingShoes, 2: Shaving, 3: Driving, 4: Custom, 5: Show Total Time, 0: Exit): ");
			int taskChoice = getValidIntInput(scanner, "Enter your choice:");

			if (taskChoice == 0) {
				break;
			}

			switch (taskChoice) {
			case 1:
				int shoeStartAge = getValidIntInput(scanner, "How old were you when you started tying your shoes?");
				double minutesToTieShoes = getValidDoubleInput(scanner,
						"How many minutes does it take to tie your shoes?");
				TimeTakesTask shoeTask = new TimeTakesTask("Tying Shoes", shoeStartAge, endAge, minutesToTieShoes);
				tasks.add(shoeTask);
				shoeTask.calculateTaskTime();
				totalTime += shoeTask.getTotalMinsOfTaskLifetime();
				System.out.println(shoeTask.toString());

				break;
			// Add cases for other tasks similarly
			case 2:
				int shaveStartAge = getValidIntInput(scanner, "How old were you when you started shaving?");
				double minutesToShave = getValidDoubleInput(scanner, "How many minutes does it take to shave?");
				TimeTakesTask shaveTask = new TimeTakesTask("It takes ", shaveStartAge, endAge, minutesToShave);
				tasks.add(shaveTask);
				shaveTask.calculateTaskTime();
				totalTime += shaveTask.getTotalMinsOfTaskLifetime();
				System.out.println(shaveTask.toString());

				break;
			case 3:
				int drivingStartAge = getValidIntInput(scanner, "How old were you when you started driving?");
				double minutesDriving = getValidDoubleInput(scanner, "How many minutes you drive for?");
				TimeTakesTask drivingTask = new TimeTakesTask("Driving", drivingStartAge, endAge, minutesDriving);
				tasks.add(drivingTask);
				drivingTask.calculateTaskTime();
				totalTime += drivingTask.getTotalMinsOfTaskLifetime();
				System.out.println(drivingTask.toString());

				break;

			case 4:
				int customStartAge = getValidIntInput(scanner, "How old were you when you started this task?");
				double minutesCustomTask = getValidDoubleInput(scanner,
						"How many minutes does it take to preform this task?");
				TimeTakesTask customInputTask = new TimeTakesTask("Task from User Input", customStartAge, endAge,
						minutesCustomTask);
				tasks.add(customInputTask);
				customInputTask.calculateTaskTime();
				totalTime += customInputTask.getTotalMinsOfTaskLifetime();
				System.out.println(customInputTask.toString());

				break;
			case 5:
				System.out.println("Total time spent on all tasks: " + totalTime + " minutes.");
				System.out.print("Which equals: ");
				convertTime(totalTime);
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}

		scanner.close();
	}

	private static void convertTime(int totalTime) {
		totalTime = TimeTakesTask.convertTime(totalTime);
	}

	public static int getValidIntInput(Scanner scanner, String prompt) {
		int input = 0;
		while (true) {
			try {
				System.out.println(prompt);
				input = scanner.nextInt();
				if (input < 0) {
					throw new IllegalArgumentException("Input must be greater than or equal to 0.");
				}
				break;
			} catch (InputMismatchException excpt) {
				System.out.println("Invalid input. Please enter a valid number.");
				scanner.next(); // clear the invalid input
			} catch (IllegalArgumentException excpt) {
				System.out.println(excpt.getMessage());
			}
		}
		return input;
	}

	public static double getValidDoubleInput(Scanner scanner, String prompt) {
		double input = 0;
		while (true) {
			try {
				System.out.println(prompt);
				input = scanner.nextDouble();
				if (input < 0) {
					throw new IllegalArgumentException("Input must be greater than or equal to 0.");
				}
				break;
			} catch (InputMismatchException excpt) {
				System.out.println("Invalid input. Please enter a valid number.");
				scanner.next();
			} catch (IllegalArgumentException excpt) {
				System.out.println(excpt.getMessage());
			}
		}
		return input;
	}
}
