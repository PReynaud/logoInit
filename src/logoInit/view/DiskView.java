package view;

import model.Turtle;

import java.awt.*;

/**
 * Created by Toromis on 27/04/2015.
 */
public class DiskView extends PolygonView{
    @Override
    public void drawPolygon (Graphics graphics, Turtle turtle) {
        double r = turtle.getTurtleRadius();
        graphics.fillOval(turtle.getX(),turtle.getY(),(int)r, (int) r);
        super.drawPolygon(graphics, turtle );
    }
}
