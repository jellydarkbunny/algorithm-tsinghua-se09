package hanoi;
public class Hanoi{
	public Hanoi(){
		setN(1);
	}
	public Hanoi(int n){
		this.setN(n);
	}
	private void move(char chSour,char chDest){    
        System.out.println("将盘从"+chSour+"柱移动到"+chDest+"柱");    
    }    
	//递归求得汉诺塔的解
    public void hanoi(int n,char chA,char chB,char chC){    
        if(n==1){
        	move(chA,chC);    
        }else{    
            hanoi(n-1,chA,chC,chB);    
            this.move(chA,chC);    
            hanoi(n-1,chB,chA,chC);    
        }    
    }
    public void setN(int n) {
		this.n = n;
	}
	public int getN() {
		return n;
	}
	private int n;
}  