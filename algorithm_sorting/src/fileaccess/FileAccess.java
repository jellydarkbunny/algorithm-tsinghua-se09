package fileaccess;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import sorting.QuickSort;
import sorting.SortingAlgorithmParent;

public class FileAccess {
	private BufferedReader myBufferedReader;
	
	private SortingAlgorithmParent sortingAlgorithm;
	
	public FileAccess(){
		sortingAlgorithm = new QuickSort();
	}
	/********************************************************************
	 * 将源文件按照读取要求分成若干个小文件
	 * @param inputFile 待排序源文件
	 * @param maxLine 每个小文件最大读取行数
	 * @param fileNum 小文件个数
	 * @return a list of arrays to be sorted
	 *******************************************************************/
	public ArrayList<File> divideOriginalFile(File inputFile,int maxLine,int fileNum){
		setBufferedReader(inputFile);
		ArrayList <File> files = new ArrayList<File>();
		for(int i = 0;i<fileNum;i++){
			File f = new File("f"+i);
			files.add(f);
			double s1 = System.currentTimeMillis();
			//读文件
			long [] array = readArrayFromFile(maxLine);
			//排序
			long [] sortedArray = getSortedArray(array);
			//写文件
			writeArrayToFile(sortedArray,10,f);
			double e1 = System.currentTimeMillis();
			System.out.println((e1-s1)+"ms,"+f.getName()+"数组排好序，并写入文件");
		}
		return files;
	}
	/**************************************************************
	 * Combine all the files into the result one.
	 * And Delete the temp files.
	 * @param files
	 **************************************************************/
	public File combineSortedArray(ArrayList <File> files){
		while(files.size()>1){
			File f1 = files.get(0);
			File f2 = files.get(1);
			File newFile = combineTwoFile(f1,f2,10);
			files.add(newFile);
			files.remove(0);
			files.remove(0);
			f1.delete();
			f2.delete();
		}
		return files.get(0);
	}
	/***************************************************************
	 * Combine a and b into a bigger file. 
	 * @param a
	 * @param b 
	 * @param numPerLine the number of integers for each line.
	 * @return combined file
	 */
	public File combineTwoFile(File a,File b,int numPerLine){
		try{
			String fileWriterName = a.getName()+b.getName();
			File resultFile = new File(fileWriterName);
			FileWriter fw = new FileWriter(resultFile);
			int num =0;
			BufferedReader bra= new BufferedReader(new FileReader(a));
			BufferedReader brb = new BufferedReader(new FileReader(b));
			ArrayList <String> longa = new ArrayList<String>();
			ArrayList <String> longb = new ArrayList<String>();
			String linea;
			String lineb;
			boolean endA= false; boolean endB = false;
			while(true){
				if(endA){
					if(endB){
						break;
					}
				}
				if(longa.size()==0){
					linea = bra.readLine();
					if(linea != null){
						String [] ss = linea.split(";");
						for(int i=0;i<ss.length;i++ ){
							longa.add(ss[i]);
						}
					}else{
						endA = true;
					}
				}if(longb.size()==0){
					lineb = brb.readLine();
					if(lineb != null){
						String [] ss = lineb.split(";");
						for(int i=0;i<ss.length;i++ ){
							longb.add(ss[i]);
						}
					}else{
						endB=true;
					}
				}
				if(endA){
					//把b写完
					for(int i = 0;i<longb.size();i++){
						fw.append(longb.get(i));
						fw.append(";");
						num++;
						if(num==numPerLine){
							fw.append("\n");
							num=0;
						}
					}
					while(true){
						lineb = brb.readLine();
						if(lineb ==null){
							endB=true;
							break;
						}
						String [] ss = lineb.split(";");
						for(int i =0;i<ss.length;i++){
							fw.append(ss[i]);
							fw.append(";");
							num++;
							if(num==numPerLine){
								fw.append("\n");
								num=0;
							}
						}
					}
				}
				if(endB){
					for(int i = 0;i<longa.size();i++){
						fw.append(longa.get(i));
						fw.append(";");
						num++;
						if(num==numPerLine){
							fw.append("\n");
							num=0;
						}
					}
					while(true){
						linea = bra.readLine();
						if(linea ==null){
							endA=true;
							break;
						}
						String [] ss = linea.split(";");
						for(int i =0;i<ss.length;i++){
							fw.append(ss[i]);
							fw.append(";");
							num++;
							if(num==numPerLine){
								fw.append("\n");
								num=0;
							}
						}
					}
				}
				while(true){
					if(longa.size()==0 || longb.size()==0){
						break;
					}
					if(Long.parseLong(longa.get(0))>Long.parseLong(longb.get(0))){
						fw.append(longb.get(0));
						fw.append(";");
						num++;
						if(num==numPerLine){
							fw.append("\n");
							num=0;
						}
						longb.remove(0);
					}else{
						fw.append(longa.get(0));
						fw.append(";");
						num++;
						if(num==numPerLine){
							fw.append("\n");
							num=0;
						}
						longa.remove(0);
					}
				}
			}
			bra.close();
			brb.close();
			fw.close();
			System.out.println("file "+a.getName()+"和file"+b.getName()+"合并成功");
			return resultFile;
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
		return null;
	}
	
	
	/*************************************************************************
	 * Read the data from the input file, and store them in a long array.
	 * @param inputFile
	 * @return
	 */
	//在操作前需要设置BufferedReader因为要对同一个文件进行多次读取。
	public long [] readArrayFromFile(int maxLine){
		try{
			long [] tempOriginal = new long[maxLine*10];
			int index = 0;
			int max = 0;
			String s;
			while(true){
				if(max==maxLine){
					break;
				}
				s = myBufferedReader.readLine();
				max++;
				if(s==null){
					break;
				}
				String []ss = s.split(";");
				for(int i =0;i<ss.length;i++){
					tempOriginal [index] = Long.parseLong(ss[i]);
					index++;
				}
			}
			return tempOriginal;
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
		return null;
	}
	public long [] getSortedArray(long [] original){
		sortingAlgorithm.sortLong(original);
		return sortingAlgorithm.getSortOriginal();
		
	}
	/************************************************************************
	 * Write the original array into the given file.
	 * 
	 * @param original
	 * @param numPerLine: The number of the datas in each line
	 * @param file: the output file
	 */
	public  void writeArrayToFile(long [] original, int numPerLine,File file){
		int i =0;
		int nums =0;
		try{
			FileWriter fw = new FileWriter(file);
			while(true){
				if(nums==numPerLine){
					fw.append("\n");
					nums=0;
				}
				if(i == original.length){
					break;
				}
				fw.append(String.valueOf(original[i]));
				fw.append(";");
				i++;
				nums++;
			}
			fw.close();
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
	}
	public void setSortingAlgorithm(SortingAlgorithmParent sortingAlgorithm) {
		this.sortingAlgorithm = sortingAlgorithm;
	}
	public SortingAlgorithmParent getSortingAlgorithm() {
		return sortingAlgorithm;
	}
	public void setBufferedReader(File inputFile){
		try{
			myBufferedReader = new BufferedReader(new FileReader(inputFile));
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
	}
	public void closeBufferedReader(){
		try{
			myBufferedReader.close();
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
		
	}
}
