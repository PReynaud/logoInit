package view;

import model.Turtle;
import model.TurtleList;

import java.awt.*;

/**
 * Created by Toromis on 27/04/2015.
 */
public class BallTurtleView extends TurtleView{

    public BallTurtleView(TurtleList turtles) {
        super(turtles);
    }

    @Override
    public void drawTurtle (Graphics graph, Turtle turtle) {
        if (graph==null)
            return;

        new DiskView().drawPolygon(graph,turtle);
    }
}
