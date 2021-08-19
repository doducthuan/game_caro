/**
 * Copyright(C)2011 Luvina Software Company
 * LogicCaro.java Aug 3, 2021 doducthuan
 */
package LogicGameCaro;

import java.io.FileNotFoundException;    // thêm thư viện ngoại lệ 
import java.io.IOException;                  // thêm thư viện ngoại lệ
import Data.DataOfMatrix;            // thêm đối tượng tự tạo
import javax.swing.JButton;          // thêm JButton

/**
 * 
 * xử lí logic cho máy đánh cờ
 * @author doducthuan
 *
 */
public class LogicCaro {
	
	FileLogic fileLogic = new FileLogic();                 // gọi đối tượng FileLogic để chạy các hàm lấy dữ liệu
	DataOfMatrix dataOfMatrix = new DataOfMatrix();         // 1 java beam để lần lưu và lấy dữ liệu
	
	/**
	 * kiểm tra thắng
	 * @param row   : chỉ số vị trí hàng
	 * @param column: chỉ số vị trí cột
	 * @param jButton : 1 mảng 2 chiều button 20*20
	 * @param name  : kiểm tra bên nào thắng : đầu vào là "X" kiểm tra người chơi thắng
	 *                                                    " O" kiểm tra máy thắng
	 * @return  : thắng thì trả về true còn thua trả về fasle
	 *
	 */
	 public boolean winCaro(int row, int column, JButton jButton[][], String name) {
	        int k, j;     
	        int d = 0;  // biến đếm số kí tự giống nhau liên tiếp
	        
	        // xét hàng dọc
	        for (k = -4; k <= 4; k++) {      // khởi tạo giá trị vào lặp để kiểm tra quanh phạm vi ma trận 9*9
	        	
	            if (row + k >= 0 && row + k < 20) {   // để cho vị trí kiểm tra khong vượt ngoài ngoài ma trạn 5*5
	                if (jButton[row + k][column].getText() == name) {   // nếu trùng tên
	                    d++;  //tăng
	                } else if (d < 5) {
	                    d = 0;  // nếu đột nhiên xuất hiện kí tự khác chặn lại thì thiết lâp lại 0
	                }
	            }
	        }
	        if (d >= 5) {   // nếu trùng nhau liên tiếp từ 5 kí tự trở lên 
	            return true;    // trả về true
	        } else {
	            d = 0;    // còn không thiết lập lại giá trị và tiếp tục xét theo hàng ngang
	        }
	        
	        
	        //xét hàng ngang
	        
	        for (k = -4; k <= 4; k++) {               // xét hang ngang phạm vi ma trận 
	            if (column + k >= 0 && column + k < 20) {  // kiểm tra để không bị tràn ra khỏi ma trận 5*5
	                if (jButton[row][column + k].getText() == name) {    // kiểm tra giá trị truỳng  lặp liên tiếp
	                    d++;        // nếu trùng 1 thì tăng lên 1
	                } else if (d < 5) {  // nếu bị chặn mà số kí tự gioáng nhau liên tiếp đó  < 5
	                    d = 0;          // set lại giá trị = 0
	                }
	            }
	        }
	        if (d >= 5) {   // nếu >=5 kí tự trùng nhau liên tiếp
	            return true;  //  thì trả về true
	        } else {         // còn không
	            d = 0;        // thiết lặp lại bằng 0
	        }
	        
	        
	        // xét đường chéo
	        for (k = -4, j = 4; k <= 4 && j >= -4; k++, j--) {            // kiểm tra đườnng chép
	            if (column + k >= 0 && column + k < 20 && row + j >= 0 && row + j < 20) {  // xác nhận để vị trí không tràn
	                if (jButton[row + j][column + k].getText() == name) {      // nếu trùng
	                    d++;         // tăng số lượng
	                } else if (d < 5) {       // còn nếu bị chặn mà số lần giống nhau liên tiếp < 5
	                    d = 0;   //set lại giá trị 0
	                }
	            }
	        }
	        if (d >= 5) {  // lặp liên tiếp số lươjg > = 5
	            return true;  // trả về true
	        } else {   // còn không thì
	            d = 0; // thiết lập lại giá trị 0
	        }
	        for (k = -4; k <= 4; k++) {                                   // kiêmt tra phạm vi 9*9
	            if (column + k >= 0 && column + k < 20 && row + k >= 0 && row + k < 20) {  // kiểm tra để không vượt ngoài phạm vi 20*20
	                if (jButton[row + k][column + k].getText() == name) {      // nếu trùn gteen
	                    d++;           // tặng lên 1
	                } else if (d < 5) {  // nếu không trùng mà số lượng trùng nhau < 5 thì 
	                    d = 0;       //thiết lập lại =0
	                }
	            }
	        }
	        if (d >= 5) {       // số lượng liên tiép >= 5 thì trả về true
	            return true;    // trả về true
	        }
	        return false; //còn không thì trả về false
	    }
	 
	 
	 /**
	  * tạo game mới, sẽ gán " " cho text của button
	  * @param jButton" 1 mảng các button
	  * @param n : số lượnt button
	  *
	  */
	 public void newGameCaro(JButton jButton[][], int n) {
		 for (int i = 0; i < n; i++) {                                   // duyệt qua các hàng
	            for (int j = 0; j < n; j++) {                               // duyệt qua các cột
	                jButton[i][j].setText(" ");                       //khởi tạo từng jbutton text về giá trị rỗng
	            }
	        }
	 }
	 
	 
	 /**
	  * so sánh hai ma trận 5*5
	  * @param matrixFile
	  * @param matrixGui
	  * @return
	  *
	  */
	 public int compareTwoMatrix(String[][] matrixFile, String[][] matrixGui) {
		 int count = 0;                      // đếm số lượng trùng           
		 int index = 0;                       // chỉ số xác nhận trùng
		 int ro = 0, col = 0;               // thiết lập toạ độ vị trí cần đánh
		 for(int i = 0; i < 5; i++) {       //  tạo vòng lặp for cho dòng
			 for(int j = 0; j < 5; j++) {   // tạo vòng lặp for cho cột
				 if(matrixFile[i][j].equals("T") && matrixGui[i][j].equals(" ")) {        
					 // nếu vị trí ma trận trong file  = T và trong ma trận máy là rỗng thì
					 count ++;              // tăng giá trị đếm
					 ro = i;          //  thiết lập vị trí hàng cần đánh
					 col = j;          // thiếp lập trị trí cột cần đáh
				 }else if(matrixFile[i][j].equals("G") && (matrixGui[i][j].equals(" ") || matrixGui[i][j].equals("X") || matrixGui[i][j].equals("O"))) { 
					 // nếu vị trí ma trận trong file  = G và trong ma trận máy là kí tự nào đi nữa thì
					 count ++;  // tăng giá trị trùng
				 }else if(matrixFile[i][j].equals("D") && matrixGui[i][j].equals(" ")) {  
					 // nếu vị trí ma trận trong file  = D và trong ma trận máy là rỗng thì
					 count ++;  // tăng giá trị giống
				 }else if(matrixFile[i][j].equals(matrixGui[i][j])) {   // hai vị trí giống nhau
					 count ++;             // tăng giá trị trùng nhau
				 }
			 }
		 }
		 if(count == 25) {                      // nếu trùng nhau hoàn toàn
			 index = 1;         // gán giá trị kiểm tra =0
			 dataOfMatrix.setColumnMatrix(2-col);       // thiếp lập độ lệch cột của chỗ cần đánh và vị trí giữa ma trận 5*5
			 dataOfMatrix.setRowMatrix(2- ro);           // thiếp lập độ lệch hàng của chỗ cần đánh và vị  trí giữa của ma trận 5*5
		 }else {
			 index = 0;                           // nếu không giống thì trả về 0 tức là hai ma trận khác nhau
		 }
		 return index;           // trả về tham số xác định hai ma trận có trùng nhau không
	 }
	 
