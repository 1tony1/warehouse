package frame;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Frame;
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

public class EditFrame extends JFrame{

	mainframe mainFrame = null;
	
	public void EditUserFrame(mainframe ff,Map map){
		mainFrame = ff;
		setTitle("编辑用户信息");
		setBounds(760, 230, 400, 600);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Container con = getContentPane();
		
		JLabel l1 = new JLabel("用 户 id:");
		JLabel l2 = new JLabel("用户姓名:");
		JLabel l3 = new JLabel("用户性别:");
		JLabel l4 = new JLabel("用户年龄:");
		JLabel l5 = new JLabel("出生日期:");
		JLabel l6 = new JLabel("用户类型:");
		JButton but1 = new JButton("完成编辑");
		JTextField text1 = new JTextField(map.get("id").toString());
		text1.setEditable(false);
		text1.setColumns(15);
		JTextField text2 = new JTextField(map.get("username").toString());
		text2.setColumns(15);
		JTextField text3 = new JTextField(map.get("sex").toString());
		text3.setColumns(15);
		JTextField text4 = new JTextField(map.get("age").toString());
		text4.setColumns(15);
		JTextField text5 = new JTextField(map.get("hiredate").toString());
		text5.setColumns(15);
		JTextField text6 = new JTextField(map.get("typrs").toString());
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
					
					JOptionPane.showMessageDialog(null, "请完善以上全部信息！","信息提示",JOptionPane.INFORMATION_MESSAGE);
					
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
					boolean tt = sql.editUser(map);
					if(tt){
						
						JOptionPane.showMessageDialog(null, "编辑成功！","信息提示",JOptionPane.INFORMATION_MESSAGE);
						setVisible(false);
						ff.updateusers();
						
					}
					
				}
				
			}
		});
		
		
		setVisible(true);
		
	}
	
	public void EditMusicFrame(mainframe ff,Map map){
		mainFrame = ff;
		setTitle("编辑音乐信息");
		setBounds(760, 230, 400, 600);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Container con = getContentPane();
		
		JLabel l1 = new JLabel("音 乐 id:");
		JLabel l2 = new JLabel("音乐名称:");
		JLabel l3 = new JLabel("音乐类型:");
		JLabel l4 = new JLabel("上传用户:");
		JLabel l5 = new JLabel("播放次数:");
		JLabel l6 = new JLabel("文件大小:");
		JButton but1 = new JButton("完成编辑");
		JTextField text1 = new JTextField(map.get("id").toString());
		text1.setEditable(false);
		text1.setColumns(15);
		JTextField text2 = new JTextField(map.get("name").toString());
		text2.setColumns(15);
		JTextField text3 = new JTextField(map.get("type").toString());
		text3.setColumns(15);
		JTextField text4 = new JTextField(map.get("uploader").toString());
		text4.setColumns(15);
		JTextField text5 = new JTextField(map.get("amount").toString());
		text5.setColumns(15);
		JTextField text6 = new JTextField(map.get("sizes").toString());
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
					
					JOptionPane.showMessageDialog(null, "请完善以上全部信息！","信息提示",JOptionPane.INFORMATION_MESSAGE);
					
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
					boolean tt = sql.editMusic(map);
					if(tt){
						
						JOptionPane.showMessageDialog(null, "编辑成功！","信息提示",JOptionPane.INFORMATION_MESSAGE);
						setVisible(false);
						ff.updatemusic();
						
					}
					
				}
				
			}
		});
		
		
		setVisible(true);
		
	}
	
	public void EditGameFrame(mainframe ff,Map map){
		mainFrame = ff;
		setTitle("编辑游戏信息");
		setBounds(760, 230, 400, 600);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Container con = getContentPane();
		
		JLabel l1 = new JLabel("游 戏 id:");
		JLabel l2 = new JLabel("游戏名称:");
		JLabel l3 = new JLabel("游戏类型:");
		JLabel l4 = new JLabel("上传用户:");
		JLabel l5 = new JLabel("浏览次数:");
		JLabel l6 = new JLabel("文件大小:");
		JButton but1 = new JButton("完成编辑");
		JTextField text1 = new JTextField(map.get("id").toString());
		text1.setEditable(false);
		text1.setColumns(15);
		JTextField text2 = new JTextField(map.get("name").toString());
		text2.setColumns(15);
		JTextField text3 = new JTextField(map.get("type").toString());
		text3.setColumns(15);
		JTextField text4 = new JTextField(map.get("uploader").toString());
		text4.setColumns(15);
		JTextField text5 = new JTextField(map.get("amount").toString());
		text5.setColumns(15);
		JTextField text6 = new JTextField(map.get("sizes").toString());
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
					
					JOptionPane.showMessageDialog(null, "请完善以上全部信息！","信息提示",JOptionPane.INFORMATION_MESSAGE);
					
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
					boolean tt = sql.editGame(map);
					if(tt){
						
						JOptionPane.showMessageDialog(null, "编辑成功！","信息提示",JOptionPane.INFORMATION_MESSAGE);
						setVisible(false);
						ff.updategame();
						
					}
					
				}
				
			}
		});
		
		
		setVisible(true);
		
	}
	
	public void EditLiveFrame(mainframe ff,Map map){
		mainFrame = ff;
		setTitle("编辑直播信息");
		setBounds(760, 230, 400, 600);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Container con = getContentPane();
		
		JLabel l1 = new JLabel("直 播 id:");
		JLabel l2 = new JLabel("直播名称:");
		JLabel l3 = new JLabel("直播类型:");
		JLabel l4 = new JLabel("上传用户:");
		JLabel l5 = new JLabel("在线人数:");
		JButton but1 = new JButton("完成编辑");
		JTextField text1 = new JTextField(map.get("id").toString());
		text1.setEditable(false);
		text1.setColumns(15);
		JTextField text2 = new JTextField(map.get("name").toString());
		text2.setColumns(15);
		JTextField text3 = new JTextField(map.get("type").toString());
		text3.setColumns(15);
		JTextField text4 = new JTextField(map.get("uploader").toString());
		text4.setColumns(15);
		JTextField text5 = new JTextField(map.get("spectators").toString());
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
					
					JOptionPane.showMessageDialog(null, "请完善以上全部信息！","信息提示",JOptionPane.INFORMATION_MESSAGE);
					
				}
				else {
					
					Map map = new HashMap();
					map.put("id",id);
					map.put("name",name);
					map.put("type",type);
					map.put("uploader",uploader);
					map.put("spectators",spectators);
					
					sqlmess sql = new sqlmess();
					boolean tt = sql.editLive(map);
					if(tt){
						
						JOptionPane.showMessageDialog(null, "编辑成功！","信息提示",JOptionPane.INFORMATION_MESSAGE);
						setVisible(false);
						ff.updatelive();
						
					}
					
				}
				
			}
		});
		
		
		setVisible(true);
		
	}
}
