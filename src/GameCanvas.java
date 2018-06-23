import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameCanvas extends JPanel {
    Random random = new Random();

    //BackBuffered
    private BufferedImage backBuffered;
    private Graphics graphics;
    int countStar = 0;
    int countEnemy = 0;

    private List<Star> stars;
    private List<Enemy> enemies;
    private Player player;
    private Background background;


    public GameCanvas() {
        this.setSize(1024, 600);
        this.setupBackBuffered();
        this.setupCharacter();
        this.setVisible(true);

    }

    private void setupBackBuffered() {
        this.backBuffered = new BufferedImage(1024, 600, BufferedImage.TYPE_4BYTE_ABGR);
        this.graphics = this.backBuffered.getGraphics();
    }

    private void setupCharacter() {
        this.stars = new ArrayList<>();
        this.enemies = new ArrayList<>();
        createPlayer();

    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered, 0, 0, null);
    }

    public void renderAll() {

//        this.graphics.setColor(Color.BLACK);
//        this.graphics.fillRect(0, 0, 1024, 600);

        this.drawBackground();
        this.player.render(this.graphics);
        this.stars.forEach(star -> star.render(graphics));
        this.enemies.forEach(enemy -> enemy.render(graphics));
        this.repaint();
    }

    public void runAll() {
        this.createStar();
        this.createEnemy();
        this.stars.forEach(star -> star.runStar());
        // enemy run
        this.enemies.forEach(enemy -> enemy.velocity.set(this.player.position
                .subtract(enemy.position)
                .normalize()
        ));
        this.enemies.forEach(enemy -> enemy.runEnemy());


    }

    private void createStar() {
        if (this.countStar == 40) {
            Star star = new Star(
                    new Vector2D(1024, this.random.nextInt(600)),
                    this.loadImage("resources/resources-rocket-master/resources/images/star.png"),
                    5, 5,
                    new Vector2D(this.random.nextInt(3) + 1, 0));
            this.stars.add(star);
            this.countStar = 0;
        } else this.countStar += 1;

    }

    private void createEnemy() {
        if (countEnemy == 5) {
            Enemy enemy = new Enemy(
                    new Vector2D(this.random.nextInt(1024), this.random.nextInt(600)),

                    this.loadImage("resources/resources-rocket-master/resources/images/circle.png"),
                    20,
                    20,
                    new Vector2D(5,5)
            );
            this.enemies.add(enemy);
            this.countEnemy = 0;
        } else this.countEnemy += 1;
    }

    private void createPlayer() {
        this.player = new Player(new Vector2D(200,200),new Vector2D(5,5), Color.red);

    }

    private void drawBackground() {
        this.background = new Background(Color.black, 0, 0, 1024, 600);
        this.background.render(this.graphics);

    }


    private BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            return null;
        }
    }
}

