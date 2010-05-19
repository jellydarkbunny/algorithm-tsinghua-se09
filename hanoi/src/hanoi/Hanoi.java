package hanoi;
public class Hanoi{
	public Hanoi(){
		setN(1);
	}
	public Hanoi(int n){
		this.setN(n);
	}
	private void move(char chSour,char chDest){    
        System.out.println("���̴�"+chSour+"���ƶ���"+chDest+"��");    
    }    
	//�ݹ���ú�ŵ���Ľ�
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