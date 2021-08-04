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
	public NewGame(GuiCaro guiCaro) {
		this.guiCaroNew = guiCaro;
	}
	
	LogicCaro logicCaro = new LogicCaro();
	public void actionPerformed(ActionEvent e) {
		logicCaro.newGameCaro(guiCaroNew.arraySquare, 20);
		//logicCaro.newGameCaro(guiCaroNew.arr, 9);
		guiCaroNew.count = 0;
	}
}
