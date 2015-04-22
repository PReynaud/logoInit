package model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Pierre on 22/04/2015.
 */
public class TurtleList {
    private ArrayList<Turtle> tortues; // la liste des tortues enregistrees

    public TurtleList() {
        tortues = new ArrayList<Turtle>();
    }

    public void addTortue(Turtle o) {
        tortues.add(o);
    }

    public void reset() {
        for (Iterator it = tortues.iterator();it.hasNext();) {
            Turtle t = (Turtle) it.next();
            t.reset();
        }
    }
}
