package gui;
import entity.MyPoint;
import gui.action.ClearPointsAction;
import gui.action.CompareAlgorithmsAction;
import gui.action.ComputeClosestPointsPairAction;
import gui.action.ComputeMillionAction;
import gui.action.DivideAndConqueAction;
import gui.action.OriginalAction;
import gui.action.RandomGeneratePoints;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;



public class ClosestPointGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3828435870050334351L;
	private static JTextArea output = new JTextArea();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClosestPointGUI gui = new ClosestPointGUI();
		gui.setVisible(true);
	}
	
	public ClosestPointGUI(){
		setSize(900,600);
		setTitle("Closest Point Pairs");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//set the window on the center of the screen
		Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);

        JTabbedPane tabbedPane = new JTabbedPane();
        output.setEditable(false);
        JScrollPane   scrollPane = new JScrollPane(output);
        
        ScreenPanel screenPanel = new ScreenPanel();
        screenPanel.setPoints(getInitPoint());
        JPanel panel2 = new JPanel();
        
        screenPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        tabbedPane.addTab("取点屏幕", screenPanel);
        tabbedPane.addTab("Console:输出数据", scrollPane);
         
        JButton button1 = new JButton();
        button1.setText("暴力算法");
        button1.addActionListener(new ComputeClosestPointsPairAction(screenPanel));
        
        JButton button2 = new JButton();
        button2.setText("分治法一");
        button2.addActionListener(new DivideAndConqueAction(screenPanel));
        
        JButton button3 = new JButton();
        button3.setText("分治法二");
        button3.addActionListener(new OriginalAction(screenPanel));
        
        JButton button4 = new JButton();
        button4.setText("随机生成点");
        button4.addActionListener(new RandomGeneratePoints(screenPanel));
        
        JButton button5 = new JButton();
        button5.setText("清除所有点");
        button5.addActionListener(new ClearPointsAction(screenPanel));
        
        JButton button6 = new JButton();
        button6.setText("比较3种算法");
        button6.addActionListener(new CompareAlgorithmsAction());
        
        JButton button7 = new JButton();
        button7.setText("计算一百万个点");
        button7.addActionListener(new ComputeMillionAction());
        
        JLabel text = new JLabel(); 
        text.setText("输出数据请看Console");
       
        panel2.add(button1);
        panel2.add(button2);
        panel2.add(button3);
        panel2.add(button4);
        panel2.add(button5);
        panel2.add(button6);
        panel2.add(button7);
        panel2.add(text);
        
        getContentPane().add(tabbedPane,BorderLayout.CENTER);
        getContentPane().add(panel2,BorderLayout.SOUTH);
        
	}
	public ArrayList <MyPoint> getInitPoint(){
		MyPoint m1 =new MyPoint(200.0,300.0);
		MyPoint m2 =new MyPoint(100.0,200.0);
		MyPoint m3 =new MyPoint(100.0,100.0);
		MyPoint m4 = new MyPoint(200.0,200.0);
		ArrayList <MyPoint>points = new ArrayList<MyPoint>();
		points.add(m1);
		points.add(m2);
		points.add(m3);
		points.add(m4);
		return points;
	}
	
	protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = ClosestPointGUI.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
	
	public static void println(String s){
		output.append(s+"\n");
	}
	public static void clearOutput(){
		output.setText("清空输出屏\n");
	}
}

