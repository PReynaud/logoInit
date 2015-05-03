package view;

import model.Turtle;

import java.awt.*;

/**
 * Created by Dimitri on 27/04/2015.
 */
public class BallTurtleView extends TurtleView {

    public BallTurtleView(Turtle turtle) {
        super(turtle);
    }

    @Override
    public void drawTurtle(Graphics graph) {
        if (graph == null)
            return;

        new DiskView().drawPolygon(graph, super.turtle);
    }
}
