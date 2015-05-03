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
    private MainPanel view;

    public MouseController(MainPanel view, TurtleList turtles) {
        this.view = view;
        this.turtles = turtles;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Point point = e.getPoint();
        for (int i = 0; i < turtles.getTurtles().size(); i++) {
            if (turtles.getTurtles().get(i).isInTurtleRadius(point)) {
                turtles.setCurrent(i);
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
