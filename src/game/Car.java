package game;

public class Car extends Player {
	
	public Car(int posX, int posY, int speed){
		super(posX,posY,speed);
	}

	public void move(String direction){
		Player.move(direction);
	}
	
	public void stop(){
		Player.stop();
	}
	
	public int getPosX(){
		Player.getPosX();
	}
	
	public int getPosY(){
		Player.getPosY();
	}
	
}
