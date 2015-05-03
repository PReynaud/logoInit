package view;

import model.Turtle;

import java.awt.*;

/**
 * Created by Dimitri on 27/04/2015.
 */
public class DiskView implements PolygonView {
    @Override
    public void drawPolygon(Graphics graphics, Turtle turtle) {
        double r = turtle.getTurtleRadius();
        graphics.setColor(turtle.decodeColor(turtle.getColor()));
        graphics.fillOval(turtle.getX(), turtle.getY(), (int) r, (int) r);
    }
}
