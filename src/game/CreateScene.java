package game;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by bianca on 06/11/16.
 */
public class CreateScene {
    HashMap<String, Object> scene;

    public CreateScene() {
        scene = new HashMap<>();
    }

    public void addObject(String name, Object obj){
        scene.put(name, obj);
    }
}
