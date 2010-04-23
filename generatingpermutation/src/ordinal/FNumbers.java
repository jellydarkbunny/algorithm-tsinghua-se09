package ordinal;

import java.util.ArrayList;

public class FNumbers {
	public FNumbers(){
		n=3;
		nums=new int[n];
		//initialize the sequence of numbers
		//ai is stored in nums[i-1]
		for(int i = 0;i<n;i++){
			nums[i]=0;
		}
	}
	public ArrayList<Integer> getPermutationFromFNumber(){
		ArrayList<Integer> p = new ArrayList<Integer>();
		int temp= 1;
		p.add(temp);
		int index = 1;
		while(index<=n){
			temp++;
			int location=index-nums[index-1];
			p.add(location,temp);
			index++;
		}
		System.out.println(p);
		return p;
	}
	//get the Factorial Number lists.
	public FNumbers getFNumbersFromNaturalNum(int num){
		FNumbers newF = new FNumbers();
		int temp = num;
		int i = 0;
		int index =2;
		while(temp>0){
			newF.nums[i]=Ordinal.getRemainder(temp,index);
			temp = temp/index;
			index++;
			i++;
		}
		return newF;
	}
	public void add(){
		nums[0]++;
		adapt();
	}
	private void adapt(){
		int i = 0;
		int boundary =2;
		while(i<n){
			if(nums[i]<boundary){
				break;
			}
			if(nums[i]>=boundary){
				nums[i+1]=nums[i+1]+1;
				nums[i]=nums[i]-boundary;
			}
			i++;
			boundary++;
		}
	}
	public String toString(){
		StringBuffer sb = new StringBuffer();
		for(int i =0;i<n;i++){
			sb.append(nums[n-1-i]);
		}
		return sb.toString();
	}
	private int[] nums;
	private int n;
}
