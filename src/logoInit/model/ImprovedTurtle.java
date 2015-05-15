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

    public ArrayList<ImprovedTurtle> getKnownTurtles() {
        return knownTurtles;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addKnownTurtle(ImprovedTurtle t) {
        if (!equals(t))
            knownTurtles.add(t);
    }

    public void removeKnownTurtle(ImprovedTurtle t) {
        knownTurtles.remove(t);
    }

    public void avancer(int dist) {
        super.avancer(dist);
    }

    public void saySomething (){
        for (ImprovedTurtle oneTurtle : knownTurtles) {
            double distanceBetweenTurtles = calculDistanceBetweenTurtles(oneTurtle);
            if (distanceBetweenTurtles <= 15) {
                System.out.println("Hey " + oneTurtle.getName());
                System.out.println("MOVE!!");
                oneTurtle.avancer(20);
            }
        }
    }

    public boolean equals(ImprovedTurtle obj) {
        return super.equals(obj) && name.equals(obj.getName());
    }
}
