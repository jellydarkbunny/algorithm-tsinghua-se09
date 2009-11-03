package gui;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


import knapsack01problem.Item;

public class ItemControlPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1036105642040374456L;
	JLabel labelWeight= new JLabel("weight") ;
	JTextField inputWeight  = new JTextField(10);
	JLabel labelValue = new JLabel("value");
	TextField inputValue = new TextField(10);
	JLabel labelBag = new JLabel("bag");
	TextField inputBag = new TextField(10);
	JButton addItemButton = new JButton("����һ����Ʒ");
	JButton clearItemsButton = new JButton("���������Ʒ");
	JButton setBagCapability = new JButton("���ð�������");
	JButton randomButton = new JButton("����õ�10����Ʒ");
	JButton executeButton = new JButton("ִ����Ѱ����");
	JButton displayInfoButton = new JButton("��ʾ����״̬");
	JButton cleanScreenButton = new JButton("��������Ļ");
	public ItemControlPanel(){
		setSize(300,300);
		
		inputControl();
		executeControl();
		
	}
	private void inputControl(){
		add(labelWeight);
		add(inputWeight);
		add(labelValue);
		add(inputValue);
		addItemButton.addActionListener(new AddItemAction());
		add(addItemButton);
		clearItemsButton.addActionListener(new ClearItemsAction());
		add(clearItemsButton);
		add(labelBag);
		add(inputBag);
		setBagCapability.addActionListener(new setBagCapbilityAction());
		add(setBagCapability);
	}
	private void executeControl(){
		randomButton.addActionListener(new RandomAction());
		add(randomButton);
		executeButton.addActionListener(new ExecuteAction());
		add(executeButton);
		cleanScreenButton.addActionListener(new CleanScreen());
		add(cleanScreenButton);
		displayInfoButton.addActionListener(new DisplayInfoAction());
		add(displayInfoButton);
	}

	private class AddItemAction implements ActionListener{

		@SuppressWarnings("static-access")
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			int value = Integer.parseInt(inputValue.getText());
			int weight = Integer.parseInt(inputWeight.getText());
			Item item = new Item(value,weight);
			KnapsackGUI.addItem(item);
			KnapsackGUI.outputScreen.print("������Ʒ��ֵ"+value+"����"+weight);
		}
	}
	private class ClearItemsAction implements ActionListener{
		@SuppressWarnings("static-access")
		public void actionPerformed(ActionEvent arg0){
			KnapsackGUI.clearItems();
			KnapsackGUI.outputScreen.print("�����Ʒ");
		}
	}
	private class setBagCapbilityAction implements ActionListener{

		@SuppressWarnings("static-access")
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int maxWeight = Integer.parseInt(inputBag.getText());
			KnapsackGUI.myKnapsack.setMaxWeight(maxWeight);
			KnapsackGUI.outputScreen.print("���ð������ֵ"+maxWeight);
		}
	}
	private class DisplayInfoAction implements ActionListener{

		@SuppressWarnings("static-access")
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			ArrayList <Item> items = KnapsackGUI.myKnapsack.getOriginalItems();
			KnapsackGUI.outputScreen.print(Item.getPrintItemsString(items));
			KnapsackGUI.outputScreen.print("����������"+KnapsackGUI.myKnapsack.getMaxWeight());
			KnapsackGUI.outputScreen.print("����ֵ��"+KnapsackGUI.myKnapsack.getMaxValue());
		}
	}
	private class CleanScreen implements ActionListener{

		@SuppressWarnings("static-access")
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			KnapsackGUI.outputScreen.cleanScreen();
		}
		
	}
	private class ExecuteAction implements ActionListener{

		@SuppressWarnings("static-access")
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			ArrayList <Item> original = KnapsackGUI.myKnapsack.getOriginalItems();
			if(original.size()==0){
				KnapsackGUI.outputScreen.print("ȱ�ٳ�ʼ��Ʒ���������Ʒ�������롯��ѯ״̬��");
			}if(KnapsackGUI.myKnapsack.getMaxWeight()==0){
				KnapsackGUI.outputScreen.print("��������Ϊ0���߲�����������");
			}if(original.size()>0 &&KnapsackGUI.myKnapsack.getMaxWeight()>0){
				ArrayList <Item> values = KnapsackGUI.myKnapsack.getValuableItems(original);
				int maxValue = KnapsackGUI.myKnapsack.getMaxValue();
				KnapsackGUI.outputScreen.print("������װֵǮ����Ʒ��");
				KnapsackGUI.outputScreen.print(Item.getPrintItemsString(values));
				KnapsackGUI.outputScreen.print("����ֵ"+maxValue);
			}
			
		}
		
	}
	private class RandomAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			ArrayList <Item> items = Item.getItems(10);
			for(int i = 0;i<items.size();i++){
				Item item = items.get(i);
				KnapsackGUI.addItem(item);
				//KnapsackGUI.outputScreen.print("������Ʒ��ֵ"+item.getValue()+"����"+item.getWeight());
			}
		}
		
	}
}

