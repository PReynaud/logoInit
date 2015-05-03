package controller;

import model.TurtleList;
import view.MainPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Pierre on 22/04/2015.
 */
public class MovingButtonsController implements ActionListener {
    private TurtleList turtles;
    private MainPanel view;

    public MovingButtonsController(MainPanel view, TurtleList turtles){
        this.view = view;
        this.turtles = turtles;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String c = e.getActionCommand();

        // actions des boutons du haut
        if (c.equals("Avancer")) {
            System.out.println("command avancer");
            try {
                int v = Integer.parseInt(view.getInputValue().getText());
                turtles.goForward(v);
            } catch (NumberFormatException ex){
                System.err.println("ce n'est pas un nombre : " + view.getInputValue().getText());
            }

        }
        else if (c.equals("Droite")) {
            try {
                int v = Integer.parseInt(view.getInputValue().getText());
                turtles.goRight(v);
            } catch (NumberFormatException ex){
                System.err.println("ce n'est pas un nombre : " + view.getInputValue().getText());
            }
        }
        else if (c.equals("Gauche")) {
            try {
                int v = Integer.parseInt(view.getInputValue().getText());
                turtles.goLeft(v);
            } catch (NumberFormatException ex){
                System.err.println("ce n'est pas un nombre : " + view.getInputValue().getText());
            }
        }
        else if (c.equals("Ajouter")){
            String name = view.getControlPanel().getInputName().getText();
            int color = view.getCurrentColor();
            if(name == ""){
                turtles.addTurtle(color);
            }
            else{
                turtles.addTurtle(color, name);
            }
        }
    }
}
