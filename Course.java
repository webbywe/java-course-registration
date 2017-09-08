
public class Course {
	private String courseID;
	private String courseName;
	private String startDate;
	private String endDate;
	private String summary;
	private int enrollmentLimit;
	private int numberOfStudentsEnrolled;

	public Course() 
	{
	}

	public Course(String courseID, String courseName, String startDate, String endDate, 
			String summary, int enrollmentLimit, int numberOfStudentsEnrolled) {
		this.courseID = courseID;
		this.courseName = courseName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.summary = summary;
		this.enrollmentLimit = enrollmentLimit;
		this.numberOfStudentsEnrolled = numberOfStudentsEnrolled;
	}

	public String getCourseID() {
		return courseID;
	}

	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public int getEnrollmentLimit() {
		return enrollmentLimit;
	}

	public void setEnrollmentLimit(int enrollmentLimit) {
		this.enrollmentLimit = enrollmentLimit;
	}

	public int getNumberOfStudentsEnrolled() {
		return numberOfStudentsEnrolled;
	}

	public void setNumberOfStudentsEnrolled(int numberOfStudentsEnrolled) {
		this.numberOfStudentsEnrolled = numberOfStudentsEnrolled;
	}
	
}
