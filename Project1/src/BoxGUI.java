import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.util.ArrayList;
public class BoxGUI extends JFrame {
	
	private JTextArea unsorted,sorted;
	private ArrayList<Box> boxes;
	
	/*
	 * Default Constructor for the BoxGUI. Sets up the main components
	 * to the GUI such as the title, size, location etc. of the GUI
	 * @param b an array of Boxes
	 * @param length the current amount of Boxes in the array
	 */
	public BoxGUI(ArrayList<Box> b) {
		boxes = b;
		setTitle("BoxGUI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,400);
		setLocationRelativeTo(null);
		setComponenets();
		setVisible(true);
		
	}
	
	/*
	 * Sets up the items needed for the GUI
	 */
	private void setComponenets() {
		/* 
		 * Sets the layout of the GUI like a grid. This grid layout
		 * contains one row and two columns 
		 */
		setLayout(new GridLayout(1,2));
		
		
		/*
		 * Displays the unsorted array of Boxes in a text area with 
		 * some decorations such as a different background color 
		 * and text style
		 */
		unsorted = new JTextArea();
		unsorted.setBackground(Color.CYAN);
		unsorted.setFont(new Font(Font.DIALOG, Font.BOLD, 12));
		unsorted.setEditable(false);
		unsorted.setBorder(BorderFactory.createLineBorder(Color.black));
		for(int i=0;i<boxes.size();++i) {
			unsorted.append(boxes.get(i).toString()+"\n");
		}
		
		//Adds the TextArea to the GUI on the left side
		add(unsorted);
		
		//Sorting algorithm for the array
		selectionSort(boxes);
		
		
		/*
		 * Displays the sorted array of Boxes in a text area with
		 * some decorations such as a different background color
		 * and text style
		 */
		sorted = new JTextArea();
		sorted.setBackground(Color.YELLOW);
		sorted.setFont(new Font(Font.DIALOG, Font.BOLD, 12));
		sorted.setEditable(false);
		sorted.setBorder(BorderFactory.createLineBorder(Color.black));
		for(int i=0;i<boxes.size();++i) {
			sorted.append(boxes.get(i).toString()+"\n");
		}
		
		//Adds the TextArea to the GUI on the right side
		add(sorted);
	}
	
	/*
	 * Sorts an Array of Boxes based on their volumes 
	 * 
	 * @param b an array of Boxes
	 * @param length the current amount of Boxes in the array
	 */
	private void selectionSort(ArrayList<Box> b) {
		for ( int i = 0; i < b.size() - 1; i++ ) { 
		      int indexLowest = i; 
		      for ( int j = i + 1; j < b.size(); j++ ) {
		         if ( b.get(j).volume() < b.get(indexLowest).volume()) {indexLowest = j;}
		      }
		      if ( b.get(indexLowest) != b.get(i) ) { 
		         Box temp = b.get(indexLowest);
		         b.set(indexLowest,b.get(i)); 
		         b.set(i, temp);
		      }  
		} 

	}//selectionSort
}
