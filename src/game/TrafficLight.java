package game;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TrafficLight extends Sprite{
    BufferedImage image, image1, image2;
    /**
     * Created by bianca on 06/11/16.
     */
    public TrafficLight(int x, int y) throws IOException {
        super(x, y);
        image1 = ImageIO.read(new File("../assets/traffic-lights-green.png"));
        image2 = ImageIO.read(new File("../assets/traffic-lights-red.png"));
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
}