	 /**
	  * tạo ma trận 5*5 từ toạ độ của bàn cờ
	  * @param row
	  * @param column
	  * @param jButton
	  * @return
	  *
	  */
	 public String[][] getMatrixAttackOrDefence(int row, int column, JButton[][] jButton){  // lấy ma trận 5*5 trong ma trận 20*20
		int rowOne = row - 2,   // lùi hàng 2 đơn vị
		      rowTwo = row + 2,  // tăng hàng 2 đơn vị
			  columnOne = column - 2,   // giảm cột 2 đơn vi
			  columnTwo = column + 2;   // tăng cột 2 đợ vị
		int rowMatrix= 0, colMatrix = 0;   // thiết lập indexx cho ma trận 5*5
		String[][] matrix = new String[5][5];  // thiết lập mảng 2 chiều 5*5
		loop:                    // nhảy đến đầu để thoát khỏi vòng lặp
			for(int ro = rowOne; ro <= rowTwo; ro++) {            // xét vị trí hàng
				for(int  co = columnOne; co <= columnTwo; co++) {     // xét vị trí cột
					matrix[rowMatrix][colMatrix] = jButton[ro][co].getText();   // gán nội dung của từng button cho mảng ma trận
					colMatrix++;   // tặng sô cột
					if(colMatrix == 5) {  // nếu cột = 5
						rowMatrix++;   // tăng số hàng
						colMatrix = 0;  // giảm cột về 0
					}
					if(rowMatrix == 5) {  // nếu hàng =5
						break loop; // thoát khỏi vòng lặp
					}
				}
			}
		return matrix;  // trả về ma trận 5*5
	}
	 
