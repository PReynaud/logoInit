package model;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Pierre on 22/04/2015.
 */
public class Turtle {

    /**************************************/
    /**********  Attributs  ***************/
    /**
     * **********************************
     */
    public static final int RP = 10, RB = 5; // Taille de la pointe et de la base de la fleche
    public static final double RATIO_DEG_RAD = 0.0174533; // Rapport radians/degres (pour la conversion)
    public static final int MAX_X = 600;
    public static final int MAX_Y = 400;

    protected ArrayList<Segment> listSegments; // Trace de la tortue

    protected int x, y;    // Coordonnees de la tortue
    protected int dir;    // Direction de la tortue (angle en degres)
    protected boolean crayon; // par defaut on suppose qu'on dessine
    protected int coul;


    /**************************************/
    /**********  Methodes  ****************/
    /**
     * **********************************
     */
    public void setColor(int n) {
        coul = n;
    }

    public int getColor() {
        return coul;
    }

    public ArrayList<Segment> getListSegments() {
        return listSegments;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDir() {
        return dir;
    }

    public Turtle() {
        this.x = (int)(Math.random()*MAX_X);
        this.y = (int)(Math.random()*MAX_Y);
        this.dir = -((int)(Math.random()*8))*45+180;
        listSegments = new ArrayList<Segment>();
    }

    public void reset() {
        // on initialise la position de la tortue
        x = 0;
        y = 0;
        dir = -90;
        coul = 0;
        crayon = true;
        listSegments.clear();
    }

    public void setPosition(int newX, int newY) {
        x = newX;
        y = newY;
    }

    public Color decodeColor(int c) {
        switch (c) {
            case 0:
                return (Color.black);
            case 1:
                return (Color.blue);
            case 2:
                return (Color.cyan);
            case 3:
                return (Color.darkGray);
            case 4:
                return (Color.red);
            case 5:
                return (Color.green);
            case 6:
                return (Color.lightGray);
            case 7:
                return (Color.magenta);
            case 8:
                return (Color.orange);
            case 9:
                return (Color.gray);
            case 10:
                return (Color.pink);
            case 11:
                return (Color.yellow);
            default:
                return (Color.black);
        }
    }

    /**************************************/
    /*******  Fonctions de base  **********/
    /**
     * **********************************
     */

    // avancer de n pas
    public void avancer(int dist) {
        int newX = (int) Math.round(x + dist * Math.cos(RATIO_DEG_RAD * dir));
        int newY = (int) Math.round(y + dist * Math.sin(RATIO_DEG_RAD * dir));

        newX = Math.max(newX,0);
        newY = Math.max(newY, 0);
        newX = Math.min(newX, MAX_X);
        newY = Math.min(newY,MAX_Y);

        if (newX<=0 || newY<=0 || newX>=MAX_X || newY>=MAX_Y){
            dir = -dir;
        }

        if (crayon == true) {
            Segment seg = new Segment();

            seg.ptStart.x = x;
            seg.ptStart.y = y;
            seg.ptEnd.x = newX;
            seg.ptEnd.y = newY;
            seg.color = decodeColor(coul);

            listSegments.add(seg);
        }

        x = newX;
        y = newY;
    }

    // aller a droite
    public void droite(int ang) {
        dir = (dir + ang) % 360;
    }

    // aller a gauche
    public void gauche(int ang) {
        dir = (dir - ang) % 360;
    }

    // pour changer de couleur de dessin
    public void couleur(int n) {
        coul = n % 12;
    }

    public void couleurSuivante() {
        couleur(coul + 1);
    }

    public double getTurtleRadius() {
        return Math.sqrt(RP * RP + RB * RB);
    }

    public boolean isInTurtleRadius(Point point) {
        return getTurtleRadius() - Math.sqrt(Math.pow(x - point.x, 2) + Math.pow(y - point.y, 2)) >= 0;
    }

    public double calculDistanceBetweenTurtles(Turtle t) {
        double calc;
        calc = Math.sqrt(Math.pow(this.x - t.getX(), 2) + Math.pow(this.y - t.getY(), 2));
        return calc;
    }

    public boolean isDrawing (){
        return crayon;
    }

    public boolean equals(Turtle obj) {
        return x==obj.getX() && y==obj.getY() && dir == obj.getDir() && crayon==obj.isDrawing() && coul==obj.getColor();
    }
}
