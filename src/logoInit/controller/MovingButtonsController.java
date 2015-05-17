package controller;

import model.BallTurtle;
import model.TurtleList;
import view.MainPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Pierre on 22/04/2015.
 */
public class MovingButtonsController implements ActionListener {
    private TurtleList turtles;
    private MainPanel view;
    private int passTempo;

    public MovingButtonsController(MainPanel view, TurtleList turtles, int passTempo) {
        this.view = view;
        this.turtles = turtles;
        this.passTempo = passTempo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String c = e.getActionCommand();

        // actions des boutons du haut
        if (c.equals("Avancer")) {
            try {
                int v = Integer.parseInt(view.getInputValue().getText());
                turtles.moveControlledTurtle(2, v);
            } catch (NumberFormatException ex) {
                System.err.println("ce n'est pas un nombre : " + view.getInputValue().getText());
            }

        } else if (c.equals("Droite")) {
            try {
                int v = Integer.parseInt(view.getInputValue().getText());
                turtles.moveControlledTurtle(1, v);
            } catch (NumberFormatException ex) {
                System.err.println("ce n'est pas un nombre : " + view.getInputValue().getText());
            }
        } else if (c.equals("Gauche")) {
            try {
                int v = Integer.parseInt(view.getInputValue().getText());
                turtles.moveControlledTurtle(0, v);
            } catch (NumberFormatException ex) {
                System.err.println("ce n'est pas un nombre : " + view.getInputValue().getText());
            }
        } else if (c.equals("Ajouter")) {
            String name = view.getControlPanel().getInputName().getText();
            int color = view.getCurrentColor();
            if (name.equals("")) {
                turtles.addTurtle(color);
            } else {
                turtles.addTurtle(color, name);
            }
        }else if (c.equals("Demarrer")){
            int index= (int)(Math.random()*turtles.getTurtles().size());
            BallTurtle ball = turtles.addBallTurtle(6, turtles.getTurtles().get(index));
            new TimeController().schedulePass(turtles,ball, passTempo);
            for(Component component: view.getControlPanel().getToolbar().getComponents()){
                if (component instanceof JButton &&((JButton)component).getActionCommand().equals("Demarrer")) {
                    component.setEnabled(false);
                    break;
                }
            }
        }
    }
}
