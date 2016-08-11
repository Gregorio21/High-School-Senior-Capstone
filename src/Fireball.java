import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Fireball {
int x;
int y;
int speed;
int moving = 0;
int player;
int combo;
int damage;

public Fireball(int x1,int y1,int speed1,int playerType, int d, int c){
	x = x1;
	y = y1;
	speed = speed1;
	player = playerType;
	combo = c;
	damage = d;
	if(c == 3){
		if(speed > 0){
			speed = speed1 -1;
		}
		else if(speed < 0){
			speed = speed1 + 1;
		}
	}
}
public void draw(Graphics g){
	x += speed;
	moving ++;
	String img = "";
	if(speed>0){
		if(moving >= 0 && moving <= 2){
			img = "/fireballright1.png";
		}
		else if(moving > 2 && moving <= 4){
			img = "/fireballright2.png";
		}
		else if(moving > 4 && moving <= 6){
			img = "/fireballright3.png";
		}
		else if(moving > 6 && moving <= 8){
			img = "/fireballright4.png";
		}
		else if(moving > 8 && moving <= 10){
			img = "/fireballright5.png";
		}
		else if(moving > 10 && moving <= 12){
			img = "/fireballright6.png";
		}
		else if(moving > 12 && moving <= 14){
			img = "/fireballright7.png";
		}
		else if(moving > 14 && moving <= 16){
			img = "/fireballright8.png";
		}
		else if(moving > 16 && moving <= 18){
			img = "/fireballright9.png";
		}
		else if(moving > 18 && moving <= 20){
			img = "/fireballright10.png";
		}
		else if(moving > 20 && moving <= 22){
			img = "/fireballright11.png";
		}
		else if(moving > 22 && moving <= 24){
			img = "/fireballright12.png";
		}
		else if(moving > 24 && moving <= 26){
			img = "/fireballright13.png";
		}
		else if(moving > 26 && moving <= 28){
			img = "/fireballright14.png";
		}
		else if(moving > 28 && moving <= 30){
			img = "/fireballright15.png";
		}
		else if(moving > 30 && moving <= 32){
			img = "/fireballright16.png";
		}
		else if(moving > 32 && moving <= 34){
			img = "/fireballright17.png";
		}
		else if(moving > 34 && moving <= 36){
			img = "/fireballright18.png";
		}
		else if(moving > 36 && moving <= 38){
			img = "/fireballright19.png";
		}
		else if(moving > 38 && moving <= 40){
			img = "/fireballright20.png";
		}
		else if(moving > 40 && moving <= 42){
			img = "/fireballright21.png";
			moving = 0;
		}
	}
	else{
		if(moving >= 0 && moving <= 2){
			img = "/fireballleft1.png";
		}
		else if(moving > 2 && moving <= 4){
			img = "/fireballleft2.png";
		}
		else if(moving > 4 && moving <= 6){
			img = "/fireballleft3.png";
		}
		else if(moving > 6 && moving <= 8){
			img = "/fireballleft4.png";
		}
		else if(moving > 8 && moving <= 10){
			img = "/fireballleft5.png";
		}
		else if(moving > 10 && moving <= 12){
			img = "/fireballleft6.png";
		}
		else if(moving > 12 && moving <= 14){
			img = "/fireballleft7.png";
		}
		else if(moving > 14 && moving <= 16){
			img = "/fireballleft8.png";
		}
		else if(moving > 16 && moving <= 18){
			img = "/fireballleft9.png";
		}
		else if(moving > 18 && moving <= 20){
			img = "/fireballleft10.png";
		}
		else if(moving > 20 && moving <= 22){
			img = "/fireballleft11.png";
		}
		else if(moving > 22 && moving <= 24){
			img = "/fireballleft12.png";
		}
		else if(moving > 24 && moving <= 26){
			img = "/fireballleft13.png";
		}
		else if(moving > 26 && moving <= 28){
			img = "/fireballleft14.png";
		}
		else if(moving > 28 && moving <= 30){
			img = "/fireballleft15.png";
		}
		else if(moving > 30 && moving <= 32){
			img = "/fireballleft16.png";
		}
		else if(moving > 32 && moving <= 34){
			img = "/fireballleft17.png";
		}
		else if(moving > 34 && moving <= 36){
			img = "/fireballleft18.png";
		}
		else if(moving > 36 && moving <= 38){
			img = "/fireballleft19.png";
		}
		else if(moving > 38 && moving <= 40){
			img = "/fireballleft20.png";
		}
		else if(moving > 40 && moving <= 42){
			img = "/fireballleft21.png";
			moving = 0;
		}
	}
	if(combo == 3){
		
		g.drawImage(new ImageIcon(Game.class.getResource(img)).getImage(), x, y-32, 128, 128, null);
		if(player == 2){
			if(speed > 0){
				g.setColor(Color.blue);
				g.fillOval(x+60, y+25, 24, 24);
			}
			else{
				g.setColor(Color.blue);
				g.fillOval(x+51, y+25, 24, 24);
			}
		}
	}
	else{
		g.drawImage(new ImageIcon(Game.class.getResource(img)).getImage(), x, y, 64, 64, null);
		if(player == 2){
			if(speed > 0){
				g.setColor(Color.blue);
				g.fillOval(x+31, y+28, 12, 12);
			}
			else{
				g.setColor(Color.blue);
				g.fillOval(x+23, y+28, 12, 12);
			}
		}
	}
	
	
}
}
