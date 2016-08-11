import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;

public class Character {
	int interval = 0;
	int combo = 0;
	public int x3;
	public int y3;
	public String img;
	public String name;
	private int jump = 50;
	int speed = 0;
	static keyEvents key;
	public boolean jumpY;
	private int initial;
	int jumped = 0;
	private boolean pressed = false;
	private int attacking = 0;
	private String direction;
	public int health = 100;
	public int characterNum;
	public boolean hit = false;
	public int walkingleft = 0;
	public int walkingright = 0;
	public int knockedBack = 0;
	public int knockbackSpeed = 0;
	public int lives = 3;
	int shielded = 100;
	boolean protecting = false;
	boolean projectileCollision = false;
	int damage = 0;
	List<Fireball> fireballs = new ArrayList<Fireball>();
	//public static boolean jumpY;
	public Character(int x,int y, int player, String playerName, keyEvents e){
		x3 = x;
		y3 = y;
		name = playerName;
		key = e;
		//System.out.println(playerName + " vlad");
		initial = player;
		
	}
	public void drawPlayer(Graphics g,int characterNumber, int changes, String mapCollision, String playerName, int player){
		x3 += changes;
		y3 -= speed;
		String right = "";
		String left = "";
		String leftwalking = "";
		String leftwalking2 = "";
		String leftwalking3 ="";
		String leftwalking4= "";
		String leftwalking5 = "";
		String leftwalking6 = "";
		String leftwalking7 ="";
		String leftwalking8 = "";
		String rightwalking = "";
		String rightwalking2 = "";
		String rightwalking3 = "";
		String rightwalking4 = "";
		String rightwalking5 = "";
		String rightwalking6 = "";
		String rightwalking7 = "";
		String rightwalking8 = "";
		characterNum = characterNumber;
		//System.out.println(playerName.length());
		//changes images based on what character is selected
		switch(characterNumber){
		case 1:
			right = "/right.png";
			left = "/left.png";
			leftwalking = "/leftwalking.png";
			leftwalking2 = "/leftwalking2.png";
			leftwalking3 ="/leftwalking3.png";
			leftwalking4= "/leftwalking4.png";
			leftwalking5 = "/leftwalking5.png";
			leftwalking6 = "/leftwalking6.png";
			leftwalking7 ="/leftwalking7.png";
			leftwalking8 ="/leftwalking8.png";
			rightwalking = "/rightwalking.png";
			rightwalking2 = "/rightwalking2.png";
			rightwalking3 = "/rightwalking3.png";
			rightwalking4 = "/rightwalking4.png";
			rightwalking5 = "/rightwalking5.png";
			rightwalking6 = "/rightwalking6.png";
			rightwalking7 = "/rightwalking7.png";
			rightwalking8 = "/rightwalking8.png";
			break;
		case 2:
			right = "/crocyright.png";
			left = "/crocyleft.png";
			leftwalking = "/crocyleftwalking.png";
			leftwalking2 = "/crocyleftwalking2.png";
			leftwalking3 ="/crocyleftwalking3.png";
			leftwalking4= "/crocyleftwalking4.png";
			leftwalking5 = "/crocyleftwalking5.png";
			leftwalking6 = "/crocyleftwalking.png";
			leftwalking7 ="/crocyleftwalking7.png";
			leftwalking8 ="/crocyleftwalking8.png";
			rightwalking = "/crocyrightwalking.png";
			rightwalking2 = "/crocyrightwalking2.png";
			rightwalking3 = "/crocyrightwalking3.png";
			rightwalking4 = "/crocyrightwalking4.png";
			rightwalking5 = "/crocyrightwalking5.png";
			rightwalking6 = "/crocyrightwalking6.png";
			rightwalking7 = "/crocyrightwalking7.png";
			rightwalking8 = "/crocyrightwalking8.png";
			break;
		case 3:
			right = "/magerightwalking1.png";
			left = "/mageleftwalking1.png";
			leftwalking = "/mageleftwalking1.png";
			leftwalking2 = "/mageleftwalking2.png";
			leftwalking3 ="/mageleftwalking3.png";
			leftwalking4= "/mageleftwalking4.png";
			leftwalking5 = "/mageleftwalking5.png";
			leftwalking6 = "/mageleftwalking6.png";
			leftwalking7 ="/mageleftwalking7.png";
			leftwalking8 ="/mageleftwalking8.png";
			rightwalking = "/magerightwalking1.png";
			rightwalking2 = "/magerightwalking2.png";
			rightwalking3 = "/magerightwalking3.png";
			rightwalking4 = "/magerightwalking4.png";
			rightwalking5 = "/magerightwalking5.png";
			rightwalking6 = "/magerightwalking6.png";
			rightwalking7 = "/magerightwalking7.png";
			rightwalking8 = "/magerightwalking8.png";
			break;
		}
		//detects if a player has fallen below the map
		if(y3 > 1180 || health <= 0){
			double random = Math.floor(Math.random()*11);
			//System.out.println(random);
			if(random == 0){
				y3 = 490;
				x3 = 945;
			}
			else if(random == 1){
				y3 = 490;
				x3 = 455;
			}
			else if(random == 2){
				y3 = 490;
				x3 = 1405;
			}
			else if(random == 3){
				y3 = 290;
				x3 = 705;
			}
			else if(random == 4){
				y3 = 290;
				x3 = 1165;
			}
			else if(random == 5){
				y3 = 90;
				x3 = 945;
			}
			else if(random == 6){
				y3 = 90;
				x3 = 1405;
			}
			else if(random == 7){
				y3 = 90;
				x3 = 455;
			}
			else if(random == 8){
				y3 = 690;
				x3 = 885;
			}
			else if(random == 9){
				y3 = 490;
				x3 = 1465;
			}
			else if(random == 10){
				y3 = 490;
				x3 = 265;
			}
			
			health = 100;
			lives --;
			speed = 0;
			knockedBack = 0;
			jumped = 0;
			knockbackSpeed = 0;
			initial = player;
			key.changeX = 0;
			key.changeX2 = 0;
		}
		//System.out.println(mapCollision + y3);
		//checks for map collision and creates gravity/makes platforms feel like they exist to player
		
		if(mapCollision == "above" && speed <= 0){
			speed = 0;
			jumped = 0;
			
		}
		else if(mapCollision == "below" && speed >= 0){
			speed = 0;
		}
		else if(mapCollision == "none"){
			//System.out.println(x3);
			speed -= 1;
		}
		if(jump < 50 && jump >= 0){
			//img = "";
			jump += 1;
			
		}
		//controls jumping for the player
		if(jumpY && jump == 50 && jumped == 0 && !pressed){
			//System.out.println(jump);
			speed = 20;
			jump = 0;
			jumped += 1;
			pressed = true;
			
		}
		else if(jumpY && jumped == 1 && !pressed){
			//System.out.println(jump);
			speed = 18;
			jump = 0;
			jumped += 1;
			pressed = true;
		}
		else if(!jumpY && pressed){
			pressed = false;
		}
		
		if(knockedBack > 0){
			x3 -= changes;
			y3 += speed;
			x3 += knockbackSpeed;
			knockedBack -= 1;
			if(knockedBack > 10){
				y3 -= 2;
				
			}
			
		}
		
		//detects which direction the player is moving
		if(changes < 0){
			//img = left;
			direction ="left";
			walkingright = 0;
			walkingleft += 1;
			if(walkingleft >= 0 && walkingleft < 5){
				img = leftwalking;
			}
			else if(walkingleft >= 5 && walkingleft < 10){
				img = leftwalking2;
			}
			else if(walkingleft >= 10 && walkingleft < 15){
				img = leftwalking3;
			}
			else if(walkingleft >= 15 && walkingleft < 20){
				img = leftwalking4;
			}
			else if(walkingleft >= 20 && walkingleft < 25){
				img = leftwalking5;
			}
			else if(walkingleft >= 25 && walkingleft < 30){
				img = leftwalking6;
			}
			else if(walkingleft >= 30 && walkingleft < 35){
				img = leftwalking7;
			}
			else if(walkingleft >= 35 && walkingleft < 40){
				img = leftwalking8;
			}
			else{
				walkingleft = 0;
				img = leftwalking8;
			}
			
		}
		else if(changes > 0){
			//img = right;
			direction ="right";
			walkingright += 1;
			walkingleft = 0;
			if(walkingright >= 0 && walkingright < 5){
				img = rightwalking;
			}
			else if(walkingright >= 5 && walkingright < 10){
				img = rightwalking2;
			}
			else if(walkingright >= 10 && walkingright < 15){
				img = rightwalking3;
			}
			else if(walkingright >= 15 && walkingright < 20){
				img = rightwalking4;
			}
			else if(walkingright >= 20 && walkingright < 25){
				img = rightwalking5;
			}
			else if(walkingright >= 25 && walkingright < 30){
				img = rightwalking6;
			}
			else if(walkingright >= 30 && walkingright < 35){
				img = rightwalking7;
			}
			else if(walkingright >= 35 && walkingright < 40){
				img = rightwalking8;
			}
			else{
				walkingright = 0;
				img = rightwalking8;
			}
		}
		else if(initial == 1){
			img = right;
			initial = 0;
			direction ="right";
		}
		else if(initial == 2){
			img = left;
			initial = 0;
			direction ="left";
		}
		else if(direction == "left"){
			walkingright = 0;
			walkingleft = 0;
			img = left;
		}
		else if(direction == "right"){
			walkingright = 0;
			walkingleft = 0;
			img = right;
		}
		if(attack(player,characterNumber) != ""){
			
			img = attack(player,characterNumber);
		}
		if(img == ""){
			if(direction == "left"){
				img = left;
			}
			else if(direction == "right"){
				img = right;
			}
		}
		//draws players names over their head and centers based on name length
		if(playerName.length() == 0){
			g.setColor(Color.black);
			g.drawString("player" + player, x3 + 85, y3 + 35);
			g.drawRect(x3 + 54, y3 + 40, 101, 10);
			g.setColor(new Color(220,40,20,98));
			g.fillRect(x3 + 55, y3 + 40, health, 10);
		}
		else{
			g.setColor(Color.black);
			g.drawString(playerName, x3 + 100 - (3*playerName.length()), y3 + 35);
			g.drawRect(x3 + 54, y3 + 40, 101, 10);
			g.setColor(new Color(220,40,20,98));
			g.fillRect(x3 + 55, y3 + 40, health, 10);
		}
		for(int i = 0;i<fireballs.size();i++){
			fireballs.get(i).draw(g);
		}
		g.drawImage(new ImageIcon(First_Screen.class.getResource(img)).getImage(), x3, y3, 200, 200, null);
		//System.out.println(img);
		if((player == 1 && key.shield && shielded > 0)||(player == 2 && key.shield2 && shielded > 0)){
			g.setColor(new Color(240,200,20,90));
			g.fillOval(x3+70, y3+50, 60, 100);
			protecting = true;
			shielded --;
			//System.out.println(shielded);
		}
		else if((player == 1 && !key.shield && (shielded <= 100))||(player == 2 && !key.shield2 && (shielded <= 100)) ){
			shielded += 2;
			protecting = false;
		}
		else{
			protecting = false;
		}
	}
	private String attack(int player,int characterNumber){
		String rightattack = "";
		String rightattack2 = "";
		String rightattack3 = "";
		String rightattack4 = "";
		String rightattack5 = "";
		String rightattack6 = "";
		String rightattack7 = "";
		String rightattack8 = "";
		String rightattack9 = "";
		String rightattack10 = "";
		String rightattack11 = "";
		String leftattack = "";
		String leftattack2 = "";
		String leftattack3 = "";
		String leftattack4 = "";
		String leftattack5 = "";
		String leftattack6 = "";
		String leftattack7 = "";
		String leftattack8 = "";
		String leftattack9 = "";
		String leftattack10 = "";
		String leftattack11 = "";
		
		
		switch(characterNumber){
		case 1:
			 //interval = 4;
			 rightattack = "/rightattack.png";
			 rightattack2 = "/rightattack2.png";
			 rightattack3 = "/rightattack3.png";
			 rightattack4 = "/rightattack4.png";
			 rightattack5 = "/rightattack5.png";
			 rightattack6 = "/rightattack6.png";
			 rightattack7 = "/rightattack7.png";
			 rightattack8 = "/rightattack8.png";
			 rightattack9 = "/rightattack9.png";
			 rightattack10 = "/rightattack10.png";
			 rightattack11 = "/rightattack11.png";
			 leftattack = "/leftattack.png";
			 leftattack2 = "/leftattack2.png";
			 leftattack3 = "/leftattack3.png";
			 leftattack4 = "/leftattack4.png";
			 leftattack5 = "/leftattack5.png";
			 leftattack6 = "/leftattack6.png";
			 leftattack7 = "/leftattack7.png";
			 leftattack8 = "/leftattack8.png";
			 leftattack9 = "/leftattack9.png";
			 leftattack10 = "/leftattack10.png";
			 leftattack11 = "/leftattack11.png";
			break;
		case 2:
			 //interval = 12;
			 rightattack = "/crocyrightattack.png";
			 rightattack2 = "/crocyrightattack2.png";
			 rightattack3 = "/crocyrightattack3.png";
			 rightattack4 = "/crocyrightattack4.png";
			 rightattack5 = "/crocyrightattack5.png";
			 rightattack6 = "/crocyrightattack6.png";
			 rightattack7 = "/crocyrightattack7.png";
			 rightattack8 = "/crocyrightattack8.png";
			 rightattack9 = "/crocyrightattack9.png";
			 rightattack10 = "/crocyrightattack10.png";
			 rightattack11 = "/crocyrightattack10.png";
			 leftattack = "/crocyleftattack.png";
			 leftattack2 = "/crocyleftattack2.png";
			 leftattack3 = "/crocyleftattack3.png";
			 leftattack4 = "/crocyleftattack4.png";
			 leftattack5 = "/crocyleftattack5.png";
			 leftattack6 = "/crocyleftattack6.png";
			 leftattack7 = "/crocyleftattack7.png";
			 leftattack8 = "/crocyleftattack8.png";
			 leftattack9 = "/crocyleftattack9.png";
			 leftattack10 = "/crocyleftattack10.png";
			 leftattack11 = "/crocyleftattack10.png";
			break;
		case 3:
			//interval = 12;
			rightattack = "/magerightattack1.png";
			 rightattack2 = "/magerightattack2.png";
			 rightattack3 = "/magerightattack3.png";
			 rightattack4 = "/magerightattack4.png";
			 rightattack5 = "/magerightattack5.png";
			 rightattack6 = "/magerightattack6.png";
			 rightattack7 = "/magerightattack7.png";
			 rightattack8 = "/magerightattack8.png";
			 rightattack9 = "/magerightattack9.png";
			 rightattack10 = "/magerightattack10.png";
			 rightattack11 = "/magerightattack10.png";
			 leftattack = "/mageleftattack1.png";
			 leftattack2 = "/mageleftattack2.png";
			 leftattack3 = "/mageleftattack3.png";
			 leftattack4 = "/mageleftattack4.png";
			 leftattack5 = "/mageleftattack5.png";
			 leftattack6 = "/mageleftattack6.png";
			 leftattack7 = "/mageleftattack7.png";
			 leftattack8 = "/mageleftattack8.png";
			 leftattack9 = "/mageleftattack9.png";
			 leftattack10 = "/mageleftattack10.png";
			 leftattack11 = "/mageleftattack11.png";
			break;
		}
		if((key.meleeAttack || key.meleeAttack2) && attacking == 0){
			if(characterNum == 1){
				if(combo == 3){
					combo = 0;
				}
				if(combo == 0){
					interval = 6;
					combo ++;
					damage = 10;
				}
				else if(combo == 1){
					combo ++;
					interval = 4;
					damage = 10;
				}
				else if(combo == 2){
					combo ++;
					interval = 2;
					damage = 10;
				}
			}
			else if(characterNum == 2){
				if(combo == 3){
					combo = 0;
				}
				if(combo == 0){
					interval = 12;
					combo ++;
					damage = 10;
				}
				else if(combo == 1){
					combo ++;
					interval = 18;
					damage = 15;
				}
				else if(combo == 2){
					combo ++;
					interval = 24;
					damage = 20;
				}
			}
			else if(characterNum == 3){
				if(combo == 3){
					combo = 0;
				}
				if(combo == 0){
					interval = 12;
					combo ++;
					damage = 10;
				}
				else if(combo == 1){
					interval = 12;
					combo ++;
					damage = 10;
				}
				else if(combo == 2){
					interval = 24;
					damage = 25;
					combo ++;
				}
			}
		}
		if(direction == "left"){
			
			if(player == 1){
				if(key.meleeAttack && attacking == 0){
					attacking += 1;
					if(characterNum == 1 || characterNum == 2){
					try {		         
				         AudioInputStream audioIn = AudioSystem.getAudioInputStream(Character.class.getResource("/woosh.wav" ));		         
				         Clip clip = AudioSystem.getClip();
				         clip.open(audioIn);
				         clip.start();
				      } catch (Exception ex) {
				         ex.printStackTrace();
				      }
					
					return leftattack;
				}}
				
				
			}
			else{
				if(key.meleeAttack2 && attacking == 0){
					attacking += 1;
					if(characterNum == 1 || characterNum == 2){
					try {		         
				         AudioInputStream audioIn = AudioSystem.getAudioInputStream(Character.class.getResource("/woosh.wav" ));		         
				         Clip clip = AudioSystem.getClip();
				         clip.open(audioIn);
				         clip.start();
				      } catch (Exception ex) {
				         ex.printStackTrace();
				      }
				
					return leftattack;
				}}
				
			}
			
			if(attacking > 0 && attacking <= interval){
				attacking += 1;
				return leftattack2;
			}
			else if(attacking > interval && attacking <= 2*interval){
				attacking += 1;
				return leftattack3;
			}
			else if(attacking > 2*interval && attacking <= 3*interval){
				attacking += 1;
				return leftattack4;
			}
			else if(attacking > 3*interval && attacking <= 4*interval){
				attacking += 1;
				return leftattack5;
			}
			else if(attacking > 4*interval && attacking <= 5*interval){
				attacking += 1;
				
				return leftattack6;
			}
			else if(attacking > 5*interval && attacking <= 6*interval){
				attacking += 1;
				return leftattack7;
			}
			else if(attacking > 6*interval && attacking <= 7*interval){
				attacking += 1;
				return leftattack8;
			}
			else if(attacking > 7*interval && attacking <= 8*interval){
				attacking += 1;
				
				return leftattack9;
			}
			else if(attacking > 8*interval && attacking <= 9*interval){
				attacking += 1;
				return leftattack10;
			}
			else if(attacking > 9*interval && attacking <= 10*interval){
				attacking += 1;
				if(characterNum == 3 && attacking == 9.5*interval && knockedBack == 0){
					fireballs.add(new Fireball(x3+40,y3 + 60,-6,player,damage,combo));
					try {		         
				         AudioInputStream audioIn = AudioSystem.getAudioInputStream(Character.class.getResource("/fireball.wav" ));		         
				         Clip clip = AudioSystem.getClip();
				         clip.open(audioIn);
				         clip.start();
				      } catch (Exception ex) {
				         ex.printStackTrace();
				      }
					}
				return leftattack11;
			}
			else if(attacking > 10*interval){
				attacking = 0;
				hit = false;
				
				return "";
			}
			else{
				return "";
			}
		}
		else if(direction == "right"){
			
			if(player == 1){
				if(key.meleeAttack && attacking == 0){
					attacking += 1;
					if(characterNum == 1 || characterNum == 2){
					try {		         
				         AudioInputStream audioIn = AudioSystem.getAudioInputStream(Character.class.getResource("/woosh.wav" ));		         
				         Clip clip = AudioSystem.getClip();
				         clip.open(audioIn);
				         clip.start();
				      } catch (Exception ex) {
				         ex.printStackTrace();
				      }
					}
					
					return rightattack;
				}
				
			}
			else{
				if(key.meleeAttack2 && attacking == 0){
					attacking += 1;
					if(characterNum == 1 || characterNum == 2){
					try {		         
				         AudioInputStream audioIn = AudioSystem.getAudioInputStream(Character.class.getResource("/woosh.wav" ));		         
				         Clip clip = AudioSystem.getClip();
				         clip.open(audioIn);
				         clip.start();
				      } catch (Exception ex) {
				         ex.printStackTrace();
				      }
					}
					
					return rightattack;
				}
			}
			if(attacking > 0 && attacking <= interval){
				attacking += 1;
				return rightattack2;
			}
			else if(attacking > interval && attacking <= 2*interval){
				attacking += 1;
				return rightattack3;
			}
			else if(attacking > 2*interval && attacking <= 3*interval){
				attacking += 1;
				return rightattack4;
			}
			else if(attacking > 3*interval && attacking <= 4*interval){
				attacking += 1;
				return rightattack5;
			}
			else if(attacking > 4*interval && attacking <= 5*interval){
				attacking += 1;
				
				return rightattack6;
			}
			else if(attacking > 5*interval && attacking <= 6*interval){
				attacking += 1;
				return rightattack7;
			}
			else if(attacking > 6*interval && attacking <= 7*interval){
				attacking += 1;
				return rightattack8;
			}
			else if(attacking > 7*interval && attacking <= 8*interval){
				attacking += 1;
				return rightattack9;
			}
			else if(attacking > 8*interval && attacking <= 9*interval){
				attacking += 1;
				return rightattack10;
			}
			else if(attacking > 9*interval && attacking <= 10*interval){
				attacking += 1;
				if(characterNum == 3 && attacking == 9.5*interval && knockedBack == 0){
					fireballs.add(new Fireball(x3 + 120,y3 + 60,6,player,damage,combo));
					try {		         
				         AudioInputStream audioIn = AudioSystem.getAudioInputStream(Character.class.getResource("/fireball.wav" ));		         
				         Clip clip = AudioSystem.getClip();
				         clip.open(audioIn);
				         clip.start();
				      } catch (Exception ex) {
				         ex.printStackTrace();
				      }
					}
				return rightattack11;
			}
			else if(attacking > 10*interval){
				attacking = 0;
				hit = false;
				
				return "";
			}
			else{
				return "";
			}
			
		}
		else{
			return "";
		}
	}
	public boolean meleeAttackCollision(Character e, int CharacterNumber){
		if(!(e.protecting)){
		if(CharacterNumber == 1 && attacking > 7*interval && !hit && ((y3+55 >= e.y3+55 && y3+55 <= e.y3+145)||(y3+145 >= e.y3+55 && y3+145 <= e.y3+145))){
			if(direction == "left"){
				if(e.characterNum == 1 || e.characterNum == 3){
					if((x3+30 >= e.x3+70 && x3+30 <= e.x3+109)||(x3+62 >= e.x3+70 && x3+62 <= e.x3+109)){
						e.health -= damage;
						e.knockedBack = 30;
						try {		         
					         AudioInputStream audioIn = AudioSystem.getAudioInputStream(Character.class.getResource("/whack.wav" ));		         
					         Clip clip = AudioSystem.getClip();
					         clip.open(audioIn);
					         clip.start();
					      } catch (Exception ex) {
					         ex.printStackTrace();
					      }
						if(direction == "left"){
							e.knockbackSpeed = -3;
						}
						else if(direction == "right"){
							e.knockbackSpeed = 3;
						}
						hit = true;
						return true;
					}
					else{
						return false;
					}
				}
				else if(e.characterNum == 2){
					if((x3+30 >= e.x3+86 && x3+30 <= e.x3+125)||(x3+62 >= e.x3+86 && x3+62 <= e.x3+125)){
						e.health -= damage;
						e.knockedBack = 30;
						try {		         
					         AudioInputStream audioIn = AudioSystem.getAudioInputStream(Character.class.getResource("/whack.wav" ));		         
					         Clip clip = AudioSystem.getClip();
					         clip.open(audioIn);
					         clip.start();
					      } catch (Exception ex) {
					         ex.printStackTrace();
					      }
						if(direction == "left"){
							e.knockbackSpeed = -3;
						}
						else if(direction == "right"){
							e.knockbackSpeed = 3;
						}
						hit = true;
						return true;
					}
					else{
						return false;
					}
				}
				else{
					return false;
				}
			}
			else if(direction == "right"){
				if(e.characterNum == 1 || e.characterNum == 3){
					if((x3+156 >= e.x3+70 && x3+156 <= e.x3+109)||(x3+124 >= e.x3+70 && x3+124 <= e.x3+109)){
						e.health -= damage;
						e.knockedBack = 30;
						try {		         
					         AudioInputStream audioIn = AudioSystem.getAudioInputStream(Character.class.getResource("/whack.wav" ));		         
					         Clip clip = AudioSystem.getClip();
					         clip.open(audioIn);
					         clip.start();
					      } catch (Exception ex) {
					         ex.printStackTrace();
					      }
						if(direction == "left"){
							e.knockbackSpeed = -3;
						}
						else if(direction == "right"){
							e.knockbackSpeed = 3;
						}
						hit = true;
						return true;
					}
					else{
						return false;
					}
				}
				else if(e.characterNum == 2){
					if((x3+156 >= e.x3+86 && x3+156 <= e.x3+125)||(x3+124 >= e.x3+86 && x3+124 <= e.x3+125)){
						e.health -= damage;
						e.knockedBack = 30;
						try {		         
					         AudioInputStream audioIn = AudioSystem.getAudioInputStream(Character.class.getResource("/whack.wav" ));		         
					         Clip clip = AudioSystem.getClip();
					         clip.open(audioIn);
					         clip.start();
					      } catch (Exception ex) {
					         ex.printStackTrace();
					      }
						if(direction == "left"){
							e.knockbackSpeed = -3;
						}
						else if(direction == "right"){
							e.knockbackSpeed = 3;
						}
						hit = true;
						return true;
					}
					else{
						return false;
					}
				}
				else{
					return false;
				}
			}
			else{
				return false;
			}
		}
		else if(CharacterNumber == 2 && attacking > 7*interval && !hit && ((y3+55 >= e.y3+55 && y3+55 <= e.y3+145)||(y3+145 >= e.y3+55 && y3+145 <= e.y3+145))){
			if(direction == "left"){
				if(e.characterNum == 1 || e.characterNum == 3){
					if((x3+39 >= e.x3+70 && x3+39 <= e.x3+109)||(x3+71 >= e.x3+70 && x3+71 <= e.x3+109)){
						e.health -= damage;
						e.knockedBack = 30;
						try {		         
					         AudioInputStream audioIn = AudioSystem.getAudioInputStream(Character.class.getResource("/whack.wav" ));		         
					         Clip clip = AudioSystem.getClip();
					         clip.open(audioIn);
					         clip.start();
					      } catch (Exception ex) {
					         ex.printStackTrace();
					      }
						if(direction == "left"){
							e.knockbackSpeed = -3;
						}
						else if(direction == "right"){
							e.knockbackSpeed = 3;
						}
						hit = true;
						return true;
					}
					else{
						return false;
					}
				}
				else if(e.characterNum == 2){
					if((x3+39 >= e.x3+86 && x3+39 <= e.x3+125)||(x3+71 >= e.x3+86 && x3+71 <= e.x3+125)){
						e.health -= damage;
						e.knockedBack = 30;
						try {		         
					         AudioInputStream audioIn = AudioSystem.getAudioInputStream(Character.class.getResource("/whack.wav" ));		         
					         Clip clip = AudioSystem.getClip();
					         clip.open(audioIn);
					         clip.start();
					      } catch (Exception ex) {
					         ex.printStackTrace();
					      }
						if(direction == "left"){
							e.knockbackSpeed = -3;
						}
						else if(direction == "right"){
							e.knockbackSpeed = 3;
						}
						hit = true;
						return true;
					}
					else{
						return false;
					}
				}
				else{
					return false;
				}
			}
			else if(direction == "right"){
				if(e.characterNum == 1 || e.characterNum == 3){
					if((x3+148 >= e.x3+70 && x3+148 <= e.x3+109)||(x3+116 >= e.x3+70 && x3+116 <= e.x3+109)){
						e.health -= damage;
						e.knockedBack = 30;
						try {		         
					         AudioInputStream audioIn = AudioSystem.getAudioInputStream(Character.class.getResource("/whack.wav" ));		         
					         Clip clip = AudioSystem.getClip();
					         clip.open(audioIn);
					         clip.start();
					      } catch (Exception ex) {
					         ex.printStackTrace();
					      }
						if(direction == "left"){
							e.knockbackSpeed = -3;
						}
						else if(direction == "right"){
							e.knockbackSpeed = 3;
						}
						hit = true;
						return true;
					}
					else{
						return false;
					}
				}
				else if(e.characterNum == 2){
					if((x3+148 >= e.x3+86 && x3+148 <= e.x3+125)||(x3+116 >= e.x3+86 && x3+116 <= e.x3+125)){
						e.health -= damage;
						e.knockedBack = 30;
						try {		         
					         AudioInputStream audioIn = AudioSystem.getAudioInputStream(Character.class.getResource("/whack.wav" ));		         
					         Clip clip = AudioSystem.getClip();
					         clip.open(audioIn);
					         clip.start();
					      } catch (Exception ex) {
					         ex.printStackTrace();
					      }
						if(direction == "left"){
							e.knockbackSpeed = -3;
						}
						else if(direction == "right"){
							e.knockbackSpeed = 3;
						}
						hit = true;
						return true;
					}
					else{
						return false;
					}
				}
				else{
					return false;
				}
			}
			else{
				return false;
			}
		}
		else{
		return false;
		}}
		else{
			return false;
		}
	}
	public void projectileAttackCollision(Character e, int player){
		projectileCollision = false;
		if(characterNum == 3 && !(e.protecting)){
			
			for(int i = 0;i<fireballs.size();i++){
				Fireball f = fireballs.get(i);
				if(f.speed > 0 && f.x + 35 >= e.x3 + 70 && f.x + 35 <= e.x3 + 110 && f.y + 35 >= e.y3 + 55 && f.y <= e.y3 + 145 && f.player == player){
					projectileCollision = true;
					fireballs.remove(i);
					e.health -= f.damage;
					try {		         
				         AudioInputStream audioIn = AudioSystem.getAudioInputStream(Character.class.getResource("/whack.wav" ));		         
				         Clip clip = AudioSystem.getClip();
				         clip.open(audioIn);
				         clip.start();
				      } catch (Exception ex) {
				         ex.printStackTrace();
				      }
				}
				else if(f.x + 28 >= e.x3 + 70 && f.x + 28 <= e.x3 + 110 && f.y + 35 >= e.y3 + 55 && f.y <= e.y3 + 145 && f.player == player){
					projectileCollision = true;
					fireballs.remove(i);
					e.health -= f.damage;
					try {		         
				         AudioInputStream audioIn = AudioSystem.getAudioInputStream(Character.class.getResource("/whack.wav" ));		         
				         Clip clip = AudioSystem.getClip();
				         clip.open(audioIn);
				         clip.start();
				      } catch (Exception ex) {
				         ex.printStackTrace();
				      }
				}
			}
			
		}
		
		
	}
	public void reset(int x, int y,int player){
		speed = 0;
		x3 = x;
		y3 = y;
		lives = 3;
		health = 100;
		knockedBack = 0;
		jumped = 0;
		knockbackSpeed = 0;
		initial = player;
		key.changeX = 0;
		key.changeX2 = 0;
		attacking = 0;
	}
	
}
