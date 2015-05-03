import javax.swing.*;

/**
 * Created by Pierre on 27/04/2015.
 */
public class Main {
    public static void main(String[] arg) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                BallGameFactory game = new BallGameFactory();
                game.buildGame();
            }
        });
    }
}
