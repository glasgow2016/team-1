package game;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TrafficLight extends Sprite{
    BufferedImage image, image1, image2;
    boolean waiting = false;
    /**
     * Created by bianca on 06/11/16.
     */
    public TrafficLight(int x, int y, Map<String, BufferedImage> images) throws IOException {
        super(x, y);
        image1 = images.get("traffic-lights-green");
        image2 = images.get("traffic-lights-red");
        image = image1;
    }

    public void changeToGreen() {
        image = image1;
    }

    public void changeToRed() {
        image = image2;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setTimer() {
        waiting = true;
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                System.out.println(new Date());
            }
        }, 0, 5, TimeUnit.MINUTES);
    }
}