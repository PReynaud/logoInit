package controller;

import model.BallTurtle;
import model.ImprovedTurtle;
import model.Turtle;
import model.TurtleList;
import view.MainPanel;

import java.util.TimerTask;

/**
 * Created by Dimitri on 15/05/2015.
 */
public class PassTask extends TimerTask {
    private TurtleList turtles;
    private BallTurtle ball;

    public PassTask(TurtleList turtles, BallTurtle ball) {
        this.turtles = turtles;
        this.ball =ball;
    }

    @Override
    public void run() {
        for (Turtle turtle : turtles.getTurtles()) {
            if (ball.makeAPass(turtle)) {
                break;
            }
        }
    }
}
