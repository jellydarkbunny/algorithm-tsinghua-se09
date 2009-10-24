package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class LisGUI extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = -109685569756507533L;
	private static JTextArea output = new JTextArea();
	private static JTextArea inputArea = new JTextArea(1,30);
	private static JComboBox box = new JComboBox();
	public static String getInputString(){
		return inputArea.getText();
	}
	public static int getAlgorithm(){
		return box.getSelectedIndex();
	}
	public static void println(String s){
		output.append(s+"\n");
	}
	
	public static void clearOutput(){
		output.setText("清空输出屏\n");
	}
	public static void main(String []args){
		LisGUI gui = new LisGUI();
		gui.setVisible(true);
	}
	public LisGUI(){
		setSize(900,600);
		setTitle("Closest Point Pairs");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setWindowOnCenter();
		
		Panel input = getInputScreen();
		JScrollPane output = getOutputScreen();
		
		Panel control = getControlPanel();
		getContentPane().add(input,BorderLayout.NORTH);
        getContentPane().add(output,BorderLayout.CENTER);
        getContentPane().add(control,BorderLayout.SOUTH);
        
	}
	public Panel getInputScreen(){
		Panel input = new Panel();
		JLabel label = new JLabel();
		label.setText("输入形如：1,2,3,4,5");
		inputArea.setEditable(true);
		
		String algorithms[] = {"NLgN算法","N2算法"};
		box = new JComboBox (algorithms);
		
		input.add(label);
		input.add(inputArea);
		input.add(box);
		return input;
	}
	public JScrollPane getOutputScreen(){
		JScrollPane panel = new JScrollPane(output);
		panel.setSize(400, 600);
		return panel;
	}
	public Panel getControlPanel(){
		Panel controlPanel = new Panel();
		
		JButton confirmButton = new JButton();
		confirmButton.setText("confirm");
		confirmButton.addActionListener(new ComputeLisAction());
		
		JButton resetButton = new JButton();
		resetButton.setText("reset");
		
		controlPanel.add(confirmButton);
		controlPanel.add(resetButton);
		return controlPanel;
	}
	private void setWindowOnCenter(){
		//set the window on the center of the screen
		Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);
	}
	
}
