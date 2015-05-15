package controller;

import model.TurtleList;
import view.MainPanel;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Dimitri on 27/04/2015.
 */
public class MouseController implements MouseListener {
    private TurtleList turtles;

    public MouseController(TurtleList turtles) {
        this.turtles = turtles;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Point point = e.getPoint();
        for (int i = 0; i < turtles.getTurtles().size(); i++) {
            if (turtles.getTurtles().get(i).isInTurtleRadius(point)) {
                turtles.setControlledTurtle(i);
                break;
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
