/**
 * Copyright(C)2011 Luvina Software Company
 * ToolXoayArray.java Aug 4, 2021 doducthuan
 */
package ToolCreateMatrix;
import java.io.File;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * tool này phục vụ cho việc tạo dự liệu được nhanh chóng hơn
 * @author doducthuan
 *
 */
public class ToolXoayArray {
	
	
	Data data = new Data();
	/**
	 * đọc file và trả về số ma trận 5*5 của mảng hai chiều
	 * bằng cách đọc số dòng rồi lấy số dòng chia cho 5 ta được độ dài của mảng 3 chiều chứa các ma trận 5*5
	 * @return : trả về độ dài của mảng 3 chiều
	 * @throws FileNotFoundException : ngoại lệ
	 * @throws IOException : ngoại lệ
	 *
	 */
	public int getLengthArray3() throws FileNotFoundException, IOException{
		FileInputStream fileInputStream = new FileInputStream("src\\ToolCreateMatrix\\final\\result.txt");
		//FileInputStream fileInputStream = new FileInputStream("src/Data/Theco/theco.txt");
		InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		int length = 0;
        while(bufferedReader.readLine() != null){
        	length ++;
        }
        data.setLength(length);
        fileInputStream.close();
        bufferedReader.close();
        return length/5;
	}
	
	/**
	 * đọc file , lấy dữ liệu từ file vào lưu vào 1 mảng 3 chiều 
	 * @throws FileNotFoundException : ngoại lệ
	 * @throws IOException : ngoại lệ
	 *
	 */
	public String[][][] readFileAndGetData() throws FileNotFoundException, IOException{
		FileInputStream fileInputStream = new FileInputStream("src\\ToolCreateMatrix\\final\\result.txt");
		//FileInputStream fileInputStream = new FileInputStream("src\\ToolCreateMatrix\\File\\fileNguon.txt");
		//FileInputStream fileInputStream = new FileInputStream("src/Data/Theco/theco.txt");
		InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		int length = getLengthArray3();
		String[][][] arrayContainingMatrix = new String[length][5][5];
		String lines = "";
		int index = 0, row = 0;
        while((lines = bufferedReader.readLine()) != null){
        	String line[] = lines.split("");
        	for(int i = 0; i < line.length; i++) {
        		if(line[i].equals("X")) {
        			arrayContainingMatrix[index][row][i] = "O";
        		}else {
        		arrayContainingMatrix[index][row][i] = line[i];
        		}
        		
        	}
        	row ++;
        	if(row == 5) {
        		row = 0;
        		index ++;
        	}
        }
        fileInputStream.close();
        bufferedReader.close();
        return arrayContainingMatrix;
	}
	
	
	/**
	 * lấy dữ liệu từ mảng 3 chiều mà đã được tạo và gán giá trị từ hàm readFileAndGetData
	 * @return  : trả về mảng 3 chiều
	 * @throws FileNotFoundException  : ngoại lệ
	 * @throws IOException  : ngoại lệ
	 *
	 */
	public String[][][] getArray3()  throws FileNotFoundException, IOException{
		getLengthArray3();
		readFileAndGetData();
		return data.getDataArray();
	}
	
	
	public void writeFiles(String[][] array) throws FileNotFoundException, IOException{
		File writeFile = new File("src\\ToolCreateMatrix\\final\\cheoO.txt");
		//File writeFile = new File("src\\Data\\fileDich.txt");
		//File writeFile = new File("src\\Data\\fileDich.txt");
		FileOutputStream fileOutputStream = null;
		fileOutputStream = new FileOutputStream(writeFile,true);
		for(int i = 0; i < 5; i++) {
			//if(data.getLength())
			String result = array[i][0] +"" + array[i][1] + "" + array[i][2] + "" + array[i][3] + "" + array[i][4] + "\n";
			byte[] bs = result.getBytes();
			fileOutputStream.write(bs);
		}
		fileOutputStream.close();
	}
	 
	public String[][] xoayArray90(String[][] arr) {
		String[][] array = new String[5][5];
		for (int i = 0; i < 5; ++i) {
	        for (int j = 0; j < 5; ++j) {
	            array[i][j] = arr[5 - j - 1][i];
	        }
	    }
		return array;
	}
	
	
	///////////////////////////////////////////////////////đảo //////////////////////////////////////////
	public String[][] swapMatrix1(String[][] arr){
		String[][] array = new String[5][5];
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
			    if(i != 0 && i != 1) {
			    	array[i][j] = arr[i][j];
			    }else {
			    	if(i == 0) {
			    		array[0][j] = arr[1][j];
			    	}else {
			    		array[1][j] = arr[0][j];
			    	}
			    }
			}
		}
		return array;
	}
	
	
	public String[][] swapMatrix2(String[][] arr){
		String[][] array = new String[5][5];
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
			    if(i != 0 && i != 2) {
			    	array[i][j] = arr[i][j];
			    }else {
			    	if(i == 0) {
			    		array[0][j] = arr[2][j];
			    	}else {
			    		array[2][j] = arr[0][j];
			    	}
			    }
			}
		}
		return array;
	}
	public String[][] swapMatrix3(String[][] arr){
		String[][] array = new String[5][5];
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
			    if(i != 0 && i != 3) {
			    	array[i][j] = arr[i][j];
			    }else {
			    	if(i == 0) {
			    		array[0][j] = arr[3][j];
			    	}else {
			    		array[3][j] = arr[0][j];
			    	}
			    }
			}
		}
		return array;
	}
	public String[][] swapMatrix4(String[][] arr){
		String[][] array = new String[5][5];
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
			    if(i != 0 && i != 4) {
			    	array[i][j] = arr[i][j];
			    }else {
			    	if(i == 0) {
			    		array[0][j] = arr[4][j];
			    	}else {
			    		array[4][j] = arr[0][j];
			    	}
			    }
			}
		}
		return array;
	}
	///////////////////////////////////////////////////////////////////////////////////////////
	public void xoayAllAndWriFile(String[][] array) throws FileNotFoundException, IOException{
		writeFiles(array);
		String[][] array1 = xoayArray90(array);
		writeFiles(array1);
		String[][] array2 = xoayArray90(array1);
		writeFiles(array2);
		String[][] array3 = xoayArray90(array2);
		writeFiles(array3);
	}
	
	
	public String[][] chuyen(String [][] array){
		String[][] arr = new String[5][5];
		for(int i = 0; i < 5; i ++) {
			for(int j = 0; j < 5; j++) {
				if(i == j) {
					arr[i][j] = array[0][j];
				}else {
					arr[i][j] = "G";
				}
			}
		}
		return arr;
	}
	public void writeMatrixToFile() throws FileNotFoundException, IOException {
		String[][][] matrix = readFileAndGetData();
		for(String[][] array : matrix) {
			writeFiles(array);
		
			
			
//			xoayAllAndWriFile(array);
//			String[][] arr = chuyen(array);
//			xoayAllAndWriFile(arr);
//			String[][] array1 = swapMatrix1(array);
//			xoayAllAndWriFile(array1);
//			String[][] array2 = swapMatrix1(array);
//			xoayAllAndWriFile(array2);
//			String[][] array3 = swapMatrix1(array);
//			xoayAllAndWriFile(array3);
//			String[][] array4 = swapMatrix1(array);
//			xoayAllAndWriFile(array4);
//			
			
		}
	}
	
	
	
	public static void main(String[] args)throws FileNotFoundException, IOException {
		ToolXoayArray toolXoayArray = new ToolXoayArray();
		toolXoayArray.writeMatrixToFile();
	}
}
