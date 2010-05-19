package hanoi;
import hanoi.Hanoi;
public class TestHanoi {
	public static void main(String [] args){    
        int n = 10;
    	Hanoi han=new Hanoi();    
        han.hanoi(n,'A','B','C');    
    }
}