	 /**
	  * so sánh thế cờ với bàn cờ
	  * @param jButton
	  * @throws FileNotFoundException
	  * @throws IOException
	  *
	  */
	 public int compareFileAndMatrix(JButton[][] jButton) throws FileNotFoundException, IOException {
		 String[][][] dataFile = fileLogic.getArray3();   // lấy thế cờ trong file
		 int index = 0;     // chỉ số kiểm tra hai ma trận có giống không
		 int confirm = 0;
		outerloop:            // nhảy thoát ra khỏi vòng lặp 
			for(String[][] matrixFi : dataFile) { //  lấy từng ma trận thế cờ
			for(int i = 2; i < 18; i++) {         // vị trí hàng băt đầu từ hàng 2 và kết thúc 18
				for(int j = 2; j < 18; j ++) {    // vị trí cột bắt đầu từ 2 và kết thúc 18
					
					String[][] matrix5 = getMatrixAttackOrDefence(i, j, jButton);   // gọi hàm tạo ma trận từ các vị trí được thiết lập+
					//for(String[][] matrixFi : dataFile) { //  lấy từng ma trận thế cờ
					index = compareTwoMatrix(matrixFi, matrix5);        // so sánh hai ma trận và trả về 1 số int để kiểm tra có giống nhau không
					if(index > 0) {   // nếu giống
						dataOfMatrix.setToaDoRow(i - (int)dataOfMatrix.getRowMatrix() );           // lưu vị trí hàng cần đánh
						dataOfMatrix.setToaDoColumn(j - (int)dataOfMatrix.getColumnMatrix());     // lưu vị trí cột cần đánh
						break outerloop;               // nếu xong thì thoát ra khỏi các vòng lặp
					}
				}
			}
		}
		if(index == 0) {
			confirm = 0;
		}else {
			confirm = 1;
		}
		return confirm ;
	 }
	 
	 /**
	  * hàm trả về vị trí cần cần đánh
	  * @return: chỉ số vị trí hàng
	  *
	  */
	 public int getRowMa() {
		 int c = dataOfMatrix.getToaDoRow();  // gọi hàm trả về và gán giá trị vị trí hàng
		 return c;  // trả về vị trí hàng
	 }
	 
	 
	 /**
	  * trả về vị trí cột
	  * @return  : vị trí cột
	  *
	  */
	 public int getColMa() {
		 int c = dataOfMatrix.getToaDoColumn();  // gọi hàm trả về và gán giá trị vị trí cột
		 return c;  // trả về vị tri cột
	 }
	 

}
