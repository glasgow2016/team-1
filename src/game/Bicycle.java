package game;

public class Bicycle extends Player {

	public Bicycle(int posX, int posY, int speed) {
		super(posX,posY,speed);
	}
	
	public void move(String direction){
		Player.move(direction);
	}
	
	public int getPosX(){
		Player.getPosX();
	}
	
	public int getPosY(){
		Player.getPosY();
	}
}
