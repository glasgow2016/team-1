package game;
public class Sprite {
	public int xpos, ypos;
	/**
	 * Created by bianca on 06/11/16.
	 */
	public Sprite(int x, int y){
		xpos = x;
		ypos = y;
	}

	public int getXPos() {
		return xpos;
	}

	public void setXPos(int x) {
		xpos = x;
	}

	public int getYPos() {
		return ypos;
	}

	public void setYpos(int y) {
		ypos = y;
	}
}