import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class GameWindow extends JFrame {

    GameCanvas gameCanvas;
    Player player;
    BulletPlayer bulletPlayer;
    long lastTime = 0;
    Random random = new Random();


    public GameWindow() {
        this.setSize(1024, 600);
        this.gameCanvas = new GameCanvas();
        this.add(this.gameCanvas);
        this.event();
        this.setVisible(true);
    }

    private void event() {
        this.keyboardEvent();
        this.windowEvent();
    }

    private void keyboardEvent() {
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    gameCanvas.player.angle -= 5;
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    gameCanvas.player.angle += 5;
                }

                gameCanvas.player.velocity.set(
                        (new Vector2D(3.5f, 0.0f)).rotate(gameCanvas.player.angle)
                );



//                gameCanvas.bulletPlayers.forEach(bulletPlayer -> bulletPlayer.velocity.set(
//                        new Vector2D(gameCanvas.player.velocity.x +10, gameCanvas.player.velocity.y)
//                        .rotate(gameCanvas.player.angle))
//                );

            }

            @Override
            public void keyReleased(KeyEvent e) {
                //System.out.println("keyReleased");
            }
        });
    }

    private void windowEvent() {
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
