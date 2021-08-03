/**
 * Copyright(C)2011 Luvina Software Company
 * LogicCaro.java Aug 3, 2021 doducthuan
 */
package LogicGameCaro;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;

/**
 * @author doducthuan
 *
 */
public class LogicCaro {
	
	FileLogic fileLogic = new FileLogic();
	/**
	 * 
	 * @param jButton
	 * @param jLabel
	 * @param textButton
	 * @param textLabel
	 * @return
	 */
	public int setValue(JButton jButton, JLabel jLabel, String textButton, String textLabel) {
		int confirm;
		jButton.setText(textButton);
		jLabel.setText(textLabel);
		if(textButton.equals("x")) {
			confirm = 1;
		}else {
			confirm = 0;
		}
		return confirm;
	}
	
	/**
	 * 
	 * @param jButtonTwo
	 * @return
	 */
	public int confirmTickOrNO(JButton jButtonTwo) {
		int confirm = 0;
		if(jButtonTwo.getText().equals("x") || jButtonTwo.getText().equals("o")) {
			confirm = 1;
		}
		if(!jButtonTwo.getText().equals("x") && !jButtonTwo.getText().equals("o")) {
			confirm = 0;
		}
		return confirm;
	}
	
	
	/**
	 * kiểm tra thắng
	 * @param row
	 * @param column
	 * @param jButton
	 * @param name
	 * @return
	 *
	 */
	 public boolean winCaro(int row, int column, JButton jButton[][], String name) {
	        int k, j;
	        int d = 0;
	        for (k = -4; k <= 4; k++) {
	            if (row + k >= 0 && row + k < 20) {
	                if (jButton[row + k][column].getText() == name) {
	                    d++;
	                } else if (d < 5) {
	                    d = 0;
	                }
	            }
	        }
	        if (d >= 5) {
	            return true;
	        } else {
	            d = 0;
	        }
	        //xet ngang
	        for (k = -5; k <= 5; k++) {
	            if (column + k >= 0 && column + k < 20) {
	                if (jButton[row][column + k].getText() == name) {
	                    d++;
	                } else if (d < 5) {
	                    d = 0;
	                }
	            }
	        }
	        if (d >= 5) {
	            return true;
	        } else {
	            d = 0;
	        }
	        //cheo
	        for (k = -4, j = 4; k <= 4 && j >= -4; k++, j--) {
	            if (column + k >= 0 && column + k < 20 && row + j >= 0 && row + j < 20) {
	                if (jButton[row + j][column + k].getText() == name) {
	                    d++;
	                } else if (d < 5) {
	                    d = 0;
	                }
	            }
	        }
	        if (d >= 5) {
	            return true;
	        } else {
	            d = 0;
	        }
	        for (k = -4; k <= 4; k++) {
	            if (column + k >= 0 && column + k < 20 && row + k >= 0 && row + k < 20) {
	                if (jButton[row + k][column + k].getText() == name) {
	                    d++;
	                } else if (d < 5) {
	                    d = 0;
	                }
	            }
	        }
	        if (d >= 5) {
	            return true;
	        }
	        return false;
	    }
	 
	 
	 /**
	  * tạo game mới
	  * @param jButton
	  * @param n
	  *
	  */
	 public void newGameCaro(JButton jButton[][], int n) {
		 for (int i = 0; i < n; i++) {                                   // duyệt qua các hàng
	            for (int j = 0; j < n; j++) {                               // duyệt qua các cột
	                jButton[i][j].setText(" ");                       //khởi tạo từng jbutton
	            }
	        }
	 }
	 
	 public int compareTwoMatrix(String[][] matrixFile, String[][] matrixGui) {
		 int count = 0;
		 int index = 0;
		 int confirm = 0;
		 for(int i = 0; i < 5; i++) {
			 for(int j = 0; j < 5; j++) {
				 if(matrixFile[i][j].equals("T") && matrixGui[i][j].equals(" ")) {
					 count ++;
					 confirm = i + 1;
				 }else if(matrixFile[i][j].equals("G") && (matrixGui[i][j].equals(" ") || matrixGui[i][j].equals("X") || matrixGui[i][j].equals("O"))) {
					 count ++;
				 }else if(matrixFile[i][j].equals("D") && matrixGui[i][j].equals(" ")) {
					 count ++;
				 }else if(matrixFile[i][j].equals(matrixGui[i][j])) {
					 count ++;
				 }
			 }
		 }
		 if(count == 25) {
			 index = confirm;
		 }
		 return index;
	 }
	 public String[][] getMatrixAttackOrDefence(int row, int column, JButton[][] jButton){
		float rowOne = row - 2, 
		      rowTwo = row + 2, 
			  columnOne = column - 2, 
			  columnTwo = column + 2;
		int rowMatrix= 0, colMatrix = 0;
		String[][] matrix = new String[9][9];
			for(float ro = rowOne; ro <= rowTwo; ro++) {
				for(float co = columnOne; co <= columnTwo; co++) {
					matrix[rowMatrix][colMatrix] = jButton[(int)ro][(int)co].getText();
					colMatrix++;
					if(colMatrix == 5) {
						rowMatrix++;
						colMatrix = 0;
					}
					if(rowMatrix == 5) {
						break;
					}
				}
			}
		return matrix;
	}
	 public void setMatrix5(JButton[][] jButton) {
		 String[][][] dataOfMatrix20;
		 for(int i = 2; i < 18; i++) {
			 for(int j = 2; j < 18; j++) {
				 String[][] matrix5 = getMatrixAttackOrDefence(i, j, jButton);
				 
			 }
		 }
	 }
	 public void compareFileAndMatrix(JButton jButton) throws FileNotFoundException, IOException {
		 String[][][] dataFile = fileLogic.getArray3();
		 for(int index = 0; index < dataFile.length; index ++) {
			 for(int row = 0; row < 5; row ++) {
				 for(int column = 0; column < 5; column ++) {
					 
				 }
			 }
		 }
	 }

}
