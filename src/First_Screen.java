import java.awt.Color;
//import java.awt.Font;
import java.awt.Graphics;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.event.*;
import java.awt.MouseInfo;
//import java.awt.event.MouseListener;
@SuppressWarnings("serial")
public class First_Screen extends JPanel{
	//private static int tick = 0;
	private static boolean mouse = false;
	public static boolean clicked = false;
	static boolean play = false;
	public void paint(Graphics g){
		//Font myFont = new Font ("Courier New", 1, 40);
		g.drawImage(new ImageIcon(First_Screen.class.getResource("/old_paper.jpg")).getImage(), 0, 0, 1900, 1000, null);
		g.setColor(Color.black);
		//g.drawLine(0, 0, 900, 450);
		//g.drawLine(1900, 0, 1000, 450);
		//g.drawLine(1900, 1000, 1000, 500);
		//g.drawLine(0, 1000, 900, 500);
		g.setColor(Color.red);
		//g.setFont(myFont);
		//g.drawString("Play", 900, 485);
		//g.drawImage(new ImageIcon("Older Paper 6.png").getImage(), 520, 10, 900, 156, null);
		g.drawImage(new ImageIcon(First_Screen.class.getResource("/Older Paper 6.png")).getImage(), 520, 10, 900, 156, null);
		g.drawImage(new ImageIcon(First_Screen.class.getResource("/Capstone.png")).getImage(), 680, 160, 556, 155, null);
		g.drawImage(new ImageIcon(First_Screen.class.getResource("/crocyright.png")).getImage(), 50, 250, 512, 512, null);
		g.drawImage(new ImageIcon(First_Screen.class.getResource("/left.png")).getImage(), 1300, 250, 512, 512, null);
		g.drawImage(new ImageIcon(First_Screen.class.getResource("/Grass_Square.png")).getImage(), 820, 650, 262, 312, null);
		button_listener(g);
	}
	public static void button_listener(Graphics g){
		final int x = MouseInfo.getPointerInfo().getLocation().x;
		final int y = MouseInfo.getPointerInfo().getLocation().y;
		g.drawImage(new ImageIcon(First_Screen.class.getResource("/Play.png")).getImage(), 880, 450, 149, 54, null);
		if(!mouse && !(clicked && x >= 850 && x <= 1050 && y >= 457 && y <= 557)){
		g.setColor(new Color(5,5,5,90));
		
		g.fillRect(850, 427, 200, 100);
		}
		else if (mouse && !(clicked && x >= 850 && x <= 1050 && y >= 457 && y <= 557)){
			g.setColor(new Color(5,5,5,70));
			
			g.fillRect(850, 427, 200, 100);
		}
		else if (clicked && x >= 850 && x <= 1050 && y >= 457 && y <= 557){
			g.setColor(new Color(5,5,5,40));
			
			g.fillRect(850, 427, 200, 100);
			
			play = true;
			
			try {		         
		         AudioInputStream audioIn = AudioSystem.getAudioInputStream(First_Screen.class.getResource("/click.wav" ));		         
		         Clip clip = AudioSystem.getClip();
		         clip.open(audioIn);
		         clip.start();
		      } catch (Exception ex) {
		         ex.printStackTrace();
		      }
			//System.out.println("gray");
			
		}
		
		//System.out.println("true");
	}
	public static void check_mouse(){
		final int x = MouseInfo.getPointerInfo().getLocation().x;
		final int y = MouseInfo.getPointerInfo().getLocation().y;
		if(x >= 850 && x <= 1050 && y >= 457 && y <= 557){
			//return true;
			mouse = true;
			//System.out.println(y);
		}
		else{
			//return false;
			mouse = false;
			//System.out.println("false");
		}
		
	}
	
	public static void main(String[] args) {
		
	JFrame window = new JFrame("Older Paper 6: Capstone");
	
	window.setVisible(true);
	
	window.setResizable(false);
	
	window.setSize(1900, 1035);
	
	First_Screen panel = new First_Screen();
	
	window.add(panel);
	
	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	mouse_listener mouse = new mouse_listener();
	
	panel.addMouseListener(mouse);
	
	Character_Select.createWindow();
		
	Timer timer = new Timer(10, new ActionListener(){
		public void actionPerformed(ActionEvent arg0){
			//tick += 1;
			check_mouse();
			panel.repaint();
			clicked = mouse.clicked;
			
			if (play){
				
				window.dispose();
					
			}
			//System.out.println(clicked);
		}
	});
	timer.start();
	
	
	}

}
