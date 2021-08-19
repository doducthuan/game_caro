/**
 * CopyRight(C) doducthuan
 * ControllerCaro.java Jul 30, 2021
 */
package ControllerGameCaro;

import java.awt.event.ActionListener;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import Data.*;
//import javax.swing.JButton;

import java.awt.event.ActionEvent;
import ViewGameCaro.GuiCaro;
import LogicGameCaro.*;
import javax.swing.JButton;


/**
 * 
 * điều khiển, nhận sự kiện gọi hàm sử lí và trả về kết quả
 * @author Admin
 *
 */
public class ControllerCaro implements ActionListener{
	
	GuiCaro guiCaro;
	
	/**
	 * tương tác với phần giao diện
	 * @param guiCaro  đối tượng tương tác
	 *
	 */
	public ControllerCaro(GuiCaro guiCaro) {
		this.guiCaro = guiCaro;
	}
	
	ShowNotification showNotification = new ShowNotification();/// khởi tạo các đối tượng để gọi đến các hàm liên quan của đối tượng đó
	LogicCaro logicCaro = new LogicCaro();         // khởi tạo đối tượg để xử lí phần logic
	
	/**
	 * xử lí khi lắng nghe được 1 sự kiện 
	 */
	public void actionPerformed(ActionEvent e) {
		
		//                      Lấy dữ liệu                            ////////
        JButton btnClick = (JButton)e.getSource();  // tạo button là button có giá trị giống button được người dùng click
        int row = (int)(btnClick.getY() / GuiCaro.SIZE_O_CO);   // lấy toạ độ hàng
        int column = (int)(btnClick.getX() / GuiCaro.SIZE_O_CO);  // lấy toạ độ cột
        
        if(btnClick.getText().equals("X") || btnClick.getText().equals("O")) {
        	showNotification.notificationEndGame(3);
        }else {
			btnClick.setText("X");             // hiển thị X trên bàn cờ
			if(logicCaro.winCaro(row, column, guiCaro.arraySquare, "X")) {   // sau khi tích thì kiểm tra chiến thắng
				showNotification.notificationEndGame(1);     // in thông báo chiến thắng
				System.exit(0);      // thoát luôn chương trình
			}
			
			guiCaro.confirmSpill ++;            // tăng số lượng kí tự đã đánh để kiểm tra xem bàn cờ đầy chưa
			guiCaro.labelUserPlay.setText("Máy"); // khi đánh xong thiết lập text của JLabel thể hiện đến lượt máy đánh
			
			try {                                       // bước  vào phần xử lí máy đánh
				// gọi hàm để máy thực hiện đánh hàm này tạo ra toạ độ chính xác ô cần đánh ( file JavaBean để lưu)
    			int confirmCoicide = logicCaro.compareFileAndMatrix(guiCaro.arraySquare);    
    			if(confirmCoicide == 0) {
    				// hiển thị thông báo máy không tìm được nước đi phù hợp  - thường sẽ không xảy ra vì phần thế cờ đã bao phủ
    				showNotification.notificationEndGame(4); 
    			}else {
    				// gọi toạ độ đã được tạo ở bên trên - là toạ độ máy tìm được vị trí thích hợp để đánh
        			int row1 = logicCaro.getRowMa() , col1 = logicCaro.getColMa();           			
        			guiCaro.arraySquare[row1][col1].setText("O");         // gán kí tự O vào toạ độ cần đánh
        			if(logicCaro.winCaro(row1, col1, guiCaro.arraySquare, "O")) { // kiểm tra chiến thắng
        				showNotification.notificationEndGame(2);          // in thông báo chiến thắng
        				System.exit(0);             // thoát chương trình              
        			}
        			guiCaro.confirmSpill++;     // tăng giá trị số lương ô cờ đã được đánh
        			
        			guiCaro.labelUserPlay.setText("Bạn"); // máy đánh xong thì set lại text cho JLabel để thông báo đến lượt người chơi đánh
    			}
			}catch(Exception e1) {       // nhận ngoại lệ
				System.out.println(e1);       // in ngoại lệ
			}
    		if(guiCaro.confirmSpill == 400) {   // khi số lượng ô cờ đánh đã hết 
    			showNotification.notificationEndGame(5);         // thông báo bàn cờ đã hết chỗ đánh, hoà
    			System.exit(0);     // thoát khỏi chương trình
    		}
    		
    	}
	}
}