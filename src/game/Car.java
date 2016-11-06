package game;

public class Car extends Player {
	
	public Car(int posX, int posY, int speed){
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
