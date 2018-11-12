package frame;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import frame.mainframe;
import sql.sqlmess;

public class AddFrame extends JFrame{

	mainframe mainFrame = null;
	public void AddUsersFrame(mainframe ff){
		mainFrame = ff;
		setTitle("¼���û�");
		setBounds(760, 230, 400, 600);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Container con = getContentPane();
		
		JLabel l1 = new JLabel("�� �� id:");
		JLabel l2 = new JLabel("�û�����:");
		JLabel l3 = new JLabel("�û��Ա�:");
		JLabel l4 = new JLabel("�û�����:");
		JLabel l5 = new JLabel("��������:");
		JLabel l6 = new JLabel("�û�����:");
		JButton but1 = new JButton("¼���û�");
		JTextField text1 = new JTextField();
		text1.setColumns(15);
		JTextField text2 = new JTextField();
		text2.setColumns(15);
		JTextField text3 = new JTextField();
		text3.setColumns(15);
		JTextField text4 = new JTextField();
		text4.setColumns(15);
		JTextField text5 = new JTextField();
		text5.setColumns(15);
		JTextField text6 = new JTextField();
		text6.setColumns(15);
		
		JPanel jj = new JPanel();
		con.add(jj,BorderLayout.CENTER);
		jj.setOpaque(false);
		jj.setLayout(new GridBagLayout());
		
		GridBagConstraints g1 = new GridBagConstraints();
		g1.gridy=0;
		g1.gridx=0;
		g1.insets = new Insets(0, 0, 40, 20);
		jj.add(l1,g1);
		
		GridBagConstraints g2 = new GridBagConstraints();
		g2.gridy=0;
		g2.gridx=1;
		g2.insets = new Insets(0, 0, 40, 0);
		jj.add(text1,g2);
		
		GridBagConstraints g3 = new GridBagConstraints();
		g3.gridy=1;
		g3.gridx=0;
		g3.insets = new Insets(0, 0, 40, 20);
		jj.add(l2,g3);
		
		GridBagConstraints g4 = new GridBagConstraints();
		g4.gridy=1;
		g4.gridx=1;
		g4.insets = new Insets(0, 0, 40, 0);
		jj.add(text2,g4);
		
		GridBagConstraints g5 = new GridBagConstraints();
		g5.gridy=2;
		g5.gridx=0;
		g5.insets = new Insets(0, 0, 40, 20);
		jj.add(l3,g5);
		
		GridBagConstraints g6 = new GridBagConstraints();
		g6.gridy=2;
		g6.gridx=1;
		g6.insets = new Insets(0, 0, 40, 0);
		jj.add(text3,g6);
		
		GridBagConstraints g7 = new GridBagConstraints();
		g7.gridy=3;
		g7.gridx=0;
		g7.insets = new Insets(0, 0, 40, 20);
		jj.add(l4,g7);
		
		GridBagConstraints g8 = new GridBagConstraints();
		g8.gridy=3;
		g8.gridx=1;
		g8.insets = new Insets(0, 0, 40, 0);
		jj.add(text4,g8);
		
		GridBagConstraints g9 = new GridBagConstraints();
		g9.gridy=4;
		g9.gridx=0;
		g9.insets = new Insets(0, 0, 40, 20);
		jj.add(l5,g9);
		
		GridBagConstraints g10 = new GridBagConstraints();
		g10.gridy=4;
		g10.gridx=1;
		g10.insets = new Insets(0, 0, 40, 0);
		jj.add(text5,g10);
		
		GridBagConstraints g11 = new GridBagConstraints();
		g11.gridy=5;
		g11.gridx=0;
		g11.insets = new Insets(0, 0, 40, 20);
		jj.add(l6,g11);
		
		GridBagConstraints g12 = new GridBagConstraints();
		g12.gridy=5;
		g12.gridx=1;
		g12.insets = new Insets(0, 0, 40, 0);
		jj.add(text6,g12);
		
		GridBagConstraints g13 = new GridBagConstraints();
		g13.gridy=6;
		g13.gridx=1;
		g13.insets = new Insets(0, 0, 0, 90);
		jj.add(but1,g13);
		
		but1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String id = text1.getText();
				String username = text2.getText();
				String sex = text3.getText();
				String age = text4.getText();
				String hiredate = text5.getText();
				String typrs = text6.getText();
				
				
				
				
				
				if (id.equals("")||username.equals("")||sex.equals("")||age.equals("")||hiredate.equals("")||typrs.equals("")){
					
					JOptionPane.showMessageDialog(null, "����������ȫ����Ϣ��","��Ϣ��ʾ",JOptionPane.INFORMATION_MESSAGE);
					
				}
				else {
					
					Map map = new HashMap();
					map.put("id",id);
					map.put("username",username);
					map.put("sex",sex);
					map.put("age",age);
					map.put("hiredate",hiredate);
					map.put("typrs",typrs);
					
					sqlmess sql = new sqlmess();
					boolean tt = sql.addUser(map);
					if(tt){
						
						JOptionPane.showMessageDialog(null, "¼��ɹ���","��Ϣ��ʾ",JOptionPane.INFORMATION_MESSAGE);
						setVisible(false);
						ff.updateusers();
						
					}
					else {
						JOptionPane.showMessageDialog(null, "��ǰ�û��Ѵ��ڣ������ԣ�","��Ϣ��ʾ",JOptionPane.INFORMATION_MESSAGE);
					}
					
					
				}
				
			}
		});
		
		
		setVisible(true);
		
	}
	
	public void AddMusicFrame(mainframe ff){
		mainFrame = ff;
		setTitle("¼��������Ϣ");
		setBounds(760, 230, 400, 600);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Container con = getContentPane();
		
		JLabel l1 = new JLabel("�� �� id:");
		JLabel l2 = new JLabel("��������:");
		JLabel l3 = new JLabel("��������:");
		JLabel l4 = new JLabel("�ϴ��û�:");
		JLabel l5 = new JLabel("���Ŵ���:");
		JLabel l6 = new JLabel("�ļ���С:");
		JButton but1 = new JButton("¼��������Ϣ");
		JTextField text1 = new JTextField();
		text1.setColumns(15);
		JTextField text2 = new JTextField();
		text2.setColumns(15);
		JTextField text3 = new JTextField();
		text3.setColumns(15);
		JTextField text4 = new JTextField();
		text4.setColumns(15);
		JTextField text5 = new JTextField();
		text5.setColumns(15);
		JTextField text6 = new JTextField();
		text6.setColumns(15);
		
		JPanel jj = new JPanel();
		con.add(jj,BorderLayout.CENTER);
		jj.setOpaque(false);
		jj.setLayout(new GridBagLayout());
		
		GridBagConstraints g1 = new GridBagConstraints();
		g1.gridy=0;
		g1.gridx=0;
		g1.insets = new Insets(0, 0, 40, 20);
		jj.add(l1,g1);
		
		GridBagConstraints g2 = new GridBagConstraints();
		g2.gridy=0;
		g2.gridx=1;
		g2.insets = new Insets(0, 0, 40, 0);
		jj.add(text1,g2);
		
		GridBagConstraints g3 = new GridBagConstraints();
		g3.gridy=1;
		g3.gridx=0;
		g3.insets = new Insets(0, 0, 40, 20);
		jj.add(l2,g3);
		
		GridBagConstraints g4 = new GridBagConstraints();
		g4.gridy=1;
		g4.gridx=1;
		g4.insets = new Insets(0, 0, 40, 0);
		jj.add(text2,g4);
		
		GridBagConstraints g5 = new GridBagConstraints();
		g5.gridy=2;
		g5.gridx=0;
		g5.insets = new Insets(0, 0, 40, 20);
		jj.add(l3,g5);
		
		GridBagConstraints g6 = new GridBagConstraints();
		g6.gridy=2;
		g6.gridx=1;
		g6.insets = new Insets(0, 0, 40, 0);
		jj.add(text3,g6);
		
		GridBagConstraints g7 = new GridBagConstraints();
		g7.gridy=3;
		g7.gridx=0;
		g7.insets = new Insets(0, 0, 40, 20);
		jj.add(l4,g7);
		
		GridBagConstraints g8 = new GridBagConstraints();
		g8.gridy=3;
		g8.gridx=1;
		g8.insets = new Insets(0, 0, 40, 0);
		jj.add(text4,g8);
		
		GridBagConstraints g9 = new GridBagConstraints();
		g9.gridy=4;
		g9.gridx=0;
		g9.insets = new Insets(0, 0, 40, 20);
		jj.add(l5,g9);
		
		GridBagConstraints g10 = new GridBagConstraints();
		g10.gridy=4;
		g10.gridx=1;
		g10.insets = new Insets(0, 0, 40, 0);
		jj.add(text5,g10);
		
		GridBagConstraints g11 = new GridBagConstraints();
		g11.gridy=5;
		g11.gridx=0;
		g11.insets = new Insets(0, 0, 40, 20);
		jj.add(l6,g11);
		
		GridBagConstraints g12 = new GridBagConstraints();
		g12.gridy=5;
		g12.gridx=1;
		g12.insets = new Insets(0, 0, 40, 0);
		jj.add(text6,g12);
		
		GridBagConstraints g13 = new GridBagConstraints();
		g13.gridy=6;
		g13.gridx=1;
		g13.insets = new Insets(0, 0, 0, 90);
		jj.add(but1,g13);
		
		but1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String id = text1.getText();
				String name = text2.getText();
				String type = text3.getText();
				String uploader = text4.getText();
				String amount = text5.getText();
				String sizes = text6.getText();
				
				
				
				
				
				if (id.equals("")||name.equals("")||type.equals("")||uploader.equals("")||amount.equals("")||sizes.equals("")){
					
					JOptionPane.showMessageDialog(null, "����������ȫ����Ϣ��","��Ϣ��ʾ",JOptionPane.INFORMATION_MESSAGE);
					
				}
				else {
					
					Map map = new HashMap();
					map.put("id",id);
					map.put("name",name);
					map.put("type",type);
					map.put("uploader",uploader);
					map.put("amount",amount);
					map.put("sizes",sizes);
					
					sqlmess sql = new sqlmess();
					boolean tt = sql.addMusic(map);
					if(tt){
						
						JOptionPane.showMessageDialog(null, "¼��ɹ���","��Ϣ��ʾ",JOptionPane.INFORMATION_MESSAGE);
						setVisible(false);
						ff.updatemusic();
						
					}
					else {
						JOptionPane.showMessageDialog(null, "��ǰ������Ϣ�Ѵ��ڣ������ԣ�","��Ϣ��ʾ",JOptionPane.INFORMATION_MESSAGE);
					}
					
					
				}
				
			}
		});
		
		
		setVisible(true);
		
	}

	public void AddGameFrame(mainframe ff){
		mainFrame = ff;
		setTitle("¼����Ϸ��Ϣ");
		setBounds(760, 230, 400, 600);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Container con = getContentPane();
		
		JLabel l1 = new JLabel("�� Ϸ id:");
		JLabel l2 = new JLabel("��Ϸ����:");
		JLabel l3 = new JLabel("��Ϸ����:");
		JLabel l4 = new JLabel("�ϴ��û�:");
		JLabel l5 = new JLabel("�������:");
		JLabel l6 = new JLabel("�ļ���С:");
		JButton but1 = new JButton("¼����Ϸ��Ϣ");
		JTextField text1 = new JTextField();
		text1.setColumns(15);
		JTextField text2 = new JTextField();
		text2.setColumns(15);
		JTextField text3 = new JTextField();
		text3.setColumns(15);
		JTextField text4 = new JTextField();
		text4.setColumns(15);
		JTextField text5 = new JTextField();
		text5.setColumns(15);
		JTextField text6 = new JTextField();
		text6.setColumns(15);
		
		JPanel jj = new JPanel();
		con.add(jj,BorderLayout.CENTER);
		jj.setOpaque(false);
		jj.setLayout(new GridBagLayout());
		
		GridBagConstraints g1 = new GridBagConstraints();
		g1.gridy=0;
		g1.gridx=0;
		g1.insets = new Insets(0, 0, 40, 20);
		jj.add(l1,g1);
		
		GridBagConstraints g2 = new GridBagConstraints();
		g2.gridy=0;
		g2.gridx=1;
		g2.insets = new Insets(0, 0, 40, 0);
		jj.add(text1,g2);
		
		GridBagConstraints g3 = new GridBagConstraints();
		g3.gridy=1;
		g3.gridx=0;
		g3.insets = new Insets(0, 0, 40, 20);
		jj.add(l2,g3);
		
		GridBagConstraints g4 = new GridBagConstraints();
		g4.gridy=1;
		g4.gridx=1;
		g4.insets = new Insets(0, 0, 40, 0);
		jj.add(text2,g4);
		
		GridBagConstraints g5 = new GridBagConstraints();
		g5.gridy=2;
		g5.gridx=0;
		g5.insets = new Insets(0, 0, 40, 20);
		jj.add(l3,g5);
		
		GridBagConstraints g6 = new GridBagConstraints();
		g6.gridy=2;
		g6.gridx=1;
		g6.insets = new Insets(0, 0, 40, 0);
		jj.add(text3,g6);
		
		GridBagConstraints g7 = new GridBagConstraints();
		g7.gridy=3;
		g7.gridx=0;
		g7.insets = new Insets(0, 0, 40, 20);
		jj.add(l4,g7);
		
		GridBagConstraints g8 = new GridBagConstraints();
		g8.gridy=3;
		g8.gridx=1;
		g8.insets = new Insets(0, 0, 40, 0);
		jj.add(text4,g8);
		
		GridBagConstraints g9 = new GridBagConstraints();
		g9.gridy=4;
		g9.gridx=0;
		g9.insets = new Insets(0, 0, 40, 20);
		jj.add(l5,g9);
		
		GridBagConstraints g10 = new GridBagConstraints();
		g10.gridy=4;
		g10.gridx=1;
		g10.insets = new Insets(0, 0, 40, 0);
		jj.add(text5,g10);
		
		GridBagConstraints g11 = new GridBagConstraints();
		g11.gridy=5;
		g11.gridx=0;
		g11.insets = new Insets(0, 0, 40, 20);
		jj.add(l6,g11);
		
		GridBagConstraints g12 = new GridBagConstraints();
		g12.gridy=5;
		g12.gridx=1;
		g12.insets = new Insets(0, 0, 40, 0);
		jj.add(text6,g12);
		
		GridBagConstraints g13 = new GridBagConstraints();
		g13.gridy=6;
		g13.gridx=1;
		g13.insets = new Insets(0, 0, 0, 90);
		jj.add(but1,g13);
		
		but1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String id = text1.getText();
				String name = text2.getText();
				String type = text3.getText();
				String uploader = text4.getText();
				String amount = text5.getText();
				String sizes = text6.getText();
				
				
				
				
				
				if (id.equals("")||name.equals("")||type.equals("")||uploader.equals("")||amount.equals("")||sizes.equals("")){
					
					JOptionPane.showMessageDialog(null, "����������ȫ����Ϣ��","��Ϣ��ʾ",JOptionPane.INFORMATION_MESSAGE);
					
				}
				else {
					
					Map map = new HashMap();
					map.put("id",id);
					map.put("name",name);
					map.put("type",type);
					map.put("uploader",uploader);
					map.put("amount",amount);
					map.put("sizes",sizes);
					
					sqlmess sql = new sqlmess();
					boolean tt = sql.addGame(map);
					if(tt){
						
						JOptionPane.showMessageDialog(null, "¼��ɹ���","��Ϣ��ʾ",JOptionPane.INFORMATION_MESSAGE);
						setVisible(false);
						ff.updategame();
						
					}
					else {
						JOptionPane.showMessageDialog(null, "��ǰ��Ϸ��Ϣ�Ѵ��ڣ������ԣ�","��Ϣ��ʾ",JOptionPane.INFORMATION_MESSAGE);
					}
					
					
				}
				
			}
		});
		
		
		setVisible(true);
		
	}
	
	public void AddLiveFrame(mainframe ff){
		mainFrame = ff;
		setTitle("¼��ֱ����Ϣ");
		setBounds(760, 230, 400, 600);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Container con = getContentPane();
		
		JLabel l1 = new JLabel("ֱ �� id:");
		JLabel l2 = new JLabel("ֱ������:");
		JLabel l3 = new JLabel("ֱ������:");
		JLabel l4 = new JLabel("�ϴ��û�:");
		JLabel l5 = new JLabel("��������:");
		JButton but1 = new JButton("¼��ֱ����Ϣ");
		JTextField text1 = new JTextField();
		text1.setColumns(15);
		JTextField text2 = new JTextField();
		text2.setColumns(15);
		JTextField text3 = new JTextField();
		text3.setColumns(15);
		JTextField text4 = new JTextField();
		text4.setColumns(15);
		JTextField text5 = new JTextField();
		text5.setColumns(15);
		
		JPanel jj = new JPanel();
		con.add(jj,BorderLayout.CENTER);
		jj.setOpaque(false);
		jj.setLayout(new GridBagLayout());
		
		GridBagConstraints g1 = new GridBagConstraints();
		g1.gridy=0;
		g1.gridx=0;
		g1.insets = new Insets(0, 0, 40, 20);
		jj.add(l1,g1);
		
		GridBagConstraints g2 = new GridBagConstraints();
		g2.gridy=0;
		g2.gridx=1;
		g2.insets = new Insets(0, 0, 40, 0);
		jj.add(text1,g2);
		
		GridBagConstraints g3 = new GridBagConstraints();
		g3.gridy=1;
		g3.gridx=0;
		g3.insets = new Insets(0, 0, 40, 20);
		jj.add(l2,g3);
		
		GridBagConstraints g4 = new GridBagConstraints();
		g4.gridy=1;
		g4.gridx=1;
		g4.insets = new Insets(0, 0, 40, 0);
		jj.add(text2,g4);
		
		GridBagConstraints g5 = new GridBagConstraints();
		g5.gridy=2;
		g5.gridx=0;
		g5.insets = new Insets(0, 0, 40, 20);
		jj.add(l3,g5);
		
		GridBagConstraints g6 = new GridBagConstraints();
		g6.gridy=2;
		g6.gridx=1;
		g6.insets = new Insets(0, 0, 40, 0);
		jj.add(text3,g6);
		
		GridBagConstraints g7 = new GridBagConstraints();
		g7.gridy=3;
		g7.gridx=0;
		g7.insets = new Insets(0, 0, 40, 20);
		jj.add(l4,g7);
		
		GridBagConstraints g8 = new GridBagConstraints();
		g8.gridy=3;
		g8.gridx=1;
		g8.insets = new Insets(0, 0, 40, 0);
		jj.add(text4,g8);
		
		GridBagConstraints g9 = new GridBagConstraints();
		g9.gridy=4;
		g9.gridx=0;
		g9.insets = new Insets(0, 0, 40, 20);
		jj.add(l5,g9);
		
		GridBagConstraints g10 = new GridBagConstraints();
		g10.gridy=4;
		g10.gridx=1;
		g10.insets = new Insets(0, 0, 40, 0);
		jj.add(text5,g10);
		
		GridBagConstraints g13 = new GridBagConstraints();
		g13.gridy=6;
		g13.gridx=1;
		g13.insets = new Insets(0, 0, 0, 90);
		jj.add(but1,g13);
		
		but1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String id = text1.getText();
				String name = text2.getText();
				String type = text3.getText();
				String uploader = text4.getText();
				String spectators = text5.getText();
				
				
				
				
				
				if (id.equals("")||name.equals("")||type.equals("")||uploader.equals("")||spectators.equals("")){
					
					JOptionPane.showMessageDialog(null, "����������ȫ����Ϣ��","��Ϣ��ʾ",JOptionPane.INFORMATION_MESSAGE);
					
				}
				else {
					
					Map map = new HashMap();
					map.put("id",id);
					map.put("name",name);
					map.put("type",type);
					map.put("uploader",uploader);
					map.put("spectators",spectators);
					
					sqlmess sql = new sqlmess();
					boolean tt = sql.addLive(map);
					if(tt){
						
						JOptionPane.showMessageDialog(null, "¼��ɹ���","��Ϣ��ʾ",JOptionPane.INFORMATION_MESSAGE);
						setVisible(false);
						ff.updatelive();
						
					}
					else {
						JOptionPane.showMessageDialog(null, "��ǰֱ����Ϣ�Ѵ��ڣ������ԣ�","��Ϣ��ʾ",JOptionPane.INFORMATION_MESSAGE);
					}
					
					
				}
				
			}
		});
		
		
		setVisible(true);
		
	}
}
