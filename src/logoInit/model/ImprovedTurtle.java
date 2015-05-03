package model;

import java.util.ArrayList;

/**
 * Created by Pierre on 27/04/2015.
 */
public class ImprovedTurtle extends Turtle {
    private String name;
    private ArrayList<ImprovedTurtle> knownTurtles;

    public ImprovedTurtle() {
        super();
        this.knownTurtles = new ArrayList<ImprovedTurtle>();
        this.name = "Michelangelo";
    }

    public ImprovedTurtle(String name) {
        super();
        this.knownTurtles = new ArrayList<ImprovedTurtle>();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addKnownTurtle(ImprovedTurtle t) {
        knownTurtles.add(t);
    }

    public void removeKnownTurtle(ImprovedTurtle t) {
        knownTurtles.remove(t);
    }

    public double calculDistanceBetweenTurtles(ImprovedTurtle t) {
        double calc;
        calc = Math.sqrt(Math.pow(this.x + t.getX(), 2) + Math.pow(this.y + t.getY(), 2));
        return calc;
    }

    public void avancer(int dist) {
        super.avancer(dist);
        for (ImprovedTurtle oneTurtle : knownTurtles) {
            double distanceBetweenTurtles = calculDistanceBetweenTurtles(oneTurtle);
            if (distanceBetweenTurtles <= 15) {
                if (oneTurtle instanceof Turtle) {
                    System.out.println("Hey mysterious turtle");
                } else {
                    System.out.println("Hey " + oneTurtle.getName());
                }
                System.out.println("MOVE!!");
                oneTurtle.avancer(15);
            }
        }
    }
}
