/*
 TUIO Java GUI Demo
 Copyright (c) 2005-2014 Martin Kaltenbrunner <martin@tuio.org>
 
 Permission is hereby granted, free of charge, to any person obtaining
 a copy of this software and associated documentation files
 (the "Software"), to deal in the Software without restriction,
 including without limitation the rights to use, copy, modify, merge,
 publish, distribute, sublicense, and/or sell copies of the Software,
 and to permit persons to whom the Software is furnished to do so,
 subject to the following conditions:
 
 The above copyright notice and this permission notice shall be
 included in all copies or substantial portions of the Software.
 
 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR
 ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF
 CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/

import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.*;

import TUIO.*;
import game.MovingSprite;
import game.TrafficLight;
import game.Background;

public class TuioDemoComponent extends JPanel implements TuioListener {

    private Hashtable<Long, TuioObject> objectList = new Hashtable<>();

    public static final int object_size = 60;
    public static final int table_size = 760;

    public static int width, height;
    private float scale = 1.0f;
    public boolean verbose = false;
    private Map<String, BufferedImage> images = new HashMap<>();
    private MovingSprite car = new MovingSprite(-200, 300, 30);
    private MovingSprite bike = new MovingSprite(600, 800, 30);
    private TrafficLight lightE, lightS, lightN, lightW;
    Background bg;

    /**Scenes**/
    TrafficLight[] scene1 = new TrafficLight[4];
    TrafficLight[] scene2 = new TrafficLight[3];


    public TuioDemoComponent() throws IOException {
    }

    public void setSize(int w, int h) {
        super.setSize(w, h);
        width = w;
        height = h;
        scale = height / (float) TuioDemoComponent.table_size;
        bg.setWidth(getWidth());
        bg.setHeight(-height);

        for(TrafficLight light:scene1) {
            light.setWidth((int) (width * 0.06));
            light.setHeight((int) (height * 0.17));
        }

        for(TrafficLight light:scene2) {
            light.setWidth((int) (width * 0.06));
            light.setHeight((int) (height * 0.17));
        }

    }

    public void loadImages() throws IOException {
        File abs_root = Paths.get("assets").toAbsolutePath().toFile();
        String image_suffix = ".png";
        String[] paths = {
                "car",
                "bike",
                "junction",
                "t-junction",
                "t-junction2",
                "traffic-lights-amber",
                "traffic-lights-green",
                "traffic-lights-red"
        };

        for (int i = 0; i < paths.length; i++) {
            try {
                BufferedImage img = ImageIO.read(new File(abs_root, paths[i] + image_suffix));
                this.images.put(paths[i], img);
            } catch (IOException e) {
                e.printStackTrace();
            }
            bg = new Background(images);
            lightS = new TrafficLight(300, 580, 40, 80, images);
            lightN = new TrafficLight( 900, 80, 40, 80, images);
            lightE = new TrafficLight(900, 580, 40, 80, images);
            lightW = new TrafficLight(300, 80, 40, 80, images);

            scene1[0] = lightE;
            scene1[1] = lightS;
            scene1[2] = lightN;
            scene1[3] = lightW;

            scene2[0] = lightE;
            scene2[1] = lightN;
            scene2[2] = lightW;
        }

    }

    public void addTuioObject(TuioObject tobj) {
        TuioObject demo = new TuioObject(tobj);
        objectList.put(tobj.getSessionID(), demo);

        if (verbose)
            System.out.println("add obj " + tobj.getSymbolID() + " (" + tobj.getSessionID() + ") " + tobj.getX() + " " + tobj.getY() + " " + tobj.getAngle());
    }

    public void updateTuioObject(TuioObject tobj) {

        TuioObject demo = (TuioObject) objectList.get(tobj.getSessionID());
        demo.update(tobj);

        if (verbose)
            System.out.println("set obj " + tobj.getSymbolID() + " (" + tobj.getSessionID() + ") " + tobj.getX() + " " + tobj.getY() + " " + tobj.getAngle() + " " + tobj.getMotionSpeed() + " " + tobj.getRotationSpeed() + " " + tobj.getMotionAccel() + " " + tobj.getRotationAccel());
    }

    public void removeTuioObject(TuioObject tobj) {
        objectList.remove(tobj.getSessionID());

        if (verbose)
            System.out.println("del obj " + tobj.getSymbolID() + " (" + tobj.getSessionID() + ")");
    }

    public void addTuioCursor(TuioCursor tcur) {
    }

    public void updateTuioCursor(TuioCursor tcur) {
    }

    public void removeTuioCursor(TuioCursor tcur) {
    }

    public void addTuioBlob(TuioBlob tblb) {
    }

    public void updateTuioBlob(TuioBlob tblb) {
    }

    public void removeTuioBlob(TuioBlob tblb) {
    }

    public void refresh(TuioTime frameTime) {
        repaint();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.drawImage(bg.getOrigin(), bg.getX(), bg.getY(), this.getWidth(), this.getHeight(), this);
        g2d.drawImage(bg.getTop(), bg.getX(), bg.getHeight(), this.getWidth(), this.getHeight(), this);
        g2d.drawImage(bg.getRight(), bg.getWidth() - 10, 0, this.getWidth(), this.getHeight(), this);

        /**Car**/
        g2d.drawImage(images.get("car"), car.getXPos(), car.getYPos(), 150, 75, this);

        /**Bike**/
        g2d.drawImage(images.get("bike"), bike.getXPos(), bike.getYPos(), 150, 100, this);

        /**Traffic Lights**/

        g2d.drawImage(lightS.getImage(), lightS.getXPos(), lightS.getYPos(), lightS.getWidth(), lightS.getHeight(), this);
        g2d.drawImage(lightN.getImage(), lightN.getXPos(), lightN.getYPos(), lightN.getWidth(), lightN.getHeight(), this);

        g2d.drawImage(lightE.getImage(), lightE.getXPos(), lightE.getYPos(), lightE.getWidth(), lightE.getHeight(), this);
        g2d.drawImage(lightW.getImage(), lightW.getXPos(), lightW.getYPos(), lightW.getWidth(), lightW.getHeight(), this);

        update(g);
    }


    public void update(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;


        // draw the objects
        Enumeration<TuioObject> objects = objectList.elements();
        while (objects.hasMoreElements()) {
            TuioObject tobj = objects.nextElement();
            switch (tobj.getSymbolID()) {
                case 2: {
                    bg.moveRight();
                    break;
                }
                case 39: {
                    bike.moveUp();
                    break;
                }
                case 37: {
                    lightS.changeToGreen();
                    lightN.changeToGreen();
                    lightE.changeToRed();
                    lightW.changeToRed();
                    break;
                }
                case 36: {
                    lightS.changeToRed();
                    lightN.changeToRed();
                    lightE.changeToGreen();
                    lightW.changeToGreen();
                    break;
                }
                case 38: {
                    lightS.changeToAmber();
                    lightN.changeToAmber();
                    lightE.changeToAmber();
                    lightW.changeToAmber();
                    break;
                }
                case 41: {
                    car.moveRight();
                    break;
                }
                case 50: {
                    bg.moveLeft();
                    break;
                }
                case 48: {
                    bg.moveTop();
                    for(TrafficLight light:scene1){
                        light.setYpos(light.getYPos() + 5);
                    }
                    break;
                }
                case 49: {
                    bg.moveDown();
                    for(TrafficLight light:scene1){
                        light.setYpos(light.getYPos() - 5);
                    }
                    break;
                }
            }
        }

    }
}
