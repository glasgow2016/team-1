package game;
public class Player {
	
	private int posX;
	private int posY;
	private int speed;
	
	/*Returns the position of the object on the X axis*/
	public int getPosX() {
		return posX;
	}

	/*Returns the position of the object on the Y axis*/
	public int getPosY() {
		return posY;
	}
	
	public Player(int x, int y, int speed){
		posX = x;
		posY = y;
		this.speed = speed;
	}
	
	/*Changes the position of the object*/
	public void move(String direction){
		switch(direction){
		case "up":
			posY -= speed;
			break;
		case "right":
			posX += speed;
			break;
		case "down":
			posY += speed;
			break;
		case "left":
			posX -= speed;
			break;
		}
	}
	
}