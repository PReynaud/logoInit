package view;

import model.ImprovedTurtle;
import model.Turtle;

import java.awt.*;

/**
 * Created by Dimitri on 27/04/2015.
 */
public abstract class PolygonView {
    public void drawPolygon (Graphics graphics, Turtle turtle){
        if(turtle instanceof ImprovedTurtle){
            graphics.drawString(((ImprovedTurtle) turtle).getName(), turtle.getX() + 20, turtle.getY());
        }
    }
}
