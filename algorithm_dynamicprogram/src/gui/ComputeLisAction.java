package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import algorithm.LisAlgorithm;
import algorithm.LisN2;
import algorithm.LisNLgN;

public class ComputeLisAction implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		String s = LisGUI.getInputString();
		String ss[] =s.split(",");
		int [] array = new int [ss.length];
		for(int i = 0;i<ss.length;i++){
			array[i] = Integer.parseInt(ss[i]);
		}
		int algorithm = LisGUI.getAlgorithm();
		LisAlgorithm lis = new LisNLgN();
		if(algorithm==1){
			lis = new LisN2();
		}
		LisGUI.println("a[n]:"+lis.arrayToString(array));
		int longest = lis.getLongestLength(array);
		LisGUI.println("最长子序列字符数："+longest);
		int [] records = lis.getRecords(array, lis.getLengthRecords(), longest);
		LisGUI.println("最长子序列为："+lis.arrayToString(records));
	}
}
