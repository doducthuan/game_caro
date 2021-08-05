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



/**
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
		loop:
		for (int i = 0; i < GuiCaro.ROW; i++) {                                   // duyệt qua các hàng
            for (int j = 0; j < GuiCaro.COLUMN; j++) {                               // duyệt qua các cột
            	int confirm = logicCaro.confirmTickOrNO(guiCaro.arraySquare[i][j]);   // gọi hàm kiểm tra xem 1 ô đã được tích hay chưa
            	if(e.getSource() == guiCaro.arraySquare[i][j] && confirm == 1) {      // nếu được tích rồi
            		showNotification.notificationEndGame(3);                       // thông báo ô đã được tích
            	}else if(e.getSource() == guiCaro.arraySquare[i][j] && confirm == 2) {         // nếu chưa được tích
        			guiCaro.arraySquare[i][j].setText("X");                          // gán kí tự X vào text của buttton vừa nhấn
        			if(logicCaro.winCaro(i, j, guiCaro.arraySquare, "X")) {         // sau khi tích thì kiểm tra chiến thắng
        				showNotification.notificationEndGame(1);                   // in thông báo chiến thắng
        				System.exit(0);
        			}
        			guiCaro.confirmSpill ++;
        			guiCaro.labelUserPlay.setText("May");	        // khi đánh xong thiết lập text của JLabel thể hiện đến lượt máy đánh
        			try {                                       // bước  vào phần xử lí máy đánh
            			int confirmCoicide = logicCaro.compareFileAndMatrix(guiCaro.arraySquare);    // gọi hàm để máy thực hiện đánh hàm này tạo ra toạ độ chính xác ô cần đánh ( file JavaBean để lưu)
            			if(confirmCoicide == 0) {
            				showNotification.notificationEndGame(4);
            			}else {
	            			int row1 = logicCaro.getRowMa() , col1 = logicCaro.getColMa();    // gọi toạ độ đã được tạo ở bên trên          			
	            			guiCaro.arraySquare[row1][col1].setText("O");                     // gán kí tự O vào toạ độ cần đánh
	            			if(logicCaro.winCaro(row1, col1, guiCaro.arraySquare, "O")) {    // kiểm tra chiến thắng
	            				showNotification.notificationEndGame(2);
	            				System.exit(0);             // in thông báo                
	            			}
	            			guiCaro.confirmSpill++;
	            			
	            			guiCaro.labelUserPlay.setText("Ban");     // máy đánh xong thì set lại text cho JLabel để thông báo đến lượt người chơi đánh
            			}
        			}catch(Exception e1) {                      // nhận ngoại lệ
        				System.out.println(e1);                  // in ngoại lệ
        			}
            		if(guiCaro.confirmSpill == 400) {
            			showNotification.notificationEndGame(5);
            		}
            		break loop;                     // nếu đánh xong thì thoát luôn khỏi vòng lặt đôi sử dụng giống như kiểu 1 lênh jump
            	}
            }
		}
	}
}