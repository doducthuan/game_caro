/**
 * Copyright(C)2011 Luvina Software Company
 * LogicCaro.java Aug 3, 2021 doducthuan
 */
package LogicGameCaro;

import javax.swing.JButton;
import javax.swing.JLabel;

/**
 * @author doducthuan
 *
 */
public class LogicCaro {
	
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
	 * cách này  hay
	 * @param row
	 * @param column
	 * @param jButton
	 * @return
	 *
	 */
	public String[][] getMatrixAttackOrDefence(int row, int column, JButton jButton[][]){
		float rowOne = row - 4, 
		      rowTwo = row + 4, 
			  columnOne = column - 4, 
			  columnTwo = column + 4;
		int l= 0, m = 0;
		String[][] matrix = new String[9][9];
			for(float i = rowOne; i <= rowTwo; i++) {
				for(float j = columnOne; j <= columnTwo; j++) {
					if(i < 0 || j < 0 || i > 19 || j > 19) {
						matrix[l][m] = "i";
						m++;
					}else if(i >= 0 || j >=0) {
						matrix[l][m] = jButton[(int)i][(int)j].getText();
						m++;
					}
					if(m == 9) {
						l++;
						m = 0;
					}
					if(l == 9) {
						break;
					}
				}
			}
		return matrix;
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
	  * duyet nhung truong hop nguy hiem
	  * @param arrayOfMatrix
	  *
	  */

}
