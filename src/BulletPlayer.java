import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class BulletPlayer extends GameObject{
    public Vector2D velocity;
    public Renderer renderer;

    public BulletPlayer() {
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/resources-rocket-master/resources/images/circle.png", 8,8);
    }


    public void run() {
        super.run();
        this.position.addUp(this.velocity);
    }

}
