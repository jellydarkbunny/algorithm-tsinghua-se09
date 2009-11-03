package gui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import knapsack01problem.Item;
import knapsack01problem.Knapsack;

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
		
		//initialize the Knapsack
		myKnapsack = new Knapsack();
		JPanel itemControl = new ItemControlPanel();
		outputScreen = new OutputScreenPanel();
		outputScreen.setEditable(false);
		outputScreen.setLocation(0, 100);
		outputScreen.setSize(900, 500);
		getContentPane().add(outputScreen);
		getContentPane().add(itemControl);
		
	}
	private void setWindowOnCenter(){
		//set the window on the center of the screen
		Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);
	}
	public static void addItem(Item item){
		myKnapsack.originalItems.add(item);
	}
	public static void clearItems(){
		myKnapsack.originalItems.clear();
	}
	public static OutputScreenPanel outputScreen;
	public static Knapsack myKnapsack;
}


