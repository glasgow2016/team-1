package game;

/**
 * Created by bianca on 06/11/16.
 */
public class MovingSprite extends Sprite{
    int speed;
    private static final int VELOCITY = 5;

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
        xpos += VELOCITY;
    }

    public void moveUp() {
        ypos -= VELOCITY;
    }

    public void moveDown() {
        ypos += 1;
    }

    public void moveLeft() {
        xpos -= 1;
    }
}
