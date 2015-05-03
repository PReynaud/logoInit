package view;

import model.Turtle;

import java.awt.*;

/**
 * Created by Pierre on 27/04/2015.
 */
public class TurtleView {
    protected Turtle turtle;

    public TurtleView(Turtle turtle) {
        this.turtle = turtle;
    }

    public void drawTurtle(Graphics graph) {
        if (graph == null)
            return;
        new ArrowView().drawPolygon(graph, turtle);
    }
}
