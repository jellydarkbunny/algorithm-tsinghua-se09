package algorithm;
public class LisN2 extends LisAlgorithm{
	
	//b[n]��ʾ��a[n]��β������������еĳ���
	public int getLongestLength(int [] input){
		int size = input.length;
		int []b = new int[size];
		for(int i = 0;i<size;i++){
			int k = 0;
			for(int j = 0;j<i;j++){
				if(input[j]<=input[i] && k<b[j]){
					k=b[j];
				}
			}
			b[i]= k+1;
		}
		setLengthRecords(b);
		int longest =  getMaxLength(b);
		return longest;
	}
	
}
