/*
 * Author - Larry Sanders 
 * 
 */
package classes;
import java.io.*;
import java.util.*;

// TODO: Auto-generated Javadoc
/**
 * The Class PhoneDirectory.
 * This classes uses functions that will manipulate the "phone.properties" file
 */
// I'm was a TreeMap implementation for this assignment.
public class PhoneDirectory {
	
	/** The properties. */
	Properties properties = new Properties();
	
	
	
	/**
	 * Instantiates a new phone directory.
	 * 
	 *
	 */
	//Class constructor
	public PhoneDirectory(){
		
		try(InputStream i = new FileInputStream("src/main/resources/phone.properties")){ 
			Properties property = new Properties();
			property.load(i);
			for (String prop : property.stringPropertyNames()){
				String value = property.getProperty(prop);
				addEntry(prop, value);
			}
			
			
		}catch (IOException e){
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * Adds the entry. That is typed in by the user.
	 *
	 * @param name the name that will be added into the phone book
	 * @param number the number that will be added as the key: name's value
	 */
	//Function that adds the entry to a file
	public void addEntry(String name, String number){
		try{
			OutputStream o = new FileOutputStream("src/main/resources/phone.properties");
			properties.setProperty(name, number);
			properties.store(o, "PhoneBook");
			
		}catch(IOException e){
			e.printStackTrace();
		}
		//phonebook.put(name, number);//This use to be apart of a tree map that i was using.
		
		
	}
	
	/**
	 * Deletes the entry under the name that the user gives
	 * 
	 *
	 * @param name the name
	 */
	//Function that will Search and delete the entry in a file
	public void deleteEntry(String name){
		try{
			OutputStream o = new FileOutputStream("src/main/resources/phone.properties");
			properties.remove(name);
			properties.store(o, "PhoneBook");
			
		}catch(IOException e){
			e.printStackTrace();
		}
		//phonebook.remove(name);//old tree map implementation
	}
	
	/**
	 * Gets the number that is mapped to the key : name given by the user.
	 *
	 * @param name the name
	 * @return the number that is mapped to the parameter name
	 */
	//Function that will search the file for a name and return the phone number.
	public String getNumber(String name){
		return properties.getProperty(name);
		//return phonebook.get(name);..old tree map implementation
		
	}
	
	/**
	 * Change entry.
	 *
	 * @param name the name
	 * @param number the number
	 */
	//Function that will search the name and the number and change it.
	public void changeEntry(String name, String number){
		addEntry(name,number);
	}
	
	
	
	
	//Function that writes to the file using a for loop that will o through the treemap
	/*public void Write(String file_name){
		
		try{
			File file = new File(file_name);
			
			/*if (file.createNewFile()){
				System.out.println("File is created!");
			}else{
				System.out.println("File already exists.");
			}
			
			
			FileWriter fw = new FileWriter(file.getAbsolutePath());
			BufferedWriter bw = new BufferedWriter(fw);
			
			for( Map.Entry<String, String> entry : phonebook.entrySet()){
				bw.write("Name: " + entry.getKey() + ", Number: " + entry.getValue());
				bw.flush();
			
			}
			bw.close();
			
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}
	
	
	public void Reader(String file_name){
		File file = new File(file_name);
		try{
			BufferedReader read = new BufferedReader(new FileReader(file));
			String  str; //control variable for the loop
			while ((str = read.readLine()) != null){
				System.out.println(str);
			}
			read.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		
	}*/ /////This entire code was for a tree map implementation without the use of a properties file
	
	/**
	 * Prints the phone book.
	 */
	public void printPhoneBook(){
		System.out.println("This is the phonebook!");
		System.out.println();
		for(String prop : properties.stringPropertyNames()){
			String value = properties.getProperty(prop);
			System.out.printf("%-20s%-20s", prop, value);
			System.out.println(); // so it could move down a line before it prints the next entry
		}
		
		
	}
	
	
}// end of class
	 

