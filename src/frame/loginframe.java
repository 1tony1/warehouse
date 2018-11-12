package frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import frame.mainframe;
import sql.sqlmess;

import frame.MyPanel;

public class loginframe extends JFrame {
	
	static JTextField text1 = new JTextField();
	static JPasswordField pass = new JPasswordField();

	public loginframe(){
		
		setTitle("请  登  录");
		setBounds(680, 350, 500, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container con = getContentPane();
		
		MyPanel jj = new MyPanel(this.getClass().getResource("/img/5.jpg"));
		con.add(jj,BorderLayout.CENTER);
		jj.setOpaque(false);
		
		
jj.setLayout(new GridBagLayout());
		
		JButton button1 = new JButton("登录");
		JButton button2 = new JButton("重置");
		JLabel l1 = new JLabel("账户名称:");
		JLabel l2 = new JLabel("账户密码:");
		
		text1.setColumns(15);
		pass.setColumns(15);
		
		text1.setOpaque(false);
		pass.setOpaque(false);
		
		GridBagConstraints g1 = new GridBagConstraints();
		g1.gridy=0;
		g1.gridx=0;
		g1.insets = new Insets(0, 80, 20, 0);
		
		jj.add(l1,g1);
		
		GridBagConstraints g2 = new GridBagConstraints();
		g2.gridy=0;
		g2.gridx=1;
		g2.insets = new Insets(0, 0, 20, 60);
		
		jj.add(text1,g2);
		
		GridBagConstraints g3 = new GridBagConstraints();
		g3.gridy=1;
		g3.gridx=0;
		g3.insets = new Insets(0, 80, 20, 0);
		
		jj.add(l2,g3);
		
		GridBagConstraints g4 = new GridBagConstraints();
		g4.gridy=1;
		g4.gridx=1;
		g4.insets = new Insets(0, 0, 20, 60);
		
		jj.add(pass,g4);
		
		
		JPanel pp = new JPanel();
		pp.setOpaque(false);
		pp.add(button1);
		pp.add(button2);
		
		GridBagConstraints g5 = new GridBagConstraints();
		g5.gridy=2;
		g5.gridx=1;	
		g5.insets = new Insets(0, 0, 0, 100);
		
		jj.add(pp,g5);
//===========================================================================================================
button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
//			System.out.println("12");
				String name = text1.getText();
				String pass1 = pass.getText();
				if (name.equals("")||pass1.equals("")){
					JOptionPane.showMessageDialog(null, "请输入用户名称或密码！","信息提示",JOptionPane.INFORMATION_MESSAGE);
				}
				else{
					sqlmess sql = new sqlmess();
					boolean tt = sql.login(name, pass1);
						if (!tt) {
							JOptionPane.showMessageDialog(null, "用户名称或密码错误！","信息提示",JOptionPane.INFORMATION_MESSAGE);
						}
						else{
							JOptionPane.showMessageDialog(null, "登陆成功，即将跳入主界面！","信息提示",JOptionPane.INFORMATION_MESSAGE);
							showmain();
						}
				}
			}
		});
		
		button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				text1.setText("");
				pass.setText("");
				
			}
		});
		
		setVisible(true);
		
		Mylistener my=new Mylistener();
		text1.addKeyListener(my);
		pass.addKeyListener(my);
		
	}
	
	protected void showmain() {
		mainframe main = new mainframe();
		setVisible(false);
		
	}
	public static void main(String[] args) {
		
		loginframe login = new loginframe();
		
	}
	
	
	class Mylistener implements  KeyListener {
		
		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void keyPressed(KeyEvent arg0) {
			if(arg0.getKeyChar() == KeyEvent.VK_ENTER )
			{
				String name = loginframe.text1.getText();
				String pass1 = loginframe.pass.getText();
				if (name.equals("")||pass1.equals("")){
					JOptionPane.showMessageDialog(null, "请输入用户名称或密码！","信息提示",JOptionPane.INFORMATION_MESSAGE);
				}
				else{
					sqlmess sql = new sqlmess();
					boolean tt = sql.login(name, pass1);
						if (!tt) {
							JOptionPane.showMessageDialog(null, "用户名称或密码错误！","信息提示",JOptionPane.INFORMATION_MESSAGE);
						}
						else{
							JOptionPane.showMessageDialog(null, "登陆成功，即将跳入主界面！","信息提示",JOptionPane.INFORMATION_MESSAGE);
							showmain();
						}
				}
			}

			
		}
	}
	
}
