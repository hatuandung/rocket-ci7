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
    int countBullet = 0;

    private List<Star> stars;
    private List<Enemy> enemies;
    public List<BulletPlayer> bulletPlayers;
    public Player player = new Player();
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
        this.bulletPlayers = new ArrayList<>();
        createPlayer();
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered, 0, 0, null);
    }

    public void renderAll() {

        this.drawBackground();
        this.player.render(this.graphics);
        this.stars.forEach(star -> star.render(graphics));
        this.enemies.forEach(enemy -> enemy.render(graphics));
        //this.bulletPlayers.forEach(bulletPlayer -> bulletPlayer.render(graphics));
        this.repaint();
    }

    public void runAll() {
        this.createStar();
        this.createEnemy();
        //this.createBullet();
        this.stars.forEach(star -> star.runStar());
        // enemy run
        this.enemies.forEach(enemy -> enemy.velocity.set(this.player.position
                .subtract(enemy.position)
                .normalize()
        ));
        this.enemies.forEach(enemy -> enemy.runEnemy());

        this.player.runPlayer();

    }

    private void createStar() {
        if (this.countStar == 20) {
            Star star = new Star();
            star.position.set(1024, this.random.nextInt(600));
            star.image = this.loadImage("resources/resources-rocket-master/resources/images/star.png");
            star.velocity.set(this.random.nextInt(3) + 1, 0);
            this.stars.add(star);
            this.countStar = 0;
        } else this.countStar += 1;

    }

    private void createEnemy() {

        if (countEnemy == 40) {
            Enemy enemy = new Enemy();
            enemy.position.set(this.random.nextInt(1024), this.random.nextInt(600));
            enemy.velocity.set(10, 10);
            enemy.image = this.loadImage("resources/resources-rocket-master/resources/images/circle.png");
            this.enemies.add(enemy);
            this.countEnemy = 0;
        } else {
            this.countEnemy += 1;
        }
    }

    private void createPlayer() {
        this.player.position.set(200, 200);

    }

//    private void createBullet() {
//        if (countBullet == 10) {
//            BulletPlayer bulletPlayer = new BulletPlayer();
//            bulletPlayer.position.set(this.player.position.x, this.player.position.y);
//            bulletPlayer.image = this.loadImage("resources/resources-rocket-master/resources/images/circle.png");
//            bulletPlayer.velocity.set(this.player.velocity.x+10, this.player.velocity.y);
//            this.bulletPlayers.add(bulletPlayer);
//            this.countBullet = 0;
//        } else {
//            this.countBullet += 1;
//        }
//    }

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

