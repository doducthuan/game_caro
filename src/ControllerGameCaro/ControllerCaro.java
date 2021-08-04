/**
 * CopyRight(C) doducthuan
 * ControllerCaro.java Jul 30, 2021
 */
package ControllerGameCaro;
//import java.io.IOException;

import java.awt.event.ActionListener;
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
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < GuiCaro.ROW; i++) {                                   // duyệt qua các hàng
            for (int j = 0; j < GuiCaro.COLUMN; j++) {                               // duyệt qua các cột
            	int confirm = logicCaro.confirmTickOrNO(guiCaro.arraySquare[i][j]);
            	if(e.getSource() == guiCaro.arraySquare[i][j] && confirm == 1) {
            		showNotification.NotificationEndGame(3);
            	}else if(e.getSource() == guiCaro.arraySquare[i][j] && confirm == 2) {               	
            		guiCaro.arraySquare[i][j].setText("x");           		
                	break;
            	}
            }
		}
	}
}