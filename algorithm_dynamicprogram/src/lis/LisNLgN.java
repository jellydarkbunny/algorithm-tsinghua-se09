package lis;

import java.util.ArrayList;

public class LisNLgN extends LisAlgorithm{
	
	//return the index x where array[x]>=num
	public int find(ArrayList<Integer> array, int num){
		int left = 0;
		int right = array.size()-1;
		int mid = (left+right)/2;
		while(left<=right){
			int temp = array.get(mid);
			if(num>temp){
				left = mid+1;
			}else if(num<temp){
				right = mid-1;
			}else{
				return mid;
			}
			mid = (left+right)/2;
		}
		return left;
	}
	
	public int getLongestLength(int [] input){
		int size = input.length;
		int b[] = new int [size];
		ArrayList <Integer> c = new ArrayList<Integer>();
		b[0]=1;
		c.add(input[0]);
		int j=1;
		for(int i =1;i<size;i++){
			if(input[i]>=c.get(c.size()-1)){
				c.add(input[i]);
				b[i]=c.size();
				continue;
			}
			j = find(c,input[i]);
			c.set(j, input[i]);
			b[i]=j+1;
		}
		setLengthRecords(b);
		int longest = getMaxLength(b);
		return longest;
	}
}
