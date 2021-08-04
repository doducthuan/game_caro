/**
 * Copyright(C)2011 Luvina Software Company
 * LogicCaro.java Aug 3, 2021 doducthuan
 */
package LogicGameCaro;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 * hiển thị những thông báo cho người chơi biết
 * @author Admin
 *
 */
public class ShowNotification {
	/**
	 * hiển thị kết quả chơi của trận đấu
	 * @param win : = 1 thì người chơi thắng,
	 *              = 0 thì người chơi thua.
	 */
	public void NotificationEndGame(int win) {
		JFrame frame = new JFrame();          // tạo khung thông báo
		if(win == 1) {                        // nếu người chơi thắng
	        JOptionPane.showMessageDialog(frame, "Bạn đã thắng máy", "Kết quả chơi", JOptionPane.INFORMATION_MESSAGE);  // thông báo cho biết người chơi thắng
		}else if(win == 2) {                               // nếu máy thắng
	        JOptionPane.showMessageDialog(frame, "Bạn đã thua máy", "Kết quả chơi", JOptionPane.INFORMATION_MESSAGE);   // thông báo cho biết người chơi thua
		}else if(win == 3) {                               // nếu máy thắng
	        JOptionPane.showMessageDialog(frame, "Ô này đã được nhập rồi", "Thông báo", JOptionPane.INFORMATION_MESSAGE);   // thông báo cho biết người chơi thua
		}else if(win == 4) {                               // nếu máy thắng
	        JOptionPane.showMessageDialog(frame, "Máy không tìm thấy nước để đánh", "Thông báo", JOptionPane.INFORMATION_MESSAGE);   // thông báo cho biết người chơi thua
		}else if(win == 5) {                               // nếu máy thắng
	        JOptionPane.showMessageDialog(frame, "Hoà - Hẹn tái đấu lần sau", "Thông báo", JOptionPane.INFORMATION_MESSAGE);   // thông báo cho biết người chơi thua
		}
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);  // tắt luôn chương trình
		System.exit(0);
	}
	

}
