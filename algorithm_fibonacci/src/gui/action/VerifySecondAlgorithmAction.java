package gui.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import fibonacci.Fibonacci;
import gui.FibonacciGUI;

public class VerifySecondAlgorithmAction implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Fibonacci f = new Fibonacci();
		int i = 0;
		BigInteger big1 = new BigInteger("0");
		BigInteger big2 = new BigInteger("0");
		while(true){
			big1 = f.getFibonacciOne(i);
			big2 = f.getFibonacciTwo(i);
			if(big1.compareTo(big2)==0){
				FibonacciGUI.println("第"+i+"个结果是："+big1);
				i++;
			}
			if(big1.compareTo(big2)!=0){
				FibonacciGUI.println("F("+i+") is not right. And all the numbers after this are not right");
				break;
			}
		}
	}
	
}
