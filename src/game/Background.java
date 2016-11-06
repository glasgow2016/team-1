package game;

import java.awt.image.BufferedImage;
import java.util.Map;

/**
 * Created by megamolis on 06/11/2016.
 */
public class Background {
    private static final int VELOCITY = 5;
    int x;
    int y;
    BufferedImage origin;
    BufferedImage top;
    BufferedImage right;
    int width;
    int height;
    int farRight;

    public Background(Map<String, BufferedImage> images) {
        x = 0;
        y = 0;
        origin = images.get("junction");
        right = images.get("t-junction");
        right = images.get("t-junction2");
        farRight = width * 2;
    }

    public void moveRight() {
        if (width > 10) {
            x-=VELOCITY;
            width-=VELOCITY;
        }
    }
    public void moveLeft() {
        if (x < -1) {
            x+=VELOCITY;
            width+=VELOCITY;
        }
    }

    public void moveTop() {
        if (y < height) {
            y+=VELOCITY;
            height+=VELOCITY;
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public BufferedImage getOrigin() {
        return origin;
    }

    public void setOrigin(BufferedImage origin) {
        this.origin = origin;
    }

    public BufferedImage getRight() {
        return right;
    }

    public void setRight(BufferedImage right) {
        this.right = right;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getFarRight() {
        return farRight;
    }

    public void setFarRight(int farRight) {
        this.farRight = farRight;
    }

    public BufferedImage getTop() {
        return top;
    }
}

