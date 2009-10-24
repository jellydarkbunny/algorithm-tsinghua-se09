package chessMove;

public class ChessPiece {
	public int value;
	private int x;
	private int y;
	
	public ChessPiece(int value, int x, int y){
		this.value = value;
		this.setX(x);
		this.setY(y);
	}
	public ChessPiece(){
		
	}
	//cp[i][j] ==Piece(i,j)
	public ChessPiece [][] initial(int values[][]){
		int n = values.length;
		ChessPiece [][]cps = new ChessPiece[n][n];
		for(int i = 0;i<n;i++){
			for(int j = 0;j<n;j++){
				int value = values[i][j];
				cps[i][j] = new ChessPiece(value,i,j);
			}
		}
		return cps;
	}
	public ChessPiece[][] getEmpty(int n){
		ChessPiece [][] cps = new ChessPiece[n][n];
		for(int i = 0;i<n;i++){
			for(int j = 0;j<n;j++){
				int value = Integer.MIN_VALUE;
				cps[i][j] = new ChessPiece(value,i,j);
			}
		}
		return cps;
	}
	public ChessPiece [][] move(int startX,int startY,ChessPiece [][]array){
		ChessPiece[][] result = getEmpty(array.length);
		int j = 0;
		int n = array.length;
		int left = startX;
		result[startX][j].value = array[startX][j].value;
		j++;
		int right = startX;
		while(j<n){
			if(left>0){
				left--;
			}
			if(right<n-1){
				right++;
			}
			int index = left;
			while(index<=right){
				int leftTemp = Integer.MIN_VALUE;
				if(index>0){
					leftTemp= result[index-1][j-1].value;
				}
				int middleTemp = result[index][j-1].value;
				int rightTemp = Integer.MIN_VALUE;
				if(index<n-1){
					rightTemp = result[index+1][j-1].value;
				}
				int valueTemp = getLargest(leftTemp,middleTemp,rightTemp);
				if(valueTemp > Integer.MIN_VALUE){
					result[index][j].value = valueTemp+array[index][j].value;
				}
				index++;
			}
			j++;
		}
		
		return result;
	}
	public int getLargest(int left,int middle,int right){
		int largest = left;
		if(left<=middle){
			largest = middle;
		}
		if(right>=largest){
			largest = right;
		}
		return largest;
	}
	public ChessPiece getMax(ChessPiece [][]array){
		int max = Integer.MIN_VALUE;
		ChessPiece maxCP = new ChessPiece();
		ChessPiece cp ;
		for(int i = 0;i<array.length;i++){
			cp = array[i][array.length-1];
			if(cp.value>max){
				maxCP = cp;
				max= cp.value;
			}
		}
		return maxCP;
	}
	public String toString(){
		return "("+value+")";
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getX() {
		return x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getY() {
		return y;
	}
}
