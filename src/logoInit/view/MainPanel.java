package view;

import controller.MovingButtonsController;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Pierre on 22/04/2015.
 */
public class MainPanel extends JFrame implements Observer {
    private FunctionPanel functionPanel;
    private ControlPanel controlPanel;
    private GraphPanel graphPanel;

    private ActionListener controllerButtons;

    public MainPanel(){
        super("Un super logo");

        JPanel buttonPanel = new JPanel();

        controllerButtons = new MovingButtonsController();
        controlPanel = new ControlPanel(controllerButtons);

        buttonPanel.add(controlPanel.getToolbar());
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
