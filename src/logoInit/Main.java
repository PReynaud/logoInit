import controller.MovingButtonsController;
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

                MovingButtonsController buttonsController;
                MainPanel mainPanel = new MainPanel(turtles, buttonsController);
                buttonsController = new MovingButtonsController(mainPanel, turtles);

                turtles.addObserver(mainPanel);
                mainPanel.setVisible(true);
            }
        });
    }
}
