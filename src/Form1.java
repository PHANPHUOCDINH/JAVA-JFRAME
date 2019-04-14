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
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Point;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JToolBar;
import javax.swing.Timer;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.event.MenuListener;
import javax.swing.event.MenuEvent;
import javax.swing.JMenuItem;

public class Form1 extends JFrame {

	private JPanel contentPane,panelThuatToan,panelChieuSapXep;
	private JMenuBar menuBar;
	private JMenu menuCaiDat,menuGioiThieu;
	private JMenuItem chonMau;
	private JRadioButton radioButtonNhap,radioButtonRandom,radiobuttonIS,radioButton1,radioButton2,radioButton3,radioButton4,radioButton5,radioButton6,radioButton7,radiobuttonGiamDan,radiobuttonTangDan;
	private ButtonGroup buttonGroup1,buttonGroup2,buttonGroup3;
	private JButton btnChonFile,buttonRandom,buttonTaoNut,buttonTiepTuc,buttonTaoLai,buttonStart,listbut[];
	private JComboBox comboBoxFile,comboBoxRandom;
	private JLabel labelNhapSo,labelRandom,labelRandom1,labelCode,labelindex[];
	private JTextField textSo,textRandom;
	private JTextArea textArea,textArea_1;
	private int arr[],len,pos[];
	private Timer timer;
	private JButton buttonStop;
	private Color color;
	private List<Step> list= new ArrayList<Step>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form1 frame = new Form1();
					//frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
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
		
