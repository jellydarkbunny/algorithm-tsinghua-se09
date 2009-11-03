package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


import knapsack01problem.Item;

public class ItemControlPanel extends JPanel{
	private ArrayList <Item> items;
	private int bagCapability;
	JLabel labelWeight = new JLabel("weight");
	JTextField inputWeight = new JTextField(10);
	JLabel labelValue = new JLabel("value");
	JTextField inputValue = new JTextField(10);
	JLabel labelBag = new JLabel("bag");
	JTextField inputBag = new JTextField(10);
	JTextArea output = new JTextArea();
	
	public ItemControlPanel(){
		setSize(300,300);
		items = new ArrayList<Item>();
		output.setText("printe items");
		output.setEditable(false);
		JButton confirmButton = new JButton("confirm");
		confirmButton.addActionListener(new addItemAction());
		JButton clearItemsButton = new JButton("clear");
		JButton setBagCapability = new JButton("setBagCapability");
		
		Panel p1 =new Panel();
		p1.add(labelWeight);
		p1.add(inputWeight);
		p1.setLayout(new BoxLayout(p1,BoxLayout.X_AXIS));
		
		Panel p2 = new Panel();
		p2.add(labelValue);
		p2.add(inputValue);
		p2.setLayout(new BoxLayout(p2,BoxLayout.X_AXIS));
		Panel c3 = new Panel();
		c3.add(labelBag);
		c3.add(inputBag);
		Panel buttons = new Panel();
		buttons.add(confirmButton);
		buttons.add(clearItemsButton);
		buttons.add(setBagCapability);
		this.setBorder(BorderFactory.createTitledBorder("Control the items"));
		this.add(p1);
		this.add(p2);
		this.add(c3);
		this.add(buttons);
		this.add(output);
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
	}
	
	public void clearItems(){
		items.clear();
	}
	public void setBadCapability(){
		
	}
	private class addItemAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			String s = output.getText();
			output.setText(s+inputWeight.getText());
		}
		
	}
}

