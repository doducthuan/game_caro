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
		FileInputStream fileInputStream = new FileInputStream("src\\Data\\TheCo\\theco1.txt");   // truyền địa chỉ file vào đối tượng FileInputStream để đọc file
		//FileInputStream fileInputStream = new FileInputStream("src/Data/Theco/theco.txt");
		InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);            // truyền đối tượng fileInputStream vào làm tham số cho đối tượng InputStreamReader
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);               // sử dụng đối tượng BufferedReader để đọc file
		int length = 0;                                   // khởi tạo biến đếm số dòng  = 0
        while(bufferedReader.readLine() != null){       //  đọc từng dòng
        	length ++;                                  // mỗi lần đọc xong 1 đòng
        }   
        dataManagement.setLength(length/5);            // set giá trị độ dài của mảng 3 chiều bằng cách lấy số dòng chia 5 vì mỗi thế cờ có 5 dòng
        fileInputStream.close();                       // đóng đối tượng
        bufferedReader.close();                       // đóng đối tượng
	}
	
	/**
	 * đọc file , lấy dữ liệu từ file vào lưu vào 1 mảng 3 chiều 
	 * @throws FileNotFoundException : ngoại lệ
	 * @throws IOException : ngoại lệ
	 *
	 */
	public void readFileAndGetData() throws FileNotFoundException, IOException{
		FileInputStream fileInputStream = new FileInputStream("src\\Data\\TheCo\\theco1.txt");   // truyền địa chỉ file vào đối tượng FileInputStream để đọc file
		//FileInputStream fileInputStream = new FileInputStream("src/Data/Theco/theco.txt");
		InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);           // truyền đối tượng fileInputStream vào làm tham số cho đối tượng InputStreamReader
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);          // sử dụng đối tượng BufferedReader để đọc file
		int length = dataManagement.getLength();                                        // nhận giá trị độ dài của mảng 3 chiều
		String[][][] arrayContainingMatrix = new String[length][5][5];                // khởi tạo mảng 3 chiều
		String lines = "";      // khởi tạo lines rỗnmg để đọc từng dòng
		int index = 0, row = 0;   // số index là chỉ số của mảng 3 chiều vào row là index hảng của phần tử mảng hai chiều trong mảng 3 chiều
        while((lines = bufferedReader.readLine()) != null){     // đọc từng dòng đến hết
        	String line[] = lines.split(" ");        // tách riêng phần tử bằng khoảng trống
        	for(int i = 0; i < line.length; i++) {
        		arrayContainingMatrix[index][row][i] = line[i];     // gán mỗi phần tử đó vào 1 mảng 2 chiều trong mảng 3 chiều
        	}
        	row ++;               // đọc xong 1 dòng thì tăng chỉ số đòng
        	if(row == 5) {            // khi chỉ số dòng = 5 tức là   đã đọc xong 1 thế cờ ( 1 mảng hai chiều là 1 phần tử của mảng 3 chiều) 
        		row = 0;             // xét chỉ số dòng về giá trị = 0 để đọc thế cờ tiếp
        		index ++;              // tăng chỉ số index của mảng 3 chiều
        	}
        }
        dataManagement.setDataMatrix(arrayContainingMatrix);  // lưu trữ mảng 3 chiều để sử dụng cho logic sau
        fileInputStream.close();  // đóng đối tượng
        bufferedReader.close();   // đóng đối tượg
	}
	
	
	/**
	 * lấy dữ liệu từ mảng 3 chiều mà đã được tạo và gán giá trị từ hàm readFileAndGetData
	 * @return  : trả về mảng 3 chiều
	 * @throws FileNotFoundException  : ngoại lệ
	 * @throws IOException  : ngoại lệ
	 *
	 */
	public String[][][] getArray3()  throws FileNotFoundException, IOException{
		getLengthArray3();        // gọi hàm tính độ dài của mảng 3 chiều
		readFileAndGetData();    // sau đó gọi hàm để lấy các thế cờ lưu vào mảng 3 chiều và lưu mảng 3 chiều vào chỗ javabean
		return dataManagement.getDataMatrix();   // trả về mảng 3 chiều vừa lưu
	}
	
	/*
	 * trả về độ dài của mảng 3 chiều ( không cần thiết lắm ) 
	 */
	public int lenOfArray3() throws FileNotFoundException, IOException {
		getLengthArray3();  // gọi hàm tính độ dài mảng 3 chiều
		return dataManagement.getLength();   // trả về độ dài mảng 3 chiều
	}

	
}
