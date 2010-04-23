package ordinal;

import java.util.ArrayList;

public class FNumbers {
	public FNumbers(){
		an=3;
		init();
	}
	public FNumbers(int n){
		an=n-1;
		init();
	}
	private void init(){
		nums=new int[an];
		//initialize the sequence of numbers
		//ai is stored in nums[i-1]
		for(int i = 0;i<an;i++){
			nums[i]=0;
		}
	}

	public ArrayList<Integer> getPermutationFromFNumber(){
		ArrayList<Integer> p = new ArrayList<Integer>();
		int temp= 1;
		p.add(temp);
		int index = 1;
		while(index<=an){
			temp++;
			int location=index-nums[index-1];
			p.add(location,temp);
			index++;
		}
		return p;
	}
	//get the Factorial Number lists.
	public FNumbers getFNumbersFromNaturalNum(int num){
		FNumbers newF = new FNumbers();
		int temp = num;
		int i = 0;
		int index =2;
		while(temp>0){
			newF.nums[i]=getRemainder(temp,index);
			temp = temp/index;
			index++;
			i++;
		}
		return newF;
	}
	public int getRemainder(int x,int y){
		return x-x/y*y;
	}

	public void add(){
		nums[0]++;
		adapt();
	}
	private void adapt(){
		int i = 0;
		int boundary =2;
		while(i<an){
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
		for(int i =0;i<an;i++){
			sb.append(nums[an-1-i]);
		}
		return sb.toString();
	}
	private int[] nums;
	private int an;
}
