package fileaccess;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;

import sorting.QuickSort;
import sorting.SortingAlgorithmParent;

public class TestFileAccess {
	
	public static void main(String [] args) throws IOException{
		fileAccessSorting();
	}
	
	public static void fileAccessSorting(){
		FileAccess fr = new FileAccess();
		int fileNum = 5;
		int maxLine = 10;
		//读取初始文件
		ArrayList <File> files = fr.divideOriginalFile(new File("10_8"),maxLine,fileNum);
		fr.closeBufferedReader();
		double start = System.currentTimeMillis();
		fr.combineSortedArray(files);
		double end = System.currentTimeMillis();
		System.out.println((end-start)+"ms，排好序数组合并写入最终文件");
	}
	
	public static void initOriginalFile(String originalFileName){
		try{
			FileWriter fw = new FileWriter(new File("2_10_8"));
			int n =100000000;
			double start = System.currentTimeMillis();
			for(int i = 0;i<2;i++){
				initOriginalFile(fw,n,100);
			}
			fw.close();
			double end = System.currentTimeMillis();
			System.out.println("读数、排序、完成合并、写入文件总耗时"+(end-start)+"ms");
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
		
	}
	public static void initOriginalFile(FileWriter fw,int n,int numPerLine){
		try{
			Random ran = new Random();
			int fwNum =0;
			double start = System.currentTimeMillis();
			for(int i = 0;i<n;i++){
				BigInteger integer = new BigInteger(32, ran);
				fw.append(integer.toString());
				fw.append(";");
				fwNum++;
				if(fwNum==numPerLine){
					fw.append("\n");
					fwNum=0;
				}
			}
			double end = System.currentTimeMillis();
			System.out.println("经过"+(end-start)+"ms，将"+n+"个数写入原始数组文件");
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
	}
	
	//测试方法，用于读取文件数据，排序然后返回数组
	//文件中数据不能过大，因为没有对数据读取量做限制 
	public static long [] readLongArray(File inputFile){
		try{
			SortingAlgorithmParent sortingAlgorithm = new QuickSort();
			ArrayList<Long> strings = new ArrayList<Long> ();
			BufferedReader br = new BufferedReader(new FileReader(inputFile));
			while(true){
				String s = br.readLine();
				if(s==null){
					break;
				}
				String []ss = s.split(";");
				for(int i =0;i<ss.length;i++){
					strings.add(Long.parseLong(ss[i]));
				}
			}
			br.close();
			long [] tempOriginal = new long[strings.size()];
			for(int i = 0;i<strings.size();i++){
				tempOriginal[i] = strings.get(i).longValue();
			}
			sortingAlgorithm.checkLongArray(tempOriginal);
			return tempOriginal;
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
		return null;
	}
	
}
