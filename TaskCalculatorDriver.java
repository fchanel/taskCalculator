package finalProject;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TaskCalculatorDriver {

	public static void main(String[] args) {
		// TaskCalculator taskCalculator = new TimeTakesTask("WelcomeTask", 0, 0, 0);
		// System.out.println(taskCalculator.toString());
		System.out.println("***Welcome to the task calculator!***\n\n"
				+ "\n\tIn this program we will explore\n\tHow much of your life you\n\tSpend on tasks you might preform daily\n\tBased on selected tasks from the menu"
				+ "\n\tfrom custom tasks from input" + "\n\tTo start please answer the following questions:\n\n ");
		Scanner scanner = new Scanner(System.in);

		int endAge = getValidIntInput(scanner, "How old do you plan on living until?");

		// ArrayList to hold TaskCalculator objects
		ArrayList<TimeTakesTask> tasks = new ArrayList<>();
		int totalTime = 0;

		while (true) {
			System.out.println(
					"Choose a task from the following menu\n   or enter '0' to exit:\n\n\t1: Tying Shoes\n\t2: Shaving\n\t3: Driving\n\t4: Custom\n\t5: Show Total Time\n");
			int taskChoice = getValidIntInput(scanner, "Please enter your choice:");

			if (taskChoice == 0) {
				System.out.println("Good-Bye!");
				System.exit(taskChoice);
			}

			switch (taskChoice) {
			case 1:
				int shoeStartAge = getValidIntInput(scanner, "How old were you when you started tying your shoes?");
				double minutesToTieShoes = getValidDoubleInput(scanner,
						"How many minutes do you believe it takes to tie your shoes?");
				TimeTakesTask shoeTask = new TimeTakesTask("Tying Shoes", shoeStartAge, endAge, minutesToTieShoes);
				tasks.add(shoeTask);
				shoeTask.calculateTaskTime();
				totalTime += shoeTask.getTotalMinsOfTaskLifetime();
				System.out.println(shoeTask.toString());

				break;
			case 2:
				int shaveStartAge = getValidIntInput(scanner, "How old were you when you started shaving?");
				double minutesToShave = getValidDoubleInput(scanner, "How many minutes a day does it take to shave?");
				TimeTakesTask shaveTask = new TimeTakesTask("Shaving", shaveStartAge, endAge, minutesToShave);
				tasks.add(shaveTask);
				shaveTask.calculateTaskTime();
				totalTime += shaveTask.getTotalMinsOfTaskLifetime();
				System.out.println(shaveTask.toString());

				break;
			case 3:
				int drivingStartAge = getValidIntInput(scanner, "How old were you when you started driving?");
				double minutesDriving = getValidDoubleInput(scanner, "How many minutes a day do you drive?");
				TimeTakesTask drivingTask = new TimeTakesTask("Driving", drivingStartAge, endAge, minutesDriving);
				tasks.add(drivingTask);
				drivingTask.calculateTaskTime();
				totalTime += drivingTask.getTotalMinsOfTaskLifetime();
				System.out.println(drivingTask.toString());

				break;

			case 4:
				int customStartAge = getValidIntInput(scanner, "How old were you when you started this task?");
				double minutesCustomTask = getValidDoubleInput(scanner,
						"How many minutes a day does it take to preform this task?");
				TimeTakesTask customInputTask = new TimeTakesTask("Task from User Input", customStartAge, endAge,
						minutesCustomTask);
				tasks.add(customInputTask);
				customInputTask.calculateTaskTime();
				totalTime += customInputTask.getTotalMinsOfTaskLifetime();
				System.out.println(customInputTask.toString());

				break;
			case 5:
				System.out.println("Total time spent on all tasks:\n" + totalTime + " minutes.");
				convertTime(totalTime);
				// System.out.println(totalTime.equals(totalTime));
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}

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
