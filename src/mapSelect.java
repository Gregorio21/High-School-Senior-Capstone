import java.awt.Color;
import java.awt.Graphics;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.event.*;
import java.awt.MouseInfo;
//import java.awt.TextField;
public class mapSelect extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static boolean clicked;
	public static boolean released;
	public static boolean first;
	public static int selected = 0;
	public static String player2Name;
	public static String player1Name;
	public static int character;
	public static int character2;
	public void paint(Graphics g){
		g.drawImage(new ImageIcon(First_Screen.class.getResource("/old_paper.jpg")).getImage(), 0, 0, 1900, 1000, null);
		hoverBox(400,400,500,300,g,"/map1.png",1);
		g.drawImage(new ImageIcon(First_Screen.class.getResource("/mapSelect.png")).getImage(), 650, 20, 600, 100, null);
	}
	
	public static void hoverBox(int d,int h,int width,int height, Graphics g, String img, int mapNumber){
		final int x = MouseInfo.getPointerInfo().getLocation().x;
		final int y = MouseInfo.getPointerInfo().getLocation().y;
		g.drawImage(new ImageIcon(First_Screen.class.getResource(img)).getImage(), d+1, h+1, width-2, height-2, null);
		if(x >= d && x <= d + width && y >= h && y <= h + width && !released){
			g.setColor(new Color(5,5,5,70));
			g.fillRect(d,h,width,height);
		}
		else if(x >= d && x <= d + width && y >= h && y <= h + width && released){
				try {		         
			         AudioInputStream audioIn = AudioSystem.getAudioInputStream(mapSelect.class.getResource("/click.wav" ));		         
			         Clip clip = AudioSystem.getClip();
			         clip.open(audioIn);
			         clip.start();
			      } catch (Exception ex) {
			         ex.printStackTrace();
			      }
			
			g.setColor(new Color(5,5,5,90));
			g.fillRect(d,h,width,height);
			selected = mapNumber;
		}
		else {
			g.setColor(new Color(5,5,5,50));
			g.fillRect(d,h,width,height);			
		}
		
		
	}
	
	public static void createWindow() {
		
		JFrame mapSelect = new JFrame("Older Paper 6: Capstone");
		
		mapSelect.setVisible(false);
		
		mapSelect.setResizable(false);
		
		mapSelect.setSize(1900, 1035);
		
		mapSelect.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mapSelect panel2 = new mapSelect();
		
		mapSelect.add(panel2);
		
		mouse_listener mousey = new mouse_listener();
		
		panel2.addMouseListener(mousey);
		
		//Game game = new Game();
		
		Game.StartGame();
		
		
		Timer timer = new Timer(10, new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				clicked = mousey.clicked;
				released = mousey.released;
				//game.player1Name = player1Name;
				//game.player2Name = player2Name;
				//System.out.println(player1Name + " map");
				Game.mapNumber = selected;
				Game.character = character;
				Game.character2 = character2;
				
				panel2.repaint();		
				mousey.released = false;
				final int x = MouseInfo.getPointerInfo().getLocation().x;
				final int y = MouseInfo.getPointerInfo().getLocation().y;
				if (selected != 0){
					mapSelect.dispose();
				}
				if (!first && Character_Select.clicked && (x >= 850 && x <= 1050 && y >= 480 && y <= 588) && Character_Select.selected > 0 && Character_Select.selected2 > 0){
					mapSelect.setVisible(true);
					first = true;
					
				}
			}
		});
		timer.start();
	}
}
