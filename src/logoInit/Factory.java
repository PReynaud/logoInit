import model.TurtleList;
import view.MainPanel;

import java.util.ArrayList;
import java.util.EventListener;

/**
 * Created by Dimitri on 02/05/2015.
 */
public interface Factory {
    void buildGame();

    void buildPanels(ArrayList<EventListener> controllers, MainPanel panel, TurtleList turtles);

    TurtleList buildPlayers(TurtleList turtles);
}
