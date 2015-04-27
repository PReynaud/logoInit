package view;

import model.ImprovedTurtle;
import model.Turtle;
import model.TurtleList;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;

/**
 * Created by Pierre on 22/04/2015.
 */
public class GraphPanel extends JPanel {
    // Classe interne : segment avec couleur
    protected class Segment {
        public Point ptStart, ptEnd;
        public Color color;

        public Segment() {
            ptStart = new Point(0,0);
            ptEnd = new Point(0,0);
        }

        public void drawSegment(Graphics graph) {
            if (graph==null)
                return;

            graph.setColor(color);
            graph.drawLine(ptStart.x, ptStart.y, ptEnd.x, ptEnd.y);
        }
    }

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
