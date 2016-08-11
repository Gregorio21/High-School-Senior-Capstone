//import java.awt.Color;
import java.awt.Color;
import java.awt.Graphics;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.event.*;

//import java.awt.MouseInfo;
//import java.awt.TextField;
public class Game extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static keyEvents key = new keyEvents();
	//private static int tick = 0;
	//private static boolean clicked = false;
	private static boolean start = false;
	public static String player1Name;
	public static String player2Name;
	public static int mapNumber;
	private static int x1 = 785;
	private static int y1 = 690;
	private static int x2 = 985;
	private static int y2 = 690;
	private static int change;
	private static int change2;
	public static int character;
	public static int character2;
	public static boolean jumpY;
	public static boolean jumpY2;
	public static String mapCollision;
	public static String mapCollision2;
	public static int pause = 201;
	public static int gameOver;
	public static boolean end = false;
	static Character player1 = new Character(x1,y1,1,player1Name,key);
	static Character player2 = new Character(x2,y2,2,player2Name,key);
	/*switch(character){
	case 1:
		static Vlad player1 = new Vlad(x1,y1,1,player1Name,key);
		break;
	case 2:
		static crocy player1 = new crocy(x1,y1,1,player1Name,key);
		break;
	}
	
	switch(character2){
	case 1:
		static Vlad player2 = new Vlad(x1,y1,1,player2Name,key);
		break;
	case 2:
		static crocy player2 = new crocy(x1,y1,1,player2Name,key);
		break;
	}*/
	
	
	//private static int leftanimate;
	public void paint(Graphics g){
		
			
		if(pause == 0 && gameOver == 0){
			
		//System.out.println(mapNumber);
		switch(mapNumber){
		case 1: 
		//System.out.println(mapNumber);
			map1.drawMap(g);
			break;
		case 2:
		//System.out.println(mapNumber + "0");
			break;
		}
		
		player1.drawPlayer(g,character,change,mapCollision,player1Name,1);
		player2.drawPlayer(g,character2,change2,mapCollision2,player2Name,2);
		
		for(int i = 0; i < player1.lives;i++){
			g.setColor(Color.red);
			g.fillOval(500 + i*45, 10, 40, 40);
			g.setColor(Color.BLACK);
			g.drawOval(500 + i*45, 10, 40, 40);
			g.drawString("1", 518 + i*45, 35);
		}
		for(int i = 0; i < player2.lives;i++){
			g.setColor(Color.blue);
			g.fillOval(1400 + i*45, 10, 40, 40);
			g.setColor(Color.BLACK);
			g.drawOval(1400 + i*45, 10, 40, 40);
			g.drawString("2", 1418 + i*45, 35);
		}
		}
		else if(pause > 0){
			String img = "";
		if(pause >= 130 && pause <= 200){
			if(pause == 160){
				try {		         
			         AudioInputStream audioIn = AudioSystem.getAudioInputStream(Game.class.getResource("/tick.wav" ));		         
			         Clip clip = AudioSystem.getClip();
			         clip.open(audioIn);
			         clip.start();
			      } catch (Exception ex) {
			         ex.printStackTrace();
			      }
			}
			img ="three.png";
		}
		else if(pause < 130 && pause >= 60){
			if(pause == 100){
				try {		         
			         AudioInputStream audioIn = AudioSystem.getAudioInputStream(Game.class.getResource("/tick.wav" ));		         
			         Clip clip = AudioSystem.getClip();
			         clip.open(audioIn);
			         clip.start();
			      } catch (Exception ex) {
			         ex.printStackTrace();
			      }
			}
			img = "two.png";
		}
		else if(pause < 60 && pause > 0){
			if(pause == 30){
				try {		         
			         AudioInputStream audioIn = AudioSystem.getAudioInputStream(Game.class.getResource("/tick.wav" ));		         
			         Clip clip = AudioSystem.getClip();
			         clip.open(audioIn);
			         clip.start();
			      } catch (Exception ex) {
			         ex.printStackTrace();
			      }
			}
			
			img = "one.png";
		}
		
		switch(mapNumber){
		case 1: 
		//System.out.println(mapNumber);
			map1.drawMap(g);
			break;
		case 2:
		//System.out.println(mapNumber + "0");
			break;
		}
		
		
		player1.drawPlayer(g,character,change,mapCollision,player1Name,1);
		player2.drawPlayer(g,character2,change2,mapCollision2,player2Name,2);
		
		for(int i = 0; i < player1.lives;i++){
			g.setColor(Color.red);
			g.fillOval(500 + i*45, 10, 40, 40);
			g.setColor(Color.BLACK);
			g.drawOval(500 + i*45, 10, 40, 40);
			g.drawString("1", 518 + i*45, 35);
		}
		for(int i = 0; i < player2.lives;i++){
			g.setColor(Color.blue);
			g.fillOval(1400 + i*45, 10, 40, 40);
			g.setColor(Color.BLACK);
			g.drawOval(1400 + i*45, 10, 40, 40);
			g.drawString("2", 1418 + i*45, 35);
		}
		pause --;
		g.drawImage(new ImageIcon(Game.class.getResource(img)).getImage(), 915, 490, 70, 100, null);
		
		}
		else if(gameOver > 0){
			//gameOver --;
			if(player1.lives == 0){
				g.drawImage(new ImageIcon(Game.class.getResource("player2wins.png")).getImage(), 570, 480, 760, 120, null);
			}
			else if(player2.lives == 0){
				g.drawImage(new ImageIcon(Game.class.getResource("player1wins.png")).getImage(), 570, 480, 760, 120, null);
			}
			if(gameOver == 1){
				end = true;
			}
		}
		
	}
	
	
	public static void StartGame(){
		
		JFrame game = new JFrame("Older Paper 6: Capstone");
		
		game.setVisible(false);
		
		game.setResizable(false);
		
		game.setSize(1900, 1035);
		
		game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Game panel3 = new Game();
		
		game.add(panel3);
		
		mouse_listener mousey = new mouse_listener();
		
		panel3.setLayout(null);
		
		panel3.addMouseListener(mousey);
		
		game.addKeyListener(key);
		
		
		Timer timer = new Timer(10, new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//tick += 1;
				//x2 += key.changeX;
				//x1 += key.changeX2;
				change = key.changeX;
				change2 = key.changeX2;
				if(key.left && change == 0){
					change = -4;
				}
				else if(key.right && change == 0){
					change = 4;
				}
				if(key.left2 && change2 == 0){
					change2 = -4;
				}
				else if(key.right2 && change2 == 0){
					change2 = 4;
				}
				player1.jumpY = key.jumpY;
				player2.jumpY = key.jumpY2;
				player1Name = Character_Select.player1Name;
				player2Name = Character_Select.player2Name;
				player1.meleeAttackCollision(player2, character);
				player2.meleeAttackCollision(player1, character2);
				player1.projectileAttackCollision(player2,1);
				player2.projectileAttackCollision(player1,2);
				
				if(pause == 1){
					try {		         
				         AudioInputStream audioIn = AudioSystem.getAudioInputStream(Game.class.getResource("/backgroundMusic.wav" ));		         
				         Clip clip = AudioSystem.getClip();
				         clip.open(audioIn);
				         //clip.loop(100);
				      } catch (Exception ex) {
				         ex.printStackTrace();
				      }
				}
				if((player1.lives == 0 || player2.lives == 0)&& start){
					if(end){
					//System.out.println("end");
					start = false;
					//Character_Select.createWindow();
					Character_Select.playAgain = true;
					Character_Select.selected = 0;
					Character_Select.selected2 = 0;
					mapSelect.selected = 0;
					player1.reset(x1,y1,1);
					player2.reset(x2,y2,2);
					end = false;
					gameOver = 0;
					pause = 201;
					game.dispose();
					}
					else if(gameOver == 0){
						gameOver = 100;
					}
					else{
						gameOver --;
					}
				}
				switch(mapNumber){
				case 1: 
					mapCollision = map1.checkCollision(player1.x3, player1.y3,player1.speed,player1);
					mapCollision2 = map1.checkCollision(player2.x3, player2.y3,player2.speed,player2);
					
					break;
				case 2:
					
					break;
				}
				//System.out.println(player1Name);
				//clicked = mousey.clicked;
				panel3.repaint();		
				mousey.released = false;
				//final int x = MouseInfo.getPointerInfo().getLocation().x;
				//final int y = MouseInfo.getPointerInfo().getLocation().y;
				if (mapSelect.selected != 0 && !start){
					game.setVisible(true);
					start = true;
					
				}
				
			}
		});
		timer.start();
	}
}
