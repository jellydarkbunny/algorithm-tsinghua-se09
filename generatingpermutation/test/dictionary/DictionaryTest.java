package dictionary;

import java.util.ArrayList;

public class DictionaryTest {
	public static void main(String args[]){
		testRandomN();
	}
	public static void testRandomN(){
		Dictionary d = new Dictionary(5);
		ArrayList <Integer> no1 = new ArrayList <Integer>();
		no1.add(1);
		no1.add(2);
		no1.add(3);
		no1.add(4);
		no1.add(5);
		System.out.println(no1);
		while(true){
			no1=d.getNext(no1);
			System.out.println(no1);
			if(d.isLast(no1)){
				break;
			}
		}
	}
	public static void testGetNext(){
		Dictionary d = new Dictionary();
		ArrayList <Integer> no1 = new ArrayList <Integer>();
		no1.add(1);
		no1.add(2);
		no1.add(3);
		no1.add(4);
		System.out.println(no1);
		while(true){
			no1=d.getNext(no1);
			System.out.println(no1);
			if(d.isLast(no1)){
				break;
			}
		}
	}
}
