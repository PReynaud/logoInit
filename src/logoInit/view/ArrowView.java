package view;

import model.Turtle;

import java.awt.*;

/**
 * Created by Toromis on 27/04/2015.
 */
public class ArrowView extends PolygonView {
    @Override
    public void drawPolygon (Graphics graphics,Turtle turtle) {
        Polygon polygon = new Polygon();
        //Calcule les 3 coins du triangle a partir de
        // la position de la tortue p
        Point p = new Point(turtle.getX(),turtle.getY());

        //Calcule des deux bases
        //Angle de la droite
        double theta = Turtle.RATIO_DEG_RAD * (-turtle.getDir());
        //Demi angle au sommet du triangle
        double alpha = Math.atan((float) Turtle.RB / (float) Turtle.RP);
        //Rayon de la fleche
        double r = turtle.getTurtleRadius();
        //Sens de la fleche

        //Pointe
        Point p2 = new Point((int) Math.round(p.x + r * Math.cos(theta)),
                (int) Math.round(p.y - r * Math.sin(theta)));
        polygon.addPoint(p2.x, p2.y);
        polygon.addPoint((int) Math.round(p2.x - r * Math.cos(theta + alpha)),
                (int) Math.round(p2.y + r * Math.sin(theta + alpha)));

        //Base2
        polygon.addPoint((int) Math.round(p2.x - r * Math.cos(theta - alpha)),
                (int) Math.round(p2.y + r * Math.sin(theta - alpha)));

        polygon.addPoint(p2.x, p2.y);
        graphics.fillPolygon(polygon);
        super.drawPolygon(graphics, turtle);
    }
}
