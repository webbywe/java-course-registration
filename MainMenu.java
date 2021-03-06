import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class MainMenu {
	// Main menu selections
	private static final String EXIT = "[0] EXIT";
	private static final String LOGIN = "[1] LOGIN";
	private static final String CREATE_PROFILE = "[2] CREATE PROFILE";


	// Login sub menu selections
	private static final String LOGOUT = "[0] LOGOUT";
	private static final String PROFILE = "[1] PROFILE";
	private static final String REGISTER = "[2] REGISTER";

	// CONSTS
	private static final int MIN_STUDENTS = 1;
	private static final int MAX_STUDENTS = 200000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while(true)
		{
		    System.out.println("Please make a selection");
		    System.out.println(EXIT);
		    System.out.println(LOGIN);
		    System.out.println(CREATE_PROFILE);
				

		    String selection = sc.nextLine();

		    switch(selection)
		    {
			    case "0":
			    	System.out.println("GoodBye!");
			    	sc.close();
			    	System.exit(0);
			    	break;
			    case "1":
			    	// LOGIN Page Logic (Viewing profile, registering for course)
			    	clearScreen();
			    	loginPage(sc);
			    	break;
			    case "2":
			    	// Create new profile
			    	clearScreen();
			    	createNewProfile(sc);
			    	break;
			    default:
			    	System.out.println("Please enter valid selection");
		    }
		}
	}

	public static void loginPage(Scanner sc)
	{
		Boolean isRegistered = false;
		Student student = new Student();
		String studentID;
		do
		{
			System.out.println(EXIT);
			System.out.println("Please enter your student ID: ");
			studentID = sc.nextLine();

			// Create an instance of File for Student.csv file.
	        File file = createStudentFile("Students.csv");

	        try {
	            // Create a new Scanner object which will read the data
	            // from the file passed in. To check if there are more
	            // line to read from it we check by calling the
	            // scanner.hasNextLine() method. We then read line one
	            // by one till all lines is read.
	        	Scanner studentFile = new Scanner(file);
	            while (studentFile.hasNextLine()) {
	                String line = studentFile.nextLine();
	                String[] info = line.split(",");
					if (info.length == 3 && info[2].equals(studentID))
					{
						isRegistered = true;
						student.setLastName(info[0]);
						student.setFirstName(info[1]);
						student.setStudentID(Integer.parseInt(info[2]));
						break;
					}
	            }

	            studentFile.close();
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        }

			if (!studentID.equals("0") && isRegistered == false)
			{
				System.out.println("Student is not registered. Select exit to go to the previous menu to register.");
			}
			else if (!studentID.equals("0"))
			{
				String selection;
				do
				{
					clearScreen();
					System.out.println("Please make a selection: ");
					System.out.println(LOGOUT);
				    System.out.println(PROFILE);
				    System.out.println(REGISTER);
				    selection = sc.nextLine();

				    switch(selection)
				    {
					    case "0":
					    	clearScreen();
					    	break;
					    case "1":
					    	clearScreen();
					    	System.out.println(student.toString());
					    	System.out.println("[1] View Registered Courses");
					    	selection = sc.nextLine();
					    	// TODO: Print out courses
					    	break;
					    case "2":
					    	clearScreen();
					    	// TODO: Print courses
					    	break;
					    default:
					    	clearScreen();
					    	System.out.println("Please enter a valid selection");
					    	break;
				    }

				}while(!selection.equals("0"));
			}
		}
		while(!studentID.equals("0"));
	}

	/*
	 * Create new student profile
	 */
	public static void createNewProfile(Scanner sc)
	{
		String lastName;
		String firstName;
		int studentID;

		System.out.println("Please enter your Last Name ");
		lastName = sc.nextLine();
		System.out.println("Please enter your First Name: ");
		firstName = sc.nextLine();

		studentID = getRandomInteger(MIN_STUDENTS,MAX_STUDENTS);
		// TODO: add check if studentID is already in Registrar.csv. If it is then get
		// another random number.

		File file = createStudentFile("Students.csv");


		try {
			PrintWriter pw = new PrintWriter(new FileOutputStream(file,true));
			pw.print(lastName + ",");
			pw.print(firstName + ",");
			pw.println(studentID);

			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Return File object based on fileName param. If it doesn't exist
	 * create new file.
	 */
	public static File createStudentFile(String fileName)
	{
		// Create an instance of File for Student.csv file.
        File file = new File(fileName);

        if (!file.exists())
        {
            try
            {
				file.createNewFile();
				PrintWriter pw = new PrintWriter(file);

				pw.print("Last Name,");
				pw.print("First Name,");
				pw.println("Student ID");

				pw.close();
			} catch (IOException e)
            {
				e.printStackTrace();
			}
        }

        return file;
	}

	/*
	 *  Returns random integer between minimum and maximum range
	 */
	public static int getRandomInteger(int minimum, int maximum){
		return ((int) (Math.random()*(maximum - minimum))) + minimum;
	}

	/*
	 * Give an illusion of the console screen clearing to show the next page
	 */
	public static void clearScreen()
	{
		char c = '\n';
		int length = 25;
		char[] chars = new char[length];
		Arrays.fill(chars, c);
		System.out.print(String.valueOf(chars));
	}
}
