import java.awt.Color;
import java.awt.Graphics;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.event.*;
import java.awt.MouseInfo;
import java.awt.TextField;
public class Character_Select extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private static int tick = 0;
	static boolean first = false;
	public static boolean clicked = false;
	public static int selected = 0;
	private static boolean released;
	public static int selected2 = 0;
	public static String player2Name;
	public static String player1Name;
	public static int character;
	public static int character2;
    static boolean playAgain = false;
    static boolean start = false;
	
	//public static boolean change = true;
	
	public void paint(Graphics g){
		g.drawImage(new ImageIcon(First_Screen.class.getResource("/old_paper.jpg")).getImage(), 0, 0, 1900, 1000, null);
		g.setColor(Color.BLACK);
		g.drawLine(700,0,700,1000);
		g.drawLine(1200,0,1200,1000);
		
		g.drawImage(new ImageIcon(First_Screen.class.getResource("/start.png")).getImage(), 865, 465, 175, 75, null);
		g.drawImage(new ImageIcon(First_Screen.class.getResource("/player1.png")).getImage(), 250, 10, 210, 65, null);
		g.drawImage(new ImageIcon(First_Screen.class.getResource("/player2.png")).getImage(), 1450, 10, 210, 65, null);
		button_listener(g);
		g.drawRect(50,700,256,256);
		g.drawRect(1600,700,256,256);
		g.setColor(new Color(5,240,215,90));
		g.fillRect(50, 700,256,256);
		g.fillRect(1600, 700,256,256);
		hoverBox(50,100,130,130,g, "/right.png",1);
		hoverBox2(1720,100,130,130,g,"/left.png",1);
		hoverBox(200,100,130,130,g, "/crocyright.png",2);
		hoverBox2(1570,100,130,130,g,"/crocyleft.png",2);
		hoverBox(350,100,130,130,g, "/magerightwalking1.png",3);
		hoverBox2(1420,100,130,130,g,"/mageleftwalking1.png",3);
		g.drawImage(new ImageIcon(First_Screen.class.getResource("/name.png")).getImage(), 40, 620, 75, 40, null);
		g.drawImage(new ImageIcon(First_Screen.class.getResource("/name.png")).getImage(), 1690, 620, 75, 40, null);
		g.drawImage(new ImageIcon(First_Screen.class.getResource("/character.png")).getImage(), 340, 800, 328, 65, null);
		g.drawImage(new ImageIcon(First_Screen.class.getResource("/character.png")).getImage(), 1240, 800, 328, 65, null);
		//System.out.println(player1Name);
	}
	public static void button_listener(Graphics g){
		final int x = MouseInfo.getPointerInfo().getLocation().x;
		final int y = MouseInfo.getPointerInfo().getLocation().y;
		if (!clicked && (x >= 850 && x <= 1050 && y >= 480 && y <= 588) && selected != 0 && selected2 != 0){
			g.setColor(new Color(5,5,5,70));
			
			g.fillRect(850,450,200,100);
		}
		else if (clicked && x >= 850 && x <= 1050 && y >= 450 && y <= 550 && selected != 0 && selected2 != 0){
			g.setColor(new Color(5,5,5,40));
			
			g.fillRect(850,450,200,100);
			
			
			try {		         
		         AudioInputStream audioIn = AudioSystem.getAudioInputStream(Character_Select.class.getResource("/click.wav" ));		         
		         Clip clip = AudioSystem.getClip();
		         clip.open(audioIn);
		         clip.start();
		      } catch (Exception ex) {
		         ex.printStackTrace();
		      }
			start = true;
			
		}
		else{
			g.setColor(new Color(5,5,5,90));
			
			g.fillRect(850,450,200,100);
		}
	}
	public static void hoverBox(int d,int h,int width,int height, Graphics g, String img, int characterNumber){
		final int x = MouseInfo.getPointerInfo().getLocation().x;
		final int y = MouseInfo.getPointerInfo().getLocation().y;
		//System.out.println(released);
		g.setColor(new Color(5,240,215,90));
		g.fillRect(d, h, width, height);
		if(x >= d && x <= d + width && y >= h && y <= h + width && !released && selected != characterNumber){
			g.setColor(Color.BLUE);
			g.drawRect(d,h,width,height);
		}
		else if(x >= d && x <= d + width && y >= h && y <= h + width && selected==0 && released){
			g.setColor(Color.RED);
			g.drawRect(d,h,width,height);
			selected = characterNumber;
			character = characterNumber;
			try {		         
		         AudioInputStream audioIn = AudioSystem.getAudioInputStream(Character_Select.class.getResource("/click.wav" ));		         
		         Clip clip = AudioSystem.getClip();
		         clip.open(audioIn);
		         clip.start();
		      } catch (Exception ex) {
		         ex.printStackTrace();
		      }
			//System.out.println("change");
		}
		
		else if(x >= d && x <= d + width && y >= h && y <= h + width && selected == characterNumber && released){
			g.setColor(Color.RED);
			g.drawRect(d,h,width,height);
			selected = 0;
			//System.out.println("unchanged");
			try {		         
		         AudioInputStream audioIn = AudioSystem.getAudioInputStream(Character_Select.class.getResource("/click.wav" ));		         
		         Clip clip = AudioSystem.getClip();
		         clip.open(audioIn);
		         clip.start();
		      } catch (Exception ex) {
		         ex.printStackTrace();
		      }
		}
		else if(selected == characterNumber){
			g.setColor(Color.RED);
			g.drawRect(d,h,width,height);			
			//System.out.println("stop");
			g.setColor(new Color(5,240,215,98));
			g.fillRect(50, 700,256,256);
			g.drawImage(new ImageIcon(First_Screen.class.getResource(img)).getImage(), 50, 700, 256, 256, null);						
				//g.drawImage(new ImageIcon(img).getImage(), 1600, 700, 256, 256, null);
			
		}
		else {
			g.setColor(Color.BLACK);
			g.drawRect(d,h,width,height);			
		}
		g.drawImage(new ImageIcon(First_Screen.class.getResource(img)).getImage(), d+1, h+1, width-2, height-2, null);
		
	}
	public static void hoverBox2(int d,int h,int width,int height, Graphics g, String img, int characterNumber){
		final int x = MouseInfo.getPointerInfo().getLocation().x;
		final int y = MouseInfo.getPointerInfo().getLocation().y;
		//System.out.println(released);
		g.setColor(new Color(5,240,215,90));
		g.fillRect(d, h, width, height);
		if(x >= d && x <= d + width && y >= h && y <= h + width && !released && selected2 != characterNumber){
			g.setColor(Color.BLUE);
			g.drawRect(d,h,width,height);
		}
		else if(x >= d && x <= d + width && y >= h && y <= h + width && selected2 == 0 && released){
			g.setColor(Color.RED);
			g.drawRect(d,h,width,height);
			selected2 = characterNumber;
			character2 = characterNumber;
			try {		         
		         AudioInputStream audioIn = AudioSystem.getAudioInputStream(Character_Select.class.getResource("/click.wav" ));		         
		         Clip clip = AudioSystem.getClip();
		         clip.open(audioIn);
		         clip.start();
		      } catch (Exception ex) {
		         ex.printStackTrace();
		      }
			//System.out.println("change");
		}
		
		else if(x >= d && x <= d + width && y >= h && y <= h + width && selected2 == characterNumber && released){
			g.setColor(Color.RED);
			g.drawRect(d,h,width,height);
			selected2 = 0;
			try {		         
		         AudioInputStream audioIn = AudioSystem.getAudioInputStream(Character_Select.class.getResource("/click.wav" ));		         
		         Clip clip = AudioSystem.getClip();
		         clip.open(audioIn);
		         clip.start();
		      } catch (Exception ex) {
		         ex.printStackTrace();
		      }
			//System.out.println("unchanged");
		}
		else if(selected2 == characterNumber){
			g.setColor(Color.RED);
			g.drawRect(d,h,width,height);			
			//System.out.println("stop");
			g.setColor(new Color(5,240,215,98));
			g.fillRect(1600, 700,256,256);						
			g.drawImage(new ImageIcon(First_Screen.class.getResource(img)).getImage(), 1600, 700, 256, 256, null);
			
		}
		else {
			g.setColor(Color.BLACK);
			g.drawRect(d,h,width,height);			
		}
		g.drawImage(new ImageIcon(First_Screen.class.getResource(img)).getImage(), d+1, h+1, width-2, height-2, null);
		
	}
	public static void createWindow() {
		JFrame select = new JFrame("Older Paper 6: Capstone");
		
		select.setVisible(false);
		
		select.setResizable(false);
		
		select.setSize(1900, 1035);
		
		select.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Character_Select panel2 = new Character_Select();
		
		panel2.setLayout(null);
		
		TextField input = new TextField();
		
		input.setBounds(50, 650, 150, 20);
		
		panel2.add(input);
		
		TextField input2 = new TextField();
		
		input2.setBounds(1700, 650, 150, 20);
		
		panel2.add(input2);
		
		select.add(panel2);
		
		mouse_listener mousey = new mouse_listener();
		
		panel2.addMouseListener(mousey);
		
		//mapSelect map = new mapSelect();
		
		mapSelect.createWindow();
		
		
		Timer timer = new Timer(10, new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				//tick += 1;
				clicked = mousey.clicked;
				released = mousey.released;
				player1Name = input.getText();
				player2Name = input2.getText();
				
				mapSelect.player1Name = player1Name;
				mapSelect.player2Name = player2Name;
				
				mapSelect.character = character;
				mapSelect.character2 = character2;
				panel2.repaint();		
				mousey.released = false;
				if (start){
					//System.out.println("start");
					start = false;
					select.dispose();
					
				}
				if(First_Screen.play && !first){
					select.setVisible(true);
					first = true;
					
				}
				else if(playAgain){
					//System.out.println("play again");
					select.setVisible(true);
					mapSelect.first = false;
					playAgain = false;
				}
			}
		});
		timer.start();
	}

}
