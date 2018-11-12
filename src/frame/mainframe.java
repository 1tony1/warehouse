package frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Map;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import frame.EditFrame;
import frame.loginframe.Mylistener;
import sql.sqlmess;
import table.gameTable;
import table.liveTable;
import table.musicTable;
import table.userTable;

public class mainframe extends JFrame{
	
	private JButton but1;
	private JButton but2;
	private JButton but3;
	private JButton but4;
	private JButton but5;
	private JButton but6;
	private JButton but7;
	private JButton but8;
	private JButton but9;
	
	private JLabel l1;
	
	private JTextField jtf1 = new JTextField("请输入内容");
	
	
	static JScrollPane jj1 = null;
	static JPanel jj2 = null;
	MyPanel j = new MyPanel(this.getClass().getResource("/img/7.jpg"));
    int mess=0;
	public mainframe(){
		
		setTitle("资源管理系统");
		setBounds(0, 0, 1920, 1080);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container con = getContentPane();
		setResizable(false);
		
		jtf1.setForeground(Color.gray);
		jtf1.setOpaque(false);
		jtf1.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent arg0) {
				
				if(jtf1.getText().equals("")){
					jtf1.setText("请输入内容");
				
				}
				
			}
			
			@Override
			public void focusGained(FocusEvent arg0) {
				
				jtf1.setText("");
				
			}
		});
		
		j.setLayout(new BorderLayout());
		con.add(j,BorderLayout.CENTER);
		
		
		but1 = new JButton("用  户  列  表");
		but2 = new JButton("音  乐  列  表");
		but3 = new JButton("游  戏  列  表");
		but4 = new JButton("直  播  列  表");
		but5 = new JButton("退  出  登  录");
		but6 = new JButton("编  辑  信  息");
		but7 = new JButton("增  加  信  息");
		but8 = new JButton("删  除  信  息");
		but9 = new JButton("查  询  信  息");
		
		jtf1.setColumns(15);
		
		int i = 120;
		int k = 50;
		
		but1.setPreferredSize(new Dimension(i,k));
		but2.setPreferredSize(new Dimension(i,k));
		but3.setPreferredSize(new Dimension(i,k));
		but4.setPreferredSize(new Dimension(i,k));
		but5.setPreferredSize(new Dimension(i,k));
		but6.setPreferredSize(new Dimension(i,k));
		but7.setPreferredSize(new Dimension(i,k));
		but8.setPreferredSize(new Dimension(i,k));
		but9.setPreferredSize(new Dimension(i,k));

		l1 = new JLabel("欢迎使用本系统，请点击左侧功能键选择功能！");
		
		l1.setFont(new Font("楷体",   1,   50));
		l1.setForeground(Color.blue);
		
		int i2 = 100;
		
		JPanel pan = new JPanel();
		j.add(pan,BorderLayout.NORTH);
		pan.setOpaque(false);
		pan.setLayout(new GridBagLayout());
		
		GridBagConstraints g7 = new GridBagConstraints();
		g7.gridy=0;
		g7.gridx=0;
		g7.insets = new Insets(0, i2, 0, i2);
		pan.add(but6,g7);
		
		GridBagConstraints g8 = new GridBagConstraints();
		g8.gridy=0;
		g8.gridx=1;
		g8.insets = new Insets(0, i2, 0, i2);
		pan.add(but7,g8);
		
		GridBagConstraints g9 = new GridBagConstraints();
		g9.gridy=0;
		g9.gridx=2;
		g9.insets = new Insets(0, i2, 0, i2);
		pan.add(but8,g9);
		
		GridBagConstraints g10 = new GridBagConstraints();
		g10.gridy=0;
		g10.gridx=3;
		g10.insets = new Insets(0, i2, 0, 0);
		pan.add(jtf1,g10);
		
		GridBagConstraints g11 = new GridBagConstraints();
		g11.gridy=0;
		g11.gridx=4;
		g11.insets = new Insets(0, 0, 0, i2);
		pan.add(but9,g11);
		
		JPanel jj = new JPanel();
		j.add(jj,BorderLayout.WEST);
		jj.setOpaque(false);
		jj.setLayout(new GridBagLayout());
		
		int i1 = 50;
		
		GridBagConstraints g1 = new GridBagConstraints();
		g1.gridy=0;
		g1.gridx=0;
		g1.insets = new Insets(i1, 10, i1, 10);
		jj.add(but1,g1);
		
		
		GridBagConstraints g2 = new GridBagConstraints();
		g2.gridy=1;
		g2.gridx=0;
		g2.insets = new Insets(i1, 10, i1, 10);
		jj.add(but2,g2);
		
		GridBagConstraints g3 = new GridBagConstraints();
		g3.gridy=2;
		g3.gridx=0;
		g3.insets = new Insets(i1, 10, i1, 10);
		jj.add(but3,g3);
		
		GridBagConstraints g4 = new GridBagConstraints();
		g4.gridy=3;
		g4.gridx=0;
		g4.insets = new Insets(i1, 10, i1, 10);
		jj.add(but4,g4);
		
		GridBagConstraints g5 = new GridBagConstraints();
		g5.gridy=4;
		g5.gridx=0;
		g5.insets = new Insets(i1, 10, i1, 10);
		jj.add(but5,g5);

		setLabel(l1);
		
		but1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(jj2 != null){
					
					jj2.setVisible(false);
					
				}
				setTable(userTable.ut());
				mess=1;	
					
					
			}
		});
		
		but2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(jj2 != null){
					
					jj2.setVisible(false);
					
				}
				setTable(musicTable.mt());
				mess=2;	
			}
		});
		
		but3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(jj2 != null){
					
					jj2.setVisible(false);
					
				}
				setTable(gameTable.gt());
				mess=3;
				
			}
		});
		
		but4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(jj2 != null){
					
					jj2.setVisible(false);
					
				}
				setTable(liveTable.lt());
				mess=4;
				
			}
		});
		
		but5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				showlogin();
				
			}
		});
		
		but6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(mess == 0){
					
					JOptionPane.showMessageDialog(null, "请选择左侧功能按键后点击该按钮！","信息提示",JOptionPane.INFORMATION_MESSAGE);
					
				}
				else if(mess == 1){
					
					int row = userTable.table.getSelectedRow();
					int rr[] = userTable.table.getSelectedRows();
					if(rr.length > 1){
						JOptionPane.showMessageDialog(null, "请只选择一条信息！","信息提示",JOptionPane.INFORMATION_MESSAGE);
					}
					else{
						if(row > -1){
						
							sqlmess sql = new sqlmess();
							String id = (String)userTable.table.getValueAt(row, 1);
							Map map = sql.getOneUserById(id);
							System.out.println(map);
							editUser(map);
						}
						else{
							JOptionPane.showMessageDialog(null, "请选择要编辑的信息！","信息提示",JOptionPane.INFORMATION_MESSAGE);
						}
					
					}
				}
				else if(mess == 2){
					
					int row = musicTable.table.getSelectedRow();
					int rr[] = musicTable.table.getSelectedRows();
					if(rr.length > 1){
						JOptionPane.showMessageDialog(null, "请只选择一条信息！","信息提示",JOptionPane.INFORMATION_MESSAGE);
					}
					else{
						if(row > -1){
						
							sqlmess sql = new sqlmess();
							String id = (String)musicTable.table.getValueAt(row, 1);
							Map map = sql.getOneMusicById(id);
							
							editMusic(map);
						}
						else{
							JOptionPane.showMessageDialog(null, "请选择要编辑的信息！","信息提示",JOptionPane.INFORMATION_MESSAGE);
						}
					
					}
				}
				else if(mess == 3){
					
					int row = gameTable.table.getSelectedRow();
					int rr[] = gameTable.table.getSelectedRows();
					if(rr.length > 1){
						JOptionPane.showMessageDialog(null, "请只选择一条信息！","信息提示",JOptionPane.INFORMATION_MESSAGE);
					}
					else{
						if(row > -1){
						
							sqlmess sql = new sqlmess();
							String id = (String)gameTable.table.getValueAt(row, 1);
							Map map = sql.getOneGameById(id);
							
							editGame(map);
						}
						else{
							JOptionPane.showMessageDialog(null, "请选择要编辑的信息！","信息提示",JOptionPane.INFORMATION_MESSAGE);
						}
					
					}
				}
				else if(mess == 4){
					
					int row = liveTable.table.getSelectedRow();
					int rr[] = liveTable.table.getSelectedRows();
					if(rr.length > 1){
						JOptionPane.showMessageDialog(null, "请只选择一条信息！","信息提示",JOptionPane.INFORMATION_MESSAGE);
					}
					else{
						if(row > -1){
						
							sqlmess sql = new sqlmess();
							String id = (String)liveTable.table.getValueAt(row, 1);
							Map map = sql.getOneLiveById(id);
							
							editLive(map);
						}
						else{
							JOptionPane.showMessageDialog(null, "请选择要编辑的信息！","信息提示",JOptionPane.INFORMATION_MESSAGE);
						}
					
					}
				}
			}
		});
					
		
		but7.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(mess == 0){
					
					JOptionPane.showMessageDialog(null, "请选择左侧功能按键后点击该按钮！","信息提示",JOptionPane.INFORMATION_MESSAGE);
					
				}
				else if (mess == 1){
					
					showadduser();
					
				}
				else if (mess == 2){
					
					showaddmusic();
					
				}
				else if (mess == 3){
					
					showaddgame();
					
				}
				else if (mess == 4){
					
					showaddlive();
					
				}
				
			}
		});
		
		but8.addActionListener(new ActionListener() {
			sqlmess sql = new sqlmess();
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(mess == 0){
					
					JOptionPane.showMessageDialog(null, "请选择左侧功能按键后点击该按钮！","信息提示",JOptionPane.INFORMATION_MESSAGE);
					
				}
				else if (mess == 1){
					int row = userTable.table.getSelectedRow();
					if(row > -1){
						int i = JOptionPane.showConfirmDialog(null, "确定要删除该条记录么？","信息提示",JOptionPane.YES_NO_OPTION);
						if(i == 0){
							String id = (String)userTable.table.getValueAt(row, 1);
							boolean tt = sql.delUser(id);
							updateusers();
						}
					}
					else{
						JOptionPane.showMessageDialog(null, "请选择要删除的信息！","信息提示",JOptionPane.INFORMATION_MESSAGE);
					}
				}
				else if (mess == 2){
					int row = musicTable.table.getSelectedRow();
					if(row > -1){
						int i = JOptionPane.showConfirmDialog(null, "确定要删除该条记录么？","信息提示",JOptionPane.YES_NO_OPTION);
						if(i == 0){
							String id = (String)musicTable.table.getValueAt(row, 1);
							boolean tt = sql.delMusic(id);
							updatemusic();
						}
					}
					else{
						JOptionPane.showMessageDialog(null, "请选择要删除的信息！","信息提示",JOptionPane.INFORMATION_MESSAGE);
					}
				}
				else if (mess == 3){
					int row = gameTable.table.getSelectedRow();
					if(row > -1){
						int i = JOptionPane.showConfirmDialog(null, "确定要删除该条记录么？","信息提示",JOptionPane.YES_NO_OPTION);
						if(i == 0){
							String id = (String)gameTable.table.getValueAt(row, 1);
							boolean tt = sql.delGame(id);
							updategame();
						}
					}
					else{
						JOptionPane.showMessageDialog(null, "请选择要删除的信息！","信息提示",JOptionPane.INFORMATION_MESSAGE);
					}
				}
				else if (mess == 4){
					int row = liveTable.table.getSelectedRow();
					if(row > -1){
						int i = JOptionPane.showConfirmDialog(null, "确定要删除该条记录么？","信息提示",JOptionPane.YES_NO_OPTION);
						if(i == 0){
							String id = (String)liveTable.table.getValueAt(row, 1);
							boolean tt = sql.delLive(id);
							updatelive();
						}
					}
					else{
						JOptionPane.showMessageDialog(null, "请选择要删除的信息！","信息提示",JOptionPane.INFORMATION_MESSAGE);
					}
				}

			}
		});
		
		but9.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
