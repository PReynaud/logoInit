package model;

/**
 * Created by Dimitri on 27/04/2015.
 */
public class BallTurtle extends Turtle {
    private Turtle owner;

    public BallTurtle(Turtle turtle, int color) {
        super();
        setColor(color);
        this.owner = turtle;
    }

    public void updatePosition(){
        int angle = -owner.dir;
        if (angle>180){
            angle=-angle%180;
        }
        double cosX = Math.cos(Math.toRadians(angle)),
                sinY = Math.sin(Math.toRadians(angle)),
                radius=15+owner.getTurtleRadius();
        setPosition(owner.getX()+(int)(cosX*radius), owner.getY()- (int)(sinY*radius));
    }
}
