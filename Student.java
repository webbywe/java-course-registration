import java.util.ArrayList;

public class Student {
	
	private String lastName;
	private String firstName;
	private int studentID;
	private final ArrayList<String> registeredCourses = new ArrayList<String>();
	
	public Student()
	{
	}
	
	public Student(String lastName, String firstName, int studentID) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.studentID = studentID;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	
	/*
	 * Add course to students list of registered courses
	 */
	public void registerForCourse(String courseName)
	{
		if (!registeredCourses.contains(courseName))
		{
			registeredCourses.add(courseName);
		}
		else
		{
			System.out.println("Student already registered for course!");
		}
	}
	
	/*
	 * Remove course from students list of registered courses
	 */
	public void unregisterForCourse(String courseName)
	{
		if (registeredCourses.contains(courseName))
		{
			registeredCourses.remove(courseName);
		}
	}
	
	public void showRegisteredCourses()
	{
		for (int i = 0; i < registeredCourses.size(); i++)
		{
			System.out.println(registeredCourses.get(i));
		}
	}
	
	public String toString()
	{
		return "Last Name:" + lastName + ", First Name:" + firstName + ", ID:" + studentID;
	}
	

}
