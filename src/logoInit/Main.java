import controller.MouseController;
import controller.MovingButtonsController;
import model.Turtle;
import model.TurtleList;
import view.MainPanel;

import javax.swing.*;

/**
 * Created by Pierre on 27/04/2015.
 */
public class Main {
    public static void main (String [] arg){
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                TurtleList turtles = new TurtleList();

                MainPanel mainPanel = new MainPanel();
                MovingButtonsController buttonsController = new MovingButtonsController(mainPanel, turtles);
                MouseController mouseController = new MouseController(mainPanel,turtles);
                //Crée les boutons et les associe au controleur
                mainPanel.addButtons(buttonsController);
                mainPanel.addTurtles (turtles, mouseController);
                turtles.addObserver(mainPanel);
                mainPanel.setVisible(true);
            }
        });
    }
}
