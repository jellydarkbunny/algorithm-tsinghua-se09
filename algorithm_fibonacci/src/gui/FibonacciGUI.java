package gui;

import gui.action.CleanScreenAction;
import gui.action.CompareAlgorithmsAction;
import gui.action.PreInputAction;
import gui.action.RunAlgorithmAction;
import gui.action.VerifySecondAlgorithmAction;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class FibonacciGUI extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 774455423006667136L;
	private static JTextArea output = new JTextArea();
	public static int n = 0;
	public static int index = 0;
	public static JTextArea textArea =  new JTextArea(1,5);
	public static JComboBox box = new JComboBox();
	public static void main(String [] args){
		FibonacciGUI gui = new FibonacciGUI();
		gui.setVisible(true);
	}
	
	public FibonacciGUI(){
		setSize(900,600);
		setTitle("Fibonacci");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//set the window on the center of the screen
		Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);
        
        JPanel headPanel = new JPanel();
        output.setEditable(false);
        JScrollPane screenPanel = new JScrollPane(output);
        JPanel bottomPanel = new JPanel(); 
        
        JLabel label1 = new JLabel("输入n值");
        
        FibonacciGUI.textArea.setText("0");
        JLabel label2 = new JLabel("算法选择");
        String [] algorithms ={"基本算法","矩阵n次方","Strassen求矩阵"}; 
        FibonacciGUI.box = new JComboBox (algorithms);
        JButton buttonHead = new JButton();
        buttonHead.setText("设定输入值");
        buttonHead.addActionListener(new PreInputAction( ));
        
        headPanel.add(label1);
        headPanel.add(FibonacciGUI.textArea);
        headPanel.add(label2);
        headPanel.add(FibonacciGUI.box);
        headPanel.add(buttonHead);
        
        
        JButton button1 = new JButton();
        button1.setText("比较不同算法");
        button1.addActionListener(new CompareAlgorithmsAction());
        
        JButton button2 = new JButton();
        button2.setText("运行算法");
        button2.addActionListener(new RunAlgorithmAction());
        
        JButton button3 = new JButton();
        button3.setText("验证估算的偏差");
        button3.addActionListener(new VerifySecondAlgorithmAction());
        
        JButton button4 = new JButton();
        button4.setText("清除屏幕");
        button4.addActionListener(new CleanScreenAction());
        
        bottomPanel.add(button1);
        bottomPanel.add(button2);
        bottomPanel.add(button3);
        bottomPanel.add(button4);
        
        getContentPane().add(headPanel,BorderLayout.NORTH);
        getContentPane().add(screenPanel,BorderLayout.CENTER);
        getContentPane().add(bottomPanel,BorderLayout.SOUTH);
        
	}
	
	public static void println(String s){
		output.append(s+"\n");
	}
	
	public static void clearOutput(){
		output.setText("清空输出屏\n");
	}
	
}
