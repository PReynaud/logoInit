package model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Pierre on 22/04/2015.
 */
public class TurtleList {
    private ArrayList<Turtle> turtles; // la liste des turtles enregistrees

    public TurtleList() {
        turtles = new ArrayList<Turtle>();
    }

    public void addTortue(Turtle o) {
        turtles.add(o);
    }

    public void reset() {
        for (Iterator it = turtles.iterator();it.hasNext();) {
            Turtle t = (Turtle) it.next();
            t.reset();
        }
    }

    public ArrayList<Turtle> getTurtles (){
        return turtles;
    }
}
