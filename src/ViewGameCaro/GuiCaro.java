/**
 * CopyRight(C) doducthuan
 * GuiCaro.java Jul 30, 2021
 */
package ViewGameCaro;

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
 * @author Admin
 *
 */
public class GuiCaro {
	ControllerCaro controllerCaro = new ControllerCaro(this);
	NewGame newGame = new NewGame(this);
	public static final int ROW = 20, COLUMN = 20;
	public int count = 2;
	public int rowMatrixMax, columnMatrixMax, countUser, countComputer;
	
	
	JFrame jFrameCaro = new JFrame("Luvina - Đỗ Đức Thuận - Game Caro");   // tạo 1 khung JFrame chức tất cả các hiển thị cho người chơi xem
	JPanel panelCenter = new JPanel();                                    // tạo JPanel chứa 400 ô button để chơi caro
	JPanel test = new JPanel();
	public JButton arraySquare[][] = new JButton[20][20];                        // tạo mảng hai chiều button với kích thước 20x20 để chơi caro
    public JButton arr[][] = new JButton[9][9];
	
	JLabel labelIconCute = new JLabel();                                    
	JLabel labelTurn = new JLabel("Đến lượt", SwingConstants.CENTER);
	public JLabel labelUserPlay = new JLabel("Bạn", SwingConstants.CENTER);
	JLabel labelIconCute2 = new JLabel();
	JButton buttonExit = new JButton("Thoát trò chơi");
	JButton buttonNewGame = new JButton("Trò chơi mới");
	JButton buttonRedo = new JButton("Đi lại");
	/**
	 * hàm khởi tạo giao diện cho tròn chơi caro
	 * 
	 */
	public void guiGameCaro()  throws IOException{
		
		

		
		jFrameCaro.add(panelCenter);                                      // thêm panelCenter vào trong JFrame
		jFrameCaro.add(labelIconCute);
		jFrameCaro.add(labelTurn);
		jFrameCaro.add(labelUserPlay);
		jFrameCaro.add(labelIconCute2);
		//jFrameCaro.add(test);
		jFrameCaro.add(buttonNewGame);
		//jFrameCaro.add(buttonRedo);
		//jFrameCaro.add(buttonExit);
		
		
		jFrameCaro.setLayout(new FlowLayout());
		jFrameCaro.getContentPane().setBackground(new Color(255,235,205));  //Whatever color
		jFrameCaro.setLayout(new BorderLayout());                         // thiết lập bố cục để các phần khác không bị nhảy ra ngoài tiêu chuẩn kích thước của nó
		jFrameCaro.setSize(1300, 870);                                    // xét kích thước cho JFrame: để chiều rộng là 816 vì khoảng cách các button nhỏ lúc chia sẽ có độ giãn cách nhỏ
		
		
		
		//---------------------------- xét nửa bên phải - nơi chơi trò chơi caro--------------------------------------------//
		
		panelCenter.setBounds(20,20,800,800);                            // xét vị trí và kích thước cho panelCenter( nằm bên dưới có chiều dài và chiều rộng bằng 800 )
		panelCenter.setLayout(new GridLayout(20, 20));                   // để panelCenter chia thành các khoảng diện tích bằng nhau cụ thể là có 20 x 20 ô vuông
		for (int i = 0; i < 20; i++) {                                   // duyệt qua các hàng
            for (int j = 0; j < 20; j++) {                               // duyệt qua các cột
                arraySquare[i][j] = new JButton(" ");                       //khởi tạo từng jbutton
                arraySquare[i][j].setBackground(new Color(220, 220, 220));
                arraySquare[i][j].setMargin(new Insets(0, 0, 0, 0));
                arraySquare[i][j].setFont(new Font("Serif", Font.PLAIN, 25));
                panelCenter.add(arraySquare[i][j]);                     //  add button vào panelCenter
                arraySquare[i][j].addActionListener(controllerCaro);
            }
        }
		//-------------------------------------------------------------------------------------------------------------------//
		
		
		
		
//		test.setBounds(900,350,360,360);                            // xét vị trí và kích thước cho panelCenter( nằm bên dưới có chiều dài và chiều rộng bằng 800 )
//		test.setLayout(new GridLayout(9, 9));                   // để panelCenter chia thành các khoảng diện tích bằng nhau cụ thể là có 20 x 20 ô vuông
//		for (int i = 0; i < 9; i++) {                                   // duyệt qua các hàng
//            for (int j = 0; j < 9; j++) {                               // duyệt qua các cột
//                arr[i][j] = new JButton(" ");                       //khởi tạo từng jbutton
//                arr[i][j].setMargin(new Insets(0, 0, 0, 0));
//                arr[i][j].setFont(new Font("Serif", Font.PLAIN, 25));
//                test.add(arr[i][j]);                     //  add button vào panelCenter
//            }
//        }
		
		//----------------------------- xét nửa bên phải - nơi chứa icon, thông báo, lựa chọn cho người chơi ----------------//
		
		labelIconCute.setBounds(900, 20, 250, 200);
		labelIconCute.setIcon(new ImageIcon(new ImageIcon("images/tym2.gif").getImage().getScaledInstance(250, 200, Image.SCALE_DEFAULT)));
		
		labelTurn.setBounds(980, 220, 150, 50);
		labelTurn.setFont(new Font("Serif", Font.PLAIN, 30));
       
		
		labelUserPlay.setBounds(980, 270, 150, 50);
		labelUserPlay.setBackground(new Color(50, 205, 50));
        labelUserPlay.setOpaque(true);
		labelUserPlay.setFont(new Font("Serif", Font.PLAIN, 30));
		
		labelIconCute2.setBounds(870, 350, 400, 240);
		labelIconCute2.setIcon(new ImageIcon(new ImageIcon("images/456.jpg").getImage().getScaledInstance(400, 240, Image.SCALE_DEFAULT)));
		
		
		buttonNewGame.setBounds(910, 600, 300, 50);
		buttonNewGame.setBounds(910, 750, 300, 50);

		buttonNewGame.addActionListener(newGame);
		buttonRedo.setBounds(910, 670, 300, 50);
		buttonExit.setBounds(910, 740, 300, 50);
		
		//------------------------------------------------------------------------------------------------------------------------//
		
		jFrameCaro.setLocationRelativeTo(null);                        // căn giao diện chương trình ở giữa màn hình máy tính
		jFrameCaro.setResizable(false);                                // không cho phóng to JFrame
		jFrameCaro.setVisible(true);                                   // hiển thị giao diện JFrame
		jFrameCaro.setDefaultCloseOperation(EXIT_ON_CLOSE);            // đóng hoàn toàn khung JFrame
	}

}
