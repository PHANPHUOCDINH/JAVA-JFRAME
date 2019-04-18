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

public class Form1 extends JFrame {

	private JPanel contentPane,panelThuatToan,panelChieuSapXep;
	private JMenuBar menuBar;
	private JMenu menuCaiDat,menuGioiThieu;
	private JMenuItem chonMau;
	private JRadioButton radioButtonNhap,radioButtonRandom,radiobuttonIS,radiobuttonQS,radiobuttonSS,radiobuttonShS,radiobuttonBS,radiobuttonRdS,radiobuttonInsS,radioButton7,radiobuttonGiamDan,radiobuttonTangDan;
	private ButtonGroup buttonGroup1,buttonGroup2,buttonGroup3;
	private JButton btnChonFile,buttonRandom,buttonTaoNut,buttonTiepTuc,buttonTaoLai,buttonStart,listbut[];
	private JComboBox comboBoxFile,comboBoxRandom;
	private JLabel labelNhapSo,labelRandom,labelRandom1,labelCode,labelindex[],labeli,labelk,labelj,labelLink,labelmin;
	private JTextField textSo,textRandom;
	private int arr[],len,xpos[],tang_giam;
	private Timer timer;
	private JButton buttonStop;
	private Color color=Color.white;
	private List<Step> list= new ArrayList<Step>();
	private int start = 0, green = 0, yellow = 0,indexstep=0,y1=460,y2=380,speed=5,start_khoi_tao=0,orange=0,purple=0;
	private JList<String> thuattoan;
	private JScrollPane scrollPane;
	private DefaultListModel<String> model= new DefaultListModel<>();
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
		radiobuttonIS.setSelected(true);
		radiobuttonIS.setFont(new Font("Tahoma", Font.PLAIN, 15));
		radiobuttonIS.setBounds(6, 19, 135, 23);
		panelThuatToan.add(radiobuttonIS);
		
		radiobuttonQS = new JRadioButton("Quick Sort");
		radiobuttonQS.setFont(new Font("Tahoma", Font.PLAIN, 15));
		radiobuttonQS.setBounds(161, 19, 135, 23);
		panelThuatToan.add(radiobuttonQS);
		
		radiobuttonSS = new JRadioButton("Selection Sort");
		radiobuttonSS.setFont(new Font("Tahoma", Font.PLAIN, 15));
		radiobuttonSS.setBounds(6, 62, 135, 23);
		panelThuatToan.add(radiobuttonSS);
		
		radiobuttonShS = new JRadioButton("Shaker Sort");
		radiobuttonShS.setFont(new Font("Tahoma", Font.PLAIN, 15));
		radiobuttonShS.setBounds(161, 62, 135, 23);
		panelThuatToan.add(radiobuttonShS);
		
		radiobuttonBS = new JRadioButton("Bubble Sort");
		radiobuttonBS.setFont(new Font("Tahoma", Font.PLAIN, 15));
		radiobuttonBS.setBounds(6, 107, 135, 23);
		panelThuatToan.add(radiobuttonBS);
		
		radiobuttonRdS = new JRadioButton("Radix Sort");
		radiobuttonRdS.setFont(new Font("Tahoma", Font.PLAIN, 15));
		radiobuttonRdS.setBounds(161, 107, 135, 23);
		panelThuatToan.add(radiobuttonRdS);
		
		radiobuttonInsS = new JRadioButton("Insertion Sort");
		radiobuttonInsS.setFont(new Font("Tahoma", Font.PLAIN, 15));
		radiobuttonInsS.setBounds(6, 147, 135, 23);
		panelThuatToan.add(radiobuttonInsS);
		
		radioButton7 = new JRadioButton("Selection Sort");
		radioButton7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		radioButton7.setBounds(161, 147, 135, 23);
		panelThuatToan.add(radioButton7);
		
		buttonGroup2= new ButtonGroup();
		buttonGroup2.add(radiobuttonIS);
		buttonGroup2.add(radiobuttonQS);
		buttonGroup2.add(radiobuttonSS);
		buttonGroup2.add(radiobuttonShS);
		buttonGroup2.add(radiobuttonBS);
		buttonGroup2.add(radiobuttonRdS);
		buttonGroup2.add(radiobuttonInsS);
		buttonGroup2.add(radioButton7);
		
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
		
