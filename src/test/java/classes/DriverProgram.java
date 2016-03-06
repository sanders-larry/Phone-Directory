/*Author- Larry Sanders
 * 
 */
package classes;
//import java.io.*;
import java.util.Scanner;
// TODO: Auto-generated Javadoc
//import java.util.*;


/**
 * The Class DriverProgram.
 * Test the PhoneDirectory class
 */
public class DriverProgram {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args){
		PhoneDirectory test = new PhoneDirectory(); // creates an instance
		
		Scanner user_input = new Scanner(System.in); // for the switch case.
		Scanner name_input = new Scanner(System.in); // for name parameter
		Scanner number_input = new Scanner(System.in); // for number parameter.
		
////////////////////////////////////////////////////////////////////////////////		
		
		int choice_1 = 0;  //switch variable for the switch case
		String name, number; // for the parameters
		
		//PhoneDirectory test = new PhoneDirectory(name, number); // old treemap code
		//File file = test.createFile("file");
	
	//These two lines display the phone book before he person starts to manipulate it
		test.printPhoneBook();
		System.out.println();
		//This block of code is the initial opening in which the user will choose what the want to do.
		//This will trigger a switch statement.
		do{
			System.out.println("Hello! What would you like to do?");
			System.out.println("1. Add an entry.");
			System.out.println("2. Delete an entry.");
			System.out.println("3. Look up a phone number.");
			System.out.println("4. Change someone's entry in the phone directory");
			
			choice_1 = user_input.nextInt();
			
			
			switch (choice_1){
			
			case 1:
				
				System.out.println("What is the name and phone number of the person that you want to add?");
				System.out.println("Type first name and Last Name(no spaces), then hit enter!");
				name = name_input.nextLine();
				name.trim();
				System.out.println("Type the 10-digit phone number with no spaces or symbols, then press enter!");
				number = number_input.next();
				test.addEntry(name, number);
				//old tree map code
				/*test.addEntry(name, number);
				test.Write("file");
				test.Reader("file");*/
				
				break;
			
			case 2:
				System.out.println("Enter the name of the person. first name and last name(no spaces), the press enter!");
				name = name_input.next();
				name.trim();
				test.deleteEntry(name);
				
				break;
				
			case 3:
				System.out.println("Enter the name of the person to recieve thier phone number, then press enter!");
				name = name_input.next();
				name.trim();
				
				System.out.println(name +"'s" + " phone number is: " + test.getNumber(name));
				
				break;
				
			case 4:
				System.out.println("Do you know the person's name and phone number?");
				name = name_input.next();
				
				name.trim();
				System.out.println("Enter the number an press enter");
				number = number_input.nextLine();
				test.changeEntry(name, number);
				break;
			
			default:
				break;
				
			
			}
		
			
		}while(choice_1 != 0);
		test.printPhoneBook();// prints after all manipulations are finished.
		
		user_input.close();
		name_input.close();
		number_input.close();
		
	}
}


