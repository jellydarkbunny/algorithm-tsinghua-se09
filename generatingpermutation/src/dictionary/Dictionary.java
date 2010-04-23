package dictionary;

import java.util.ArrayList;

public class Dictionary {
	private int n;
	public Dictionary(){
		n = 4;
	}
	public Dictionary(int n){
		this.n = n;
	}
	public ArrayList<Integer> getLast(){
		ArrayList<Integer>last = new ArrayList<Integer>();
		int size = n;
		while(size>0){
			last.add(size);
			size--;
		}
		return last;
	}
	public boolean isLast(ArrayList<Integer> list){
		for(int i = 0;i<n;i++){
			if(!getLast().get(i).equals(list.get(i))){
				return false;
			}
		}
		return true;
	}
	public ArrayList<Integer> getNext(ArrayList<Integer> list){
		ArrayList<Integer> nextList = new ArrayList<Integer>();
		//i = max{j|pj-1<pj}
		int i = -1;
		for(int index= list.size()-1;index>=1;index--){
			if(list.get(index)>list.get(index-1)){
				i = index;
				break;
			}
		}
		//the permutation is the last one
		if(i==-1){
			return list;
		}
		//j=max{k|pi-1<pk}
		int j=-1;
		for(int index = list.size()-1;index>=0;index--){
			if(list.get(index)>list.get(i-1)){
				j=index;
				break;
			}
		}
		//j != -1, at least, k=i
		int tempA = list.get(i-1);
		int tempB = list.get(j);
		list.set(i-1, tempB);
		list.set(j, tempA);
		for(int index = 0;index<i;index++){
			nextList.add(list.get(index));
		}
		for(int index = list.size()-1;index>=i;index--){
			nextList.add(list.get(index));
		}
		return nextList;
	}
}
