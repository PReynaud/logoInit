package view;

import model.ImprovedTurtle;
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

        //Calcule les 3 coins du triangle a partir de
        // la position de la tortue p
        Point p = new Point(turtle.getX(),turtle.getY());
        Polygon arrow = new Polygon();

        //Calcule des deux bases
        //Angle de la droite
        double theta=Turtle.RATIO_DEG_RAD*(-turtle.getDir());
        //Demi angle au sommet du triangle
        double alpha=Math.atan( (float)Turtle.RB / (float)Turtle.RP );
        //Rayon de la fleche
        double r=Math.sqrt( Turtle.RP*Turtle.RP + Turtle.RB *Turtle.RB);
        //Sens de la fleche

        //Pointe
        Point p2=new Point((int) Math.round(p.x+r*Math.cos(theta)),
                (int) Math.round(p.y-r*Math.sin(theta)));
        arrow.addPoint(p2.x,p2.y);
        arrow.addPoint((int) Math.round( p2.x-r*Math.cos(theta + alpha) ),
                (int) Math.round( p2.y+r*Math.sin(theta + alpha) ));

        //Base2
        arrow.addPoint((int) Math.round(p2.x - r * Math.cos(theta - alpha)),
                (int) Math.round(p2.y + r * Math.sin(theta - alpha)));

        arrow.addPoint(p2.x, p2.y);
        graph.setColor(turtle.decodeColor(turtle.getColor()));
        graph.fillPolygon(arrow);
        if(turtle instanceof ImprovedTurtle){
            graph.drawString(((ImprovedTurtle) turtle).getName(), turtle.getX() + 20, turtle.getY());
        }
    }

    public void reset(){
        tortues.reset();
    }
}