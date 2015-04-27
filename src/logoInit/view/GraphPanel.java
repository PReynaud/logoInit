package view;

import model.TurtleList;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Pierre on 22/04/2015.
 */
public class GraphPanel extends JPanel {
    private Graphics graph;
    private TurtleView turtleView;

    public GraphPanel(TurtleList turtles, Dimension dimension) {
        super();
        this.turtleView = new TurtleView(turtles);
        this.setBackground(Color.white);
        this.setSize(dimension);
        this.setPreferredSize(dimension);
        this.turtleView.drawTurtle(graph, turtles.getCurrentTurtle());
    }

    public void reset() {
       this.turtleView.reset();
    }



    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Color c = g.getColor();

        Dimension dim = getSize();
        g.setColor(Color.white);
        g.fillRect(0,0,dim.width, dim.height);
        g.setColor(c);

        this.turtleView.showTurtles(g);
    }


}
