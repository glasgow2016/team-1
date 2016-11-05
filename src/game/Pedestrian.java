package game;

public class Pedestrian extends Player {

	public Pedestrian(int posX, int posY, int speed) {
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
