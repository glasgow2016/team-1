package game;

public class Bicycle extends Player {

	public Bicycle(int posX, int posY, int speed) {
		super(posX,posY,speed);
	}
	
	public void move(String direction){
		super.move(direction);
	}
	
	public int getPosX(){
		return super.getPosX();
	}
	
	public int getPosY(){
		return super.getPosY();
	}
}
