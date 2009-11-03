package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import knapsack01problem.Item;

public class KnapsackGUI extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7349136410758480924L;
	public static void main(String []args){
		KnapsackGUI gui = new KnapsackGUI();
		gui.setVisible(true);
	}
	
	public KnapsackGUI(){
		setSize(900,600);
		setTitle("01 knapsack problem");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setWindowOnCenter();
		
		JPanel itemControl = new ItemControlPanel();
		
		getContentPane().add(itemControl,BorderLayout.CENTER);
        
	}
	private void setWindowOnCenter(){
		//set the window on the center of the screen
		Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);
	}
}


