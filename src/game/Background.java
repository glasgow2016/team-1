package game;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Map;

/**
 * Created by megamolis on 06/11/2016.
 */
public class Background {
    int x;
    int y;
    BufferedImage center;
    BufferedImage right;
    int width;
    int farRight;

    public void moveRight() {
        if (width > 10) {
            x--;
            width--;
        }
    }

    public Background(Map<String, BufferedImage> images) {
        x = 0;
        y = 0;
        center = images.get("junction");
        right = images.get("t-junction");
        farRight = width * 2;
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

    public BufferedImage getCenter() {
        return center;
    }

    public void setCenter(BufferedImage center) {
        this.center = center;
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
}

