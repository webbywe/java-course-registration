import java.util.*;

public class MainMenu {
	// Main menu selections
	private static final String LOGIN = "[0] LOGIN";
	private static final String REGISTER = "[1] REGISTER";
	private static final String EXIT = "[2] EXIT";
	
	// Login sub menu selections
	private static final String PROFILE = "[0] PROFILE";
	private static final String COURSES = "[1] COURSES";
	private static final String LOGOUT = "[2] LOGOUT";
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true)
		{
		    System.out.println("Please make a selection");
		    System.out.println(LOGIN);
		    System.out.println(REGISTER);
		    System.out.println(EXIT);
		    
		    String selection = sc.nextLine();
		    
		    switch(selection)
		    {
			    case "0":
			    	System.out.println("Login");
			    	break;
			    case "1":
			    	System.out.println("Register");
			    	break;
			    case "2":
			    	System.out.println("GoodBye!");
			    	sc.close();
			    	System.exit(0);
			    	break;
			    default:
			    	System.out.println("Please enter valid selection");
		    }	    
		}
	}
}
