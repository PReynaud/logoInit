package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;

/**
 * Created by Pierre on 22/04/2015.
 */
public class TurtleList extends Observable{
    private ArrayList<Turtle> turtles; // la liste des turtles enregistrees
    private int indexCurrentTurtle = 0;

    public TurtleList() {
        this.turtles = new ArrayList<Turtle>();
        Turtle oneTurtle = new Turtle();
        oneTurtle.setPosition(500/2, 400/2);
        this.turtles.add(oneTurtle);
    }

    public void addTortue(Turtle o) {
        this.turtles.add(o);
    }

    public void addTurtle(int color){
        Turtle tempTurtle = new Turtle();
        tempTurtle.setPosition(500/2, 400/2);
        tempTurtle.setColor(color);
        this.turtles.add(tempTurtle);
    }

    public void reset() {
        for (Iterator it = this.turtles.iterator();it.hasNext();) {
            Turtle t = (Turtle) it.next();
            t.reset();
        }
    }

    public Turtle getCurrentTurtle(){
        return this.turtles.get(this.indexCurrentTurtle);
    }

    public ArrayList<Turtle> getTurtles (){
        return turtles;
    }
}
