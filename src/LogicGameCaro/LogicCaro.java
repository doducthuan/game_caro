/**
 * Copyright(C)2011 Luvina Software Company
 * LogicCaro.java Aug 3, 2021 doducthuan
 */
package LogicGameCaro;

import java.io.FileNotFoundException;
import java.io.IOException;
import Data.DataOfMatrix;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 * @author doducthuan
 *
 */
public class LogicCaro {
	
	FileLogic fileLogic = new FileLogic();
	DataOfMatrix dataOfMatrix = new DataOfMatrix();
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
			confirm = 2;
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
	 
	 /**
	  * so sánh hai ma trận
	  * @param matrixFile
	  * @param matrixGui
	  * @return
	  *
	  */
	 public int compareTwoMatrix(String[][] matrixFile, String[][] matrixGui) {
		 int count = 0;
		 int index = 0;
		 int ro = 0, col = 0;
		 for(int i = 0; i < 5; i++) {
			 for(int j = 0; j < 5; j++) {
				 if(matrixFile[i][j].equals("T") && matrixGui[i][j].equals(" ")) {
					 count ++;
					 ro = i;
					 col = j;
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
			 index = 1;
			 dataOfMatrix.setColumnMatrix(2-col);
			 dataOfMatrix.setRowMatrix(2- ro);
		 }else {
			 index = 0;
		 }
		 return index;
	 }
	 
	 /**
	  * tạo ma trận 5*5 từ toạ độ của bàn cờ
	  * @param row
	  * @param column
	  * @param jButton
	  * @return
	  *
	  */
	 public String[][] getMatrixAttackOrDefence(int row, int column, JButton[][] jButton){
		int rowOne = row - 2, 
		      rowTwo = row + 2, 
			  columnOne = column - 2, 
			  columnTwo = column + 2;
		int rowMatrix= 0, colMatrix = 0;
		String[][] matrix = new String[5][5];
		loop:
			for(int ro = rowOne; ro <= rowTwo; ro++) {
				for(int  co = columnOne; co <= columnTwo; co++) {
					matrix[rowMatrix][colMatrix] = jButton[ro][co].getText();
					colMatrix++;
					if(colMatrix == 5) {
						rowMatrix++;
						colMatrix = 0;
					}
					if(rowMatrix == 5) {
						break loop;
					}
				}
			}
		return matrix;
	}
	 
	 /**
	  * so sánh thế cờ với bàn cờ
	  * @param jButton
	  * @throws FileNotFoundException
	  * @throws IOException
	  *
	  */
	 public void compareFileAndMatrix(JButton[][] jButton) throws FileNotFoundException, IOException {
		 String[][][] dataFile = fileLogic.getArray3();
		 int index = 0;
		
//		 for(int i = 2; i < 18; i++) {
//			 for(int j = 2; j < 18; j++) {
//				 String[][] matrix5 = getMatrixAttackOrDefence(i, j, jButton);
//				 for(String[][] matrixFi : dataFile) {
//					 index = compareTwoMatrix(matrixFi, matrix5);
//					 if(index > 0) {
//						 dataOfMatrix.setToaDoRow(i - (int)dataOfMatrix.getRowMatrix() );
//						 dataOfMatrix.setToaDoColumn(j - (int)dataOfMatrix.getColumnMatrix());
//						 break outerloop;
//					 }
//				 }
//			 }
//		 }
		outerloop:
		for(String[][] matrixFi : dataFile) {
			for(int i = 2; i < 18; i++) {
				for(int j = 2; j < 18; j ++) {
					String[][] matrix5 = getMatrixAttackOrDefence(i, j, jButton);
					index = compareTwoMatrix(matrixFi, matrix5);
					if(index > 0) {
						dataOfMatrix.setToaDoRow(i - (int)dataOfMatrix.getRowMatrix() );
						dataOfMatrix.setToaDoColumn(j - (int)dataOfMatrix.getColumnMatrix());
						break outerloop;
					}
				}
			}
		}
	 }
	 
//	 public int[] getCoordinates() {
//		 int[] coor = new int[2];
//		 for(int i = 0; i < 2; i++) {
//			 if(i == 0) {
//				 coor[i] = dataOfMatrix.getToaDoRow(); 
//			 }
//			 if(i == 2) {
//				 coor[i] = dataOfMatrix.getToaDoColumn(); 
//			 }
//		 }
//		 return coor;
//	 }
	 public int getRowMa() {
		 int c = dataOfMatrix.getToaDoRow();
		 return c;
	 }
	 
	 public int getColMa() {
		 int c = dataOfMatrix.getToaDoColumn();
		 return c;
	 }

}
