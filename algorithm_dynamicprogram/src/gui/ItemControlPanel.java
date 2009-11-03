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
	JButton addItemButton = new JButton("增加一个物品");
	JButton clearItemsButton = new JButton("清除所有物品");
	JButton setBagCapability = new JButton("设置包裹容量");
	JButton randomButton = new JButton("随机得到10个物品");
	JButton executeButton = new JButton("执行找寻操作");
	JButton displayInfoButton = new JButton("显示现在状态");
	JButton cleanScreenButton = new JButton("清空输出屏幕");
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
			KnapsackGUI.outputScreen.print("增加物品价值"+value+"重量"+weight);
		}
	}
	private class ClearItemsAction implements ActionListener{
		@SuppressWarnings("static-access")
		public void actionPerformed(ActionEvent arg0){
			KnapsackGUI.clearItems();
			KnapsackGUI.outputScreen.print("清空物品");
		}
	}
	private class setBagCapbilityAction implements ActionListener{

		@SuppressWarnings("static-access")
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int maxWeight = Integer.parseInt(inputBag.getText());
			KnapsackGUI.myKnapsack.setMaxWeight(maxWeight);
			KnapsackGUI.outputScreen.print("设置包裹最大值"+maxWeight);
		}
	}
	private class DisplayInfoAction implements ActionListener{

		@SuppressWarnings("static-access")
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			ArrayList <Item> items = KnapsackGUI.myKnapsack.getOriginalItems();
			KnapsackGUI.outputScreen.print(Item.getPrintItemsString(items));
			KnapsackGUI.outputScreen.print("包裹容量："+KnapsackGUI.myKnapsack.getMaxWeight());
			KnapsackGUI.outputScreen.print("最大价值："+KnapsackGUI.myKnapsack.getMaxValue());
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
				KnapsackGUI.outputScreen.print("缺少初始物品，请加入物品，帮助请’查询状态‘");
			}if(KnapsackGUI.myKnapsack.getMaxWeight()==0){
				KnapsackGUI.outputScreen.print("包裹容量为0或者不合理，请设置");
			}if(original.size()>0 &&KnapsackGUI.myKnapsack.getMaxWeight()>0){
				ArrayList <Item> values = KnapsackGUI.myKnapsack.getValuableItems(original);
				int maxValue = KnapsackGUI.myKnapsack.getMaxValue();
				KnapsackGUI.outputScreen.print("包裹中装值钱的物品有");
				KnapsackGUI.outputScreen.print(Item.getPrintItemsString(values));
				KnapsackGUI.outputScreen.print("最大价值"+maxValue);
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
				//KnapsackGUI.outputScreen.print("增加物品价值"+item.getValue()+"重量"+item.getWeight());
			}
		}
		
	}
}

