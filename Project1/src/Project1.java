/*
 *@author Brian Aguilar
 *Lab Section: CSCI212 11G
 *
 *This is a program that reads information about a Box from a file
 *and displays the information in a graphical user interface. Displays 
 *the information unsorted and sorted.  
 * 
 */
import java.util.ArrayList;
import java.util.StringTokenizer;
public class Project1 {
	
	public static void main(String[] args) {
		
		//A variable that will read off the given file
		TextFileInput fileInput = new TextFileInput("BoxInfo.txt");
	
		//Stores an array of Box objects
		ArrayList <Box> boxes = new ArrayList<Box>();
	
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
			
			//Reads each number of the line and stores it in the values array
			for(int i=0;i<numberOfCommas;++i) {
				values[i]=Integer.parseInt(st.nextToken(","));
			}
			
			//Stores the three values of the line into the box object
			boxes.add(new Box(values[0],values[1],values[2]));
			

			//Reads the next line
			line = fileInput.readLine();
		
		}//end of loop

		//Displays a graphical user interface
		BoxGUI gui = new BoxGUI(boxes);
		
	}

}
