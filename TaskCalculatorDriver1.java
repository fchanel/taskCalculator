package LifetimeSpent;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskCalculatorDriver1 {

	public static void main(String[] args) {
		System.out.println("***Welcome to the task calculator!***\n\n"
				+ "\n\tIn this program we will explore\n\tHow much of your life you\n\tSpend on tasks you might perform daily\n\tBased on selected tasks from the menu"
				+ "\n\tfrom custom tasks from input" + "\n\tTo start please answer the following questions:\n\n ");
		Scanner scanner = new Scanner(System.in);

		int endAge = LifetimeTasks.getValidIntInput(scanner, "How old do you plan on living until?");

		// ArrayList to hold LifetimeTasks objects
		ArrayList<LifetimeTasks> tasks = new ArrayList<>();
		int totalTime = 0;

		while (true) {
			System.out.println(
					"Choose a task from the following menu\n   or enter '0' to exit:\n\n\t1: Tying Shoes\n\t2: Shaving\n\t3: Driving\n\t4: Custom\n\t5: Show Total Time and Quit Program\n");
			int taskChoice = LifetimeTasks.getValidIntInput(scanner, "Please enter your choice:");

			if (taskChoice == 0) {
				System.out.println("Good-Bye!");
				System.exit(taskChoice);
			}

			switch (taskChoice) {
			case 1:
				int shoeStartAge = LifetimeTasks.getValidIntInput(scanner,
						"How old were you when you started tying your shoes?");
				double minutesToTieShoes = LifetimeTasks.getValidDoubleInput(scanner,
						"How many minutes do you believe it takes to tie your shoes?");
				CustomTask shoeTask = new CustomTask("Tying Shoes", shoeStartAge, endAge, minutesToTieShoes);
				tasks.add(shoeTask);
				totalTime += shoeTask.getTotalMinsOfTaskLifetime();
				System.out.println(shoeTask.toString());
				break;
			case 2:
				int shaveStartAge = LifetimeTasks.getValidIntInput(scanner,
						"How old were you when you started shaving?");
				double minutesToShave = LifetimeTasks.getValidDoubleInput(scanner,
						"How many minutes a day does it take to shave?");
				CustomTask shaveTask = new CustomTask("Shaving", shaveStartAge, endAge, minutesToShave);
				tasks.add(shaveTask);
				totalTime += shaveTask.getTotalMinsOfTaskLifetime();
				System.out.println(shaveTask.toString());
				break;
			case 3:
				int drivingStartAge = LifetimeTasks.getValidIntInput(scanner,
						"How old were you when you started driving?");
				double minutesDriving = LifetimeTasks.getValidDoubleInput(scanner,
						"How many minutes a day do you drive?");
				CustomTask drivingTask = new CustomTask("Driving", drivingStartAge, endAge, minutesDriving);
				tasks.add(drivingTask);
				totalTime += drivingTask.getTotalMinsOfTaskLifetime();
				System.out.println(drivingTask.toString());
				break;
			case 4:
				scanner.nextLine(); // consume newline
				System.out.print("Enter the name of the custom task: ");
				String customTaskName = scanner.nextLine();
				int customStartAge = LifetimeTasks.getValidIntInput(scanner,
						"How old were you when you started this task?");
				double minutesCustomTask = LifetimeTasks.getValidDoubleInput(scanner,
						"How many minutes a day does it take to perform this task?");
				CustomTask customInputTask = new CustomTask(customTaskName, customStartAge, endAge, minutesCustomTask);
				tasks.add(customInputTask);
				totalTime += customInputTask.getTotalMinsOfTaskLifetime();
				System.out.println(customInputTask.toString());
				break;
			case 5:
				System.out.println("Total time spent on all tasks:\n" + totalTime + " minutes.");
				CustomTask.convertTime(totalTime);
				while (tasks.size() >= 2) {
					LifetimeTasks firstTask = tasks.get(0);
					LifetimeTasks secondTask = tasks.get(1);

					System.out.println("\nComparison of first two tasks:");
					int comparison = firstTask.compareTo(secondTask);
					if (comparison < 0) {
						System.out.println(firstTask.taskName + " has less total minutes than " + secondTask.taskName);
					} else if (comparison > 0) {
						System.out.println(firstTask.taskName + " has more total minutes than " + secondTask.taskName);
					} else {
						System.out
								.println(firstTask.taskName + " has the same total minutes as " + secondTask.taskName);
					}

					System.out.println("\nChecking equality of the first two tasks:");
					if (firstTask.equals(secondTask)) {
						System.out.println(firstTask.taskName + " is considered equal to " + secondTask.taskName);
						   System.out.println("I hope you have found this program enlightening and you get to spend your time doing what you enjoy, good-bye!");
						   System.exit(0);
					} else {
						System.out.println(firstTask.taskName + " is not equal to " + secondTask.taskName);
						   System.out.println("I hope you have found this program enlightening and you get to spend your time doing what you enjoy, good-bye!");
						   System.exit(0);
					}
					
					System.out.println("Not enough tasks to compare.");
				}
				break;

			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}
	}
}
