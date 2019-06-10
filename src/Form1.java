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
import java.awt.Cursor;
import java.awt.Desktop;

import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
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
import javax.swing.JScrollPane;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class Form1 extends JFrame {
	private JPanel contentPane,panelThuatToan,panelChieuSapXep;
	private JMenuBar menuBar;
	private JMenu menuCaiDat,menuGioiThieu;
	private JRadioButton radioButtonNhap,radioButtonRandom,radiobuttonIS,radiobuttonQS,radiobuttonSS,radiobuttonShS,radiobuttonBS,radiobuttonRdS,radiobuttonInsS,radiobuttonBiSrch,radiobuttonGiamDan,radiobuttonTangDan;
	private ButtonGroup buttonGroup1,buttonGroup2,buttonGroup3;
	private JButton btnChonFile,buttonRandom,buttonTaoNut,buttonTiepTuc,buttonTaoLai,buttonStart,listbut[],buttonnumsrch;
	private JComboBox comboBoxFile,comboBoxRandom;
	private JLabel labelNhapSo,labelRandom,labelRandom1,labelCode,labelindex[],labelindex1[],labelindex2[],labeli,labelk,labelj,labelLink,labelmin,labelpos,labelArrowR,labelx,labelArrowL,labelleft,labelright,labeldonvi,labelmid;
	private JTextField textSo,textRandom;
	private int arr[],len,xpos[],tang_giam,numsrch;
	private Timer timer;
	private JButton buttonStop;
	private Color color=Color.white;
	private List<Step> list= new ArrayList<Step>();
	private int start = 0, green = 0, yellow = 0,indexstep=0,y1=460,y2=380,speed=5,start_khoi_tao=0,orange=0,purple=0,temp1=0;
	private JList<String> thuattoan;
	private JScrollPane scrollPane;
	private DefaultListModel<String> model= new DefaultListModel<>();
	private JLabel labelpivot;
	private JLabel labellow;
	private JLabel labelhigh;
	private ActionListener a;
	private JRadioButton radiobuttonLiSrch;
	private JTextArea textareayTuong;
	private JLabel labelyTuong;
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
			a=new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				AbstractButton ab= (AbstractButton)arg0.getSource();
				if(ab.getText().equals("Nhanh"))
				{
					speed=10;
				}
				if(ab.getText().equals("Chậm"))
				{
					speed=5;
				}
				if(ab.getText().equals("Vừa"))
				{
					speed=2;
				}
				
			}
		};							
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
		
		JMenu mnChnhTc = new JMenu("Chỉnh tốc độ mô phỏng");
		menuCaiDat.add(mnChnhTc);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Vừa");
		rdbtnNewRadioButton_2.setSelected(true);
		rdbtnNewRadioButton_2.addActionListener(a);
		mnChnhTc.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Nhanh");
		rdbtnNewRadioButton.addActionListener(a);
		mnChnhTc.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Chậm");
		rdbtnNewRadioButton_1.addActionListener(a);
		mnChnhTc.add(rdbtnNewRadioButton_1);
		
		ButtonGroup grTocdo= new ButtonGroup();
		grTocdo.add(rdbtnNewRadioButton_1);
		grTocdo.add(rdbtnNewRadioButton);
		grTocdo.add(rdbtnNewRadioButton_2);
		
		menuGioiThieu = new JMenu("Giới Thiệu");
		menuBar.add(menuGioiThieu);
		
		JMenuItem mntmAboutUs = new JMenuItem("About Us");
		menuGioiThieu.add(mntmAboutUs);
		
		JMenuItem mntmHngDnS = new JMenuItem("Hướng dẫn sử dụng");
		menuGioiThieu.add(mntmHngDnS);
		mntmHngDnS.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(contentPane, "Chọn dãy số đầu vào > Chọn thuật toán > Chọn chiều sắp xếp(nếu có) > Tạo nút > Bắt Đầu\r\nCác tùy chọn khác: Dừng Lại,Tiếp Tục,Tạo Mới\r\n                                     Cài Đặt>Chọn Màu Nút", "Hướng dẫn sử dụng", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		radioButtonNhap = new JRadioButton("Nhập");
		radioButtonNhap.setBounds(33, 26, 63, 23);
		radioButtonNhap.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(radioButtonNhap);
		
		radioButtonRandom = new JRadioButton("Random");
		radioButtonRandom.setSelected(true);
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
		textRandom.setEditable(false);
		textRandom.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textRandom.setBounds(268, 158, 251, 29);
		textRandom.setColumns(10);
		contentPane.add(textRandom);
		
		panelThuatToan = new JPanel();
		panelThuatToan.setBounds(545, 11, 320, 223);
		panelThuatToan.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Ch\u1ECDn Thu\u1EADt To\u00E1n", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panelThuatToan.setToolTipText("");
		contentPane.add(panelThuatToan);
		panelThuatToan.setLayout(null);
		
		radiobuttonIS = new JRadioButton("Interchange Sort");
		radiobuttonIS.setSelected(true);
		radiobuttonIS.setFont(new Font("Tahoma", Font.PLAIN, 15));
		radiobuttonIS.setBounds(6, 19, 135, 23);
		radiobuttonIS.addActionListener(a);
		panelThuatToan.add(radiobuttonIS);
		
		radiobuttonQS = new JRadioButton("Quick Sort");
		radiobuttonQS.setFont(new Font("Tahoma", Font.PLAIN, 15));
		radiobuttonQS.setBounds(161, 19, 135, 23);
		radiobuttonQS.addActionListener(a);
		panelThuatToan.add(radiobuttonQS);
		
		radiobuttonSS = new JRadioButton("Selection Sort");
		radiobuttonSS.setFont(new Font("Tahoma", Font.PLAIN, 15));
		radiobuttonSS.setBounds(6, 62, 135, 23);
		radiobuttonSS.addActionListener(a);
		panelThuatToan.add(radiobuttonSS);
		
		radiobuttonShS = new JRadioButton("Shaker Sort");
		radiobuttonShS.setFont(new Font("Tahoma", Font.PLAIN, 15));
		radiobuttonShS.setBounds(161, 62, 135, 23);
		radiobuttonShS.addActionListener(a);
		panelThuatToan.add(radiobuttonShS);
		
		radiobuttonBS = new JRadioButton("Bubble Sort");
		radiobuttonBS.setFont(new Font("Tahoma", Font.PLAIN, 15));
		radiobuttonBS.setBounds(6, 107, 135, 23);
		radiobuttonBS.addActionListener(a);
		panelThuatToan.add(radiobuttonBS);
		
		radiobuttonRdS = new JRadioButton("Radix Sort");
		radiobuttonRdS.setFont(new Font("Tahoma", Font.PLAIN, 15));
		radiobuttonRdS.setBounds(161, 107, 135, 23);
		radiobuttonRdS.addActionListener(a);
		panelThuatToan.add(radiobuttonRdS);
		
		radiobuttonInsS = new JRadioButton("Insertion Sort");
		radiobuttonInsS.setFont(new Font("Tahoma", Font.PLAIN, 15));
		radiobuttonInsS.setBounds(6, 147, 135, 23);
		radiobuttonInsS.addActionListener(a);
		panelThuatToan.add(radiobuttonInsS);
		
		radiobuttonBiSrch = new JRadioButton("Binary Search");
		radiobuttonBiSrch.setFont(new Font("Tahoma", Font.PLAIN, 15));
		radiobuttonBiSrch.setBounds(161, 147, 135, 23);
		radiobuttonBiSrch.addActionListener(a);
		panelThuatToan.add(radiobuttonBiSrch);
		
		radiobuttonLiSrch = new JRadioButton("Linear Search");
		radiobuttonLiSrch.setFont(new Font("Tahoma", Font.PLAIN, 15));
		radiobuttonLiSrch.setBounds(6, 187, 135, 23);
		radiobuttonLiSrch.addActionListener(a);
		panelThuatToan.add(radiobuttonLiSrch);
		
		buttonGroup2= new ButtonGroup();
		buttonGroup2.add(radiobuttonIS);
		buttonGroup2.add(radiobuttonQS);
		buttonGroup2.add(radiobuttonSS);
		buttonGroup2.add(radiobuttonShS);
		buttonGroup2.add(radiobuttonBS);
		buttonGroup2.add(radiobuttonRdS);
		buttonGroup2.add(radiobuttonInsS);
		buttonGroup2.add(radiobuttonBiSrch);
		buttonGroup2.add(radiobuttonLiSrch);
		
		
				
		
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
		buttonTiepTuc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonTiepTuc.setVisible(false);
				buttonStop.setVisible(true);
				timer.start();
			}
		});
		buttonTiepTuc.setBounds(27, 277, 116, 23);
		buttonTiepTuc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		buttonTiepTuc.setVisible(false);
		contentPane.add(buttonTiepTuc);
		
		
		
		buttonStart = new JButton("Bắt Đầu");
		buttonStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radiobuttonIS.isSelected())
				{
					if(radiobuttonTangDan.isSelected())
					{
						tang_giam=1;
						CodeIS(tang_giam);
						for (int i = 0; i < arr.length - 1; i++)
                        {
                            for (int j = i + 1; j < arr.length; j++)
                            {
                                if (arr[i] > arr[j])
                                {
                                	list.add(new Step(i, j, listbut[i].getLocation().x, listbut[j].getLocation().x, 1,-1,-1,-1,null));
                                    int temp = arr[i];
                                    arr[i] = arr[j];
                                    arr[j] = temp;
                                }
                                else
                                	list.add(new Step(i, j, listbut[i].getLocation().x, listbut[j].getLocation().x, 0,-1,-1,-1,null));
                            }
                        }
					}
					else
					{
						tang_giam=0;
						CodeIS(tang_giam);
						for (int i = 0; i < arr.length - 1; i++)
                        {
                            for (int j = i + 1; j < arr.length; j++)
                            {
                                if (arr[i] < arr[j])
                                {
                                	list.add(new Step(i, j, listbut[i].getLocation().x, listbut[j].getLocation().x, 1,-1,-1,-1,null));
                                    int temp = arr[i];
                                    arr[i] = arr[j];
                                    arr[j] = temp;
                                }
                                else
                                	list.add(new Step(i, j, listbut[i].getLocation().x, listbut[j].getLocation().x, 0,-1,-1,-1,null));
                            }
                        }
					}
					labelLink.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						try {
					         
					        Desktop.getDesktop().browse(new URI("http://cunglaptrinh.blogspot.com/2015/03/thuat-toan-sap-xep-interchange-sort.html"));
					         
					    } catch (IOException | URISyntaxException e1) {
					        e1.printStackTrace();
					    }
					}
					});
					labelLink.setText(labelLink.getText()+"Interchange Sort");
					labelLink.setVisible(true);
					textareayTuong.setText("Sắp xếp từng vị trí của mảng từ trái qua phải, sao cho \r\nvị trí đang xét có giá trị nhỏ nhất(lớn nhất) so với các \r\nsố đứng sau nó");
					buttonStart.setVisible(false);
					buttonStop.setVisible(true);
					thuattoan=new JList<>(model);
					thuattoan.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					thuattoan.setFont(new Font("Monospaced",Font.BOLD,14));
					scrollPane.setViewportView(thuattoan);
					timer= new Timer(10,new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							if(start<50)
							{
								if(start<30)
								{
									thuattoan.setSelectedIndex(0);
								}
								else
								{
								thuattoan.setSelectedIndex(1);
								}
								start++;
							}
							else
							{
								if(indexstep<list.size())
								{
									thuattoan.setSelectedIndex(2);
									labeli.setLocation(xpos[list.get(indexstep).index1]+27,550);
									labelj.setLocation(xpos[list.get(indexstep).index2]+27,550);
									labeli.setVisible(true);
									labelj.setVisible(true);
									listbut[list.get(indexstep).index1].setBackground(Color.yellow); 
				                    listbut[list.get(indexstep).index2].setBackground(Color.yellow);
				                    if(yellow<70)
				                    	yellow++;
				                    else
				                    {
				                    	
				                    	if(list.get(indexstep).check==0)
				                    	{
				                    		listbut[list.get(indexstep).index1].setBackground(Color.green); 
				                    		listbut[list.get(indexstep).index2].setBackground(Color.green); 
				                    		if(green<70)
				                    			green++;
				                    		else
				                    		{
				                    			start=green=yellow=0;
				                    			listbut[list.get(indexstep).index1].setBackground(color); 
					                    		listbut[list.get(indexstep).index2].setBackground(color);
					                    		indexstep++;
				                    		}
				                    	}
				                    	else
				                    	{
				                    		thuattoan.setSelectedIndex(3);
				                    		listbut[list.get(indexstep).index1].setBackground(Color.red); 
				                    		listbut[list.get(indexstep).index2].setBackground(Color.red);
				                    		if(y1>380)
				                    		{
				                    			y1-=speed;
				                    			listbut[list.get(indexstep).index1].setLocation(new Point(listbut[list.get(indexstep).index1].getLocation().x,listbut[list.get(indexstep).index1].getLocation().y-speed));
				                    			listbut[list.get(indexstep).index2].setLocation(new Point(listbut[list.get(indexstep).index2].getLocation().x,listbut[list.get(indexstep).index2].getLocation().y+speed));				           
				                    		}
				                    		else
				                    		{
				                    			if(list.get(indexstep).Xleft<list.get(indexstep).Xright)
				                    			{
				                    				list.get(indexstep).Xleft+=speed;
				                    				listbut[list.get(indexstep).index1].setLocation(new Point(listbut[list.get(indexstep).index1].getLocation().x+speed,listbut[list.get(indexstep).index1].getLocation().y));
					                    			listbut[list.get(indexstep).index2].setLocation(new Point(listbut[list.get(indexstep).index2].getLocation().x-speed,listbut[list.get(indexstep).index2].getLocation().y));
				                    			}
				                    			else
				                    			{
				                    				if(y2<460)
				                    				{
				                    					y2+=speed;
				                    					listbut[list.get(indexstep).index1].setLocation(new Point(listbut[list.get(indexstep).index1].getLocation().x,listbut[list.get(indexstep).index1].getLocation().y+speed));
						                    			listbut[list.get(indexstep).index2].setLocation(new Point(listbut[list.get(indexstep).index2].getLocation().x,listbut[list.get(indexstep).index2].getLocation().y-speed));
				                    				}
				                    				else
				                    				{
				                    					JButton A=listbut[list.get(indexstep).index1];
				                    					listbut[list.get(indexstep).index1]=listbut[list.get(indexstep).index2];
				                    					listbut[list.get(indexstep).index2]=A;
				                    					listbut[list.get(indexstep).index1].setBackground(color); 
							                    		listbut[list.get(indexstep).index2].setBackground(color);
				                    					indexstep++;
				                    					y1=460;
				                    					y2=380;
				                    					start=yellow=0;
				                    				}
				                    			}
				                    		}
				                    	}
				                    }
								}
								else
								{
									buttonStop.setVisible(false);
				                    buttonTiepTuc.setVisible(false);
									indexstep=0;
									start=yellow=0;
									labeli.setVisible(false);
									labelj.setVisible(false);
									//thuattoan.setSelectedIndex(arg0);
									JOptionPane.showMessageDialog(rootPane, "Mảng đã sắp xếp xong", "", JOptionPane.INFORMATION_MESSAGE);
									timer.stop();
								}
							}
						}
						
					});
					timer.start();
				}
				if(radiobuttonSS.isSelected())
				{
					int min;
					if(radiobuttonTangDan.isSelected())
					{
						tang_giam=1;
						CodeSS(tang_giam);
						for (int i = 0; i < arr.length - 1; i++)
                        {
                            min = i;
                            for (int j = i + 1; j < arr.length; j++)
                            {
                                if (arr[j] < arr[min])
                                {
                                    list.add(new Step(i, j, listbut[i].getLocation().x, listbut[min].getLocation().x, 1, min, 0, listbut[j].getLocation().x,null));
                                    min = j;
                                }
                                else
                                {
                                    list.add(new Step(i, j, listbut[i].getLocation().x, listbut[min].getLocation().x, 0, min, 0, listbut[j].getLocation().x,null));
                                }
                            }
                            if (min != i)
                            {
                                list.add(new Step(i, -1, listbut[i].getLocation().x, listbut[min].getLocation().x, 1, min, 1,-1,null));
                                int temp = arr[min];
                                arr[min] = arr[i];
                                arr[i] = temp;
                            }
                            else
                            {
                                list.add(new Step(i, -1, -1, -1, 0, min, 1,-1,null));
                            }
                        }
					}
					else
					{
						tang_giam=0;
						CodeSS(tang_giam);
						for (int i = 0; i < arr.length - 1; i++)
                        {
                            min = i;
                            for (int j = i + 1; j < arr.length; j++)
                            {
                                if (arr[j] > arr[min])
                                {
                                    list.add(new Step(i, j, listbut[i].getLocation().x, listbut[min].getLocation().x, 1, min, 0, listbut[j].getLocation().x,null));
                                    min = j;
                                }
                                else
                                {
                                    list.add(new Step(i, j, listbut[i].getLocation().x, listbut[min].getLocation().x, 0, min, 0, listbut[j].getLocation().x,null));
                                }
                            }
                            if (min != i)
                            {
                                list.add(new Step(i, -1, listbut[i].getLocation().x, listbut[min].getLocation().x, 1, min, 1,-1,null));
                                int temp = arr[min];
                                arr[min] = arr[i];
                                arr[i] = temp;
                            }
                            else
                            {
                                list.add(new Step(i, -1, -1, -1, 0, min, 1,-1,null));
                            }
                        }
					}
					labelLink.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent arg0) {
							try {
						         
						        Desktop.getDesktop().browse(new URI("https://www.geeksforgeeks.org/selection-sort/"));
						         
						    } catch (IOException | URISyntaxException e1) {
						        e1.printStackTrace();
						    }
						}
						});
					labelLink.setText(labelLink.getText()+"Selection Sort");
					labelLink.setVisible(true);
					textareayTuong.setText("Ý tưởng như Interchange Sort, nhưng chỉ đổi chổ 1 lần ở \r\ntừng vòng lặp i dựa trên chỉ số min phụ");
					buttonStart.setVisible(false);
					buttonStop.setVisible(true);
					thuattoan=new JList<>(model);
					thuattoan.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					thuattoan.setSelectedIndex(0);
					thuattoan.setFont(new Font("Monospaced",Font.BOLD,14));
					scrollPane.setViewportView(thuattoan);
					timer=new Timer(10, new ActionListener() {
				
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							if (start_khoi_tao < 30)
							{
								thuattoan.setSelectedIndex(0);
				                start_khoi_tao++;
				            }
							else
				            {
				                if (start < 30)
				                {
				                	thuattoan.setSelectedIndex(2);
				                    start++;
				                }
				                else
				                {
				                    if (indexstep < list.size())
				                    {				                    	
				                        labeli.setLocation(xpos[list.get(indexstep).index1] + 27, 550);
				                        labeli.setVisible(true);
				                        if (list.get(indexstep).para2 == 0)
				                        {
				                        	
				                        	thuattoan.setSelectedIndex(4);
				                        	
				                        	labelj.setLocation(xpos[list.get(indexstep).index2] + 27, 580);
				                        	labelmin.setLocation(xpos[list.get(indexstep).para1] + 15, 580);
				                        	labelj.setVisible(true);
				                        	labelmin.setVisible(true);
				                            listbut[list.get(indexstep).para1].setBackground(Color.yellow);
				                            listbut[list.get(indexstep).index2].setBackground(Color.yellow);
				                            if (yellow < 55)
				                            {
				                                yellow++;
				                            }
				                            else
				                            {
				                            	
				                                if (list.get(indexstep).check == 0)
				                                {				                                	
				                                    listbut[list.get(indexstep).para1].setBackground(Color.green);
				                                    listbut[list.get(indexstep).index2].setBackground(Color.green);
				                                    if (green < 55)
				                                    {			                          
				                                        green++;
				                                    }
				                                    else
				                                    {
				                                        green = 0;
				                                        yellow = 0;
				                                        start = 0;
				                                        listbut[list.get(indexstep).para1].setBackground(color);
				                                        listbut[list.get(indexstep).index2].setBackground(color);
				                                        //labelj.setVisible(false);
				                                        indexstep++;
				                                        start=start_khoi_tao=0;
				                                    }
				                                }
				                                else
				                                {
				                                	thuattoan.setSelectedIndex(5);
				                                    listbut[list.get(indexstep).para1].setBackground(Color.orange);
				                                    listbut[list.get(indexstep).index2].setBackground(Color.orange);
				                                    if (orange < 55)
				                                    {				                                        
				                                        orange++;
				                                    }
				                                    else
				                                    {
				                                        orange = 0;
				                                        yellow = 0;
				                                        start = 0;
				                                       // labelj.setVisible(false);
				                                        listbut[list.get(indexstep).para1].setBackground(color);
				                                        listbut[list.get(indexstep).index2].setBackground(color);
				                                        indexstep++;
				                                        start=start_khoi_tao=0;
				                                    }
				                                }
				                            }
				                        }
				                        else
				                        {
				                            labelmin.setLocation(xpos[list.get(indexstep).para1] + 15, 580); 
				                            listbut[list.get(indexstep).para1].setBackground(Color.yellow);
				                            listbut[list.get(indexstep).index1].setBackground(Color.yellow);
				                            if (yellow < 55)
				                            {
				                                yellow++;
				                            }
				                            else
				                            {
				                                if (list.get(indexstep).check == 1)
				                                {				            
				                                    listbut[list.get(indexstep).index1].setBackground(Color.red);
				                                    listbut[list.get(indexstep).para1].setBackground(Color.red);
				                                    if (y1 > 380)
				                                    {
				                                        y1 -= speed;
				                                        listbut[list.get(indexstep).index1].setLocation(listbut[list.get(indexstep).index1].getLocation().x, listbut[list.get(indexstep).index1].getLocation().y - speed);
				                                        listbut[list.get(indexstep).para1].setLocation(listbut[list.get(indexstep).para1].getLocation().x, listbut[list.get(indexstep).para1].getLocation().y + speed);
				                                    }
				                                    else
				                                    {
				                                        if (list.get(indexstep).Xleft < list.get(indexstep).Xright)
				                                        {
				                                            list.get(indexstep).Xleft += speed;
				                                            listbut[list.get(indexstep).index1].setLocation(listbut[list.get(indexstep).index1].getLocation().x + speed, listbut[list.get(indexstep).index1].getLocation().y);
				                                            listbut[list.get(indexstep).para1].setLocation(listbut[list.get(indexstep).para1].getLocation().x - speed, listbut[list.get(indexstep).para1].getLocation().y);
				                                        }
				                                        else
				                                        {
				                                            if (y2 < 460)
				                                            {
				                                                y2 += speed;
				                                                listbut[list.get(indexstep).index1].setLocation(listbut[list.get(indexstep).index1].getLocation().x, listbut[list.get(indexstep).index1].getLocation().y + speed);
				                                                listbut[list.get(indexstep).para1].setLocation(listbut[list.get(indexstep).para1].getLocation().x, listbut[list.get(indexstep).para1].getLocation().y - speed);
				                                            }
				                                            else
				                                            {
				                                                JButton A = listbut[list.get(indexstep).index1];
				                                                listbut[list.get(indexstep).index1] = listbut[list.get(indexstep).para1];
				                                                listbut[list.get(indexstep).para1] = A;
				                                                listbut[list.get(indexstep).index1].setBackground(color);
				                                                listbut[list.get(indexstep).para1].setBackground(color);
				                                                indexstep++;
				                                                y1 = 460; y2 = 380;
				                                                start =start_khoi_tao= 0;
				                                                yellow = 0;
				                                            }
				                                        }
				                                    }
				                                }
				                                else
				                                {
				                                    listbut[list.get(indexstep).index1].setBackground(Color.green);
				                                    listbut[list.get(indexstep).para1].setBackground(Color.green);
				                                    if (green < 55)
				                                    {
				                                        green++;
				                                    }
				                                    else
				                                    {
				                                        green = 0;
				                                        start = 0;
				                                        yellow = 0;
				                                        listbut[list.get(indexstep).index1].setBackground(color);
				                                        listbut[list.get(indexstep).para2].setBackground(color);
				                                        indexstep++;
				                                        start =start_khoi_tao= 0;
				                                    }
				                                }
				                            }
				                        }
				                    }
				                    else
				                    {
				                    	buttonStop.setVisible(false);
					                    buttonTiepTuc.setVisible(false);
				                    	indexstep=0;
										start=start_khoi_tao=yellow=0;
										labeli.setVisible(false);
										labelj.setVisible(false);
										labelmin.setVisible(false);
										JOptionPane.showMessageDialog(rootPane, "Mảng đã sắp xếp xong", "", JOptionPane.INFORMATION_MESSAGE);
										timer.stop();
				                       
				                    }
				                }
				            }
						}
					});
					timer.start();
				}
				if(radiobuttonBS.isSelected())
				{
					if(radiobuttonTangDan.isSelected())
					{
						tang_giam=1;
						CodeBS(tang_giam);
						for (int i = 0; i < arr.length - 1; i++)
                        {
                            for (int j = arr.length - 1; j > i; j--)
                            {
                                if (arr[j] < arr[j - 1])
                                {
                                    list.add(new Step(i, j - 1, j, 1, listbut[j - 1].getLocation().x, listbut[j].getLocation().x,-1,-1,null));
                                    int temp = arr[j];
                                    arr[j] = arr[j - 1];
                                    arr[j - 1] = temp;
                                }
                                else
                                {
                                    list.add(new Step(i, j - 1, j, 0,-1,-1,-1,-1,null));
                                }
                            }
                        }
					}
					else
					{
						tang_giam=0;
						CodeBS(tang_giam);
						for (int i = 0; i < arr.length - 1; i++)
                        {
                            for (int j = arr.length - 1; j > i; j--)
                            {
                                if (arr[j] > arr[j - 1])
                                {
                                    list.add(new Step(i, j - 1, j, 1, listbut[j - 1].getLocation().x, listbut[j].getLocation().x,-1,-1,null));
                                    int temp = arr[j];
                                    arr[j] = arr[j - 1];
                                    arr[j - 1] = temp;
                                }	
                                else
                                {
                                    list.add(new Step(i, j - 1, j, 0,-1,-1,-1,-1,null));
                                }
                            }
                        }
					}
					labelLink.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent arg0) {
							try {
						         
						        Desktop.getDesktop().browse(new URI("https://www.geeksforgeeks.org/bubble-sort/"));
						         
						    } catch (IOException | URISyntaxException e1) {
						        e1.printStackTrace();
						    }
						}
						});
					labelLink.setText(labelLink.getText()+"Bubble Sort");
					labelLink.setVisible(true);
					textareayTuong.setText("Ý tưởng như Interchange Sort, nhưng chiều đi ngược lại");
					buttonStart.setVisible(false);
					buttonStop.setVisible(true);
					thuattoan=new JList<>(model);
					thuattoan.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					thuattoan.setFont(new Font("Monospaced",Font.BOLD,14));
					scrollPane.setViewportView(thuattoan);
					timer= new Timer(10, new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							if (start_khoi_tao < 40)
				            {
				                start_khoi_tao++;
				               // thuattoan.setSelectedIndex(0);
				            }
				            else
				            {
				                if (start < 38)
				                {
				                    start++;
				               //     thuattoan.setSelectedIndex(1);
				                }
				                else
				                {
				                    if (indexstep < list.size())
				                    {
				                    	labeli.setLocation(xpos[list.get(indexstep).index1] + 27, 550);
				                        
				                        labeli.setVisible(true);				                          
//				                        if (arr.length - 1 == list.get(indexstep).Xleft)
//				                        {
//				                        	
//				                        }
//				                        else
//				                        {
//
//				                        }
				                        if(list.get(indexstep).Xleft==arr.length-1&&green==0)
				                        {
				                        	thuattoan.setSelectedIndex(0);
				                        }
				                        else
				                        {
				                        	thuattoan.setSelectedIndex(2);
				                        	
				                        }
				                        listbut[list.get(indexstep).index1].setBackground(Color.magenta);
				                        if (purple < 58)
				                        {
				                            purple++;
				                            labelj.setLocation(xpos[list.get(indexstep).Xleft] + 27, 580);
				                            if(purple>29) {
						                    labelj.setVisible(true);
					                        thuattoan.setSelectedIndex(1);
				                            }
				                        }
				                        else
				                        {
				                        	
						                      
				                            listbut[list.get(indexstep).index2].setBackground(Color.yellow);
				                            listbut[list.get(indexstep).Xleft].setBackground(Color.yellow);
				                            if (yellow < 60)
				                            {
				                            	thuattoan.setSelectedIndex(2);
				                                yellow++;
				                            }
				                            else
				                            {
				                                if (list.get(indexstep).Xright == 1)
				                                {
				                                	thuattoan.setSelectedIndex(3);
				                                    listbut[list.get(indexstep).index2].setBackground(Color.red);
				                                    listbut[list.get(indexstep).Xleft].setBackground(Color.red);
				                                    if (y1 > 380)
				                                    {
				                                        y1 -= speed;
				                                        listbut[list.get(indexstep).index2].setLocation(listbut[list.get(indexstep).index2].getLocation().x, listbut[list.get(indexstep).index2].getLocation().y - speed);
				                                        listbut[list.get(indexstep).Xleft].setLocation(listbut[list.get(indexstep).Xleft].getLocation().x, listbut[list.get(indexstep).Xleft].getLocation().y + speed);
				                                    }
				                                    else
				                                    {
				                                        if (list.get(indexstep).check < list.get(indexstep).para1)
				                                        {
				                                            list.get(indexstep).check += speed;
				                                            listbut[list.get(indexstep).index2].setLocation(listbut[list.get(indexstep).index2].getLocation().x + speed, listbut[list.get(indexstep).index2].getLocation().y);
				                                            listbut[list.get(indexstep).Xleft].setLocation(listbut[list.get(indexstep).Xleft].getLocation().x - speed, listbut[list.get(indexstep).Xleft].getLocation().y);
				                                        }
				                                        else
				                                        {
				                                            if (y2 < 460)
				                                            {
				                                                y2 += speed;
				                                                listbut[list.get(indexstep).index2].setLocation(listbut[list.get(indexstep).index2].getLocation().x, listbut[list.get(indexstep).index2].getLocation().y + speed);
				                                                listbut[list.get(indexstep).Xleft].setLocation(listbut[list.get(indexstep).Xleft].getLocation().x, listbut[list.get(indexstep).Xleft].getLocation().y - speed);
				                                            }
				                                            else
				                                            {
				                                                JButton A = listbut[list.get(indexstep).index2];
				                                                listbut[list.get(indexstep).index2] = listbut[list.get(indexstep).Xleft];
				                                                listbut[list.get(indexstep).Xleft] = A;
				                                                listbut[list.get(indexstep).index2].setBackground(color);
				                                                listbut[list.get(indexstep).Xleft].setBackground(color);
				                                                if (list.get(indexstep).index1 == list.get(indexstep).index2)
				                                                {
				                                                    listbut[list.get(indexstep).index1].setBackground(color);
				                                                }
				                                                indexstep++;
				                                                y1 = 460; y2 = 380;
				                                                start = 0;
				                                                yellow = 0;
				                                                purple = 0;
				                                            }
				                                        }
				                                    }
				                                }
				                                else
				                                {
				                                	listbut[list.get(indexstep).index2].setBackground(Color.green);
				                                    listbut[list.get(indexstep).Xleft].setBackground(Color.green);
				                                    if (green < 60)
				                                        green++;
				                                    else
				                                    {
				                                        start = 0;
				                                        yellow = 0;
				                                        green = 0;
				                                        purple = 0;
				                                        listbut[list.get(indexstep).index2].setBackground(color);
				                                        listbut[list.get(indexstep).Xleft].setBackground(color);
				                                        if (list.get(indexstep).index1 == list.get(indexstep).index2)
				                                        {
				                                            listbut[list.get(indexstep).index1].setBackground(color);
				                                        }
				                                        indexstep++;
				                                    }
				                                }
				                            }
				                        }
				                    }
				                    else
				                    {
				                    	indexstep=0;
										start=yellow=purple=green=orange=start_khoi_tao=0;				                  
				                        labeli.setVisible(false);
				                        labelj.setVisible(false);
				                        buttonStop.setVisible(false);
				                        buttonTiepTuc.setVisible(false);
										JOptionPane.showMessageDialog(rootPane, "Mảng đã sắp xếp xong", "", JOptionPane.INFORMATION_MESSAGE);
				                        timer.stop();
				                    }
				                }
				            }
						}
					});
					timer.start();
				}
				if(radiobuttonInsS.isSelected())
				{
					if(radiobuttonTangDan.isSelected())
					{
						tang_giam=1;
						CodeInS(tang_giam);
						for (int i = 1; i < arr.length; i++)
                        {
                            int x = arr[i];
                            int pos = i - 1;
                            list.add(new Step(i,-1,-1,-1,0,1,-1,-1,null));
                         //   list.add(new Step(i, x, pos, 2,-1,-1,-1,-1,null));
                            while ((pos >= 0) && (arr[pos] > x))
                            {
                                list.add(new Step(pos,pos+1,listbut[pos].getLocation().x,listbut[pos+1].getLocation().x,2,1,-1,-1,null));
                                arr[pos + 1] = arr[pos];
                                pos--;
                            }                           
                            list.add(new Step(i,pos+1,listbut[i].getLocation().x,listbut[pos+1].getLocation().x,1,1,-1,-1,null));                     
                         //   list.add(new Step(i, x, pos + 1, 0,-1,-1,-1,-1,null));
                            arr[pos + 1] = x;
                        }
					}
					else
					{
						tang_giam=0;
						CodeInS(tang_giam);
						for (int i = 1; i < arr.length; i++)
                        {
							
                            int x = arr[i];
                            int pos = i - 1;
                            list.add(new Step(i,-1,-1,-1,0,0,-1,-1,null));
                          //  list.add(new Step(i, x, pos, 2,-1,-1,-1,-1,null));
                            while ((pos >= 0) && (arr[pos] <	 x))
                            {
                               // list.add(new Step(i, x, pos, 1,-1,-1,-1,-1,null));
                            	list.add(new Step(pos,pos+1,listbut[pos].getLocation().x,listbut[pos+1].getLocation().x,2,0,-1,-1,null));
                                arr[pos + 1] = arr[pos];
                                pos--;
                            }
                        //    list.add(new Step(i, x, pos + 1, 0,-1,-1,-1,-1,null));
                            list.add(new Step(i,pos+1,listbut[i].getLocation().x,listbut[pos+1].getLocation().x,1,0,-1,-1,null));
   
                            arr[pos + 1] = x;
                        }
					}
					labelLink.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent arg0) {
							try {
						         
						        Desktop.getDesktop().browse(new URI("https://www.geeksforgeeks.org/insertion-sort/"));
						         
						    } catch (IOException | URISyntaxException e1) {
						        e1.printStackTrace();
						    }
						}
						});
					labelLink.setText(labelLink.getText()+"Insertion Sort");
					labelLink.setVisible(true);
					textareayTuong.setText("Tìm vị trí thích hợp cho từng phần tử sao cho phần tử \r\ntrước lớn hơn nó và phần tử sau nhỏ hơn hoặc bằng nó, \r\nvà chèn vào vị trí đó");
					buttonStart.setVisible(false);
					buttonStop.setVisible(true);
					thuattoan=new JList<>(model);
					thuattoan.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					thuattoan.setFont(new Font("Monospaced",Font.BOLD,14));
					scrollPane.setViewportView(thuattoan);
					timer=new Timer(10, new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							if(start<48)
							{
								
								start++;
							}
							else
							{
								if(indexstep<list.size())
								{
									if(list.get(indexstep).check==0)
									{
										thuattoan.setSelectedIndex(1);
										labelpos.setText("pos");
										labelpos.setLocation(listbut[list.get(indexstep).index1-1].getLocation().x+14, 544);
										labelpos.setVisible(true);
										labelx.setLocation(listbut[list.get(indexstep).index1].getLocation().x+25, listbut[list.get(indexstep).index1].getLocation().y + 82);
										labelx.setVisible(true);
										listbut[list.get(indexstep).index1].setBackground(Color.orange);
										if(orange<50)
										{
											labeli.setLocation(listbut[list.get(indexstep).index1].getLocation().x+27, 439);
											labeli.setVisible(true);
											orange++;
										}
										else
										{
											thuattoan.setSelectedIndex(2);
										if (y1 > 380)
	                                    {
	                                        y1 -= speed;
	                                        listbut[list.get(indexstep).index1].setLocation(listbut[list.get(indexstep).index1].getLocation().x, listbut[list.get(indexstep).index1].getLocation().y - speed);	                                       
	                                    }
	                                    else
	                                    {
	                                    	labelx.setVisible(false);
	                                    	//listbut[list.get(indexstep).index1].setBackground(color);
	                                    	orange=start=0;
	                                    	y1=460;
	                                        indexstep++;
	                                    }
										}
									}
									else
									{
										if(list.get(indexstep).check==1)
										{
											thuattoan.setSelectedIndex(8);
											if(list.get(indexstep).index1==list.get(indexstep).index2)
											{
												if (y2 < 460)
			                                    {
											//		labelpos.setLocation(listbut[list.get(indexstep).index1-1].getLocation().x+14, 570);
			                                        y2 += speed;
			                                        //labelx.setLocation(listbut[list.get(indexstep).index1].getLocation().x+27, listbut[list.get(indexstep).index1].getLocation().y + 82);
			                                        listbut[list.get(indexstep).index1].setLocation(listbut[list.get(indexstep).index1].getLocation().x, listbut[list.get(indexstep).index1].getLocation().y + speed);	                                       
			                                    }
			                                    else
			                                    {
			                                    	JButton A=listbut[list.get(indexstep).index1];
			                                    	int i=list.get(indexstep).index1;
			                                    	for(;i>list.get(indexstep).index2;i--)
			                                    	{
			                                    		listbut[i]=listbut[i-1];
			                                    	}
			                                    	listbut[i]=A;
			                                    	listbut[i].setBackground(color);
			                                    	start=0;
			                                    	y2=380;
			                                        indexstep++;
			                                    }
											}
											else
											{
												if(list.get(indexstep).Xright<list.get(indexstep).Xleft)
												{
													//labelx.setLocation(listbut[list.get(indexstep).index1-1].getLocation().x+27, listbut[list.get(indexstep).index1].getLocation().y + 82);
													list.get(indexstep).Xright+=speed;
													listbut[list.get(indexstep).index1].setLocation(listbut[list.get(indexstep).index1].getLocation().x-speed, listbut[list.get(indexstep).index1].getLocation().y);	                         
												}
												else
												{///////
													if (y2 < 460)
				                                    {
														//labelx.setLocation(listbut[list.get(indexstep).index1-1].getLocation().x+27, listbut[list.get(indexstep).index1].getLocation().y + 82);
				                                        y2 += speed;
				                                       // labelx.setLocation(listbut[list.get(indexstep).index1].getLocation().x+27, listbut[list.get(indexstep).index1].getLocation().y + 82);
				                                        listbut[list.get(indexstep).index1].setLocation(listbut[list.get(indexstep).index1].getLocation().x, listbut[list.get(indexstep).index1].getLocation().y + speed);	                                       
				                                    }
				                                    else
				                                    {
				                                    	JButton A=listbut[list.get(indexstep).index1];
				                                    	int i=list.get(indexstep).index1;
				                                    	for(;i>list.get(indexstep).index2;i--)
				                                    	{
				                                    		listbut[i]=listbut[i-1];
				                                    	}
				                                    	listbut[i]=A;
				                                    	listbut[i].setBackground(color);
		                                                start=0;
				                                    	y2=380;
				                                        indexstep++;
				                                        
				                                    }
												}
											}
										}
										else
										{
											thuattoan.setSelectedIndex(5);
											if(list.get(indexstep).check==2)
											{
												labelpos.setLocation(list.get(indexstep).Xleft+14, 544);
												if(green <40)
												{
													listbut[list.get(indexstep).index1].setBackground(Color.red);
													green++;
												}
												else
												{
													thuattoan.setSelectedIndex(6);
												listbut[list.get(indexstep).index1].setBackground(color);	
												if (list.get(indexstep).Xleft < list.get(indexstep).Xright)
		                                        {
													
													//labelpos.setText("pos+1");
		                                            list.get(indexstep).Xright -= speed;
		                                            listbut[list.get(indexstep).index1].setLocation(listbut[list.get(indexstep).index1].getLocation().x + speed, listbut[list.get(indexstep).index1].getLocation().y);
		                                        }
												else
												{
													start=0;
													green=0;
	                                                indexstep++;
												}
												}
											}
										}
									}
								}
								else
								{
									green=0;
									labeli.setVisible(false);
									labelpos.setVisible(false);
									indexstep=0;
									start=0;
									buttonStop.setVisible(false);
			                        buttonTiepTuc.setVisible(false);
									JOptionPane.showMessageDialog(rootPane, "Mảng đã sắp xếp xong", "", JOptionPane.INFORMATION_MESSAGE);
									timer.stop();
								}
							}
						}
					});
