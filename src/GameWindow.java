import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class GameWindow extends JFrame {

    GameCanvas gameCanvas;
    long lastTime = 0;
    Random random = new Random();


    public GameWindow() {
        this.setSize(1024, 600);

        this.gameCanvas = new GameCanvas();

        this.add(this.gameCanvas);

        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {

                    if (gameCanvas.positionXPlayer < 0) {
                        gameCanvas.positionXPlayer = 1024;
                        gameCanvas.positionYPlayer = random.nextInt(600);
                    } else gameCanvas.positionXPlayer -= 8;

                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    if (gameCanvas.positionXPlayer > 1024) {
                        gameCanvas.positionXPlayer = 0;
                        gameCanvas.positionYPlayer = random.nextInt(600);
                    } else gameCanvas.positionXPlayer += 8;
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {
                //System.out.println("keyReleased");
            }
        });


        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
        });

        this.setVisible(true);
    }


    public void gameLoop() {
        while (true) {
            long currentTime = System.nanoTime();
            if (currentTime - this.lastTime >= 17_000_000) {
                this.gameCanvas.positionXStar -= 3;

                this.gameCanvas.positionXEnemy += gameCanvas.velocityXEnemy;
                this.gameCanvas.positionYEnemy += gameCanvas.velocityXEnemy;
                /*if (this.gameCanvas.positionXEnemy <= 0 || this.gameCanvas.positionYEnemy <= 0) {
                    if(this.gameCanvas.positionXEnemy <= 0) this.gameCanvas.positionXEnemy = 0;
                    if (this.gameCanvas.positionYEnemy <= 0) this.gameCanvas.positionYEnemy = 0;
                }

                if (this.gameCanvas.positionXEnemy >= 1024 || this.gameCanvas.positionYEnemy >= 600) {
                    if(this.gameCanvas.positionXEnemy >= 1024) this.gameCanvas.positionXEnemy = 1024;
                    if (this.gameCanvas.positionYEnemy >= 600) this.gameCanvas.positionYEnemy = 600;
                }*/

                if (this.gameCanvas.positionXEnemy >= 1024 || this.gameCanvas.positionXEnemy <= 0)
                    this.gameCanvas.velocityXEnemy = -this.gameCanvas.velocityXEnemy;
                if (this.gameCanvas.positionYEnemy >= 600 || this.gameCanvas.positionYEnemy <= 0)
                    this.gameCanvas.velocityYEnemy = -this.gameCanvas.velocityYEnemy;
                //if (this.gameCanvas.positionXEnemy >= 1024 && this.gameCanvas.positionYEnemy >=600 )


                this.gameCanvas.renderAll();
                this.lastTime = currentTime;


            }

        }
    }

}
