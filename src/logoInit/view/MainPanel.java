package view;

import controller.MovingButtonsController;
import model.TurtleList;

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

    public MainPanel(TurtleList turtles){
        super("Un super logo");

        controlPanel = new ControlPanel();
        graphPanel = new GraphPanel(turtles);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(controlPanel.getToolbar());
    }

    @Override
    public void update(Observable o, Object arg) {

    }

    public JTextField getInputValue(){
        return this.controlPanel.getInputValue();
    }

    public GraphPanel getGraphPanel(){
        return graphPanel;
    }
}
