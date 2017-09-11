import java.io.File;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Registrar {
  //SEPARATE TESTING
  // public static void main(String[] args)  throws FileNotFoundException, IOException{
    // registeredClasses(155);
    // addClass(155, "Computers 101");
    // registeredClasses(155);
    // }

  public static void registeredClasses(int studentID) throws FileNotFoundException{
    String studentIDString = Integer.toString(studentID);
    Scanner scanner = new Scanner(new File("Registrar.csv"));
    scanner.useDelimiter("\n");
    ArrayList<String> arraylist = new ArrayList<String>();
    while(scanner.hasNext()){
        arraylist.add(scanner.next());
      }
    scanner.close();
    for(int i = 0; i < arraylist.size(); i++){
      if (arraylist.get(i).startsWith(studentIDString)){
      System.out.println(arraylist.get(i));
    }
    }

  }

  public static void addClass(int studentID, String course) throws FileNotFoundException, IOException{
    String newSchedule = "";
    String studentIDString = Integer.toString(studentID);
    File file = new File("Registrar.csv");
    Scanner scanner = new Scanner(file);
    scanner.useDelimiter("\n");
    ArrayList<String> arraylist = new ArrayList<String>();
    while(scanner.hasNext()){
        arraylist.add(scanner.next());
      }
    scanner.close();
    for(int i = 0; i < arraylist.size(); i++){
      if(arraylist.get(i).startsWith(studentIDString)){
        arraylist.set(i, arraylist.get(i) + ", " + course);
      }
    }
    PrintWriter writer = new PrintWriter(file);
    for(int i = 0; i < arraylist.size(); i++){
      writer.println(arraylist.get(i));
    }
    writer.close();
  }

  public static void checkID(int studentID){
    //Will check ID and if there is no match, will create a new course line for that ID
  }
}
