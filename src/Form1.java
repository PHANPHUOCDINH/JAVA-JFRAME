package MoPhongSapXep;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import java.awt.Point;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class Form1 extends JFrame {

	private JPanel contentPane,panelThuatToan;
	private JMenuBar menuBar;
	private JMenu menuCaiDat,menuGioiThieu,menuChonMau;
	private JRadioButton radioButtonNhap,radioButtonRandom,radioButton,radioButton1,radioButton2,radioButton3,radioButton4,radioButton5,radioButton6,radioButton7;
	private ButtonGroup buttonGroup1,buttonGroup2;
	private JButton btnChonFile,buttonRandom,buttonTaoNut,buttonTiepTuc,buttonTaoLai,buttonStop;
	private JComboBox comboBoxFile,comboBoxRandom;
	private JLabel labelNhapSo,labelRandom,labelRandom1,labelCode;
	private JTextField textSo,textRandom;
	private JTextArea textArea,textArea_1;
	private int[]arr;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form1 frame = new Form1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Form1() {
		setBounds(100, 100, 1376, 742);
		setLocation(new Point(0,0));
		setTitle("Mô phỏng thuật toán sắp xếp");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 124, 21);
		menuBar.setToolTipText("");
		contentPane.add(menuBar);
		
		menuCaiDat = new JMenu("Cài Đặt");
		menuBar.add(menuCaiDat);
		
		menuChonMau = new JMenu("Chọn màu nút");
		menuCaiDat.add(menuChonMau);
		
		menuGioiThieu = new JMenu("Giới Thiệu");
		menuBar.add(menuGioiThieu);
		
		radioButtonNhap = new JRadioButton("Nhập");
		radioButtonNhap.setBounds(33, 26, 63, 23);
		radioButtonNhap.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(radioButtonNhap);
		
		radioButtonRandom = new JRadioButton("Random");
		radioButtonRandom.setBounds(33, 124, 87, 23);
		radioButtonRandom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(radioButtonRandom);
		
		buttonGroup1= new ButtonGroup();
		buttonGroup1.add(radioButtonNhap);
		buttonGroup1.add(radioButtonRandom);
		
		btnChonFile = new JButton("Chọn File");
		btnChonFile.setBounds(119, 26, 116, 23);
		btnChonFile.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(btnChonFile);
		
		comboBoxFile = new JComboBox();
		comboBoxFile.setBounds(268, 23, 251, 29);
		contentPane.add(comboBoxFile);
		
		labelNhapSo = new JLabel("Nhập dãy số (phân cách khoảng trắng)");
		labelNhapSo.setBounds(0, 83, 272, 21);
		labelNhapSo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(labelNhapSo);
		
		textSo = new JTextField();
		textSo.setBounds(268, 81, 251, 29);
		contentPane.add(textSo);
		textSo.setColumns(10);
		
		comboBoxRandom = new JComboBox();
		comboBoxRandom.setBounds(142, 124, 52, 23);
		contentPane.add(comboBoxRandom);
		
		labelRandom = new JLabel("số");
		labelRandom.setBounds(218, 125, 30, 21);
		labelRandom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(labelRandom);
		
		buttonRandom = new JButton("Random");
		buttonRandom.setBounds(268, 124, 116, 23);
		buttonRandom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(buttonRandom);
		
		labelRandom1 = new JLabel("Dãy số được Random");
		labelRandom1.setBounds(84, 160, 157, 21);
		labelRandom1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(labelRandom1);
		
		textRandom = new JTextField();
		textRandom.setBounds(268, 158, 251, 29);
		textRandom.setColumns(10);
		contentPane.add(textRandom);
		
		panelThuatToan = new JPanel();
		panelThuatToan.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Ch\u1ECDn Thu\u1EADt To\u00E1n", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panelThuatToan.setToolTipText("");
		panelThuatToan.setBounds(545, 11, 320, 177);
		contentPane.add(panelThuatToan);
		panelThuatToan.setLayout(null);
		
		radioButton = new JRadioButton("Interchange Sort");
		radioButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		radioButton.setBounds(6, 19, 135, 23);
		panelThuatToan.add(radioButton);
		
		radioButton1 = new JRadioButton("Selection Sort");
		radioButton1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		radioButton1.setBounds(161, 19, 135, 23);
		panelThuatToan.add(radioButton1);
		
		radioButton2 = new JRadioButton("Interchange Sort");
		radioButton2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		radioButton2.setBounds(6, 62, 135, 23);
		panelThuatToan.add(radioButton2);
		
		radioButton3 = new JRadioButton("Selection Sort");
		radioButton3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		radioButton3.setBounds(161, 62, 135, 23);
		panelThuatToan.add(radioButton3);
		
		radioButton4 = new JRadioButton("Interchange Sort");
		radioButton4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		radioButton4.setBounds(6, 107, 135, 23);
		panelThuatToan.add(radioButton4);
		
		radioButton5 = new JRadioButton("Selection Sort");
		radioButton5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		radioButton5.setBounds(161, 107, 135, 23);
		panelThuatToan.add(radioButton5);
		
		radioButton6 = new JRadioButton("Interchange Sort");
		radioButton6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		radioButton6.setBounds(6, 147, 135, 23);
		panelThuatToan.add(radioButton6);
		
		radioButton7 = new JRadioButton("Selection Sort");
		radioButton7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		radioButton7.setBounds(161, 147, 135, 23);
		panelThuatToan.add(radioButton7);
		
		buttonGroup2= new ButtonGroup();
		buttonGroup2.add(radioButton);
		buttonGroup2.add(radioButton1);
		buttonGroup2.add(radioButton2);
		buttonGroup2.add(radioButton3);
		buttonGroup2.add(radioButton4);
		buttonGroup2.add(radioButton5);
		buttonGroup2.add(radioButton6);
		buttonGroup2.add(radioButton7);
		
		textArea = new JTextArea();
		textArea.setBounds(883, 39, 467, 261);
		contentPane.add(textArea);
		
		labelCode = new JLabel("Code thực thi thuật toán");
		labelCode.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelCode.setBounds(1042, 6, 172, 21);
		contentPane.add(labelCode);
		
		buttonTaoNut = new JButton("Tạo Nút");
		buttonTaoNut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!radioButtonNhap.isSelected()&&!radioButtonRandom.isSelected())
				{
					JOptionPane.showMessageDialog(rootPane, "Chọn đầu vào hợp lệ", "Warning",JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					if(radioButtonNhap.isSelected())
						xuLyChuoi(textSo);
				}
			}
		});
		buttonTaoNut.setFont(new Font("Tahoma", Font.PLAIN, 15));
		buttonTaoNut.setBounds(27, 204, 116, 23);
		contentPane.add(buttonTaoNut);
		
		buttonTiepTuc = new JButton("Tiếp Tục");
		buttonTiepTuc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		buttonTiepTuc.setBounds(27, 236, 116, 23);
		contentPane.add(buttonTiepTuc);
		
		buttonTaoLai = new JButton("Tạo Lại");
		buttonTaoLai.setFont(new Font("Tahoma", Font.PLAIN, 15));
		buttonTaoLai.setBounds(180, 236, 116, 23);
		contentPane.add(buttonTaoLai);
		
		buttonStop = new JButton("Dừng Lại");
		buttonStop.setFont(new Font("Tahoma", Font.PLAIN, 15));
		buttonStop.setBounds(180, 204, 116, 23);
		contentPane.add(buttonStop);
		
		textArea_1 = new JTextArea();
		textArea_1.setBounds(431, 198, 434, 102);
		contentPane.add(textArea_1);
		
		
	}
	public static void xuLyChuoi(String s)
	{
		
	}
}
