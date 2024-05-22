package finalProject;

import java.util.List;

public abstract class TaskCalculator implements Comparable<TaskCalculator> {
	protected int startAge;
	protected int endAge;
	protected int totalMinutesOfTaskLifetime;

	private static int taskCounter = 0;

	

	public TaskCalculator(int startAge, int endAge) {
		this.startAge = startAge;
		this.endAge = endAge;
		taskCounter++;
	}

	public TaskCalculator(int endAge) {
		this.startAge = 0;
		this.endAge = endAge;
		taskCounter++;
	}

	public static int getTaskCounter() {
		return taskCounter;
	}

	public int getStartAge() {
		return startAge;
	}

	public void setStartAge(int startAge) {
		this.startAge = startAge;
	}

	public int getEndAge() {
		return endAge;
	}

	public void setEndAge(int endAge) {
		this.endAge = endAge;
	}

	public int getTotalTaskDone() {
		return totalMinutesOfTaskLifetime;
	}

	public void setTotalTaskDone(int totalMinutesOfTaskLifetime) {
		this.totalMinutesOfTaskLifetime = totalMinutesOfTaskLifetime;
	}

	public abstract void calculateTaskTime();

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		TaskCalculator that = (TaskCalculator) obj;
		return startAge == that.startAge && endAge == that.endAge;
	}

	@Override
	public int compareTo(TaskCalculator other) {
		return Integer.compare(this.totalMinutesOfTaskLifetime, other.totalMinutesOfTaskLifetime);
	}

	@Override
	public String toString() {
		return "Welcome to The Task Calculator!";
	}

	public static int getTotalMinutesOfAllTasks(List<TaskCalculator> tasks) {
		int totalMinutes = 0;
		for (TaskCalculator task : tasks) {
			totalMinutes += task.getTotalMinutesOfTaskLifetime();
		}
		return totalMinutes;
	}

	public int getTotalMinutesOfTaskLifetime() {
		return totalMinutesOfTaskLifetime;
	}

}
