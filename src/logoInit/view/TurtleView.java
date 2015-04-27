package view;

import model.Turtle;
import model.TurtleList;

import java.awt.*;
import java.util.Iterator;

/**
 * Created by Pierre on 27/04/2015.
 */
public class TurtleView {
    private TurtleList tortues; // la liste des tortues enregistrees

    public TurtleView(TurtleList turtles){
        tortues = turtles;
    }


    public void showTurtles(Graphics g) {
        for(Iterator it = tortues.getTurtles().iterator(); it.hasNext();) {
            Turtle t = (Turtle) it.next();
            drawTurtle(g, t);
        }
    }

    public void drawTurtle (Graphics graph, Turtle turtle) {
        if (graph==null)
            return;

        new ArrowView().drawPolygon(graph,turtle);
    }

    public void reset(){
        tortues.reset();
    }
}
