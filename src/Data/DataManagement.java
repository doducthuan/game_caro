/**
 * CopyRight(C) 
 * DataManagement.java Aug 3, 2021 doducthuan
 */
package Data;

/**
 * chứa các ma trận 5*5 của file thế cờ 
 * các ma trận 5*5 được nạp vào mảng 3 chiều ( tức là là 1 mảng chứa các phần tử, mỗi phần tử là một ma trận )
 * @author doducthuan
 *
 */
public class DataManagement {
	// mảng 3 chiều chứa các ma trận được đọc từ file thế cờ
	private String dataMatrix[][][];
	private int length;
	/**
	 * trả về độ dài mảng 3 chiều
	 * @return the length : độ dài của mảng 3 chiều
	 */
	public int getLength() {
		return length;
	}

	/**
	 * thiết lập giá trị độ dài mảng 3 chiều
	 * @param length the length to set : 
	 */
	public void setLength(int length) {
		this.length = length;
	}

	/**
	 * 
	 * trả về mảng 3 chiều
	 * @return the dataMatrix
	 */
	public String[][][] getDataMatrix() {
		
		// trả về mảng 3 chiều
		return dataMatrix;
	}

	/**
	 * gán giá trị cho mảng 3 chiều
	 * @param dataMatrix the dataMatrix to set
	 */
	public void setDataMatrix(String[][][] dataMatrix) {
		
		// truyền dữ liệu cho mảng 3 chiều
		this.dataMatrix = dataMatrix;
	}
}
