import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Enemy extends GameObject{
    public Vector2D velocity;
    public GameObjectAttack gameObjectAttack;


    public Enemy() {
        this.renderer = new ImageRenderer("resources/resources-rocket-master/resources/images/circle.png", 15, 15);
        this.velocity = new Vector2D();
        //this.gameObjectAttack = new EnemyShoot();
    }
    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        //this.gameObjectAttack.run(this);

    }
    @Override
    public void render(Graphics graphics) {
        super.render(graphics);
        //((EnemyShoot) this.gameObjectAttack).bulletEnemies.forEach(bulletPlayer -> bulletPlayer.render(graphics));
    }

}
