package game;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class TrafficLight extends Sprite{
    BufferedImage image, image1, image2, image3;
    boolean waiting = false;
    /**
     * Created by bianca on 06/11/16.
     */
    public TrafficLight(int x, int y, Map<String, BufferedImage> images) throws IOException {
        super(x, y);
        image1 = images.get("traffic-lights-green");
        image2 = images.get("traffic-lights-red");
        image3 = images.get("traffic-lights-amber");
        image = image1;
    }

    public void changeToGreen() {
        image = image1;
    }

    public void changeToRed() {
        image = image2;
    }

    public void changeToAmber() {
        image = image3;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setTimer() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                waiting = true;
            }
        }, 0, 60*1000);
    }
}