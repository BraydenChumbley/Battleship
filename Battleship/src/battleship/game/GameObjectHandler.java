/*
 * Tony Brayden Josh
 * May 20 2019
 * 
 */
package battleship.game;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author Brayden Chumbley
 */
public class GameObjectHandler {

    private ArrayList<AbstractGameObject> objects;
    private Game game;

    /**
     * 
     * @param game - The game
     */    
    public GameObjectHandler(Game game) {
        this.game = game;
        objects = new ArrayList<>();
    }
    /**
     * 
     * @param game - The game
     */
    public void update(Game game) {
        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).update(game);
        }
    }
    
    /**
     * 
     * @param g - graphics object
     */
    public void draw(Graphics g) {
        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).draw(g);
        }
    }
    
    /**
     * 
     * @param obj - object of AbstratGameObject
     */
    public void addObj(AbstractGameObject obj) {
        objects.add(obj);
    }

    /**
     *
     * @param index - 
     */
    public void removeObj(int index) {
        objects.remove(index);
    }

    /**
     *
     * @param obj - object of AbstratGameObject
     */
    public void removeObj(AbstractGameObject obj) {
        objects.remove(obj);
    }

    /**
     *
     * @param index
     */
    public void getObj(int index) {
        objects.get(index);
    }

}
