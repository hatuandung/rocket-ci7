import base.GameObject;
import base.GameObjectManager;
import game.background.Background;
import game.enemy.CreateEnemy;
import game.powerUp.CreatePowerUp;
import game.star.CreateStar;
import game.player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GameCanvas extends JPanel {
    private BufferedImage backBuffered;
    private Graphics graphics;

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

        GameObjectManager.instance.add(new CreateEnemy());

        GameObjectManager.instance.add(new CreatePowerUp());

        createPlayer();
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered, 0, 0, null);
    }

    public void renderAll() {
        //render all gameObject : Player, Enemy, Star, Background
        GameObjectManager.instance.renderAll(graphics);
        this.repaint();
    }

    public void runAll() {
        //run all gameObject : Player, Enemy, Star
        GameObjectManager.instance.runAll();
    }

    private void createPlayer() {
        Player player = new Player();
        player.position.set(100,200);
        GameObjectManager.instance.add(player);
    }


}

