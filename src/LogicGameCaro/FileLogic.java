/**
 * Copyright(C)2011 Luvina Software Company
 * FileLogic.java Aug 3, 2021 doducthuan
 */
package LogicGameCaro;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import Data.DataManagement;
/**
 * lấy dữ liệu là các ma trận từ file sau đó truyền cho 1 mảng 3 chiều để lưu trữ
 * @author doducthuan
 *
 */
public class FileLogic {
	
	DataManagement dataManagement = new DataManagement();
	/**
	 * đọc file và trả về số ma trận 5*5 của mảng hai chiều
	 * bằng cách đọc số dòng rồi lấy số dòng chia cho 5 ta được độ dài của mảng 3 chiều chứa các ma trận 5*5
	 * @return : trả về độ dài của mảng 3 chiều
	 * @throws FileNotFoundException : ngoại lệ
	 * @throws IOException : ngoại lệ
	 *
	 */
	public void getLengthArray3() throws FileNotFoundException, IOException{
		//FileInputStream fileInputStream = new FileInputStream("src\\Data\\TheCo\\theco.txt");
		FileInputStream fileInputStream = new FileInputStream("src/Data/Theco/theco.txt");
		InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		int length = 0;
        while(bufferedReader.readLine() != null){
        	length ++;
        }
        dataManagement.setLength(length/5);
        fileInputStream.close();
        bufferedReader.close();
	}
	
	/**
	 * đọc file , lấy dữ liệu từ file vào lưu vào 1 mảng 3 chiều 
	 * @throws FileNotFoundException : ngoại lệ
	 * @throws IOException : ngoại lệ
	 *
	 */
	public void readFileAndGetData() throws FileNotFoundException, IOException{
		FileInputStream fileInputStream = new FileInputStream("src\\Data\\TheCo\\theco.txt");
		//FileInputStream fileInputStream = new FileInputStream("src/Data/Theco/theco.txt");
		InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		int length = dataManagement.getLength();
		String[][][] arrayContainingMatrix = new String[length][5][5];
		String lines = "";
		int index = 0, row = 0;
        while((lines = bufferedReader.readLine()) != null){
        	String line[] = lines.split(" ");
        	for(int i = 0; i < line.length; i++) {
        		arrayContainingMatrix[index][row][i] = line[i];
        	}
        	row ++;
        	if(row == 5) {
        		row = 0;
        		index ++;
        	}
        }
        dataManagement.setDataMatrix(arrayContainingMatrix);
        fileInputStream.close();
        bufferedReader.close();
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
		return dataManagement.getDataMatrix();
	}
	
	
	public int lenOfArray3() throws FileNotFoundException, IOException {
		getLengthArray3();
		return dataManagement.getLength();
	}
	
	
	
	// test
//	public static void main(String args[]) throws FileNotFoundException, IOException{
//		FileLogic fileLogic = new FileLogic();
//		//int le = fileLogic.abc();
//		String a [][][] = fileLogic.getArray3();
//		for(int k  = 0; k < a.length; k++) {
//			for(int i = 0; i < 5; i++) {
//				for (int j = 0; j < 5; j++) {
//					System.out.print(a[k][i][j] + " ");
//				}
//				System.out.println("");
//			}
//			System.out.println("");
//		}
//	}
	
}
