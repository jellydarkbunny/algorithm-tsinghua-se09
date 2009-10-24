package gui.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import fibonacci.Fibonacci;
import gui.FibonacciGUI;

public class RunAlgorithmAction implements ActionListener{
	
	public RunAlgorithmAction(){
		f = new Fibonacci();
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		runAlgorithm( FibonacciGUI.n,FibonacciGUI.index);
	}
	public void runAlgorithm(int n,int index){
		switch(index){
		case 0:
			long start1ms = System.currentTimeMillis();
			long start1 = System.nanoTime();
			BigInteger a = f.getFibonacciOne(n);
			long end1 = System.nanoTime();
			long end1ms = System.currentTimeMillis();
			FibonacciGUI.println("第1种算法结果"+a);
			if((end1ms - start1ms) == 0.0){
				FibonacciGUI.println("第一种算法运行时间为 :"+(end1-start1)+"ns");
			}else{
				FibonacciGUI.println("第一种算法运行时间为 :"+(end1ms-start1ms)+"ms");
			}
			break;
		case 1:
			long start2ms = System.currentTimeMillis();
			long start2 = System.nanoTime();
			BigInteger b = f.getFibonacciThree(n);
			long end2 = System.nanoTime();
			long end2ms = System.currentTimeMillis();
			FibonacciGUI.println("第2种算法结果"+b);
			if((end2ms-start2ms)==0.0){
				FibonacciGUI.println("第二种算法运行时间为 :"+(end2-start2)+"ns");
			}else{
				FibonacciGUI.println("第二种算法运行时间为 :"+(end2ms-start2ms)+"ms");
			}
			break;
		case 2:
			long start3ms = System.currentTimeMillis();
			long start3 = System.nanoTime();
			BigInteger c = f.getFibonacciFour(n);
			long end3 = System.nanoTime();
			long end3ms = System.currentTimeMillis();
			FibonacciGUI.println("第3种算法结果"+c);
			if((end3ms - start3ms) == 0.0){
				FibonacciGUI.println("第三种算法运行时间为 :"+(end3-start3)+"ns");
			}else{
				FibonacciGUI.println("第三种算法运行时间为 :"+(end3ms-start3ms)+"ms");
			}
			break;
		}
	}
	
	private Fibonacci f;
}
