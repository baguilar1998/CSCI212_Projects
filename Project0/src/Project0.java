/*
 * Name: Brian Aguilar
 * Lab Section: CSCI212 11G
 */
import javax.swing.JOptionPane;
public class Project0 {
	public static void main(String [] args) {
		
		//Loops the main method until a break condition is met
		while(true){
			
			//These variables are used to count the number of times lower case and upper case E occurs
			int upperCaseE=0,lowerCaseE=0; 
			
			//Prompts the user to enter in a sentence
			String userInput=JOptionPane.showInputDialog(null,"Please enter a sentence.");
			
			//If the user enters in stop (no matter the case), the program will terminate
			if(userInput.equalsIgnoreCase("STOP"))System.exit(0);
			
			//The loop goes through each character of the given input and checks if it contains an upper case or lower case E
			for(int i=0;i<userInput.length();++i) {
				if(userInput.charAt(i)=='E')++upperCaseE;
				else if(userInput.charAt(i)=='e')++lowerCaseE;
			}
			
			//Displays to the user how times those letters appeared
			JOptionPane.showMessageDialog(null,"Number of lowercase e's:" +lowerCaseE+ "\nNumber of upercase E's:"+upperCaseE);
			
		}
	}//main
}