		chonMau = new JMenuItem("Chọn màu nút");
		chonMau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				color= JColorChooser.showDialog(null, "Chọn màu", Color.RED);
				for(JButton b:listbut)
				{
					b.setBackground(color);
				}
			}
		});
		menuCaiDat.add(chonMau);
		
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
		btnChonFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser jfc= new JFileChooser(new File("Desktop"));
		 //       FileFilter filter = new FileNameExtensionFilter("txt");
		   //     jfc.setFileFilter(filter);
				jfc.setDialogTitle("Chọn file");
				if(jfc.showOpenDialog(null)==JFileChooser.APPROVE_OPTION)
				{
					File file=jfc.getSelectedFile();
					try {
						Scanner sc= new Scanner(file);
						String str;
						while(sc.hasNext())
						{
							comboBoxFile.addItem(sc.nextLine());
						}
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					System.out.print(jfc.getSelectedFile().getName());
				}
			}
		});
		btnChonFile.setBounds(119, 26, 116, 23);
		btnChonFile.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(btnChonFile);
		
		comboBoxFile = new JComboBox();
		comboBoxFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textSo.setText(comboBoxFile.getSelectedItem().toString());
			}
		});
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
		comboBoxRandom.setModel(new DefaultComboBoxModel(new String[] {"2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13"}));
		comboBoxRandom.setBounds(142, 124, 52, 23);
		contentPane.add(comboBoxRandom);
		
		labelRandom = new JLabel("số");
		labelRandom.setBounds(218, 125, 30, 21);
		labelRandom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(labelRandom);
		
		buttonRandom = new JButton("Random");
		buttonRandom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				len=Integer.parseInt(comboBoxRandom.getSelectedItem().toString());
				String strmang="";
				Random rd= new Random();
				for(int i=0;i<len;i++)
				{
					strmang+=(rd.nextInt(50-1+1)+1)+" ";
				}
				textRandom.setText(strmang);
			}
		});
		buttonRandom.setBounds(268, 124, 116, 23);
		buttonRandom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(buttonRandom);
		
		labelRandom1 = new JLabel("Dãy số được Random");
		labelRandom1.setBounds(84, 160, 157, 21);
		labelRandom1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(labelRandom1);
		
		textRandom = new JTextField();
		textRandom.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textRandom.setBounds(268, 158, 251, 29);
		textRandom.setColumns(10);
		contentPane.add(textRandom);
		
		panelThuatToan = new JPanel();
		panelThuatToan.setBounds(545, 11, 320, 177);
		panelThuatToan.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Ch\u1ECDn Thu\u1EADt To\u00E1n", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panelThuatToan.setToolTipText("");
		contentPane.add(panelThuatToan);
		panelThuatToan.setLayout(null);
		
		radiobuttonIS = new JRadioButton("Interchange Sort");
		radiobuttonIS.setFont(new Font("Tahoma", Font.PLAIN, 15));
		radiobuttonIS.setBounds(6, 19, 135, 23);
		panelThuatToan.add(radiobuttonIS);
		
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
		buttonGroup2.add(radiobuttonIS);
		buttonGroup2.add(radioButton1);
		buttonGroup2.add(radioButton2);
		buttonGroup2.add(radioButton3);
		buttonGroup2.add(radioButton4);
		buttonGroup2.add(radioButton5);
		buttonGroup2.add(radioButton6);
		buttonGroup2.add(radioButton7);
		
		textArea = new JTextArea();
		textArea.setBounds(875, 39, 475, 327);
		contentPane.add(textArea);
		
		labelCode = new JLabel("Code thực thi thuật toán");
		labelCode.setBounds(1042, 6, 172, 21);
		labelCode.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(labelCode);
		
		buttonTaoNut = new JButton("Tạo Nút");
		buttonTaoNut.setBounds(142, 197, 116, 23);
		buttonTaoNut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!radioButtonNhap.isSelected()&&!radioButtonRandom.isSelected())
				{
					JOptionPane.showMessageDialog(rootPane, "Chọn đầu vào hợp lệ", "Warning",JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					if(arr!=null)
						JOptionPane.showMessageDialog(rootPane, "Mảng số đã được tạo", "Warning",JOptionPane.WARNING_MESSAGE);
					else
					{
					if(radioButtonNhap.isSelected()) 
						xuLyChuoi(textSo.getText());
					else
					{
						if(radioButtonRandom.isSelected())
							xuLyChuoi(textRandom.getText());
					}
					}
				}
			}
		});
		buttonTaoNut.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(buttonTaoNut);
		
		buttonTiepTuc = new JButton("Tiếp Tục");
		buttonTiepTuc.setBounds(27, 277, 116, 23);
		buttonTiepTuc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		buttonTiepTuc.setVisible(false);
		contentPane.add(buttonTiepTuc);
		
		buttonTaoLai = new JButton("Tạo Lại");
		buttonTaoLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				arr=null;
				for(JButton b:listbut)
				{
					contentPane.remove(b);
				}
				for(JLabel l:labelindex)
				{
					contentPane.remove(l);
				}
				textRandom.setText(null);
				textSo.setText(null);
				repaint();
			}
		});
		buttonTaoLai.setBounds(231, 277, 116, 23);
		buttonTaoLai.setFont(new Font("Tahoma", Font.PLAIN, 15));
		buttonTaoLai.setVisible(false);
		contentPane.add(buttonTaoLai);
		
		buttonStart = new JButton("Bắt Đầu");
		buttonStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radiobuttonIS.isSelected())
				{
					
				}
			}
		});
		buttonStart.setBounds(27, 239, 116, 23);
		buttonStart.setFont(new Font("Tahoma", Font.PLAIN, 15));
		buttonStart.setVisible(false);
		contentPane.add(buttonStart);
		
		textArea_1 = new JTextArea();
		textArea_1.setBounds(431, 264, 434, 102);
		contentPane.add(textArea_1);
		
		buttonStop = new JButton("Dừng Lại");
		buttonStop.setFont(new Font("Tahoma", Font.PLAIN, 15));
		buttonStop.setBounds(231, 239, 116, 23);
		buttonStop.setVisible(false);
		contentPane.add(buttonStop);
		
		panelChieuSapXep = new JPanel();
		panelChieuSapXep.setBorder(new TitledBorder(null, "S\u1EAFp x\u1EBFp theo", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panelChieuSapXep.setBounds(545, 190, 320, 70);
		contentPane.add(panelChieuSapXep);
		panelChieuSapXep.setLayout(null);
		
		radiobuttonGiamDan = new JRadioButton("Giảm Dần");
		radiobuttonGiamDan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		radiobuttonGiamDan.setBounds(161, 27, 135, 23);
		panelChieuSapXep.add(radiobuttonGiamDan);
		
		radiobuttonTangDan = new JRadioButton("Tăng Dần");
		radiobuttonTangDan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		radiobuttonTangDan.setBounds(6, 29, 135, 23);
		panelChieuSapXep.add(radiobuttonTangDan);
		
		buttonGroup3= new ButtonGroup();
		buttonGroup3.add(radiobuttonTangDan);
		buttonGroup3.add(radiobuttonGiamDan);
		
		
	}
	public void addstepRS(int a, int b , int c, int d , int e, int[] x)
    {
        list.add(new Step(a, b, c, d, e, -1, -1, -1, x));
    }
	public void xuLyChuoi(String s)
	{
		contentPane.setLayout(null);
		try {
		while(s.contains("  "))
			s=s.replace("  ", " ");
		String[]cat =s.split(" ");
		len=cat.length;
		if(len<=1)
			JOptionPane.showMessageDialog(rootPane, "Nhập 2 số trở lên", "Warning", JOptionPane.WARNING_MESSAGE);
		else
		{
			if(len>13)
				JOptionPane.showMessageDialog(rootPane, "Nhập 13 số trở xuống", "Warning", JOptionPane.WARNING_MESSAGE);
			else
			{
				buttonTaoLai.setVisible(true);
				buttonStart.setVisible(true);
				arr=new int[len];
				pos=new int[len];
				labelindex=new JLabel[len];
				listbut= new JButton[len];
				for(int i=0;i<len;i++)
				{
					arr[i]=	Integer.parseInt(cat[i]);
					labelindex[i]= new JLabel(String.valueOf(i));
					labelindex[i].setBounds(100*i+76,520,30,30);
					labelindex[i].setFont(new Font("Tahoma", Font.PLAIN, 12));
					listbut[i]= new JButton(cat[i]);
					listbut[i].setBounds(100*i + 50, 460, 60, 60);
					listbut[i].setFont(new Font("Tahoma", Font.PLAIN, 15));;
					contentPane.add(labelindex[i]);
					contentPane.add(listbut[i]);
				}
				repaint();								
			}
		}
		}catch(Exception e)
		{
	//		JOptionPane.showMessageDialog(rootPane, "Kiểm tra lại đầu vào", "Warning", JOptionPane.WARNING_MESSAGE);
			e.printStackTrace();
		}
	}
	class Step{
		public int index1, index2, Xleft, Xright, check, para1, para2, para3;
        public int[] arr;
        public Step()
        {

        }
        public Step(int b , int c, int d , int e , int Check , int p1 , int p2 , int p3 , int[] ar )
        {
            index1 = b;
            index2 = c;
            Xleft = d;
            Xright = e;
            check = Check;
            para1 = p1;
            para2 = p2;
            para3 = p3;
            arr = ar;
        }
        public String str()
        {
            return index1 + " " + index2 + " " + Xleft + " " + Xright + " " + check + " " + para1 + " " + para2 + " " + para3;
        }
	}
}
