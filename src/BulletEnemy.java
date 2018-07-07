import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BulletEnemy extends GameObject{
    public Vector2D velocity;
    //public BufferedImage image;
    public Renderer renderer;
    //Player player;
    public BulletEnemy() {
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/resources-rocket-master/resources/images/circle.png", 5,5);
    }


    public void run() {
        super.run();
        this.position.addUp(this.velocity);
    }


}
