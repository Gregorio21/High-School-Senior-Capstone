import java.awt.Graphics;

import javax.swing.ImageIcon;

public class crocy {
	public int x3;
	public int y3;
	public String img;
	public String name;
	private int jump = 50;
	private int speed = 0;
	static keyEvents key;
	public boolean jumpY;
	public crocy(int x, int y, int player, String playerName, keyEvents e) {
		
		x3 = x;
		y3 = y;
		name = playerName;
		key = e;
		//System.out.println(playerName + " vlad");
		if(player == 1){
			img = "right.png";
			//jumpY = key.jumpY;
		}
		else if(player == 2){
			img = "left.png";
			//jumpY = key.jumpY2;
		}
	}
	public void drawPlayer(Graphics g,int characterNumber, int changes, String mapCollision){
		x3 += changes;
		y3 -= speed;
		//System.out.println(changes + " "+name); 
		String right = "crocyright.png";
		String left = "crocyleft.png";
		
		if(y3 > 1080){
			y3 = 690;
			x3 = 885;
		}
		//System.out.println(mapCollision + y3);
		if(mapCollision == "above" && speed <= 0){
			speed = 0;
		}
		else if(mapCollision == "none" && speed >= -2){
			//System.out.println(x3);
			speed -= 2;
		}
		if(jump < 50 && jump >= 0){
			//img = "";
			jump += 1;
			
		}
		else if(jumpY && jump == 50 && mapCollision == "above"){
			//System.out.println(jump);
			speed = 30;
			jump = 0;
		}
		
		if(changes < 0){
			img = left;
			
			/*if(leftanimate <= 30 && leftanimate > 20){
				leftanimate -= 1;
				img = left3;
			}
			else if(leftanimate <= 20 && leftanimate > 10){
				leftanimate -= 1;
				img = left2;
			}
			else if(leftanimate <= 10 && leftanimate > 0){
				leftanimate -= 1;
				img = left;
			}
			else{
				leftanimate = 30;
			}*/
		}
		else if(changes > 0){
			img = right;
		}
		
		g.drawImage(new ImageIcon(img).getImage(), x3, y3, 200, 200, null);
		
	}

}
