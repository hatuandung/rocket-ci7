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
    int countEnemy = 0;

    private Background background;
    public CreateStar createStar;
    public CreateEnemy createEnemy;
    public Player player = new Player();



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
        this.background = new Background();
        this.createStar = new CreateStar();
        this.createEnemy = new CreateEnemy();

        createPlayer();
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered, 0, 0, null);
    }

    public void renderAll() {


        this.player.render(this.graphics);
        this.createStar.stars.forEach(star -> star.render(graphics));
        //this.createEnemy.enemies.forEach(enemy -> enemy.render(graphics));
        this.repaint();
    }

    public void runAll() {
        this.background.render(this.graphics);

        this.createStar.create();
        // enemy run

        // player run
        this.player.run();

    }


    private void createPlayer() {
        this.player.position.set(200, 200);
    }

    private void runEnemy(){
//        this.enemies.forEach(enemy -> enemy.velocity.set(this.player.position
//                .subtract(enemy.position)
//                .normalize()
//        ));

    }

    private BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            return null;
        }
    }
}

