package gui;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class OutputScreenPanel extends JScrollPane{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JTextArea output = new JTextArea();
	public OutputScreenPanel(){
		super(output);
	}
	public void setEditable(boolean b){
		output.setEditable(b);
	}
	public static void print(String s){
		output.append(s+"\n");
	}
	public static void cleanScreen(){
		output.setText("clear the screen");
	}
}
