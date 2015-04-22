package view;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Pierre on 22/04/2015.
 */
public class MainPanel extends JFrame implements Observer {
    private FunctionPanel functionPanel;
    private ControlPanel controlPanel;
    private GraphPanel graphPanel;

    public MainPanel(){
        super("Un super logo");
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
