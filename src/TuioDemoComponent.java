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
import game.TrafficLight;

public class TuioDemoComponent extends JPanel implements TuioListener {

    private Hashtable<Long, TuioObject> objectList = new Hashtable<Long, TuioObject>();

    public static final int object_size = 60;
    public static final int table_size = 760;

    public static int width, height;
    private float scale = 1.0f;
    public boolean verbose = false;
    private Map<String, BufferedImage> images = new HashMap<>();
    private TrafficLight lightE, lightS, lightN, lightW;
    Background bg;

    public TuioDemoComponent() throws IOException {
    }

    public void setSize(int w, int h) {
        super.setSize(w, h);
        width = w;
        height = h;
        scale = height / (float) TuioDemoComponent.table_size;
    }

    public void loadImages() throws IOException {
        File abs_root = Paths.get("assets").toAbsolutePath().toFile();
        String image_suffix = ".png";
        String[] paths = {
                "car",
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
            bg = new Background();
            lightE = new TrafficLight(200, 200, images);
            lightS = new TrafficLight(200, 200, images);
            lightN = new TrafficLight(200, 200, images);
            lightW = new TrafficLight(200, 200, images);

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
        g2d.drawImage(bg.center, 0, 0, this.getWidth(), this.getHeight(), this);

        /**Traffic Lights**/
        g2d.drawImage(lightS.getImage(), 200, 300, 40, 80, this);
        g2d.drawImage(lightN.getImage(), 400,  60, 40, 80, this);

        g2d.drawImage(lightE.getImage(), 400, 300, 40, 80, this);
        g2d.drawImage(lightW.getImage(), 200,  60, 40, 80, this);

        update(g);
    }


    public void update(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;


        // draw the objects
        Enumeration<TuioObject> objects = objectList.elements();
        while (objects.hasMoreElements()) {
            TuioObject tobj = objects.nextElement();
            if (tobj.getSymbolID() == 1) {
                bg.moveRight();
            }
            else if (tobj.getSymbolID() == 37) {
                lightS.changeToGreen();
                lightN.changeToGreen();
                lightE.changeToRed();
                lightW.changeToRed();
            }
            else if (tobj.getSymbolID() == 36) {
                lightS.changeToRed();
                lightN.changeToRed();
                lightE.changeToGreen();
                lightW.changeToGreen();
            }
            else if (tobj.getSymbolID() == 38) {
                lightS.changeToAmber();
                lightN.changeToAmber();
                lightE.changeToAmber();
                lightW.changeToAmber();
            }
        }
    }

    class Background{
        int x = 0;
        int y = 0;
        BufferedImage center = images.get("junction");
        BufferedImage right = images.get("t-junction");

        public void moveRight() {
            x = x + 1;
        }
    }

}
