/*
 *@author Brian Aguilar 
 *Lab Section: CSCI212 11G
 *
 *This is a program that reads information about a Box from a file
 *and displays the information in a graphical user interface. Displays 
 *the unsorted list and sorted list.  
 * 
 */
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Project4 {
	
	public static void main(String[] args) {
		
		//A variable that will read off the given file
		TextFileInput fileInput = new TextFileInput("boxes.txt");

		//Stores a unsorted list of Box objects
		HashMap<Box,Integer> unsortedBoxList = new HashMap<Box,Integer>();
		
		//Stores a sorted list of Box objects
		TreeMap<Box,Integer> sortedBoxList = new TreeMap<Box,Integer>();
		
		//A variable that will store each line of the text file one by one
		String line = fileInput.readLine();
		
		//Keeps reading through the file until there are no more lines to read
		while(line!=null) {

			//An array to store the 3 values from the file (length,width,height)
			int [] values = new int [3];
			
			//To determine how to separate each part of the string
			StringTokenizer st = new StringTokenizer(line,",");
			
			//Counts the number of commas that appears in the current line
			int numberOfCommas = st.countTokens();
			
			/*
			 * Tests the following input values to
			 * see if any values of the text file are less 
			 * than one or if they are not numbers at all.
			 */
			try {
				
				//Reads each number of the line and stores it in the values array
				for(int i=0;i<numberOfCommas;++i) {
					values[i]=Integer.parseInt(st.nextToken(","));
				}			
				//Gets all the 3 values from the line and stores it in a Box Object
				Box temp = new Box(values[0],values[1],values[2]);

				//Stores the Box Object in a Map that is unsorted 
				unsortedBoxList.put(temp,temp.volume());
			
				//Stores the Box Object in a Map that is sorted by volume
				sortedBoxList.put(temp, temp.volume());

			}catch (IllegalBoxException e) {
				System.out.println("Not a valid box");
			}catch(NumberFormatException e) {
				System.out.println("Not the correct format for a box");
			}
			
			//Reads the next line
			line = fileInput.readLine();
		
		}//end of loop

		//Displays a graphical user interface
		BoxGUI gui = new BoxGUI(unsortedBoxList,sortedBoxList);
		
	}//main

}//Project2
