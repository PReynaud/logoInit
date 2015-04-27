package view;

import controller.MovingButtonsController;
import model.TurtleList;

import javax.swing.*;
import java.awt.*;
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

    public MainPanel(TurtleList turtles, MovingButtonsController controller){
        super("Un super logo");

        getContentPane().setLayout(new BorderLayout(10, 10));

        controlPanel = new ControlPanel(controller);
        graphPanel = new GraphPanel(turtles, new Dimension(600,400));

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(controlPanel.getToolbar());
        getContentPane().add(buttonPanel, "North");
        getContentPane().add(graphPanel, "Center");

        controlPanel.setVisible(true);
        graphPanel.setVisible(true);

        pack();
        setVisible(true);
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

    public ControlPanel getControlPanel(){
        return controlPanel;
    }
}
