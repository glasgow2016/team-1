package game;

/**
 * Created by bianca on 06/11/16.
 */
public class MovingSprite extends Sprite{
    int speed;

    public MovingSprite(int x, int y, int speed) {
        super(x, y);
        this.speed = speed;
    }

    public void setSpeed(int s) {
        speed = s;
    }

    public int getSpeed() {
        return speed;
    }

    public void moveRight() {
        xpos += 1;
    }
}