		buttonTaoLai = new JButton("Tạo Lại");
		buttonTaoLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				labelLink.setVisible(false);
				green=yellow=orange=start=start_khoi_tao=indexstep=0;
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
				model.removeAllElements();
				thuattoan=null;
				listbut=null;
				labelindex=null;
				xpos=null;
				textRandom.setText(null);
				textSo.setText(null);
				buttonStart.setVisible(true);
				timer.stop();
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
					buttonStart.setVisible(false);
					buttonStop.setVisible(true);
					thuattoan=new JList<>(model);
					thuattoan.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					thuattoan.setFont(new Font("Monospaced",Font.BOLD,14));
					scrollPane.setViewportView(thuattoan);
					timer= new Timer(8,new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							if(start<50)
							{
								start++;
							}
							else
							{
								if(indexstep<list.size())
								{
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
									indexstep=0;
									start=yellow=0;
									labeli.setVisible(false);
									labelj.setVisible(false);
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
					buttonStart.setVisible(false);
					buttonStop.setVisible(true);
					thuattoan=new JList<>(model);
					thuattoan.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					thuattoan.setFont(new Font("Monospaced",Font.BOLD,14));
					scrollPane.setViewportView(thuattoan);
					timer=new Timer(10, new ActionListener() {
				
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							if (start_khoi_tao < 57)
							{
				                start_khoi_tao++;
				            }
				            {
				                if (start < 68)
				                {
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
				                        	labelj.setLocation(xpos[list.get(indexstep).index2] + 27, 580);
				                        	labelmin.setLocation(xpos[list.get(indexstep).para1] + 19, 580);
				                        	labelj.setVisible(true);
				                        	labelmin.setVisible(true);
				                            listbut[list.get(indexstep).para1].setBackground(Color.yellow);
				                            listbut[list.get(indexstep).index2].setBackground(Color.yellow);
				                            if (yellow < 80)
				                            {
				                                yellow++;
				                            }
				                            else
				                            {
				                                if (list.get(indexstep).check == 0)
				                                {
				                                    listbut[list.get(indexstep).para1].setBackground(Color.green);
				                                    listbut[list.get(indexstep).index2].setBackground(Color.green);
				                                    if (green < 80)
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
				                                    }
				                                }
				                                else
				                                {
				                                    listbut[list.get(indexstep).para1].setBackground(Color.orange);
				                                    listbut[list.get(indexstep).index2].setBackground(Color.orange);
				                                    if (orange < 80)
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
				                                    }
				                                }
				                            }
				                        }
				                        else
				                        {
				                            labelmin.setLocation(xpos[list.get(indexstep).para1] + 19, 580); 
				                            listbut[list.get(indexstep).para1].setBackground(Color.yellow);
				                            listbut[list.get(indexstep).index1].setBackground(Color.yellow);
				                            if (yellow < 65)
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
				                                                start = 0;
				                                                yellow = 0;
				                                            }
				                                        }
				                                    }
				                                }
				                                else
				                                {
				                                    listbut[list.get(indexstep).index1].setBackground(Color.green);
				                                    listbut[list.get(indexstep).para1].setBackground(Color.green);
				                                    if (green < 80)
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
				                                    }
				                                }
				                            }
				                        }
				                    }
				                    else
				                    {
				                    	indexstep=0;
										start=yellow=0;
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
				            }
				            else
				            {
				                if (start < 58)
				                    start++;
				                else
				                {
				                    if (indexstep < list.size())
				                    {
				                        labeli.setLocation(xpos[list.get(indexstep).index1] + 41, 535);
				                        labeli.setVisible(true);
				                        labelj.setLocation(xpos[list.get(indexstep).Xleft] + 41, 565);
				                        labelj.setVisible(true);
				                        if (arr.length - 1 == list.get(indexstep).Xleft)
				                        {
				                        	
				                        }
				                        else
				                        {

				                        }
				                        listbut[list.get(indexstep).index1].setBackground(Color.magenta);
				                        if (purple < 58)
				                            purple++;
				                        else
				                        {
				                            listbut[list.get(indexstep).index2].setBackground(Color.yellow);
				                            listbut[list.get(indexstep).Xleft].setBackground(Color.yellow);
				                            if (yellow < 60)
				                            {
				                                yellow++;
				                            }
				                            else
				                            {
				                                if (list.get(indexstep).Xright == 1)
				                                {
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
				                                                y1 = 480; y2 = 400;
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
				                        timer.stop();
				                    }
				                }
				            }
						}
					});
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
		panelChieuSapXep.setBounds(545, 190, 320, 70);
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
		labeli.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labeli.setBounds(325, 198, 12, 22);
		labeli.setVisible(false);
		contentPane.add(labeli);
		
		labelk = new JLabel("k");
		labelk.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelk.setBounds(390, 198, 12, 22);
		labelk.setVisible(false);
		contentPane.add(labelk);
		
		labelj = new JLabel("j");
		labelj.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelj.setBounds(431, 198, 12, 22);
		labelj.setVisible(false);
		contentPane.add(labelj);
		
		labelmin = new JLabel("min");
		labelmin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelmin.setBounds(468, 198, 30, 21);
		labelmin.setVisible(false);
		contentPane.add(labelmin);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(872, 31, 478, 335);
		contentPane.add(scrollPane);
		
		labelLink = new JLabel("Click here for more information");
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
		labelLink.setBounds(559, 659, 230, 21);
		labelLink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		labelLink.setVisible(false);
		contentPane.add(labelLink);
		
		
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
	public void CodeIS(int check)
    {
        model.addElement("for (int i = 0 ; i < N-1 ; i++)");
        model.addElement("    for(int j = i + 1; j < N ; j++)");
        if (check == 1)
        {
            model.addElement("        if(a[j] < a[i])");
        }
        else
        {
            model.addElement("        if(a[j] > a[i])");
        }
        model.addElement("           Swap(a[i], a[j]);");
    }
	public void CodeSS(int check)
	{
        model.addElement("for (i = 0; i < N-1 ; i++)");
        model.addElement("{");
        model.addElement("    int min = i;");
        model.addElement("    for(j = i + 1; j < N ; j++)");
        if (check == 1)
        {
            model.addElement("        if(a[j] < a[min])");
        }
        else
        {
            model.addElement("        if(a[j] > a[min])");
        }
        model.addElement("            min = j;");
        model.addElement("    if (min!=i)");
        model.addElement("        Swap(a[min],a[i]);");
        model.addElement("}");
	}
	public void CodeBS(int check)
	{
		model.addElement("for (int i = 0 ; i<N-1 ; i++)");
        model.addElement("     for (int j = N - 1; j > i ; j --)");
        if (check == 1)
        {
            model.addElement("          if(a[j] < a[j-1])");
        }
        else
        {
            model.addElement("          if(a[j] > a[j-1])");
        }
        model.addElement("               Swap(a[j], a[j-1]);");
	}
}
