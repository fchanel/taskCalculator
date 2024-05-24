package LifetimeSpent;

public class CustomTask extends LifetimeTasks {
	private TaskType taskType;

	public enum TaskType {
		WORK, STUDY, EXERCISE, HOBBY, OTHER
	}

	public CustomTask(String taskName, int ageStartedTask, int endAge, double minutesPerTask) {
		super(taskName, ageStartedTask, endAge, minutesPerTask);
		this.taskType = taskType;
	}

	public TaskType getTaskType() {
		return taskType;
	}

	public void setTaskType(TaskType taskType) {
		this.taskType = taskType;
	}

	public CustomTask(int endAge, double minutesPerTask) {
		super(endAge, minutesPerTask);
	}

	@Override
	public int compareTo(LifetimeTasks other) {
		return Integer.compare(CustomTask.totalMinsOfTaskLifetime, LifetimeTasks.totalMinsOfTaskLifetime);
	}

	@Override
	public String toString() {
		return "Custom Task: " + taskName + "\nAge you started performing this task: " + ageStartedTask + " years old"
				+ "\n\n\tYou will spend " + totalMinsOfTaskLifetime + " minutes of your life " + taskName
				+ "\n\tOr in hours that is: " + totalHoursOfTaskLifetime + " hours of your life " + taskName
				+ "\n\tOr days you will spend is: " + totalDaysOfTaskLifetime + " days of your life " + taskName
				+ "\n\n";
	}
}
