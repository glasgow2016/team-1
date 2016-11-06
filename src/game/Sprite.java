package game;

import java.util.Map;

public class Sprite {
	int xpos;
	int ypos;
	int width;
	int height;

	/**
	 * Created by bianca on 06/11/16.
	 */
	public Sprite(int x, int y){
		xpos = x;
		ypos = y;
	}

	public Sprite(int x, int y, int width, int height){
		this(x, y);
		this.width = width;
		this.height = height;
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
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

}