package gui.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import fibonacci.Fibonacci;
import gui.FibonacciGUI;

public class CompareAlgorithmsAction implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent arg0) {
		compareAlgorithm(FibonacciGUI.n);
	}
	
	public void compareAlgorithm(int n){
		if(n<0){
			FibonacciGUI.println("nֵ������С��0");
		}
		Fibonacci f = new Fibonacci();
		long start1ms = System.currentTimeMillis();
		long start1 = System.nanoTime();
		BigInteger a = f.getFibonacciOne(n);
		long end1 = System.nanoTime();
		long end1ms = System.currentTimeMillis();
		FibonacciGUI.println("��1���㷨���"+a);
		if((end1ms - start1ms) == 0.0){
			FibonacciGUI.println("��һ���㷨����ʱ��Ϊ :"+(end1-start1)+"ns");
		}else{
			FibonacciGUI.println("��һ���㷨����ʱ��Ϊ :"+(end1ms-start1ms)+"ms");
		}
		
		long start2ms = System.currentTimeMillis();
		long start2 = System.nanoTime();
		BigInteger b = f.getFibonacciThree(n);
		long end2 = System.nanoTime();
		long end2ms = System.currentTimeMillis();
		FibonacciGUI.println("��2���㷨���"+b);
		if((end2ms-start2ms)==0.0){
			FibonacciGUI.println("�ڶ����㷨����ʱ��Ϊ :"+(end2-start2)+"ns");
		}else{
			FibonacciGUI.println("�ڶ����㷨����ʱ��Ϊ :"+(end2ms-start2ms)+"ms");
		}
		 
		long start3ms = System.currentTimeMillis();
		long start3 = System.nanoTime();
		BigInteger c = f.getFibonacciFour(n);
		long end3 = System.nanoTime();
		long end3ms = System.currentTimeMillis();
		FibonacciGUI.println("��3���㷨���"+c);
		if((end3ms - start3ms) == 0.0){
			FibonacciGUI.println("�������㷨����ʱ��Ϊ :"+(end3-start3)+"ns");
		}else{
			FibonacciGUI.println("�������㷨����ʱ��Ϊ :"+(end3ms-start3ms)+"ms");
		}
		if(a.compareTo(b)==0){
			if(b.compareTo(c)==0){
				FibonacciGUI.println("3���㷨�����ͬ.");
			}
		}
	}
}
