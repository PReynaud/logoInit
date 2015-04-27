package view;

import controller.MovingButtonsController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Pierre on 22/04/2015.
 */
public class ControlPanel extends JPanel {
    public static final Dimension VGAP = new Dimension(1,5);
    public static final Dimension HGAP = new Dimension(5,1);
    private JTextField inputValue;
    private int currentColor;

    private JToolBar toolBar;

    public ControlPanel(MovingButtonsController controller){
        this.toolBar = new JToolBar();

        addButton(toolBar, "Effacer", "Nouveau dessin", "/icons/index.png", controller);

        toolBar.add(Box.createRigidArea(HGAP));
        inputValue = new JTextField("45",5);
        toolBar.add(inputValue);
        addButton(toolBar, "Avancer", "Avancer 50", null, controller);
        addButton(toolBar, "Droite", "Droite 45", null, controller);
        addButton(toolBar, "Gauche", "Gauche 45", null, controller);
        addButton(toolBar, "Ajouter", "Ajouter tortue", null, controller);

        String[] colorStrings = {"noir", "bleu", "cyan","gris fonce","rouge",
                "vert", "gris clair", "magenta", "orange",
                "gris", "rose", "jaune"};

        // Create the combo box
        toolBar.add(Box.createRigidArea(HGAP));
        JLabel colorLabel = new JLabel("   Couleur: ");
        toolBar.add(colorLabel);
        JComboBox colorList = new JComboBox(colorStrings);
        toolBar.add(colorList);

        colorList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox) e.getSource();
                currentColor = cb.getSelectedIndex();
            }
        });
    }

    //utilitaires pour installer des boutons et des menus
    public void addButton(JComponent p, String name, String tooltiptext, String imageName, MovingButtonsController controller) {
        JButton b;
        if ((imageName == null) || (imageName.equals(""))) {
            b = (JButton)p.add(new JButton(name));
        }
        else {
            java.net.URL u = this.getClass().getResource(imageName);
            if (u != null) {
                ImageIcon im = new ImageIcon (u);
                b = (JButton) p.add(new JButton(im));
            }
            else
                b = (JButton) p.add(new JButton(name));
            b.setActionCommand(name);
        }

        b.setToolTipText(tooltiptext);
        b.setBorder(BorderFactory.createRaisedBevelBorder());
        b.setMargin(new Insets(0, 0, 0, 0));
        b.addActionListener(controller);
    }

    public JToolBar getToolbar(){
        return this.toolBar;
    }

    public JTextField getInputValue(){
        return inputValue;
    }

    public int getCurrentColor(){
        return currentColor;
    }
}
