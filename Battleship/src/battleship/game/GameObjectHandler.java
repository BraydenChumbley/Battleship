/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

    public GameObjectHandler(Game game) {
	this.game = game;
	objects = new ArrayList<>();
    }

    public void update(Game game) {
	for(int i = 0; i < objects.size(); i++){
	    objects.get(i).update(game);
	}
    }

    public void draw(Graphics g) {
	for(int i = 0; i < objects.size(); i++){
	    objects.get(i).draw(g);
	}
    }

    public void addObj(AbstractGameObject obj) {
	objects.add(obj);
    }

    public void removeObj(int index) {
	objects.remove(index);
    }

    public void removeObj(AbstractGameObject obj) {
	objects.remove(obj);
    }

    public void getObj(int index) {
	objects.get(index);
    }

}
