import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class GameWindow extends JFrame {

    GameCanvas gameCanvas;
    Player player;
    long lastTime = 0;
    Random random = new Random();


    public GameWindow() {
        this.setSize(1024, 600);

        this.gameCanvas = new GameCanvas();

        this.add(this.gameCanvas);
        this.event();


        this.setVisible(true);
    }
    private void event(){
        this.keyboardEvent();

        this.windowEvent();

    }

    private void keyboardEvent(){
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {

//                    if (player.positionXPlayer < 0) {
//                        player.positionXPlayer = 1024;
//                        player.positionYPlayer = random.nextInt(600);
//                    } else player.positionXPlayer -= 8;

                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
//                    if (player.positionXPlayer > 1024) {
//                        player.positionXPlayer = 0;
//                        player.positionYPlayer = random.nextInt(600);
//                    } else player.positionXPlayer += 8;
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {
                //System.out.println("keyReleased");
            }
        });
    }

    private void windowEvent(){
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
        });
    }

    public void gameLoop() {
        while (true) {
            long currentTime = System.nanoTime();
            if (currentTime - this.lastTime >= 17_000_000) {
                this.gameCanvas.runAll();

                this.gameCanvas.renderAll();
                this.lastTime = currentTime;


            }

        }
    }

}
