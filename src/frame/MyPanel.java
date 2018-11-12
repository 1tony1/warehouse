package frame;

import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MyPanel extends JPanel {
	
	private ImageIcon img;
	public MyPanel(URL imgurl){
		
		super();
		//setLayout(new GridBagLayout());
		img = new ImageIcon(imgurl);
		setSize(img.getIconWidth(),img.getIconHeight());
		
	}
	protected void paintComponent(Graphics g){
		
		Image ii = img.getImage();
		g.drawImage(ii,0,0,null);
		
	}
}
