import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.StringTokenizer;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class ResultsGUI extends JFrame {
	
	//Instance variables for a ResultsGUI
	private int length,width,height;
	private JTextArea sorted;
	
	/*
	 * Default Constructor for the ResultsGUI. Sets up the main components
	 * to the GUI such as the title, size, location etc. of the GUI
	 * @param length the length that the user wants
	 * @param width the width that the user wants
	 * @param height the height that the user wants
	 */
	public ResultsGUI(int length, int width, int height) {
		this.length=length;
		this.width=width;
		this.height=height;
		setTitle("Results for Boxes with L:"+length+" W:"+width+" H:"+height);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(600,400);
		setLocationRelativeTo(null);
		setComponenets();
		searchResults();
		setVisible(true);
	}
	
	/*
	 * Sets up the components needed for the GUI
	 */
	private void setComponenets() {
		/* 
		 * Sets the layout of the GUI like a grid. This grid layout
		 * contains one row and one column 
		 */
		setLayout(new GridLayout(1,1));
		
		/*
		 * Displays the list of Boxes that meet the 
		 * following criteria in a text area with some decorations 
		 * such as a different background color and text style
		 */
		sorted = new JTextArea("Results:\n");
		sorted.setBackground(new Color(0,230,0));
		sorted.setFont(new Font(Font.DIALOG, Font.BOLD, 13));
		sorted.setEditable(false);
		sorted.setBorder(BorderFactory.createLineBorder(Color.black));
	
		//Adds the TextArea to the GUI 
		add(sorted);
	
	}//setComponents
	
	/*
	 * A helper function that displays all the boxes
	 * that meets the criteria for the user
	 */
	private void searchResults() {
		
		for(Box b: BoxGUI.sortedList.keySet()) {
			if(b.getLength()>=length && b.getWidth()>=width && b.getHeight()>=height) {
				sorted.append(b.toString()+"\n");
			}
		}
		
	}//serachResults

}//ResultsGUI
