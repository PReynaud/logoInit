package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;

/**
 * Created by Pierre on 22/04/2015.
 */
public class TurtleList extends Observable {
    private ArrayList<Turtle> turtles; // la liste des turtles enregistrees
    private int indexControlledTurtle = 0;

    public TurtleList() {
        this.turtles = new ArrayList<Turtle>();
    }

    public void setControlledTurtle(int i) {
        turtles.get(indexControlledTurtle).setIsControlled(false);
        turtles.get(i).setIsControlled(true);
        indexControlledTurtle = i;
    }

    public void addTurtle(int color) {
        Turtle tempTurtle = new Turtle();
        tempTurtle.setPosition(500 / 2, 400 / 2);
        tempTurtle.setColor(color);
        turtles.add(tempTurtle);
        updateObservers();
    }

    public void addTurtle(int color, String name) {
        ImprovedTurtle tempTurtle = new ImprovedTurtle();
        tempTurtle.setColor(color);
        tempTurtle.setName(name);
        turtles.add(tempTurtle);
        updateObservers();
    }

    public BallTurtle addBallTurtle(int color, Turtle turtle) {
        BallTurtle result = new BallTurtle(turtle, color);
        turtles.add(result);
        return result;
    }

    public void reset() {
        for (Iterator it = this.turtles.iterator(); it.hasNext(); ) {
            Turtle t = (Turtle) it.next();
            t.reset();
        }
        updateObservers();
    }

    public ArrayList<BallTurtle> getBalls (){
        ArrayList<BallTurtle> balls = new ArrayList<BallTurtle>();
        for (Turtle turtle : turtles){
            if (turtle instanceof BallTurtle){
                balls.add((BallTurtle)turtle);
            }
        }
        return balls;
    }

    public Turtle getControlledTurtle() {
        return turtles.get(indexControlledTurtle);
    }

    public ArrayList<Turtle> getTurtles() {
        ArrayList<Turtle> result = new ArrayList<Turtle>();
        for (Turtle turtle:turtles){
            if (!(turtle instanceof BallTurtle)){
                result.add(turtle);
            }
        }
        return result;
    }

    private void updateObservers() {
        setChanged();
        notifyObservers();
    }

    public void goLeft(Turtle turtle,int value) {
        turtle.gauche(value);
    }

    public void goRight(Turtle turtle, int value) {
        turtle.droite(value);
    }

    public void goForward(Turtle turtle, int value) {
        turtle.avancer(value);
    }


    public void saySomething(ImprovedTurtle turtle) {
        turtle.saySomething();
    }

    public void moveRandom(int value) {
        for (Turtle turtle : getTurtles()){
            if (!turtle.isControlled()) {
                switch ((int) (Math.random() * 5)) {
                    case (0):
                        goLeft(turtle, value);
                        break;
                    case (1):
                        goRight(turtle, value);
                        break;
                    default:
                        goForward(turtle, value);
                        break;
                }
            }
        }
        updateBallsPositions();
        updateObservers();
    }

    public void moveControlledTurtle (int action, int value){
        switch (action){
            case 0:
                goLeft(getControlledTurtle(), value);
                break;
            case 1:
                goRight(getControlledTurtle(), value);
                break;
            default:
                goForward(getControlledTurtle(),value);
                break;
        }
    }

    public void updateBallsPositions() {
        for (BallTurtle ball : getBalls()){
            ball.updatePosition();
        }
    }

    public void addKnownTurtle(ImprovedTurtle oneTurtle) {
        for (Turtle turtle : turtles) {
            if (turtle instanceof ImprovedTurtle)
                oneTurtle.addKnownTurtle((ImprovedTurtle) turtle);
        }
    }

    public void makeEveryOneKnown() {
        for (Turtle turtle : turtles) {
            if (turtle instanceof ImprovedTurtle) {
                addKnownTurtle((ImprovedTurtle) turtle);
            }
        }
    }
}
