/**
 * CopyRight(C) doducthuan
 * GuiCaro.java Jul 30, 2021
 */
package ViewGameCaro;
import java.awt.Dimension;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.io.IOException;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;


import ControllerGameCaro.*;
/**
 * khởi tạo giao diện cho game caro
 * @author Admin
 *
 */
public class GuiCaro {
	ControllerCaro controllerCaro = new ControllerCaro(this);              // tạo đối tượng để thực hiện lệnh khi có sự kiện được lắng nghe ( sau khi người đáh thì máy đanh )
	NewGame newGame = new NewGame(this);                                   // tạo đối tượng để thực hiện lệnh khi có sự kiện được lắng nghe ( Game mới )                            
	
	public static final int ROW = 20, COLUMN = 20;      // hàng và cột của ma trận lớn , nếu muốn thay đổi số hàng và số cột chỉ cần thay đổi gia trị trong này     
	public static final int SIZE_O_CO = 40;             // kích thước của 1 ô cờ
	public int confirmSpill = 0;                    // kiểm tra xem các button đã được đánh hết hay chưa
	
	
	JFrame jFrameCaro = new JFrame("Luvina - Đỗ Đức Thuận - Game Caro");   // tạo 1 khung JFrame chức tất cả các hiển thị cho người chơi xem
	JPanel panelCenter = new JPanel();                                    // tạo JPanel chứa 400 ô button để chơi caro
	JPanel test = new JPanel();
	public JButton arraySquare[][] = new JButton[20][20];                        // tạo mảng hai chiều button với kích thước 20x20 để chơi caro
                                 
	
	JLabel labelIconCute = new JLabel();          // tạo đối tương JLabel        gán icon cute                    
	JLabel labelTurn = new JLabel("Đến lượt", SwingConstants.CENTER);     // tạo đối tương để gán text thông báo đến lượt ai chơi
	public JLabel labelUserPlay = new JLabel("Bạn", SwingConstants.CENTER);   //  tạo đối tương thông báo ai sẽ điieefn
	JLabel labelIconCute2 = new JLabel();                          // tạo đối tượgn JLabel để gán icon vào
	JButton buttonExit = new JButton("Thoát trò chơi");           // tạo button có chứ năng khởi tạo trò chơi mới
	JButton buttonNewGame = new JButton("Trò chơi mới");
	/**
	 * hàm khởi tạo giao diện cho tròn chơi caro
	 * 
	 */
	public void guiGameCaro()  throws IOException{
		
		

		
		jFrameCaro.add(panelCenter);                                      // thêm panelCenter vào trong JFrame
		jFrameCaro.add(labelIconCute);                                   // thêm labelIconCute vào JFrame
		jFrameCaro.add(labelTurn);                                       // thêm labelTurn vào JFrame
		jFrameCaro.add(labelUserPlay);                                   // thêm labelUserPlay vào JFrame
		jFrameCaro.add(labelIconCute2);                                  // thêm labelIconCute2
		jFrameCaro.add(buttonNewGame);                                   // thêm buttonNewGame vào JFrame
		
		
		jFrameCaro.setLayout(new FlowLayout());                         // set Layout cho JFrame
		jFrameCaro.getContentPane().setBackground(new Color(255,235,205));  // thiết lập màu cho JFrame
		jFrameCaro.setLayout(new BorderLayout());                         // thiết lập bố cục để các phần khác không bị nhảy ra ngoài tiêu chuẩn kích thước của nó
		jFrameCaro.setSize(1300, 870);                                    // xét kích thước cho JFrame: để chiều rộng là 816 vì khoảng cách các button nhỏ lúc chia sẽ có độ giãn cách nhỏ
		
		
		
		//---------------------------- xét nửa bên phải - nơi chơi trò chơi caro--------------------------------------------//
		
		panelCenter.setBounds(20,20,800,800);                            // xét vị trí và kích thước cho panelCenter( nằm bên dưới có chiều dài và chiều rộng bằng 800 )
		panelCenter.setLayout(new GridLayout(20, 20));                   // để panelCenter chia thành các khoảng diện tích bằng nhau cụ thể là có 20 x 20 ô vuông
		for (int i = 0; i < 20; i++) {                                   // duyệt qua các hàng
            for (int j = 0; j < 20; j++) {                               // duyệt qua các cột
                arraySquare[i][j] = new JButton(" ");                       //khởi tạo từng jbutton
                arraySquare[i][j].setBackground(new Color(220, 220, 220));  // thiếp lập màu cho các button
                arraySquare[i][j].setMargin(new Insets(0, 0, 0, 0));     // thiết lập khoảng cách của chữ cho vừa với kích thước của khung button
                arraySquare[i][j].setPreferredSize(new Dimension(SIZE_O_CO, SIZE_O_CO));
                arraySquare[i][j].setFont(new Font("Serif", Font.PLAIN, 25)); // thiết lập font chữ trong text của button
                panelCenter.add(arraySquare[i][j]);                     //  add button vào panelCenter
                arraySquare[i][j].addActionListener(controllerCaro);    // nhận sự kiện
            }
        }
		//-------------------------------------------------------------------------------------------------------------------//
		
		
		
		
		//----------------------------- xét nửa bên phải - nơi chứa icon, thông báo, lựa chọn cho người chơi ----------------//
		
		labelIconCute.setBounds(900, 20, 250, 200);                     // thiết lập vị trí, toạ đọ x, y và kích thước của đối tượng
		labelIconCute.setIcon(new ImageIcon(new ImageIcon("images/tym2.gif").getImage().getScaledInstance(250, 200, Image.SCALE_DEFAULT)));  // thêm ảnh động vào labelIconCute
		
		labelTurn.setBounds(980, 220, 150, 50);                  // thiết lập vị trí, toạ đọ x, y và kích thước của đối tượng
		labelTurn.setFont(new Font("Serif", Font.PLAIN, 30));   // thiết lập font chữ cho JLabel
       
		
		labelUserPlay.setBounds(980, 270, 150, 50);    // thiết lập vị trí, toạ đọ x, y và kích thước của đối tượng
		labelUserPlay.setBackground(new Color(50, 205, 50));  // thiết lập màu nền
        labelUserPlay.setOpaque(true); // bật khung label
		labelUserPlay.setFont(new Font("Serif", Font.PLAIN, 30));   // thiết lập font chữ
		
		labelIconCute2.setBounds(870, 350, 400, 240);          // thiết lập vị trí, toạ đọ x, y và kích thước của đối tượng
		labelIconCute2.setIcon(new ImageIcon(new ImageIcon("images/456.jpg").getImage().getScaledInstance(400, 240, Image.SCALE_DEFAULT)));  // gán ảnh cho label
		
		
		//buttonNewGame.setBounds(910, 600, 300, 50);  // thiết lập vị trí, toạ đọ x, y và kích thước của đối tượng
		buttonNewGame.setBounds(910, 750, 300, 50);   // thiết lập vị trí, toạ đọ x, y và kích thước của đối tượng
		buttonNewGame.addActionListener(newGame);  // nhận sự kiện
		
		//------------------------------------------------------------------------------------------------------------------------//
		
		jFrameCaro.setLocationRelativeTo(null);                        // căn giao diện chương trình ở giữa màn hình máy tính
		jFrameCaro.setResizable(false);                                // không cho phóng to JFrame
		jFrameCaro.setVisible(true);                                   // hiển thị giao diện JFrame
		jFrameCaro.setDefaultCloseOperation(EXIT_ON_CLOSE);            // đóng hoàn toàn khung JFrame
	}

}
