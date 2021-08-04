/**
 * Copyright(C)2011 Luvina Software Company
 * DataOfMatrix.java Aug 3, 2021 doducthuan
 */
package Data;

/**
 * @author doducthuan
 *
 */
public class DataOfMatrix {
	
	private int toaDoRow;   // vị trsi hàng cần đánh của máy
	private int toaDoColumn;  // vị trí cột cần đáh
	/**
	 * trả về vị trí hàng cần đáh
	 * @return the toaDoRow  // vị trí hàng
	 */
	public int getToaDoRow() {
		return toaDoRow;  // trả về vị trí hàng
	}
	/**
	 * thiết lập vị trí hàng cần đánh
	 * @param toaDoRow the toaDoRow to set
	 */
	public void setToaDoRow(int toaDoRow) {
		this.toaDoRow = toaDoRow;  // gán giá trị cho hàng
	}
	/**
	 * trả về giá trị cột cần đáh
	 * @return the toaDoColumn
	 */
	public int getToaDoColumn() {
		return toaDoColumn;  // trả về cột
	}
	/**
	 * thiết lập vị trí cột
	 * @param toaDoColumn the toaDoColumn to set
	 */
	public void setToaDoColumn(int toaDoColumn) {
		this.toaDoColumn = toaDoColumn;  // gán giá trị cột
	}
	private float rowMatrix;   // độ lệch hàng so với vị trí cần đáh
	private float columnMatrix;  // độ lệch cột so với vị trí cần đánh
	
	
	
	/**
	 * trả về độ lêch hàng caafn đánh
	 * @return the rowMatrix
	 */
	public float getRowMatrix() {
		return rowMatrix;  // trả về độ lệch hàng
	}
	/**
	 *  thiết lập độ lêch vị trí hàng cần đánh
	 * @param rowMatrix the rowMatrix to set
	 */
	public void setRowMatrix(float rowMatrix) {
		this.rowMatrix = rowMatrix;   // gán giá trị độ lệch
	}
	/**
	 * trả về độ lêch cột cần đáh
	 * @return the columnMatrix
	 */
	public float getColumnMatrix() {
		return columnMatrix;   // độ lêch cột
	}
	/**
	 * thiết lập độ lệch cột cần đánh
	 * @param columnMatrix the columnMatrix to set
	 */
	public void setColumnMatrix(float columnMatrix) {
		this.columnMatrix = columnMatrix;  // gán độ lêch cột cần đánh
	}
	
}
