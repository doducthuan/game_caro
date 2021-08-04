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
	public ControllerCaro(GuiCaro guiCaro) {
		this.guiCaro = guiCaro;
	}
	
	ShowNotification showNotification = new ShowNotification();
	LogicCaro logicCaro = new LogicCaro();
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * xử lí khi lắng nghe được 1 sự kiện 
	 */
	public void actionPerformed(ActionEvent e) {
		loop:
		for (int i = 0; i < GuiCaro.ROW; i++) {                                   // duyệt qua các hàng
            for (int j = 0; j < GuiCaro.COLUMN; j++) {                               // duyệt qua các cột
            	int confirm = logicCaro.confirmTickOrNO(guiCaro.arraySquare[i][j]);
            	if(e.getSource() == guiCaro.arraySquare[i][j] && confirm == 1) {
            		showNotification.NotificationEndGame(3);
            	}else if(e.getSource() == guiCaro.arraySquare[i][j] && confirm == 2) {
            		if(guiCaro.count % 2 == 0) {
            			guiCaro.arraySquare[i][j].setText("X");
            			if(logicCaro.winCaro(i, j, guiCaro.arraySquare, "X")) {
            				showNotification.NotificationEndGame(1);
            				System.exit(0);
            			}
            			guiCaro.labelUserPlay.setText("May");	
            			try {
	            			logicCaro.compareFileAndMatrix(guiCaro.arraySquare);
	            			int row1 = logicCaro.getRowMa() , col1 = logicCaro.getColMa();           			
	            			guiCaro.arraySquare[row1][col1].setText("O");
	            			if(logicCaro.winCaro(row1, col1, guiCaro.arraySquare, "X")) {
	            				showNotification.NotificationEndGame(2);
	            				System.exit(0);
	            			}
	            			guiCaro.labelUserPlay.setText("Ban");
            			}catch(Exception e1) {
            				System.out.println(e1);
            			}
            		
            		}
            		break loop;
            	}
            }
		}
	}
}