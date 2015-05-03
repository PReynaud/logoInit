package controller;

import model.TurtleList;
import view.MainPanel;

import java.util.TimerTask;

/**
 * Created by Dimitri on 02/05/2015.
 */
public class MoveTask extends TimerTask{

    private TurtleList turtles;
    private MainPanel view;

    public MoveTask(TurtleList turtles, MainPanel panel){
        this.turtles = turtles;
        this.view = panel;
    }

    @Override
    public void run() {
        turtles.moveRandom(Integer.parseInt(view.getInputValue().getText()));
    }
}
