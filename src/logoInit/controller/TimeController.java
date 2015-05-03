package controller;

import model.TurtleList;
import view.MainPanel;

import java.util.Timer;

/**
 * Created by Dimitri on 02/05/2015.
 */
public class TimeController {
    private TurtleList turtles;
    private MainPanel view;
    private Timer timer;

    public TimeController(TurtleList turtles, MainPanel panel) {
        super();
        this.turtles = turtles;
        this.view = panel;
        this.timer = new Timer();
        this.timer.scheduleAtFixedRate(new MoveTask(turtles, panel), 1000, 400);
    }
}
