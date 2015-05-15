import controller.MouseController;
import controller.MovingButtonsController;
import controller.TimeController;
import model.TurtleList;
import view.MainPanel;

import java.util.ArrayList;
import java.util.EventListener;

/**
 * Created by Dimitri on 02/05/2015.
 */
public class BallGameFactory implements Factory {
    @Override
    public void buildGame() {
        MainPanel mainPanel = new MainPanel();
        TurtleList turtles = new TurtleList();
        ArrayList<EventListener> controllers = new ArrayList<EventListener>();
        controllers.add(new MovingButtonsController(mainPanel, turtles));
        controllers.add(new MouseController(turtles));
        new TimeController().scheduleMove(turtles, mainPanel);

        buildPlayers(turtles);
        buildPanels(controllers, mainPanel, turtles);

        turtles.addObserver(mainPanel);
        mainPanel.setVisible(true);
    }

    @Override
    public void buildPanels(ArrayList<EventListener> controllers, MainPanel panel, TurtleList turtles) {
        //Crée les boutons et les associe au controleur
        panel.addButtons((MovingButtonsController) controllers.get(0));
        panel.addTurtles(turtles, (MouseController) controllers.get(1));
    }

    @Override
    public TurtleList buildPlayers(TurtleList turtles) {
        turtles.addTurtle(0, "Leonardo");
        turtles.addTurtle(1, "Donatello");
        turtles.addTurtle(2, "Michelangelo");
        turtles.addTurtle(3, "Raphael");
        turtles.addTurtle(4, "Splinter");
        turtles.addTurtle(5, "April O'Neil");
        turtles.addTurtle(9, "Casey Jones");
        turtles.addTurtle(7, "Shredder");
        turtles.addTurtle(8, "Krang");
        turtles.addTurtle(12, "Baxter Stockman");
        turtles.addTurtle(10, "Hun");
        turtles.addTurtle(11, "Bishop");
        turtles.makeEveryOneKnown();

        return turtles;
    }
}