//					timer=new Timer(10, new ActionListener() {
//						
//						@Override
//						public void actionPerformed(ActionEvent e) {
//							//if(start)
//							// TODO Auto-generated method stub
//							if (start < 40)
//				            {
//				                start++;
//				                thuattoan.setSelectedIndex(0);
//				            }
//				            else
//				            {
//				                if (indexstep < list.size())
//				                {
//				                    if (list.get(indexstep).Xright == 1)
//				                    {
//				                       // richTextBox2.Text = (tang_giam == 1) ? "      while((pos >= 0)&&(a[pos] > x))\n      {\n            a[pos+1] = a[pos];\n            pos--;\n      }" : "      while((pos >= 0)&&(a[pos] < x))\n      {\n            a[pos+1] = a[pos];\n            pos--;\n      }";
//				                        labelpos.setLocation(xpos[list.get(indexstep).Xleft] + 16, 575);
//				                        labelpos.setText("pos");
//				                        listbut[list.get(indexstep).Xleft + 1].setBackground(Color.red);
//				                        listbut[list.get(indexstep).Xleft].setBackground(Color.yellow);
//				                        if (yellow < 60)
//				                            yellow++;
//				                        else
//				                        {
//				                            listbut[list.get(indexstep).Xleft].setBackground(color);
//				                            listbut[list.get(indexstep).Xleft + 1].setText(listbut[list.get(indexstep).Xleft].getText()); 
//				                            listbut[list.get(indexstep).Xleft + 1].setBackground(color);
//				             //               start = 0;
//				                            indexstep++;
//				                            yellow = 0;
//				                        }
//				                    }
//				                    else
//				                    {
//				                        if (list.get(indexstep).Xright == 0)
//				                        {
//				                            labelpos.setText("pos+1");
//				                            labelpos.setLocation(xpos[list.get(indexstep).Xleft] + 6, 575);
//				                            thuattoan.setSelectedIndex(8);
//				                            listbut[list.get(indexstep).Xleft].setBackground(Color.magenta);
//				                            if (purple < 60)
//				                                purple++;
//				                            else
//				                            {
//				                                listbut[list.get(indexstep).Xleft].setText(String.valueOf(list.get(indexstep).index2));
//				                                listbut[list.get(indexstep).Xleft].setBackground(color);
//				                                indexstep++;
//				                                start = 0;
//				                                purple = 0;
//				                            }
//				                        }
//				                        else
//				                        {
//				                            labelpos.setText("pos");
//				                            
//				                            //richTextBox2.Text = "for(int i=1 ; i<n ; i++)\n{      int x = a[i];\n       pos=i-1;";
//				                            labeli.setLocation(listbut[list.get(indexstep).index1].getLocation().x + 27, listbut[list.get(indexstep).index1].getLocation().y + 90);
//				                            labeli.setVisible(true);
//				                            labelx.setLocation(listbut[list.get(indexstep).index1].getLocation().x+5, listbut[list.get(indexstep).index1].getLocation().y - 25);
//				                            labelx.setText("x = "+list.get(indexstep).index2);
//				                            if(green<20)
//				                            {
//				                            labelx.setVisible(true);
//				                            thuattoan.setSelectedIndex(1);
//				                            green++;
//				                            }
//				                            else
//				                            {
//				                            	
//				                            
//				                            labelpos.setLocation(xpos[list.get(indexstep).Xleft] + 16, 575);
//				                            	if(green<40)
//				                            	{
//				                            green++;
//				                            labelpos.setVisible(true);
//				                            thuattoan.setSelectedIndex(2);
//				                            	}
//				                            	else {
//				                            if (orange < 10)
//				                                orange++;
//				                            else
//				                            {
//				                                orange = 0;
//				                            //    start = 0;
//				                                indexstep++;
//				                            }
//				                            	}
//				                            }
//				                        }
//				                    }
//				                }
//				                else
//				                {
//				                    labeli.setVisible(false);
//				                    labelx.setVisible(false);
//				                    buttonStop.setVisible(false);
//			                        buttonTiepTuc.setVisible(false);
//				                    indexstep = 0;
//				                    start = 0;
//				                    yellow = 0;
//				                    labeli.setVisible(false);
//				                   // textBox6.Text = "";
//				                    //textBox7.Text = "";
//				                    //richTextBox2.Text = "";
//				                    labelpos.setVisible(false);
//				                    labelpos.setText("pos");
//									JOptionPane.showMessageDialog(rootPane, "Mảng đã sắp xếp xong", "", JOptionPane.INFORMATION_MESSAGE);
//				                    timer.stop();
//				                }
//				            }
//						}
//					});
					timer.start();
				}
				if(radiobuttonQS.isSelected())
				{
					if(radiobuttonTangDan.isSelected())
					{
						tang_giam=1;
						CodeQS(tang_giam);
						quickSort(arr, 0, arr.length - 1, listbut, tang_giam);
					}
					else
					{
						tang_giam=0;
						CodeQS(tang_giam);
						quickSort(arr, 0, arr.length - 1, listbut, tang_giam);
					}
					labelLink.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent arg0) {
							try {
						         
						        Desktop.getDesktop().browse(new URI("https://www.geeksforgeeks.org/quick-sort/"));
						         
						    } catch (IOException | URISyntaxException e1) {
						        e1.printStackTrace();
						    }
						}
						});
					labelLink.setText(labelLink.getText()+"Quick Sort");
					labelLink.setVisible(true);
					textareayTuong.setText("Lựa chọn 1 phần tử làm mốc bất kỳ trong dãy đang xét và \r\nxếp lại dãy sao cho bên trái phần tử đó đều nhỏ(lớn) hơn \r\nvà bên phải phần tử đó đều lớn(nhỏ) hơn");
					buttonStart.setVisible(false);
					buttonStop.setVisible(true);
					thuattoan=new JList<>(model);
					thuattoan.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					thuattoan.setFont(new Font("Monospaced",Font.BOLD,14));
					scrollPane.setViewportView(thuattoan);
					timer=new Timer(10, new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							if (start < 22)
				                start++;
				            else
				            {
				                if (indexstep < list.size())
				                {
				                    if (list.get(indexstep).check == 0)
				                    {
				                        if (start_khoi_tao < 40)
				                        {
				                            //richTextBox2.Text = "int pi = partition(arr, low, high);";
				                            start_khoi_tao++;
				                        }
				                        else
				                        {
				                            if (green < 40)
				                            {
				                                green++;
				                                //richTextBox2.Text = "static int partition(int []arr,int low,int high)\n{\nint pivot = arr[high];\nint i = (low - 1);";
				                            }
				                            else
				                            {
				                                labelArrowR.setLocation(xpos[list.get(indexstep).Xleft] -1, 435);
				                                labelArrowL.setLocation(xpos[list.get(indexstep).Xright] + 30, 435);
				                                listbut[list.get(indexstep).Xright].setBackground(Color.orange);
				                                labelpivot.setLocation(xpos[list.get(indexstep).Xright] + 11, 418);
				                                labellow.setLocation(xpos[list.get(indexstep).Xleft] +18, 	545);
				                                labelhigh.setLocation(xpos[list.get(indexstep).Xright] + 15, 545);
				                                if (list.get(indexstep).Xleft == 0)
				                                    labeli.setLocation(xpos[list.get(indexstep).Xleft] - 18, 566);
				                                else
				                                    labeli.setLocation(xpos[list.get(indexstep).Xleft - 1] + 27, 586);
				                                labellow.setVisible(true);
				                                labelpivot.setVisible(true);
				                                labelhigh.setVisible(true);
				                                labeli.setVisible(true);
				                                labelArrowL.setVisible(true);
				                                labelArrowR.setVisible(true);
				                                if (purple < 60)
				                                {
				                                    purple++;
				                                }
				                                else
				                                {
				                                    indexstep++;
				                                    purple = 0;
				                                    start = 0;
				                                    start_khoi_tao = green = 0;
				                                }
				                            }
				                        }
				                    }
				                    else
				                    {
				                        if (list.get(indexstep).check == 2)
				                        {
				                            labelpivot.setVisible(false);
				                           // richTextBox2.Text = "Swap(a[i+1],a[high];\nreturn (i+1);";
				                            labelj.setVisible(false);
				                            listbut[list.get(indexstep).index1 + 1].setBackground(Color.red);
				                            listbut[list.get(indexstep).Xright].setBackground(Color.red);
				                            if (y1 > 380)
				                            {
				                                y1 -= speed;
				                                listbut[list.get(indexstep).index1 + 1].setLocation(listbut[list.get(indexstep).index1 + 1].getLocation().x, listbut[list.get(indexstep).index1 + 1].getLocation().y - speed);
				                                listbut[list.get(indexstep).Xright].setLocation(listbut[list.get(indexstep).Xright].getLocation().x, listbut[list.get(indexstep).Xright].getLocation().y + speed);
				                            } //y=30
				                            else
				                            {
				                                if (list.get(indexstep).index2 < list.get(indexstep).Xleft)
				                                {
				                                    list.get(indexstep).index2 += speed;
				                                    listbut[list.get(indexstep).index1 + 1].setLocation(listbut[list.get(indexstep).index1 + 1].getLocation().x + speed, listbut[list.get(indexstep).index1 + 1].getLocation().y);
				                                    listbut[list.get(indexstep).Xright].setLocation(listbut[list.get(indexstep).Xright].getLocation().x - speed, listbut[list.get(indexstep).Xright].getLocation().y);
				                                }
				                                else
				                                {
				                                    if (y2 < 460)
				                                    {
				                                        y2 += speed;
				                                        listbut[list.get(indexstep).index1 + 1].setLocation(listbut[list.get(indexstep).index1 + 1].getLocation().x, listbut[list.get(indexstep).index1 + 1].getLocation().y + speed);
				                                        listbut[list.get(indexstep).Xright].setLocation(listbut[list.get(indexstep).Xright].getLocation().x, listbut[list.get(indexstep).Xright].getLocation().y - speed);
				                                    }
				                                    else
				                                    {
				                                        JButton A = listbut[list.get(indexstep).index1 + 1];
				                                        listbut[list.get(indexstep).index1 + 1] = listbut[list.get(indexstep).Xright];
				                                        listbut[list.get(indexstep).Xright] = A;
				                                        listbut[list.get(indexstep).Xright].setBackground(color);
				                                        listbut[list.get(indexstep).index1 + 1].setBackground(Color.orange);;
				                                        indexstep++;
				                                        labelArrowL.setVisible(false);
				                                        labelArrowR.setVisible(false);
				                                        y1 = 460; y2 = 380;
				                                        start = 0;
				                                        yellow = 0;
				                                        start_khoi_tao = 0;
				                                    }
				                                }
				                            }
				                        }
				                        else
				                        {
				                            if (start_khoi_tao < 30)
				                            {
				                                start_khoi_tao++;
				                            //    richTextBox2.Text = (tang_giam == 1) ? "for (int j = low; j < high; j++)\n{\n(arr[j] <= pivot)?" : "for (int j = low; j < high; j++)\n{\n(arr[j] >= pivot)?";
				                            }
				                            labelj.setLocation(xpos[list.get(indexstep).index2] + 27, 586);
				                            labelj.setVisible(true);
				                            listbut[list.get(indexstep).index2].setBackground(Color.yellow);
				                            if (yellow < 60)
				                                yellow++;
				                            else
				                            {
				                                if (list.get(indexstep).check == 1)
				                                {
				                                //    richTextBox2.Text = "i++;\nSwap(a[i],a[j]);";
				                                    labeli.setLocation(xpos[list.get(indexstep).index1] + 27, 566);
				                                    labeli.setVisible(true);
				                                    listbut[list.get(indexstep).index2].setBackground(Color.red);
				                                    if (orange < 58)
				                                        orange++;
				                                    else
				                                    {
				                                        if (y1 > 380)
				                                        {
				                                            y1 -= speed;
				                                            listbut[list.get(indexstep).index1].setLocation(listbut[list.get(indexstep).index1].getLocation().x, listbut[list.get(indexstep).index1].getLocation().y - speed);
				                                            listbut[list.get(indexstep).index2].setLocation(listbut[list.get(indexstep).index2].getLocation().x, listbut[list.get(indexstep).index2].getLocation().y + speed);
				                                        }
				                                        else
				                                        {
				                                            if (list.get(indexstep).Xleft < list.get(indexstep).Xright)
				                                            {
				                                                list.get(indexstep).Xleft += speed;
				                                                listbut[list.get(indexstep).index1].setLocation(listbut[list.get(indexstep).index1].getLocation().x + speed, listbut[list.get(indexstep).index1].getLocation().y);
				                                                listbut[list.get(indexstep).index2].setLocation(listbut[list.get(indexstep).index2].getLocation().x - speed, listbut[list.get(indexstep).index2].getLocation().y);
				                                            }
				                                            else
				                                            {
				                                                if (y2 < 460)
				                                                {
				                                                    y2 += speed;
				                                                    listbut[list.get(indexstep).index1].setLocation(listbut[list.get(indexstep).index1].getLocation().x, listbut[list.get(indexstep).index1].getLocation().y + speed);
				                                                    listbut[list.get(indexstep).index2].setLocation(listbut[list.get(indexstep).index2].getLocation().x, listbut[list.get(indexstep).index2].getLocation().y - speed);
				                                                }
				                                                else
				                                                {
				                                                    JButton A = listbut[list.get(indexstep).index1];
				                                                    listbut[list.get(indexstep).index1] = listbut[list.get(indexstep).index2];
				                                                    listbut[list.get(indexstep).index2] = A;
				                                                    listbut[list.get(indexstep).index1].setBackground(color);
				                                                    listbut[list.get(indexstep).index2].setBackground(color);
				                                                    indexstep++;
				                                                    y1 = 460; y2 = 380;
				                                                    start = 0;
				                                                    yellow = 0;
				                                                    orange = 0;
				                                                    start_khoi_tao = 0;
				                                                }
				                                            }
				                                        }
				                                    }
				                                }
				                                else
				                                {
				                                    listbut[list.get(indexstep).index2].setBackground(Color.green);
				                                    if (green < 60)
				                                        green++;
				                                    else
				                                    {
				                                        green = 0;
				                                        start = 0;
				                                        yellow = 0;
				                                        listbut[list.get(indexstep).index2].setBackground(color);
				                                        indexstep++;
				                                    }
				                                }
				                            }
				                        }
				                    }
				                }
				                else
				                {
				                    indexstep = 0;
				                    start = 0;
				                    yellow = 0;
				                    labeli.setVisible(false);
                                    labelj.setVisible(false);
                                    labelpivot.setVisible(false);
                                    labelhigh.setVisible(false);
                                    labellow.setVisible(false);
				                 //   richTextBox2.Text = "";
				                    for (int i = 0; i < listbut.length; i++)
				                    {
				                        listbut[i].setBackground(color);
				                    }
				                    labelArrowL.setVisible(false);
                                    labelArrowR.setVisible(false);
				                    buttonStop.setVisible(false);
			                        buttonTiepTuc.setVisible(false);
									JOptionPane.showMessageDialog(rootPane, "Mảng đã sắp xếp xong", "", JOptionPane.INFORMATION_MESSAGE);
				                    timer.stop();
				                }
				            }
						}
					});
					timer.start();
				}
				if(radiobuttonShS.isSelected())
				{
					if(radiobuttonTangDan.isSelected())
					{
						tang_giam=1;
						CodeShS(tang_giam);
						int left = 0, right = arr.length - 1, k = arr.length - 1;
                        list.add(new Step(left, right, k, -1, 0,-1,-1,-1,null));
                        while (left < right)
                        {
                            for (int j = right; j > left; j--)
                            {
                                if (arr[j] < arr[j - 1])
                                {
                                    int temp = arr[j];
                                    arr[j] = arr[j - 1];
                                    arr[j - 1] = temp;
                                    k = j;
                                    list.add(new Step(listbut[j - 1].getLocation().x, listbut[j].getLocation().x, k, j - 1, 1, 1, right, j,null));
                                }
                                else
                                {
                                    list.add(new Step(left, right, k, j, 2, 1, -1, j - 1,null));
                                }
                            }
                            left = k;
                            list.add(new Step(left, right, k, -1, 4, 1,-1,-1,null));
                            for (int j = left; j < right; j++)
                            {
                                if (arr[j] > arr[j + 1])
                                {
                                    int temp = arr[j];
                                    arr[j] = arr[j + 1];
                                    arr[j + 1] = temp;
                                    k = j;
                                    list.add(new Step(listbut[j].getLocation().x, listbut[j + 1].getLocation().x, k, j, 1, 0, left, j + 1,null));
                                }
                                else
                                {
                                    list.add(new Step(left, right, k, j, 2, 0, -1, j + 1,null));
                                }
                            }
                            right = k;
                            list.add(new Step(left, right, k, -1, 4, 0,-1,-1,null));
                        }
                        list.add(new Step(left, right, k, -1, 3,-1,-1,-1,null));
					}
					else
					{
						tang_giam=0;
						CodeShS(tang_giam);
						int left = 0, right = arr.length - 1, k = arr.length - 1;
                        list.add(new Step(left, right, k, -1, 0,-1,-1,-1,null));
                        while (left < right)
                        {
                            for (int j = right; j > left; j--)
                            {
                                if (arr[j] > arr[j - 1])
                                {
                                    int temp = arr[j];
                                    arr[j] = arr[j - 1];
                                    arr[j - 1] = temp;
                                    k = j;
                                    list.add(new Step(listbut[j - 1].getLocation().x, listbut[j].getLocation().x, k, j - 1, 1, 1, right, j,null));
                                }
                                else
                                {
                                    list.add(new Step(left, right, k, j, 2, 1, -1, j - 1,null));
                                }
                            }
                            left = k;
                            list.add(new Step(left, right, k, -1, 4, 1,-1,-1,null));
                            for (int j = left; j < right; j++)
                            {
                                if (arr[j] < arr[j + 1])
                                {
                                    int temp = arr[j];
                                    arr[j] = arr[j + 1];
                                    arr[j + 1] = temp;
                                    k = j;
                                    list.add(new Step(listbut[j].getLocation().x, listbut[j + 1].getLocation().x, k, j, 1, 0, left, j + 1,null));
                                }
                                else
                                {
                                    list.add(new Step(left, right, k, j, 2, 0, -1, j + 1,null));
                                }
                            }
                            right = k;
                            list.add(new Step(left, right, k, -1, 4, 0,-1,-1,null));
                        }
                        list.add(new Step(left, right, k, -1, 3,-1,-1,-1,null));
					}
					labelLink.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent arg0) {
							try {
						         
						        Desktop.getDesktop().browse(new URI("https://www.geeksforgeeks.org/cocktail-sort/"));
						         
						    } catch (IOException | URISyntaxException e1) {
						        e1.printStackTrace();
						    }
						}
						});
					labelLink.setText(labelLink.getText()+"Shaker Sort");
					labelLink.setVisible(true);
					textareayTuong.setText("Lượt đi: đẩy phần tử nhỏ nhất(lớn nhất) về đầu mảng, \r\nLượt về: đẩy phần tử lớn nhất(nhỏ nhất) về cuối mảng");
					buttonStart.setVisible(false);
					buttonStop.setVisible(true);
					thuattoan=new JList<>(model);
					thuattoan.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					thuattoan.setFont(new Font("Monospaced",Font.BOLD,14));
					scrollPane.setViewportView(thuattoan);
					timer = new Timer(10, new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							if (start_khoi_tao < 37)
				            {
				           //     richTextBox2.Text = "";
				                start_khoi_tao++;
				            }
				            else
				            {
				                if (indexstep < list.size())
				                {
				                    if (list.get(indexstep).check == 0)
				                    {
				                    	thuattoan.setSelectedIndex(0);
				                        labelj.setVisible(false);
				                        labelleft.setLocation(xpos[list.get(indexstep).index1] + 15, 550);
				                        labelright.setLocation(xpos[list.get(indexstep).index2] + 13, 565);
				                        labelk.setLocation(xpos[list.get(indexstep).Xleft] + 27, 405);
				                        labelleft.setVisible(true);
				                        labelright.setVisible(true);
				                        labelk.setVisible(true);
				                   //     richTextBox2.Text = "int left = 0,right = t.Length - 1,k = t.Length - 1;";
				                        if (purple < 40)
				                            purple++;
				                        else
				                        {
				                            indexstep++;
				                            start_khoi_tao = 0;
				                            purple = 0;
				                        }
				                    }
				                    else
				                    {
				                        if (list.get(indexstep).check == 1)
				                        {
				                            if (list.get(indexstep).para1 == 1)
				                            {
				                            	thuattoan.setSelectedIndex(3);
				                             //   richTextBox2.Text = "for (int j = right; j > left; j--)";
				                                labelArrowL.setLocation(xpos[list.get(indexstep).para2] + 30, 435);
				                                labelj.setLocation(xpos[list.get(indexstep).para3] + 27, 422);
				                                labelArrowL.setVisible(true);
				                                labelj.setVisible(true);
				                                if (yellow < 35)
				                                {
				                                    yellow++;
				                                }
				                                else
				                                {
				                                    if (purple < 35)
				                                    {
				                                      //  richTextBox2.Text = (tang_giam == 1) ? "a[j] < a[j-1]?" : "a[j] > a[j-1]?";
				                                        purple++;
				                                    }
				                                    else
				                                    {
				                                    	thuattoan.setSelectedIndex(7);
				                                        //richTextBox2.Text = "Swap(a[j],a[j-1]);";
				                                        listbut[list.get(indexstep).para3].setBackground(Color.red);;
				                                        listbut[list.get(indexstep).Xright].setBackground(Color.red);
				                                        if (orange < 40)
				                                            orange++;
				                                        else
				                                        {
				                                        	thuattoan.setSelectedIndex(8);
				                                            if (y1 > 380)
				                                            {
				                                                y1 -= speed;
				                                                listbut[list.get(indexstep).Xright].setLocation(listbut[list.get(indexstep).Xright].getLocation().x, listbut[list.get(indexstep).Xright].getLocation().y - speed);
				                                                listbut[list.get(indexstep).para3].setLocation(listbut[list.get(indexstep).para3].getLocation().x, listbut[list.get(indexstep).para3].getLocation().y + speed);
				                                            } //y=30
				                                            else
				                                            {
				                                                if (list.get(indexstep).index1 < list.get(indexstep).index2)
				                                                {
				                                                    list.get(indexstep).index1 += speed;
				                                                    listbut[list.get(indexstep).Xright].setLocation(listbut[list.get(indexstep).Xright].getLocation().x + speed, listbut[list.get(indexstep).Xright].getLocation().y);
				                                                    listbut[list.get(indexstep).para3].setLocation(listbut[list.get(indexstep).para3].getLocation().x - speed, listbut[list.get(indexstep).para3].getLocation().y);
				                                                }
				                                                else
				                                                {
				                                                    if (y2 < 460)
				                                                    {
				                                                        y2 += speed;
				                                                        listbut[list.get(indexstep).Xright].setLocation(listbut[list.get(indexstep).Xright].getLocation().x, listbut[list.get(indexstep).Xright].getLocation().y + speed);
				                                                        listbut[list.get(indexstep).para3].setLocation(listbut[list.get(indexstep).para3].getLocation().x, listbut[list.get(indexstep).para3].getLocation().y - speed);
				                                                    }
				                                                    else
				                                                    {
				                                                        labelk.setLocation(xpos[list.get(indexstep).Xleft] + 27, 405);
				                                                        JButton A = listbut[list.get(indexstep).Xright];
				                                                        listbut[list.get(indexstep).Xright] = listbut[list.get(indexstep).para3];
				                                                        listbut[list.get(indexstep).para3] = A;
				                                                        listbut[list.get(indexstep).Xright].setBackground(color);
				                                                        listbut[list.get(indexstep).para3].setBackground(color);
				                                                        indexstep++;
				                                                        y1 = 460; y2 = 380;
				                                                        start = 0;
				                                                        yellow = purple = 0;
				                                                        start_khoi_tao = 0;
				                                                        orange = 0;
				                                                    }
				                                                }
				                                            }
				                                        }
				                                    }
				                                }
				                            }
				                            else
				                            {
				                            	thuattoan.setSelectedIndex(12);
				                              //  richTextBox2.Text = "for (int j = left; j < right; j++)";
				                                labelArrowR.setLocation(xpos[list.get(indexstep).para2] - 1, 435);
				                                labelj.setLocation(xpos[list.get(indexstep).Xright] + 27, 422);
				                                labelArrowR.setVisible(true);
				                                labelj.setVisible(true);
				                                if (yellow < 30)
				                                {
				                                    yellow++;
				                                }
				                                else
				                                {
				                                    if (purple < 35)
				                                    {
				                                     //   richTextBox2.Text = (tang_giam == 1) ? "a[j] > a[j+1]?" : "a[j] < a[j+1]?";
				                                        purple++;
				                                    }
				                                    else
				                                    {
				                                    	thuattoan.setSelectedIndex(16);
				                                       // richTextBox2.Text = "Swap(a[j],a[j+1]);";
				                                        listbut[list.get(indexstep).para3].setBackground(Color.red);
				                                        listbut[list.get(indexstep).Xright].setBackground(Color.red);
				                                        if (orange < 40)
				                                            orange++;
				                                        else
				                                        {
				                                        	thuattoan.setSelectedIndex(17);
				                                            if (y1 > 380)
				                                            {
				                                                y1 -= speed;
				                                                listbut[list.get(indexstep).Xright].setLocation(listbut[list.get(indexstep).Xright].getLocation().x, listbut[list.get(indexstep).Xright].getLocation().y - speed);
				                                                listbut[list.get(indexstep).para3].setLocation(listbut[list.get(indexstep).para3].getLocation().x, listbut[list.get(indexstep).para3].getLocation().y + speed);
				                                            } //y=30
				                                            else
				                                            {
				                                                if (list.get(indexstep).index1 < list.get(indexstep).index2)
				                                                {
				                                                    list.get(indexstep).index1 += speed;
				                                                    listbut[list.get(indexstep).Xright].setLocation(listbut[list.get(indexstep).Xright].getLocation().x + speed, listbut[list.get(indexstep).Xright].getLocation().y);
				                                                    listbut[list.get(indexstep).para3].setLocation(listbut[list.get(indexstep).para3].getLocation().x - speed, listbut[list.get(indexstep).para3].getLocation().y);
				                                                }
				                                                else
				                                                {
				                                                    if (y2 < 460)
				                                                    {
				                                                        y2 += speed;
				                                                        listbut[list.get(indexstep).Xright].setLocation(listbut[list.get(indexstep).Xright].getLocation().x, listbut[list.get(indexstep).Xright].getLocation().y + speed);
				                                                        listbut[list.get(indexstep).para3].setLocation(listbut[list.get(indexstep).para3].getLocation().x, listbut[list.get(indexstep).para3].getLocation().y - speed);
				                                                    }
				                                                    else
				                                                    {
				                                                        labelk.setLocation(xpos[list.get(indexstep).Xleft] + 27, 405);
				                                                        JButton A = listbut[list.get(indexstep).Xright];
				                                                        listbut[list.get(indexstep).Xright] = listbut[list.get(indexstep).para3];
				                                                        listbut[list.get(indexstep).para3] = A;
				                                                        listbut[list.get(indexstep).Xright].setBackground(color);
				                                                        listbut[list.get(indexstep).para3].setBackground(color);
				                                                        indexstep++;
				                                                        y1 = 460; y2 = 380;
				                                                        start = 0;
				                                                        yellow = purple = 0;
				                                                        start_khoi_tao = 0;
				                                                        orange = 0;
				                                                    }
				                                                }
				                                            }
				                                        }
				                                    }
				                                }
				                            }
				                        }
				                        else
				                        {
				                            if (list.get(indexstep).check == 2)
				                            {
				                                if (list.get(indexstep).para1 == 1)
				                                {
				                                 //   richTextBox2.Text = "for (int j = right; j < left; j--)";
				                                    labelj.setLocation(xpos[list.get(indexstep).Xright] + 27, 422);
				                                    labelArrowL.setLocation(xpos[list.get(indexstep).index2] + 30, 435);
				                                    labelArrowL.setVisible(true);
				                                    labelj.setVisible(true);
				                                    if (orange < 40)
				                                        orange++;
				                                    else
				                                    {
				                                        if (purple < 35)
				                                        {
				                                            //richTextBox2.Text = (tang_giam == 1) ? "a[j] < a[j-1]?" : "a[j] > a[j-1]?";
				                                            purple++;
				                                        }
				                                        else
				                                        {
				                                            //richTextBox2.Text = "";
				                                            listbut[list.get(indexstep).para3].setBackground(Color.green);
				                                            listbut[list.get(indexstep).Xright].setBackground(Color.green);
				                                            if (green < 40)
				                                                green++;
				                                            else
				                                            {
				                                                purple = 0;
				                                                listbut[list.get(indexstep).para3].setBackground(color);
				                                                listbut[list.get(indexstep).Xright].setBackground(color);
				                                                green = orange = 0;
				                                                start_khoi_tao = 0;
				                                                indexstep++;
				                                            }
				                                        }
				                                    }
				                                }
				                                else
				                                {
				                                //    richTextBox2.Text = "for (int j = left; j < right; j++)";
				                                    labelj.setLocation(xpos[list.get(indexstep).Xright] + 27, 422);
				                                    labelArrowR.setLocation(xpos[list.get(indexstep).index1] - 1, 435);
				                                    labelArrowR.setVisible(true);
				                                    labelj.setVisible(true);
				                                    if (orange < 35)
				                                        orange++;
				                                    else
				                                    {
				                                        if (purple < 35)
				                                        {
				                                            //richTextBox2.Text = (tang_giam == 1) ? "a[j] > a[j+1]?" : "a[j] < a[j+1]?";
				                                            purple++;
				                                        }
				                                        else
				                                        {
				                                            //richTextBox2.Text = "";
				                                            listbut[list.get(indexstep).para3].setBackground(Color.green);
				                                            listbut[list.get(indexstep).Xright].setBackground(Color.green);
				                                            if (green < 40)
				                                                green++;
				                                            else
				                                            {
				                                                listbut[list.get(indexstep).para3].setBackground(color);
				                                                listbut[list.get(indexstep).Xright].setBackground(color);
				                                                green = orange = 0;
				                                                start_khoi_tao = 0;
				                                                indexstep++;
				                                                purple = 0;
				                                            }
				                                        }
				                                    }
				                                }
				                            }
				                            else
				                            {
				                                if (list.get(indexstep).check == 4)
				                                {
				                                    if (list.get(indexstep).para1 == 1)
				                                    {
				                                       // richTextBox2.Text = "left=k;";
				                                        if (list.get(indexstep).index1 > 0)
				                                        {
				                                            for (int i = 0; i < list.get(indexstep).index1; i++)
				                                            {
				                                                listbut[i].setBackground(Color.orange);
				                                            }
				                                        }
				                                        labelArrowL.setVisible(false);
				                                        thuattoan.setSelectedIndex(11);
				                                        labelleft.setLocation(xpos[list.get(indexstep).Xleft] + 15, 550);
				                                    }
				                                    else
				                                    {
				                                        //richTextBox2.Text = "right=k;";
				                                        if (list.get(indexstep).index2 < arr.length - 1)
				                                        {
				                                            for (int i = arr.length - 1; i > list.get(indexstep).index2; i--)
				                                            {
				                                                listbut[i].setBackground(Color.orange);
				                                            }
				                                        }
				                                        labelArrowR.setVisible(false);
				                                        thuattoan.setSelectedIndex(20);
				                                        labelright.setLocation(xpos[list.get(indexstep).Xleft] + 13, 565);
				                                    }
				                                    labelj.setVisible(false);
				                                    if (green < 40)
				                                    {
				                                        green++;
				                                    }
				                                    else
				                                    {
				                                        green = 0;
				                                        start_khoi_tao = 0;
				                                        indexstep++;
				                                    }
				                                }
				                                else
				                                {
				                                    if (list.get(indexstep).check == 3)
				                                    {
				                                      //  richTextBox2.Text = "left>=right: Thoát vòng lặp";
				                                        labelArrowL.setVisible(false);
				                                        labelArrowR.setVisible(false);
				                                        labelleft.setForeground(Color.red);
				                                        labelright.setForeground(Color.red);;
				                                        labelj.setVisible(false);
				                                        if (orange < 50)
				                                            orange++;
				                                        else
				                                        {
				                                            orange = start_khoi_tao = 0;
				                                            indexstep++;
				                                        }
				                                    }
				                                }
				                            }
				                        }
				                    }
				                }
				                else
				                {
				                	buttonStop.setVisible(false);
			                        buttonTiepTuc.setVisible(false);
				                    indexstep = 0;
				                    start = 0;
				                    yellow = 0;
				                    labeli.setVisible(false);
                                    labelj.setVisible(false);
                                    labelleft.setVisible(false);
                                    labelright.setVisible(false);
                                    labelk.setVisible(false);
                                    labelleft.setForeground(Color.black);
				                    labelright.setForeground(Color.black);
				                 //   textBox6.Text = "";
				                   // textBox7.Text = "";
				                 //   richTextBox2.Text = "";
				                    for (int i = 0; i < listbut.length; i++)
				                    {
				                        listbut[i].setBackground(color);
				                    }
				                    JOptionPane.showMessageDialog(rootPane, "Mảng đã sắp xếp xong", "", JOptionPane.INFORMATION_MESSAGE);
				                    timer.stop();
				                }
				            }
						}
					});
					timer.start();
				}
				if(radiobuttonRdS.isSelected())
				{
					if(radiobuttonTangDan.isSelected())
					{
						tang_giam=1;
						CodeRdS(tang_giam);
						radixsort(arr, arr.length, listbut, 1);
					}
					else
					{
						tang_giam=0;	
						CodeRdS(tang_giam);
						radixsort(arr, arr.length, listbut, 1);
					}
					labelLink.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent arg0) {
							try {
						         
						        Desktop.getDesktop().browse(new URI("https://www.geeksforgeeks.org/radix-sort/"));
						         
						    } catch (IOException | URISyntaxException e1) {
						        e1.printStackTrace();
						    }
						}
						});
					labelLink.setText(labelLink.getText()+"Radix Sort");
					labelLink.setVisible(true);
					textareayTuong.setText("Giả sử dãy gồm các số nguyên tối đa m chữ số. Tiến hành phân loại \r\ntheo các chữ số hàng đơn vị,hàng chục,hàng trăm,...");
					buttonStart.setVisible(false);
					buttonStop.setVisible(true);
					thuattoan=new JList<>(model);
					thuattoan.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					thuattoan.setFont(new Font("Monospaced",Font.BOLD,14));
					scrollPane.setViewportView(thuattoan);
					addlabelRS();
					timer= new Timer(10, new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							if (start_khoi_tao < 45)
				                start_khoi_tao++;
				            else
				            {
				                if (indexstep < list.size())
				                {
				                    if (list.get(indexstep).check == 0)
				                    {
				                        for(JLabel lab:labelindex)
				                        {
				                            lab.setVisible(false);
				                        }
				                        if (y2 < 460)
				                        {
				                            y2 += speed;
				                            for (int i = 0; i < listbut.length; i++)
				                            {
				                                listbut[i].setLocation(listbut[i].getLocation().x, listbut[i].getLocation().y + speed);
				                            }
				                        }
				                        else
				                        {
				                            y2 = 380;
				                            indexstep++;
				                            start_khoi_tao = 0;
				                        }
				                    }
				                    else
				                    {
				                        if(list.get(indexstep).check==1)
				                        {
				                            for(JLabel lab:labelindex2)
				                            {
				                                lab.setVisible(false);
				                            }
				                            changelabelRS(list.get(indexstep).index2);
				                            //string hang = list.get(indexstep).index2 == 1 ? "đơn vị" : list.get(indexstep).index2 == 10 ? "chục" : list.get(indexstep).index2 == 100 ? "trăm":"nghìn";
				                           // richTextBox2.Text = "Phân loại theo hàng "+hang;
				                            labeldonvi.setVisible(true);
				                            for (int i=0;i<labelindex1.length;i++)
				                            {
				                                labelindex1[i].setVisible(true);
				                            }
				                            if (green < 35)
				                                green++;
				                            else
				                            {
				                                green = 0;
				                                indexstep++;
				                                start_khoi_tao = 0;
				                                labelArrowR.setVisible(true);
				                            }
				                        }
				                        else
				                        {
				                            if(list.get(indexstep).check==2)
				                            {
				                                ChangeColorRS(list.get(indexstep).index2);
				                                if (yellow < 30)
				                                    yellow++;
				                                else
				                                {
				                                    changelabelRS2(list.get(indexstep).index1, list.get(indexstep).index2);
				                                    indexstep++;
				                                    yellow =start_khoi_tao= 0;
				                                }
				                            }
				                            else
				                            {
				                                if(list.get(indexstep).check==3)
				                                {
				                                    for(JLabel lab:labelindex1)
				                                    {
				                                        lab.setVisible(false);
				                                    }
				                                    for(JButton but:listbut)
				                                    {
				                                        but.setBackground(color);
				                                    }
				                                    if (yellow < 25)
				                                        yellow++;
				                                    else
				                                    {
				                                        for(int i=0;i<arr.length;i++)
				                                        {
				                                            listbut[i].setText(labelindex2[i].getText());
				                                        }
				                                        yellow = start_khoi_tao = 0;
				                                        indexstep++;
				                                    }
				                                }
				                                else
				                                {
				                                    if(list.get(indexstep).check==4)
				                                    {
				                                        for(JLabel lab: labelindex2)
				                                        {
				                                            lab.setVisible(false);
				                                        }
				                                        labeldonvi.setVisible(false);
				                                        labelArrowR.setVisible(false);
				                                        if (y1 >380)
				                                        {
				                                            y1 -= speed;
				                                            for (int i = 0; i < listbut.length; i++)
				                                            {
				                                                listbut[i].setLocation(listbut[i].getLocation().x, listbut[i].getLocation().y - speed);
				                                            }
				                                        }
				                                        else
				                                        {
				                                            y1 = 460;
				                                            for (JLabel lab:labelindex)
				                                            {
				                                                lab.setVisible(true);
				                                            }
				                                            indexstep++;
				                                            start_khoi_tao = 0;
				                                        }
				                                    }
				                                }
				                            }
				                        }
				                    }
				                }
				                else
				                {
				                    labelArrowR.setVisible(false);
				                    labeldonvi.setVisible(false);
				                    buttonStop.setVisible(false);
			                        buttonTiepTuc.setVisible(false);
				                    indexstep = 0;
				                    start = 0;
				                    yellow = 0;
				                    JOptionPane.showMessageDialog(rootPane, "Mảng đã sắp xếp xong", "", JOptionPane.INFORMATION_MESSAGE);
				                    timer.stop();
				                }
				            }
						}
					});
					timer.start();
				}
				if(radiobuttonBiSrch.isSelected())
				{
					if(checkTangDan())
					{
					try {
					numsrch=Integer.parseInt(JOptionPane.showInputDialog(contentPane, "Nhập số tìm kiếm"));
					}catch(Exception ex)
					{
						JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập số", "", JOptionPane.ERROR_MESSAGE);
					}
					int left, right, mid;
                    left = 0;
                    right = arr.length - 1;
                    do
                    {
                        mid = (left + right) / 2;
                        if (arr[mid] == numsrch)
                        {
                            list.add(new Step(left, mid, right, 1,-1,-1,-1,-1,null));
                            left = 1;
                            right = 0;
                        }
                        else
                        {
                            list.add(new Step(left, mid, right, 0,-1,-1,-1,-1,null));
                            if (arr[mid] < numsrch)
                            {
                                //    list.Add(new Step(left, mid,right, 0));
                                left = mid + 1;
                            }
                            else
                            {
                                //   list.Add(new Step(left,mid,right, 0));
                                right = mid - 1;

                            }

                        }
                    } while (left <= right);
                    buttonnumsrch.setText(Integer.toString(numsrch));
                    buttonnumsrch.setVisible(true);
                    CodeBiS();
                    labelLink.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent arg0) {
							try {
						         
						        Desktop.getDesktop().browse(new URI("https://www.geeksforgeeks.org/binary-search/"));
						         
						    } catch (IOException | URISyntaxException e1) {
						        e1.printStackTrace();
						    }
						}
						});
                    labelLink.setText(labelLink.getText()+"Binary Search");
					labelLink.setVisible(true);
					textareayTuong.setText("So sánh giá trị tìm kiếm với phần tử chính giữa của mảng \r\nđang xét, nếu nhỏ hơn thì xét tiếp mảng ở bên trái, nếu \r\nlớn hơn thì xét tiếp ở mảng bên phải");
                    buttonStart.setVisible(false);
					buttonStop.setVisible(true);
					thuattoan=new JList<>(model);
					thuattoan.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					thuattoan.setSelectedIndex(0);
					thuattoan.setFont(new Font("Monospaced",Font.BOLD,14));
					scrollPane.setViewportView(thuattoan);
					timer= new Timer(10, new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							if (start_khoi_tao < 40)
				            {
				            //    richTextBox2.Text = "int left, right, mid; \nleft=0;\nright=n-1;";
				                start_khoi_tao++;
				            }
				            else
				            {
				                if (start < 40)
				                    start++;
				                else
				                {
				                    if (indexstep < list.size())
				                    {
				                        if (orange < 60)
				                            orange++;
				                        else
				                        {
				                            labelleft.setLocation(listbut[list.get(indexstep).index1].getLocation().x + 17, listbut[list.get(indexstep).index1].getLocation().y + 100);
				                            labelmid.setLocation(listbut[list.get(indexstep).index2].getLocation().x + 15, listbut[list.get(indexstep).index2].getLocation().y + 130);
				                            labelright.setLocation(listbut[list.get(indexstep).Xleft].getLocation().x + 13, listbut[list.get(indexstep).Xleft].getLocation().y + 160);
				                            labelleft.setVisible(true);
				                            labelmid.setVisible(true);
				                            labelright.setVisible(true);
				                            listbut[list.get(indexstep).index2].setBackground(Color.yellow);
				                            if (yellow < 80)
				                            {
				                                buttonnumsrch.setBackground(Color.yellow);
				                        //        richTextBox2.Text = "(a[mid]==x)?";
				                                yellow++;
				                            }
				                            else
				                            {
				                                if (list.get(indexstep).Xright == 1)
				                                {
				                                    listbut[list.get(indexstep).index1].setBackground(color);
				                                    listbut[list.get(indexstep).Xleft].setBackground(color);
				                                    listbut[list.get(indexstep).index2].setBackground(Color.green);
				                                    if (green < 80)
				                                    {
				                                        //richTextBox2.Text = "return 1;";
				                                        green++;
				                                    }
				                                    else
				                                    {
				                                        buttonnumsrch.setVisible(false);
				                                        buttonnumsrch.setBackground(color);;
				                                        //label13.Text = "Tìm thấy !!!";
				                                        JOptionPane.showMessageDialog(rootPane, "Tìm thấy", "", JOptionPane.INFORMATION_MESSAGE);
				                                        buttonnumsrch.setVisible(false);
				                                        orange=0;
				                                   //     richTextBox2.Text = "";
				                                        timer.stop();
				                                    }
				                                }
				                                else
				                                {
				                                    listbut[list.get(indexstep).index2].setBackground(Color.red);;
				                                    if (green < 80)
				                                    {
				                                      //  richTextBox2.Text = "if(a[mid]<x) left=mid+1;\nelse if(a[mid]>x) right=mid-1;";
				                                        green++;
				                                    }
				                                    else
				                                    {
				                                        labelmid.setVisible(false);
				                                        labelleft.setVisible(false);
				                                        labelright.setVisible(false);
				                                        listbut[list.get(indexstep).index1].setBackground(color);
				                                        listbut[list.get(indexstep).Xleft].setBackground(color);
				                                        listbut[list.get(indexstep).index2].setBackground(color);
				                                        start = 0;
				                                        yellow = 0;
				                                        green = 0;
				                                        orange=0;
				                                        indexstep++;
				                                        buttonnumsrch.setBackground(color);
				                                    }
				                                }
				                            }
				                        }
				                    }
				                    else
				                    {
				                        buttonnumsrch.setVisible(false);
				                        buttonnumsrch.setBackground(color);;
				           //             label13.Text = "Không tìm thấy !!!";
				             //           label13.ForeColor = Color.Red;
				               //         label13.Visible = true;
				              //          button5.Visible = false;
				                       // richTextBox2.Text = "";
				                        buttonStop.setVisible(false);
				                        buttonTiepTuc.setVisible(false);
					                    indexstep = 0;
					                    JOptionPane.showMessageDialog(contentPane, "Không tìm thấy", "", JOptionPane.INFORMATION_MESSAGE);
				                        timer.stop();
				                    }
				                }
				            }
						}
					});
					timer.start();
					}
					else
					{
						JOptionPane.showMessageDialog(contentPane, "Vui lòng chọn Tạo lại để nhập dãy số tăng dần", "", JOptionPane.INFORMATION_MESSAGE);
						buttonTaoLai.doClick();
					}
				}
				if(radiobuttonLiSrch.isSelected())
				{
					try {
						numsrch=Integer.parseInt(JOptionPane.showInputDialog(contentPane, "Nhập số tìm kiếm"));
						}catch(Exception ex)
						{
							JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập số", "", JOptionPane.ERROR_MESSAGE);
						}
					 for (int i = 0; i < arr.length; i++)
                     {
                         if (arr[i] == numsrch)
                             list.add(new Step(i, -1, -1, -1, 1,-1,-1,-1,null));
                         else
                             list.add(new Step(i, -1, -1, -1, 0,-1,-1,-1,null));
                     }
					buttonnumsrch.setText(Integer.toString(numsrch));
	                buttonnumsrch.setVisible(true);
					CodeLiS();
					 labelLink.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent arg0) {
								try {
							         
							        Desktop.getDesktop().browse(new URI("https://www.geeksforgeeks.org/linear-search/"));
							         
							    } catch (IOException | URISyntaxException e1) {
							        e1.printStackTrace();
							    }
							}
							});
					 labelLink.setText(labelLink.getText()+"Linear Search");
					labelLink.setVisible(true);
					textareayTuong.setText("Lần lượt so sánh giá trị tìm kiếm với từng phần tử trong \r\nmảng");
	                buttonStart.setVisible(false);
					buttonStop.setVisible(true);
					thuattoan=new JList<>(model);
					thuattoan.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					thuattoan.setSelectedIndex(0);
					thuattoan.setFont(new Font("Monospaced",Font.BOLD,14));
					scrollPane.setViewportView(thuattoan);
					timer= new Timer(10, new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							if (start < 55)
				            {
				          //      richTextBox2.Text = "for(int i=0;i<N;i++)";
								thuattoan.setSelectedIndex(0);
				                start++;
				            }
				            else
				            {
				                if (indexstep < list.size())
				                {
				                    labeli.setLocation(xpos[list.get(indexstep).index1] + 27, 550);
				                    labeli.setVisible(true);
				                    listbut[list.get(indexstep).index1].setBackground(Color.yellow);
				                    buttonnumsrch.setBackground(Color.yellow);
				                    if (yellow < 80)
				                    {
				                  //      richTextBox2.Text = "if(a[i]==x)";
				                    	thuattoan.setSelectedIndex(1);
				                        yellow++;
				                    }
				                    else
				                    {
				                        if (list.get(indexstep).check == 0)
				                        {
				                            listbut[list.get(indexstep).index1].setBackground(Color.red);

				                            if (orange < 80)
				                                orange++;
				                            else
				                            {
				                                orange = start = yellow = 0;
				                                listbut[list.get(indexstep).index1].setBackground(color);
				                                buttonnumsrch.setBackground(color);
				                                indexstep++;
				                            }
				                        }
				                        else
				                        {
				                            listbut[list.get(indexstep).index1].setBackground(Color.green);
				                            if (green < 80)
				                                green++;
				                            else
				                            {
				                                buttonnumsrch.setVisible(false);
				                                buttonnumsrch.setBackground(color);
				                                thuattoan.setSelectedIndex(2);
				                             //   label13.Visible = true;
				                             //   label13.Text = "Tìm thấy !!!";
				                                JOptionPane.showMessageDialog(rootPane, "Tìm thấy", "", JOptionPane.INFORMATION_MESSAGE);
				                                labeli.setVisible(false);
				                                buttonStop.setVisible(false);
						                        buttonTiepTuc.setVisible(false);
							                    indexstep = 0;
				                                timer.stop();
				                            }
				                        }
				                    }
				                }
				                else
				                {
				                    buttonnumsrch.setVisible(false);
				                    buttonnumsrch.setBackground(color);
				                    thuattoan.setSelectedIndex(3);
				                    JOptionPane.showMessageDialog(contentPane, "Không tìm thấy", "", JOptionPane.INFORMATION_MESSAGE);				                   
				                    labeli.setVisible(false);
				                    buttonStop.setVisible(false);
			                        buttonTiepTuc.setVisible(false);
				                    indexstep = 0;
				                    timer.stop();
				                }
				            }
						}
					});
					timer.start();
				}
			}
		});
		buttonStart.setBounds(27, 239, 116, 23);
		buttonStart.setFont(new Font("Tahoma", Font.PLAIN, 15));
		buttonStart.setVisible(false);
		contentPane.add(buttonStart);
		
		buttonStop = new JButton("Dừng Lại");
		buttonStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buttonStop.setVisible(false);
				buttonTiepTuc.setVisible(true);
				timer.stop();
			}
		});
		buttonStop.setFont(new Font("Tahoma", Font.PLAIN, 15));
		buttonStop.setBounds(231, 239, 116, 23);
		buttonStop.setVisible(false);
		contentPane.add(buttonStop);
		
		panelChieuSapXep = new JPanel();
		panelChieuSapXep.setBorder(new TitledBorder(null, "S\u1EAFp x\u1EBFp theo", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panelChieuSapXep.setBounds(545, 239, 320, 70);
		contentPane.add(panelChieuSapXep);
		panelChieuSapXep.setLayout(null);
		
		radiobuttonGiamDan = new JRadioButton("Giảm Dần");
		radiobuttonGiamDan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		radiobuttonGiamDan.setBounds(161, 27, 135, 23);
		panelChieuSapXep.add(radiobuttonGiamDan);
		
		radiobuttonTangDan = new JRadioButton("Tăng Dần");
		radiobuttonTangDan.setSelected(true);
		radiobuttonTangDan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		radiobuttonTangDan.setBounds(6, 29, 135, 23);
		panelChieuSapXep.add(radiobuttonTangDan);
		
		buttonGroup3= new ButtonGroup();
		buttonGroup3.add(radiobuttonTangDan);
		buttonGroup3.add(radiobuttonGiamDan);
		
		labeli = new JLabel("i");
		labeli.setFont(new Font("Tahoma", Font.BOLD, 16));
		labeli.setBounds(325, 198, 12, 22);
		labeli.setVisible(false);
		contentPane.add(labeli);
		
		labelk = new JLabel("k");
		labelk.setFont(new Font("Tahoma", Font.BOLD, 16));
		labelk.setBounds(390, 198, 12, 22);
		labelk.setVisible(false);
		contentPane.add(labelk);
		
		labelj = new JLabel("j");
		labelj.setFont(new Font("Tahoma", Font.BOLD, 16));
		labelj.setBounds(431, 198, 12, 22);
		labelj.setVisible(false);
		contentPane.add(labelj);
		
		labelmin = new JLabel("min");
		labelmin.setFont(new Font("Tahoma", Font.BOLD, 16));
		labelmin.setBounds(468, 198, 30, 21);
		labelmin.setVisible(false);
		contentPane.add(labelmin);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(872, 31, 478, 304);
		contentPane.add(scrollPane);
		
		labelLink = new JLabel("Tham khảo thêm về thuật toán ");
//		labelLink.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent arg0) {
//				try {
//			         
//			        Desktop.getDesktop().browse(new URI("http://www.google.com"));
//			         
//			    } catch (IOException | URISyntaxException e1) {
//			        e1.printStackTrace();
//			    }
//			}
//		});
		labelLink.setForeground(Color.BLUE);
		labelLink.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelLink.setBounds(906, 346, 417, 21);
		labelLink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		labelLink.setVisible(false);
		contentPane.add(labelLink);
		
		labelpos = new JLabel("pos");
		labelpos.setFont(new Font("Tahoma", Font.BOLD, 16));
		labelpos.setBounds(478, 230, 63, 21);
		labelpos.setVisible(false);
		contentPane.add(labelpos);
		
		labelx = new JLabel("x");
		labelx.setFont(new Font("Tahoma", Font.BOLD, 16));
		labelx.setBounds(357, 231, 104, 21);
		labelx.setVisible(false);
		contentPane.add(labelx);
		
		labelArrowR = new JLabel("→");
		labelArrowR.setFont(new Font("Tahoma", Font.BOLD, 30));
		labelArrowR.setBounds(10, 431, 41, 21);
		labelArrowR.setVisible(false);
		contentPane.add(labelArrowR);
		
		labelArrowL = new JLabel("←");
		labelArrowL.setFont(new Font("Tahoma", Font.BOLD, 30));
		labelArrowL.setBounds(102, 326, 41, 21);
		labelArrowL.setVisible(false);
		contentPane.add(labelArrowL);
		
		labelpivot = new JLabel("pivot");
		labelpivot.setFont(new Font("Tahoma", Font.BOLD, 16));
		labelpivot.setBounds(354, 259, 52, 21);
		labelpivot.setVisible(false);
		contentPane.add(labelpivot);
		
		labellow = new JLabel("low");
		labellow.setFont(new Font("Tahoma", Font.BOLD, 16));
		labellow.setBounds(421, 263, 52, 21);
		labellow.setVisible(false);
		contentPane.add(labellow);
		
		labelhigh = new JLabel("high");
		labelhigh.setFont(new Font("Tahoma", Font.BOLD, 16));
		labelhigh.setBounds(488, 262, 52, 21);
		labelhigh.setVisible(false);
		contentPane.add(labelhigh);
		
		labelleft = new JLabel("left");
		labelleft.setFont(new Font("Tahoma", Font.BOLD, 16));
		labelleft.setBounds(153, 313, 46, 14);
		labelleft.setVisible(false);
		contentPane.add(labelleft);
		
		labelright = new JLabel("right");
		labelright.setFont(new Font("Tahoma", Font.BOLD, 16));
		labelright.setBounds(226, 315, 46, 19);
		labelright.setVisible(false);
		contentPane.add(labelright);
		
		labelmid=new JLabel("mid");
		labelmid.setFont(new Font("Tahoma", Font.BOLD, 16));
		labelmid.setBounds(226, 315, 46, 19);
		labelmid.setVisible(false);
		contentPane.add(labelmid);
		
		labeldonvi = new JLabel("labeldonvi");
		labeldonvi.setFont(new Font("Tahoma", Font.BOLD, 15));
		labeldonvi.setBounds(1, 484, 91, 23);
		labeldonvi.setVisible(false);
		contentPane.add(labeldonvi);
		
		buttonnumsrch = new JButton("New button");	
		buttonnumsrch.setBounds(619, 630, 60, 60);
		buttonnumsrch.setVisible(false);
		contentPane.add(buttonnumsrch);
		
		textareayTuong = new JTextArea();
		textareayTuong.setEditable(false);
		textareayTuong.setForeground(Color.BLUE);
		textareayTuong.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textareayTuong.setBounds(357, 310, 505, 68);
		contentPane.add(textareayTuong);
		
		labelyTuong = new JLabel("Ý tưởng");
		labelyTuong.setBounds(266, 333, 81, 18);
		labelyTuong.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(labelyTuong);
		
		buttonTaoLai = new JButton("Tạo Lại");
		buttonTaoLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				labelArrowR.setLocation(10,431);
				rdbtnNewRadioButton_2.setSelected(true);
				speed=5;
				labelLink.setText("Tham khảo thêm về thuật toán ");
				textareayTuong.setText(null);
				labelLink.setVisible(false);
				green=yellow=orange=purple=start=start_khoi_tao=indexstep=0;
				arr=null;
				list.removeAll(list);
				for(JButton b:listbut)
				{
					contentPane.remove(b);
				}
				for(JLabel l:labelindex)
				{
					contentPane.remove(l);
				}
				if(labelindex1!=null)
				{
				for(JLabel l:labelindex1)
				{
					contentPane.remove(l);
				}
				}
				if(labelindex2!=null)
				{
				for(JLabel l:labelindex2)
				{
					contentPane.remove(l);
				}
				}
				model.removeAllElements();
				thuattoan=null;
				listbut=null;
				labelindex=null;
				labelindex1=null;
				labelindex2=null;
				xpos=null;
				textRandom.setText(null);
				textSo.setText(null);
				buttonnumsrch.setVisible(false);
				buttonStart.setVisible(false);
				buttonTaoLai.setVisible(false);
				buttonStop.setVisible(false);
				buttonTiepTuc.setVisible(false);
				labeli.setVisible(false);
				labelj.setVisible(false);
				labelx.setVisible(false);
				labelmin.setVisible(false);
				labelk.setVisible(false);
				labelpos.setVisible(false);
				labelArrowL.setVisible(false);
				labelArrowR.setVisible(false);
				labelhigh.setVisible(false);
				labellow.setVisible(false);
				labelpivot.setVisible(false);
				labeldonvi.setVisible(false);
				labelleft.setVisible(false);
				labelright.setVisible(false);
				labelmid.setVisible(false);
			//	label
				if(timer!=null)
					{
					timer.stop();
					}
				repaint();
			}
		});
		buttonTaoLai.setBounds(231, 277, 116, 23);
		buttonTaoLai.setFont(new Font("Tahoma", Font.PLAIN, 15));
		buttonTaoLai.setVisible(false);
		contentPane.add(buttonTaoLai);
	}
	public void changelabelRS2(int pos, int val)
    {
        labelindex2[pos].setText(Integer.toString(val));
        labelindex2[pos].setVisible(true);
    }
	public void changelabelRS(int pos)
    {
        if (pos == 1)
            labeldonvi.setText("Đơn vị");
        if (pos == 10)
            labeldonvi.setText("Chục");
        if (pos == 100)
            labeldonvi.setText("Trăm");
        if (pos == 1000)
            labeldonvi.setText("Nghìn");
        for (int i = 0; i < labelindex.length; i++)
        {
            labelindex1[i].setText(Integer.toString((Integer.parseInt(listbut[i].getText()) / pos) % 10));
        }
    }
	public void addlabelRS()
    {
		labelindex1= new JLabel[len];
		labelindex2=new JLabel[len];
        for (int i = 0; i < listbut.length; i++)
        {
        	labelindex1[i]= new JLabel(String.valueOf(i));
			labelindex1[i].setBounds(100*i+76,481,30,30);
			labelindex1[i].setFont(new Font("Tahoma", Font.PLAIN, 15));
			labelindex1[i].setVisible(false);
			contentPane.add(labelindex1[i]);
			labelindex2[i]= new JLabel(String.valueOf(i));
			labelindex2[i].setBounds(100*i+76,430,30,30);
			labelindex2[i].setFont(new Font("Tahoma", Font.PLAIN, 15));
			labelindex2[i].setVisible(false);
			contentPane.add(labelindex2[i]);
        }
        repaint();
    }
	private void ChangeColorRS(int x)
    {
        for (int i = 0; i < listbut.length; i++)
        {
            if (Integer.parseInt(listbut[i].getText()) == x && listbut[i].getBackground() == color)
            {
                listbut[i].setBackground(Color.orange);
                i = 14;
            }
        }
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
				xpos=new int[len];
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
					listbut[i].setFont(new Font("Tahoma", Font.PLAIN, 15));
					listbut[i].setBackground(color);
					xpos[i]=100*i+50;
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
	 public void quickSort(int arr[], int low, int high, JButton[] list, int tang_giam)
     {
         if (low < high)
         {
             int pi = partition(arr, low, high, list, tang_giam);
             quickSort(arr, low, pi - 1, list, tang_giam);
             quickSort(arr, pi + 1, high, list, tang_giam);
         }
     }
	 public int partition(int[] arr, int low, int high, JButton[] list, int tang_giam)
     {
         int pivot = arr[high];
         int i = low - 1;
         addstepQS(i, -1, low, high, 0);
         for (int j = low; j < high; j++)
         {
             if (tang_giam == 1)
             {
                 if (arr[j] <= pivot)
                 {
                     i++;
                     addstepQS(i, j, list[i].getLocation().x, list[j].getLocation().x, 1);
                     int temp = arr[i];
                     arr[i] = arr[j];
                     arr[j] = temp;
                 }
                 else
                 {
                     addstepQS(i, j, -1, list[j].getLocation().x, 3);
                 }
             }
             else
             {
                 if (arr[j] >= pivot)
                 {
                     i++;
                     addstepQS(i, j, list[i].getLocation().x, list[j].getLocation().x, 1);
                     int temp = arr[i];
                     arr[i] = arr[j];
                     arr[j] = temp;
                 }
                 else
                 {
                     addstepQS(i, j, -1, list[j].getLocation().x, 3);
                 }
             }
         }
         addstepQS(i, list[i + 1].getLocation().x, list[high].getLocation().x, high, 2);
         int temp1 = arr[i + 1];
         arr[i + 1] = arr[high];
         arr[high] = temp1;
         return i + 1;
     }
	 public void addstepQS(int a , int b , int c , int d, int e)
     {
         list.add(new Step(a, b, c, d, e,-1,-1,-1,null));
     }
	 public void radixsort(int[] arr, int n, JButton[] list, int check)
     {
         int m = getMax(arr, n);
         addstepRS(-1, -1, -1, -1, 0,null);
         for (int exp = 1; m / exp > 0; exp *= 10)
         {
             addstepRS(m, exp, -1, -1, 1, arr);
             countSort(arr, n, exp, list, check);
         }
         addstepRS(-1, -1, -1, -1, 4,null);
     }
	 public int getMax(int[] arr, int n)
     {
         int mx = arr[0];
         for (int i = 1; i < n; i++)
             if (arr[i] > mx)
                 mx = arr[i];
         return mx;
     }
	 public void addstepRS(int a, int b , int c , int d, int e, int[] x )
     {
         list.add(new Step(a, b, c, d, e, -1, -1, -1, x));
     }
	 public void countSort(int[] arr, int n, int exp, JButton[] list, int check)
     {
         int[] output = new int[n];
         int[] count = new int[10];
         for (int i = 0; i < n; i++)
             count[(arr[i] / exp) % 10]++;
         if (check == 1)
         {
             for (int i = 1; i < 10; i++)
                 count[i] += count[i - 1];
         }
         else
         {
             for (int i = 8; i >= 0; i--)
                 count[i] += count[i + 1];
         }
         for (int i = n - 1; i >= 0; i--)
         {
             output[count[(arr[i] / exp) % 10] - 1] = arr[i];
             count[(arr[i] / exp) % 10]--;
         }
         for (int i = 0; i < n; i++)
         {
             arr[i] = output[i];
             addstepRS(i, arr[i], -1, -1, 2, null);
         }
         addstepRS(-1, -1, -1, -1, 3, null);
     }
	public boolean checkTangDan()
	{
		for(int i=0;i<len-1;i++)
		{
			if(arr[i]>arr[i+1])
				return false;
		}
		return true;
	}
	public void CodeIS(int check)
    {
        model.addElement("for (int i = 0 ; i < N-1 ; i++)");
        model.addElement("    for(int j = i + 1; j < N ; j++)");
        if (check == 1)
        {
            model.addElement("        if(arr[j] < arr[i])");
        }
        else
        {
            model.addElement("        if(arr[j] > arr[i])");
        }
        model.addElement("           Swap(arr[i], arr[j]);");
    }
	public void CodeSS(int check)
	{
        model.addElement("for (i = 0; i < N-1 ; i++)");
        model.addElement("{");
        model.addElement("    int min = i;");
        model.addElement("    for(j = i + 1; j < N ; j++)");
        if (check == 1)
        {
            model.addElement("        if(arr[j] < arr[min])");
        }
        else
        {
            model.addElement("        if(arr[j] > arr[min])");
        }
        model.addElement("            min = j;");
        model.addElement("    if (min!=i)");
        model.addElement("        Swap(arr[min],arr[i]);");
        model.addElement("}");
	}
	public void CodeBS(int check)
	{
		model.addElement("for (int i = 0 ; i<N-1 ; i++)");
        model.addElement("     for (int j = N - 1; j > i ; j --)");
        if (check == 1)
        {
            model.addElement("          if(arr[j] < arr[j-1])");
        }
        else
        {
            model.addElement("          if(arr[j] > arr[j-1])");
        }
        model.addElement("               Swap(arr[j], arr[j-1]);");
	}
	public void CodeInS(int check)
	{
		model.addElement("for(int i=1 ; i<n ; i++)\n{");
        model.addElement("        int x = arr[i];");
        model.addElement("        int pos = i-1;");
        if (check == 1)
        {
            model.addElement("        while((pos >= 0)&&(arr[pos] > x))");
        }
        else
        {
            model.addElement("        while((pos >= 0)&&(arr[pos] < x))");
        }
        model.addElement("        {");
        model.addElement("              arr[pos+1] = arr[pos];");
        model.addElement("              pos--;");
        model.addElement("        }");
        model.addElement("        arr[pos+1] = x;");
        model.addElement("}");
	}
	public void CodeQS(int check)
	{
		 model.addElement("int partition(int []arr,int low,int high)\n{");
         model.addElement("      int pivot = arr[high];");
         model.addElement("      int i = (low - 1);");
         model.addElement("      for (int j = low; j < high; j++)");
         model.addElement("      {");
         if (check == 1)
         {
             model.addElement("            if (arr[j] <= pivot)");
         }
         else
         {
             model.addElement("            if (arr[j] >= pivot)");
         }
         model.addElement("            {");
         model.addElement("                  i++;");
         model.addElement("                  Swap(arr[i],arr[j]);");
         model.addElement("            }");
         model.addElement("      }");
         model.addElement("      Swap(temp1,arr[i+1]);");
         model.addElement("      return i+1;");
         model.addElement("}");
         model.addElement("");
         model.addElement("");
         model.addElement("void quickSort(int []arr, int low, int high)\n{");
         model.addElement("      if (low < high)");
         model.addElement("      {");
         model.addElement("           int pivot = partition(arr, low, high);");
         model.addElement("           quickSort(arr, low, pivot-1);");
         model.addElement("           quickSort(arr, pivot+1, high);");
         model.addElement("      }");
         model.addElement("}");
	}
	public void CodeShS(int check)
	{
		model.addElement("int left = 0, right = arr.Length - 1, k = arr.Length - 1;");
        model.addElement("while (left<right)");
        model.addElement("{");
        model.addElement("           for (int j = right; j > left; j--)");
        model.addElement("           {");
        if (check == 1)
        {
            model.addElement("                      if (arr[j] < arr[j - 1])");
        }
        else
        {
            model.addElement("                      if (arr[j] > arr[j - 1])");
        }
        model.addElement("                      {");
        model.addElement("                                Swap(arr[j],arr[j-1]);");
        model.addElement("                                k=j;");
        model.addElement("                      }");
        model.addElement("           }");
        model.addElement("           left=k;");
        model.addElement("           for (int j = left; j > right; j++)");
        model.addElement("           {");
        if (check == 1)
        {
            model.addElement("                      if (arr[j] > arr[j + 1])");
        }
        else
        {
            model.addElement("                      if (arr[j] < arr[j + 1])");
        }
        model.addElement("                      {");
        model.addElement("                                Swap(arr[j],arr[j+1]);");
        model.addElement("                                k=j;");
        model.addElement("                      }");
        model.addElement("           }");
        model.addElement("           right=k;");
        model.addElement("}");
	}
	public void CodeRdS(int check)
	{
		model.addElement("static void radixsort(int []arr,int n)\n{");
        model.addElement("      int m = getMax(arr, n);");
        model.addElement("      for (int exp = 1; m / exp > 0; exp *= 10)");
        model.addElement("      {");
        model.addElement("            countSort(arr, n, exp);");
        model.addElement("      }");
        model.addElement("}");
        model.addElement("static int getMax(int []arr,int n)\n{");
        model.addElement("      int mx = arr[0];");
        model.addElement("      for (int i = 1; i < n; i++)");
        model.addElement("            if (arr[i] > mx)");
        model.addElement("                 mx = arr[i];");
        model.addElement("return mx;");
        model.addElement("}");
        model.addElement("static void countSort(int []arr, int n, int exp)\n{");
        model.addElement("      int[] output = new int[n];");
        model.addElement("      int[] count = new int[10];");
        model.addElement("      for (int i = 0; i < n; i++)");
        model.addElement("            count[(arr[i] / exp) % 10]++;");
        if (check == 1)
        {
            model.addElement("      for (int i = 1; i < 10; i++)");
            model.addElement("            count[i] += count[i - 1];");
        }
        else
        {
            model.addElement("      for (int i = 8; i >= 0; i--)");
            model.addElement("            count[i] += count[i + 1];");
        }
        model.addElement("      for (int i = n - 1; i >= 0; i--)");
        model.addElement("      {");
        model.addElement("            output[count[(arr[i] / exp) % 10] - 1] = arr[i];");
        model.addElement("            count[(arr[i] / exp) % 10]--;");
        model.addElement("      }");
        model.addElement("      for (int i = 0; i < n; i++)");
        model.addElement("      {");
        model.addElement("            arr[i] = output[i];");
        model.addElement("      }");
        model.addElement("}");
	}
	public void CodeBiS()
	{
		model.addElement("int left, right, mid; left=0; right=N-1;");
        model.addElement("do{ ");
        model.addElement("           mid=(left+right)/2;");
        model.addElement("           if(arr[mid]==x) return 1;");
        model.addElement("           else if(arr[mid]<x) left=mid+1;");
        model.addElement("                      else if(arr[mid]>x) right=mid-1;");
        model.addElement("}while(left<=right);");
        model.addElement("return 0;");
	}
	public void CodeLiS()
	{
		 model.addElement("for (int i = 0 ; i < N-1 ; i++)");
         model.addElement("        if(arr[i]==search)");
         model.addElement("           return 1;");
         model.addElement("return 0;");
	}
	
}
