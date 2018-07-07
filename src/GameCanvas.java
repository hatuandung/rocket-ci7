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
    private BufferedImage backBuffered;
    private Graphics graphics;


    public CreateEnemy createEnemy = new CreateEnemy();
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
        GameObjectManager.instance.add(new Background());

        GameObjectManager.instance.add(new CreateStar());

        this.createEnemy = new CreateEnemy();
        createPlayer();
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered, 0, 0, null);
    }

    public void renderAll() {
//        this.createStar.render(this.graphics);
//        this.player.render(this.graphics);
//        //this.createEnemy.enemies.forEach(enemy -> enemy.render(graphics));
//        this.createEnemy.enemySpecials.forEach(enemySpecial -> enemySpecial.render(graphics));
//        this.createEnemy.enemyNormals.forEach(enemyNormal -> enemyNormal.render(graphics));
        //
        GameObjectManager.instance.renderAll(graphics);
        this.repaint();
    }

    public void runAll() {
        //run all gameObject : Player, Enemy, Star
        GameObjectManager.instance.runAll();
    }

    private void createPlayer() {
//        this.player.position.set(200, 200);
        Player player = new Player();
        player.position.set(100,200);
        GameObjectManager.instance.add(player);
    }

//    private void runEnemy(){
//        this.enemies.forEach(enemy -> enemy.velocity.set(this.player.position
//                .subtract(enemy.position)
//                .normalize()
//        ));
//
//    }

    private BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            return null;
        }
    }
}

