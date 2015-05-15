package controller;

import model.BallTurtle;
import model.TurtleList;
import view.MainPanel;

import java.util.Timer;

/**
 * Created by Dimitri on 02/05/2015.
 */
public class TimeController {
    private Timer timer;

    public TimeController(){
        this.timer=new Timer();
    }

    public void scheduleMove (TurtleList turtles, MainPanel panel) {
        this.timer.scheduleAtFixedRate(new MoveTask(turtles, panel), 1000, 400);
    }

    public void schedulePass (TurtleList turtles, BallTurtle ball) {
        this.timer.scheduleAtFixedRate(new PassTask(turtles, ball), 1000, 1000);
    }
}
