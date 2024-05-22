package finalProject;


public class TimeTakesTask extends TaskCalculator {
	private String taskName;
	private int ageStartedTask;
	private int finalAgeOfTask;
	private double minutesPerTask;
	private int totalMinsOfTaskLifetime;
	private double totalHoursOfTaskLifetime;
	private double totalDaysOfTaskLifetime;
	private double totalSecondsOfTaskLifetime;
	private String grandTotalOfTaskLifetime;

	public TimeTakesTask(String taskName, int ageStartedTask, int finalAgeOfTask, double minutesPerTask) {
		super(ageStartedTask, finalAgeOfTask);
		this.taskName = taskName;
	//	this.ageStartedTask = ageStartedTask;
//		this.finalAgeOfTask = finalAgeOfTask;
		this.minutesPerTask = minutesPerTask;
	}

	public TimeTakesTask(int finalAgeOfTask, double minutesPerTask) {
		super(finalAgeOfTask);
		this.taskName = "Custom Task";
	//	this.ageStartedTask = 0;
	//	this.finalAgeOfTask = finalAgeOfTask;
		this.minutesPerTask = minutesPerTask;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public int getAgeStartedTask() {
		return ageStartedTask;
	}

	public void setAgeStartedTask(int ageStartedTask) {
		this.ageStartedTask = ageStartedTask;
	}

	public int getFinalAgeOfTask() {
		return finalAgeOfTask;
	}

	public void setFinalAgeOfTask(int finalAgeOfTask) {
		this.finalAgeOfTask = finalAgeOfTask;
	}

	public double getMinutesPerTask() {
		return minutesPerTask;
	}

	public void setMinutesPerTask(double minutesPerTask) {
		this.minutesPerTask = minutesPerTask;
	}

	public int getTotalMinsOfTaskLifetime() {
		return totalMinsOfTaskLifetime;
	}

	public void setTotalMinsOfTaskLifetime(int totalMinsOfTaskLifetime) {
		this.totalMinsOfTaskLifetime = totalMinsOfTaskLifetime;
	}

	public double getTotalHoursOfTaskLifetime() {
		return totalHoursOfTaskLifetime;
	}

	public void setTotalHoursOfTaskLifetime(double totalHoursOfTaskLifetime) {
		this.totalHoursOfTaskLifetime = totalHoursOfTaskLifetime;
	}

	public double getTotalDaysOfTaskLifetime() {
		return totalDaysOfTaskLifetime;
	}

	public void setTotalDaysOfTaskLifetime(double totalDaysOfTaskLifetime) {
		this.totalDaysOfTaskLifetime = totalDaysOfTaskLifetime;
	}

	public double getTotalSecondsOfTaskLifetime() {
		return totalSecondsOfTaskLifetime;
	}

	public void setTotalSecondsOfTaskLifetime(double totalSecondsOfTaskLifetime) {
		this.totalSecondsOfTaskLifetime = totalSecondsOfTaskLifetime;
	}

	public String getGrandTotalOfTaskLifetime() {
		return grandTotalOfTaskLifetime;
	}

	public void setGrandTotalOfTaskLifetime(String grandTotalOfTaskLifetime) {
		this.grandTotalOfTaskLifetime = grandTotalOfTaskLifetime;
	}

	public static int convertTime(int totalMinutes) {
		int totalSeconds = totalMinutes * 60;
		int totalHours = totalMinutes / 60;
		int totalDays = totalMinutes / (60 * 24);

		int remainingMinutes = totalMinutes % 60;
		int remainingHours = totalHours % 24;

		System.out.println("Total Time: " + totalDays + " days, " + remainingHours + " hours, " + remainingMinutes
				+ " minutes, " + totalSeconds + " seconds.");
		return totalMinutes;
	}

	@Override
	public void calculateTaskTime() {
		int totalMinutes = (int) ((endAge - ageStartedTask) * 365 * minutesPerTask);
		totalMinsOfTaskLifetime = totalMinutes;
		totalHoursOfTaskLifetime = TimeUnit.convert(totalMinutes, TimeUnit.HOURS);
		totalDaysOfTaskLifetime = TimeUnit.convert(totalMinutes, TimeUnit.DAYS);
		totalSecondsOfTaskLifetime = TimeUnit.convert(totalMinutes, TimeUnit.SECONDS);
		grandTotalOfTaskLifetime = totalSecondsOfTaskLifetime + " seconds, " + totalMinsOfTaskLifetime + " minutes, "
				+ totalHoursOfTaskLifetime + " hours, " + totalDaysOfTaskLifetime + " days";
	}

	@Override
	public String toString() {
		return taskName + "\n Age you started preforming this task: " + ageStartedTask + " years old"
				+ "\n You will spend " + totalMinsOfTaskLifetime + " minutes of your life preforming this task. \n Or "
				+ "\n You will spend " + totalHoursOfTaskLifetime + "hours of your life preforming this task. \n Or"
				+"\n You will spend " + totalDaysOfTaskLifetime
				+ " days of your life preforming this task. \n And!" + "\n You will spend " + totalSecondsOfTaskLifetime
				+ " seconds preforming this task." + " \n Which comes to: " + grandTotalOfTaskLifetime + "\n";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		TimeTakesTask that = (TimeTakesTask) obj;
		return ageStartedTask == that.ageStartedTask && finalAgeOfTask == that.finalAgeOfTask;
	}

	@Override
	public int compareTo(TaskCalculator other) {
		return Integer.compare(this.totalMinsOfTaskLifetime, other.getTotalTaskDone());
	}
}
