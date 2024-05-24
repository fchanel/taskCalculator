package LifetimeSpent;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskCalculatorDriver1 {

	public static void main(String[] args) {
		final String BLUE_BACKGROUND = "\033[44m"; // BLUE
		final String GREY_BACKGROUND = "\033[47m";
		final String RESET = "\033[0m"; // Text Reset
		final String PURPLE = "\033[0;35m"; // PURPLE

		System.out.println(GREY_BACKGROUND + "\n\t***Welcome to the task calculator!***\t\t\n\n"
				+ "\n\tIn this program we will explore\t\t\t\n\tHow much of your life you\t\t\t\n\tSpend on tasks you might perform daily\t\t\n\tBased on selected tasks from the menu\t\t"
				+ "\n\tAnd from custom tasks from input.\t\t" + "\n\tAfter you have calculated two or more tasks\t"
				+ "\n\tYou can see a grand total of combined time\t\n\tYou will spend on these tasks.\t\t\t\n"
				+ "\n\tAnd then the program will terminate.\t   " + RESET + PURPLE
				+ "\n\n\n\t\"One must imagine Sisyphus happy.\"" + "\n\t\t\t-Albert Camus\n\n\n" + RESET
				+ "\n\n\tTo start please answer the following questions:\n\n");
		Scanner scanner = new Scanner(System.in);

		int endAge = LifetimeTasks.getValidIntInput(scanner, "\tHow old do you plan on living until?");

		ArrayList<LifetimeTasks> tasks = new ArrayList<>();
		int totalTime = 0;

		while (true) {
			System.out.println(
					"\tChoose a task from the following menu\n\n\t\tor enter '0' to exit:\n\n\t1: Tying Shoes\n\t2: Shaving\n\t3: Driving\n\t4: Custom\n\t5: Show Total Time\n");
			int taskChoice = LifetimeTasks.getValidIntInput(scanner, "\tPlease enter your choice:");

			if (taskChoice == 0) {
				System.out.println("\t\tGood-Bye!");
				System.exit(taskChoice);
			}

			switch (taskChoice) {
			case 1:
				int shoeStartAge = LifetimeTasks.getValidIntInput(scanner,
						"\tHow old were you when you started tying your shoes?");
				double minutesToTieShoes = LifetimeTasks.getValidDoubleInput(scanner,
						"\n\tHow many minutes do you believe it takes to tie your shoes?");
				CustomTask shoeTask = new CustomTask("Tying Shoes", shoeStartAge, endAge, minutesToTieShoes);
				tasks.add(shoeTask);
				totalTime += shoeTask.getTotalMinsOfTaskLifetime();
				System.out.println(shoeTask.toString());
				break;
			case 2:
				int shaveStartAge = LifetimeTasks.getValidIntInput(scanner,
						"\tHow old were you when you started shaving?");
				double minutesToShave = LifetimeTasks.getValidDoubleInput(scanner,
						"\n\tHow many minutes a day does it take to shave?");
				CustomTask shaveTask = new CustomTask("Shaving", shaveStartAge, endAge, minutesToShave);
				tasks.add(shaveTask);
				totalTime += shaveTask.getTotalMinsOfTaskLifetime();
				System.out.println(shaveTask.toString());
				break;
			case 3:
				int drivingStartAge = LifetimeTasks.getValidIntInput(scanner,
						"\tHow old were you when you started driving?");
				double minutesDriving = LifetimeTasks.getValidDoubleInput(scanner,
						"\n\tHow many minutes a day do you drive?");
				CustomTask drivingTask = new CustomTask("Driving", drivingStartAge, endAge, minutesDriving);
				tasks.add(drivingTask);
				totalTime += drivingTask.getTotalMinsOfTaskLifetime();
				System.out.println(drivingTask.toString());
				break;
			case 4:
				scanner.nextLine();
				System.out.print("\tEnter the name of the custom task: ");
				String customTaskName = scanner.nextLine();
				int customStartAge = LifetimeTasks.getValidIntInput(scanner,
						"\tHow old were you when you started this task?");
				double minutesCustomTask = LifetimeTasks.getValidDoubleInput(scanner,
						"\n\tHow many minutes a day does it take to perform this task?");
				CustomTask customInputTask = new CustomTask(customTaskName, customStartAge, endAge, minutesCustomTask);
				tasks.add(customInputTask);
				totalTime += customInputTask.getTotalMinsOfTaskLifetime();
				System.out.println(customInputTask.toString());
				break;
			case 5:
				System.out.println("\tTotal time spent on all tasks:\n\t" + totalTime + " minutes.");
				CustomTask.convertTime(totalTime);
				while (tasks.size() >= 2) {
					LifetimeTasks firstTask = tasks.get(0);
					LifetimeTasks secondTask = tasks.get(1);

					System.out.println("\n\tComparison of first two tasks:");
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
						System.out.println(
								"\n\n\t\tI hope you have found this program enlightening \n\t\t\tand you get to spend your time doing what you enjoy, good-bye!");
						System.exit(0);
					} else {
						System.out.println(firstTask.taskName + " is not equal to " + secondTask.taskName);
						System.out.println(
								"\n\n\t\tI hope you have found this program enlightening \n\t\tand you get to spend your time doing what you enjoy, good-bye!");
						System.exit(0);
					}

					System.out.println("/tNot enough tasks to compare.");
				}
				break;

			default:
				System.out.println("/tInvalid choice. Please try again.");
			}
		}
	}
}
