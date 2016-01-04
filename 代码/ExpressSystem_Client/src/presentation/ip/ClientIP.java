package presentation.ip;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import presentation.MainFrame;
import client.RMIHelper;

public  class ClientIP extends JFrame {
   
	
	JPanel jp;
	JLabel jl;
	JTextField jtf[];
	JButton jb;
	JLabel jl2;
	JTextField jtf2;
  JButton jbg;
	RemindIP remind;
	JPanel jp_remind;
	boolean ip_right = true;
	
	JLayeredPane layeredPane;  
	JLabel jlbg;

	public ClientIP() {


        
		jp = new JPanel();
		jl = new JLabel("IP地址：");
		jl.setFont(new Font("宋体",Font.PLAIN,15));
		jtf = new JTextField[4];
		for (int i = 0; i < 4; i++) {
			jtf[i] = new JTextField();
		}
		jb = new JButton("");//连接
		jl2 = new JLabel("端口：");
		jl2.setFont(new Font("宋体",Font.PLAIN,15));
		jtf2 = new JTextField();
		
		//jbg=new JButton();
		//layeredPane=new JLayeredPane();  

		init();
		this.add(jp);
		this.setSize(300, 500);
		this.setLocation(200, 100);
		this.setLayout(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);

	}

	
	private void init() {
	   jp.setBounds(0, 0, 300, 500);
		jp.setLayout(null);
		jp.setBackground(new Color(174,205,207));
		
        ImageIcon image=new ImageIcon("pictures\\ip.png");//随便找一张图就可以看到效果。        
        //创建背景的那些东西  
       // jp.setBounds(0,0,300,500);  
//  
//        jlbg=new JLabel(image);       
//        jlbg.setBounds(0,0,300,500);  
//        jp.add(jlbg);  
//        layeredPane.add(jp,JLayeredPane.DEFAULT_LAYER);  
         
		jl.setBounds(25, 100, 100, 25);
		for (int i = 0; i < 4; i++) {
			jtf[i].setBounds(100 + 35 * i, 100, 33, 25);
			jtf[i].addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent e) {
					if (!Character.isDigit(e.getKeyChar())) {
						e.consume();
					}
				}

			});
		}

		jtf[0].addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_RIGHT) {
					jtf[1].requestFocus();
				}
			}
		});
		jtf[1].addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_RIGHT) {
					jtf[2].requestFocus();
				}
			}
		});
		jtf[2].addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_RIGHT) {
					jtf[3].requestFocus();
				}
			}
		});
		jtf[3].addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					jtf[2].requestFocus();
				}
			}
		});
		jtf[2].addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					jtf[1].requestFocus();
				}
			}
		});
		jtf[1].addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					jtf[0].requestFocus();
				}
			}
		});
		jb.setBounds(82, 300, 85, 35);
		ImageIcon icon1 = new ImageIcon("pictures//连接.png");
		Image temp1 = icon1.getImage().getScaledInstance(icon1.getIconWidth(),
				icon1.getIconHeight(), icon1.getImage().SCALE_DEFAULT);
		icon1 = new ImageIcon(temp1);
		jb.setIcon(icon1);
		
		jb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == jb) {

					String ip = "";
					for (int i = 0; i < 4; i++) {
						// if (i != 3)
						// ip += (jtf[i].getText() + ".");
						// else
						// ip += jtf[i].getText();
						String temp = jtf[i].getText();
						int a = Integer.valueOf(temp);
						if (i != 3) {
							ip += "" + a + ".";
						} else {
							ip += "" + a;
						}

					}

					System.out.println("开启ip");
					System.out.println("IP:" + ip);
					String port = jtf2.getText();
					// 根据连接情况设置是否正确
					ip_right = true;

					if (RMIHelper.init(ip, port)) {
						closeFrame();

						try {
							org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();

						} catch (Exception e1) {
							// TODO exception
						}

						// 这个包只能在下面的线程里改变他的frame属性，不然会报错

						SwingUtilities.invokeLater(new Runnable() {

							@Override
							public void run() {
								// TODO Auto-generated method stub
								MainFrame m = new MainFrame();
								m.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
								// m.setUndecorated(true);
								// 用来消除上面的属性栏

							}
						});
					} else {
						jp_remind = new JPanel();
						remind = new RemindIP(jp_remind, "IP错误");
						jp.add(jp_remind);
						remind.start();
						jtf2.setText("");
						for (int i = 0; i < jtf.length; i++) {
							jtf[i].setText("");
						}
					}

				}
			}
		});

		jl2.setBounds(25, 200, 50, 25);
		jtf2.setBounds(100, 200, 100, 25);
		jtf2.setEditable(true);

		jp.add(jl);
		for (int i = 0; i < 4; i++) {
			jp.add(jtf[i]);
		}
		jp.add(jb);
		jp.add(jl2);
		jp.add(jtf2);

	}

	private void closeFrame() {
		this.dispose();
	}

	public static void main(String[] arg0) {

		
		try {
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
		} catch (Exception e1) {
			// TODO exception
		}
			
   ClientIP ip=new ClientIP();
   
	}

}
