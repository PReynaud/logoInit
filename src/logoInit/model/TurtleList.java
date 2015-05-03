package model;

import java.util.*;

/**
 * Created by Pierre on 22/04/2015.
 */
public class TurtleList extends Observable{
    private ArrayList<Turtle> turtles; // la liste des turtles enregistrees
    private int indexCurrentTurtle = 0;

    public TurtleList() {
        this.turtles = new ArrayList<Turtle>();
    }

    public void addTurtle(int color){
        Turtle tempTurtle = new Turtle();
        tempTurtle.setPosition(500/2, 400/2);
        tempTurtle.setColor(color);
        this.turtles.add(tempTurtle);
        updateObservers();
    }

    public void addTurtle(int color, String name){
        ImprovedTurtle tempTurtle = new ImprovedTurtle();
        tempTurtle.setPosition(500/2, 400/2);
        tempTurtle.setColor(color);
        tempTurtle.setName(name);
        this.turtles.add(tempTurtle);
        updateObservers();
    }

    public void reset() {
        for (Iterator it = this.turtles.iterator();it.hasNext();) {
            Turtle t = (Turtle) it.next();
            t.reset();
        }
        updateObservers();
    }

    public Turtle getCurrentTurtle(){
        return this.turtles.get(this.indexCurrentTurtle);
    }

    public ArrayList<Turtle> getTurtles (){
        return turtles;
    }

    public void setCurrent(int i) {
        indexCurrentTurtle=i;
    }

    private void updateObservers() {
        setChanged();
        notifyObservers();
    }

    public void goLeft (int value){
        getCurrentTurtle().gauche(value);
        updateObservers();
    }

    public void goRight (int value){
        getCurrentTurtle().droite(value);
        updateObservers();
    }

    public void goForward(int value) {
        getCurrentTurtle().avancer(value);
        updateObservers();
    }

    public void moveRandom(int value){
        for (Turtle turtle : turtles){
            switch((int)Math.random()*4){
                case(0):goLeft(value);
                    break;
                case (1):goRight(value);
                    break;
                default: goForward(value);
                    break;
            }
        }
    }
}
