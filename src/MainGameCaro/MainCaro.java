/**
 * CopyRight(C) doducthuan
 * MainCaro.java Jul 30, 2021
 */
package MainGameCaro;
import ViewGameCaro.GuiCaro;
import java.io.IOException;

/**
 * Lớp chính khi chương trình chạy
 * @author Admin
 *
 */
public class MainCaro {

	/**
	 * gọi các hàm để chạy chương trình
	 * @param args : tham số dòng lệnh
	 * 
	 */
	public static void main(String[] args) throws IOException{
		GuiCaro guiCaro = new GuiCaro();        // khởi tạo đối tượng giao diện game cờ caro
		guiCaro.guiGameCaro();                  // gọi hàm khởi tạo giao diện

	}

}
