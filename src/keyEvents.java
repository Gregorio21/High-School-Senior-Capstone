import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class keyEvents implements KeyListener{
	public boolean jumpY = false;
	public int changeX = 0;
	public boolean jumpY2 = false;
	public int changeX2 = 0;
	public boolean meleeAttack = false;
	public boolean meleeAttack2 = false;
	boolean shield = false;
	boolean shield2 = false;
	boolean left = false;
	boolean right = false;
	boolean left2 = false;
	boolean right2 = false;
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int key = e.getKeyCode();
		//System.out.println("key");
		if(Game.pause <= 0 && Game.gameOver <= 0){
		if(key == KeyEvent.VK_W){
			jumpY = true;
		}
		if(key == KeyEvent.VK_A){
			changeX = -4;
			left = true;
		}
		if(key == KeyEvent.VK_D){
			changeX = 4;
			right = true;
		}
		if(key == KeyEvent.VK_UP){
			jumpY2 = true;
		}
		if(key == KeyEvent.VK_LEFT){
			changeX2 = -4;
			left2 = true;
		}
		if(key == KeyEvent.VK_RIGHT){
			changeX2 = 4;
			right2 = true;
		}
		if(key == KeyEvent.VK_CONTROL){
			meleeAttack2 = true;
			
		}
		if(key == KeyEvent.VK_F){
			meleeAttack = true;
			
		}
		if(key == KeyEvent.VK_G){
			shield = true;
			
		}
		if(key == KeyEvent.VK_ALT){
			shield2 = true;
			
		}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int key = e.getKeyCode();
		if(Game.pause <= 0 && Game.gameOver <= 0){
		if(key == KeyEvent.VK_W){
			jumpY = false;
		}
		if(key == KeyEvent.VK_A){
			changeX = 0;
			left = false;
		}
		if(key == KeyEvent.VK_D){
			changeX = 0;
			right = false;
		}
		if(key == KeyEvent.VK_UP){
			jumpY2 = false;
		}
		if(key == KeyEvent.VK_LEFT){
			changeX2 = 0;
			left2 = false;
		}
		if(key == KeyEvent.VK_RIGHT){
			changeX2 = 0;
			right2 = false;
		}
		if(key == KeyEvent.VK_CONTROL){
			meleeAttack2 = false;
		}
		if(key == KeyEvent.VK_F){
			meleeAttack = false;
		}
		if(key == KeyEvent.VK_G){
			shield = false;
			
		}
		if(key == KeyEvent.VK_ALT){
			shield2 = false;
			
		}
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
