import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class GameCanvas extends JPanel {

    BufferedImage starImage;
    BufferedImage enemyImage;
    BufferedImage playerImage;
    Random random = new Random();

    //BackBuffered
    BufferedImage backBuffered;
    Graphics graphics;


    public int positionXStar = random.nextInt(1024);
    public int positionYStar = random.nextInt(600);

    public int positionXPlayer = 512;
    public int positionYPlayer = 300;
    public int velocityXEnemy = 15;
    public int velocityYEnemy = 15;

    public int positionXEnemy = random.nextInt(1024);
    public int positionYEnemy = random.nextInt(600);


    public GameCanvas() {
        this.setSize(1024, 600);

        this.backBuffered = new BufferedImage(1024, 600, BufferedImage.TYPE_4BYTE_ABGR);
        this.graphics = this.backBuffered.getGraphics();

        try {
            this.starImage = ImageIO.read(new File("resources/resources-rocket-master/resources/images/star.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            this.enemyImage = ImageIO.read(new File("resources/resources-rocket-master/resources/images/circle.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            this.playerImage = ImageIO.read(new File("resources/resources-rocket-master/resources/images/circle.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }


        this.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered, 0, 0, null);
    }

    public void renderAll() {
        this.graphics.setColor(Color.BLACK);
        this.graphics.fillRect(0, 0, 1024, 600);

        this.graphics.drawImage(this.starImage, this.positionXStar, this.positionYStar, 5, 5, null);

        this.graphics.drawImage(this.enemyImage, this.positionXEnemy, this.positionYEnemy, 20, 20, null);

        this.graphics.drawImage(this.playerImage, this.positionXPlayer, this.positionYPlayer, 20, 20, null);

        this.repaint();
    }
}

