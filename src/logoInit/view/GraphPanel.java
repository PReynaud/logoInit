package view;

import model.BallTurtle;
import model.Turtle;
import model.TurtleList;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Pierre on 22/04/2015.
 */
public class GraphPanel extends JPanel {
    private ArrayList<TurtleView> turtlesList;

    public GraphPanel(TurtleList turtles, Dimension dimension) {
        super();
        this.setBackground(Color.white);
        this.setSize(dimension);
        this.setPreferredSize(dimension);
        updateTurtles(turtles.getTurtles());
    }

    public void reset() {
       //TODO
        //this.turtleView.reset();
    }

    public void updateTurtles (ArrayList<Turtle> turtles){
        this.turtlesList =new ArrayList<TurtleView>();
        for(Turtle turtle: turtles){
            if(turtle instanceof BallTurtle){
                TurtleView temp = new BallTurtleView(turtle);
                turtlesList.add(temp);
            }
            else{
                TurtleView temp = new TurtleView(turtle);
                turtlesList.add(temp);
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        Dimension dim = getSize();
        g.fillRect(0, 0, dim.width, dim.height);
        g.setColor(Color.white);
        super.paintComponent(g);

        for(TurtleView tView: this.turtlesList){
            tView.drawTurtle(g);
        }
    }


}
