import java.awt.Graphics;
import javax.swing.ImageIcon;
public class map1 {
	public static void drawMap(Graphics g){
		g.drawImage(new ImageIcon(First_Screen.class.getResource("/blueSky.jpg")).getImage(), 0, 0, 1900, 1000, null);
		g.drawImage(new ImageIcon(First_Screen.class.getResource("/medium platform.png")).getImage(), 865, 800, 130, 100, null);
		g.drawImage(new ImageIcon(First_Screen.class.getResource("/medium platform.png")).getImage(), 985, 800, 130, 100, null);
		g.drawImage(new ImageIcon(First_Screen.class.getResource("/medium platform.png")).getImage(), 1105, 800, 130, 100, null);
		g.drawImage(new ImageIcon(First_Screen.class.getResource("/medium platform.png")).getImage(), 1225, 800, 130, 100, null);
		g.drawImage(new ImageIcon(First_Screen.class.getResource("/medium platform.png")).getImage(), 1345, 800, 130, 100, null);
		g.drawImage(new ImageIcon(First_Screen.class.getResource("/medium platform.png")).getImage(), 1465, 800, 130, 100, null);
		g.drawImage(new ImageIcon(First_Screen.class.getResource("/medium platform.png")).getImage(), 1585, 800, 130, 100, null);
		g.drawImage(new ImageIcon(First_Screen.class.getResource("/medium platform.png")).getImage(), 745, 800, 130, 100, null);
		g.drawImage(new ImageIcon(First_Screen.class.getResource("/medium platform.png")).getImage(), 625, 800, 130, 100, null);
		g.drawImage(new ImageIcon(First_Screen.class.getResource("/medium platform.png")).getImage(), 505, 800, 130, 100, null);
		g.drawImage(new ImageIcon(First_Screen.class.getResource("/medium platform.png")).getImage(), 385, 800, 130, 100, null);
		g.drawImage(new ImageIcon(First_Screen.class.getResource("/medium platform.png")).getImage(), 265, 800, 130, 100, null);
		g.drawImage(new ImageIcon(First_Screen.class.getResource("/medium platform.png")).getImage(), 145, 800, 130, 100, null);
		
		g.drawImage(new ImageIcon(First_Screen.class.getResource("/large thin platform.png")).getImage(), 835, 600, 120, 60, null);
		g.drawImage(new ImageIcon(First_Screen.class.getResource("/large thin platform.png")).getImage(), 945, 600, 120, 60, null);
		g.drawImage(new ImageIcon(First_Screen.class.getResource("/large thin platform.png")).getImage(), 1295, 600, 120, 60, null);
		g.drawImage(new ImageIcon(First_Screen.class.getResource("/large thin platform.png")).getImage(), 1405, 600, 120, 60, null);
		g.drawImage(new ImageIcon(First_Screen.class.getResource("/large thin platform.png")).getImage(), 345, 600, 120, 60, null);
		g.drawImage(new ImageIcon(First_Screen.class.getResource("/large thin platform.png")).getImage(), 455, 600, 120, 60, null);
		
		g.drawImage(new ImageIcon(First_Screen.class.getResource("/large thin platform.png")).getImage(), 595, 400, 120, 60, null);
		g.drawImage(new ImageIcon(First_Screen.class.getResource("/large thin platform.png")).getImage(), 705, 400, 120, 60, null);
		g.drawImage(new ImageIcon(First_Screen.class.getResource("/large thin platform.png")).getImage(), 1055, 400, 120, 60, null);
		g.drawImage(new ImageIcon(First_Screen.class.getResource("/large thin platform.png")).getImage(), 1165, 400, 120, 60, null);
		
		g.drawImage(new ImageIcon(First_Screen.class.getResource("/large thin platform.png")).getImage(), 835, 200, 120, 60, null);
		g.drawImage(new ImageIcon(First_Screen.class.getResource("/large thin platform.png")).getImage(), 945, 200, 120, 60, null);
		g.drawImage(new ImageIcon(First_Screen.class.getResource("/large thin platform.png")).getImage(), 1295, 200, 120, 60, null);
		g.drawImage(new ImageIcon(First_Screen.class.getResource("/large thin platform.png")).getImage(), 1405, 200, 120, 60, null);
		g.drawImage(new ImageIcon(First_Screen.class.getResource("/large thin platform.png")).getImage(), 345, 200, 120, 60, null);
		g.drawImage(new ImageIcon(First_Screen.class.getResource("/large thin platform.png")).getImage(), 455, 200, 120, 60, null);
		
	}
	public static String checkCollision(int x, int y,int speed,Character e){
		//System.out.println(speed + y);
		if(((y-speed > 690 && y < 690 || y == 690) && x >= 52 && x <= 1622)){
			if(e.speed < 0){
			e.speed = 0;
			e.jumped = 0;
			}
			return "above";
		}	
		else if((y-speed > 490 && y < 490 || y == 490) && ((x >= 742 && x <= 1065-93)||(x >= 1202 && x <= 1525-93)|| (x >= 252 && x <= 575-93))){
			e.y3 = 490;
			if(e.speed < 0){
				e.speed = 0;
				e.jumped = 0;
				}
			return "above";
		}
		else if((y-speed > 290 && y < 290 || y == 290) && ((x >= 502 && x <= 825-93)||(x >= 962 && x <= 1285-93))){
			e.y3 = 290;
			if(e.speed < 0){
				e.speed = 0;
				e.jumped = 0;
				}
			return "above";
		}
		else if(((y == 800) && x >= 52 && x <= 1622)){
			return "below";
		}
		else if((y-speed > 90 && y < 90 || y == 90) && ((x >= 742 && x <= 1065-93)||(x >= 1202 && x <= 1525-93)|| (x >= 252 && x <= 575-93))){
			e.y3 = 90;
			if(e.speed < 0){
				e.speed = 0;
				e.jumped = 0;
				}
			return "above";
		}
		else{
		return "none";
		}
	}
}
