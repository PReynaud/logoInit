package view;

import controller.MovingButtonsController;
import model.TurtleList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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

        getContentPane().setLayout(new BorderLayout(10, 10));
        graphPanel = new GraphPanel(turtles, new Dimension(600,400));
        getContentPane().add(graphPanel, "Center");
        graphPanel.setVisible(true);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent arg0) {
                super.windowClosing(arg0);
                System.exit(0);
            }
        });
    }

    public void addButtons(MovingButtonsController controller){
        JPanel buttonPanel = new JPanel();
        getContentPane().add(buttonPanel, "North");
        controlPanel = new ControlPanel(controller);
        buttonPanel.add(controlPanel.getToolbar());
        controlPanel.setVisible(true);

        pack();
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

    public int getCurrentColor(){
        return controlPanel.getCurrentColor();
    }
}
