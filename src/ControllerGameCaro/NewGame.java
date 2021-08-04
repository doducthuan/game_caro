/**
 * CopyRight(C) doducthuan
 * NewGame.java Jul 31, 2021
 */
package ControllerGameCaro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import LogicGameCaro.LogicCaro;


//import javax.swing.JButton;

import ViewGameCaro.GuiCaro;

/**
 * @author Admin
 *
 */
public class NewGame implements ActionListener{
	
	GuiCaro guiCaroNew;
	
	/**
	 * tương tác với phần view
	 * @param guiCaro : đối tượng GuiCaro
	 *
	 */
	public NewGame(GuiCaro guiCaro) {
		this.guiCaroNew = guiCaro;
	}
	
	LogicCaro logicCaro = new LogicCaro();
	
	/**
	 * xử lí sự kiện khi nhận được sự kiện tạo game mới khi đó set lại toàn bộ text của button về kí tự trống
	 */
	public void actionPerformed(ActionEvent e) {
		logicCaro.newGameCaro(guiCaroNew.arraySquare, 20);  // gọi hàm tạo game mới
	}
}