if(mess == 0){
					
					JOptionPane.showMessageDialog(null, "请选择左侧功能按键后点击该按钮！","信息提示",JOptionPane.INFORMATION_MESSAGE);
					
				}
				else{
					
					sqlmess sql = new sqlmess();
					String text = jtf1.getText();
					if(text.equals("请输入内容")){
						text="";
					}
					JTable table = new JTable();
					if (mess == 1){
						
						setTable(userTable.ut(text));
						
						
					}
					else if (mess == 2){
						
						setTable(musicTable.mt(text));
					
						
					}
					else if (mess == 3){
						
						setTable(gameTable.gt(text));
						
						
					}
					else if (mess == 4){
						
						setTable(liveTable.lt(text));
						
						
					}
					
				}
				
			}
		});
		
		Mylistener my=new Mylistener();
		jtf1.addKeyListener(my);
		
		setVisible(true);
		
	}
	
	public  void setLabel(JLabel ll) {
		
		if(jj2 == null){
			jj2 = new JPanel();
			}
		jj2.setOpaque(false);
		jj2.setLayout(new GridBagLayout());
		j.add(jj2,BorderLayout.CENTER);
		GridBagConstraints g = new GridBagConstraints();
		g.gridy=0;
		g.gridx=0;
		g.insets = new Insets(0, 0, 600, 0);
		jj2.add(ll,g);
		
	}  
	
	public void setTable(JTable tt) {
		if(jj1 == null){
		jj1 = new JScrollPane();
		}
		j.add(jj1,BorderLayout.CENTER);
		jj1.setOpaque(false);
		jj1.getViewport().setOpaque(false);
		jj1.setBorder(null);
		jj1.setViewportView(tt);
		
		tt.setOpaque(false);//将table设置为透明
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
		renderer.setOpaque(false);//render单元格的属性
		tt.setDefaultRenderer(Object.class,renderer);
		
		tt.setForeground(new Color(255, 102, 255));//设置字体颜色，但标题不会改变

		tt.setFont(new java.awt.Font("楷体", 1, 20)); 
		
		tt.setRowHeight(35);



	}
	
	public void showlogin(){
		
		dispose();
		new loginframe();
		
	}
	public void updateusers(){
		
		sqlmess sql = new sqlmess();
		Vector	v = sql.getAllUser();
		userTable.tablemode.setDataVector(v, userTable.vtitle);
		
	}
	public void updatemusic(){
		
		sqlmess sql = new sqlmess();
		Vector	v = sql.getAllMusic();
		musicTable.tablemode.setDataVector(v, musicTable.vtitle);
		
	}
	public void updatelive(){
		
		sqlmess sql = new sqlmess();
		Vector	v = sql.getAllLive();
		liveTable.tablemode.setDataVector(v, liveTable.vtitle);
		
	}
	public void updategame(){
		
		sqlmess sql = new sqlmess();
		Vector	v = sql.getAllGame();
		gameTable.tablemode.setDataVector(v, gameTable.vtitle);
		
	}
	public void showadduser(){
		AddFrame aa=new AddFrame();
		aa.AddUsersFrame(this);
		
	}
	public void showaddmusic(){
		AddFrame aa=new AddFrame();
		aa.AddMusicFrame(this);
		
	}
	public void showaddgame(){
		AddFrame aa=new AddFrame();
		aa.AddGameFrame(this);
		
	}
	public void showaddlive(){
		AddFrame aa=new AddFrame();
		aa.AddLiveFrame(this);
		
	}
	public void editUser(Map map){
		
		EditFrame user = new EditFrame();
		user.EditUserFrame(this,map);
	}
	public void editMusic(Map map){
		
		EditFrame music = new EditFrame();
		music.EditMusicFrame(this,map);
	}
	public void editGame(Map map){
		
		EditFrame game = new EditFrame();
		game.EditGameFrame(this,map);
	}
	public void editLive(Map map){
		
		EditFrame live = new EditFrame();
		live.EditLiveFrame(this,map);
	}
	public void ss(){
		
		this.repaint();
	}
	public static void main(String[] args) {
		new mainframe();
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
				if(mess == 0){
					
					JOptionPane.showMessageDialog(null, "请选择左侧功能按键后点击该按钮！","信息提示",JOptionPane.INFORMATION_MESSAGE);
					
				}
				else{
					
					sqlmess sql = new sqlmess();
					String text = jtf1.getText();
					if(text.equals("请输入内容")){
						text="";
					}
					JTable table = new JTable();
					if (mess == 1){
						
						setTable(userTable.ut(text));
						
						
					}
					else if (mess == 2){
						
						setTable(musicTable.mt(text));
					
						
					}
					else if (mess == 3){
						
						setTable(gameTable.gt(text));
						
						
					}
					else if (mess == 4){
						
						setTable(liveTable.lt(text));
						
						
					}
					
				}
			}

			
		}
	}
}
