import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BulletEnemy {
    public Vector2D position;
    public Vector2D velocity;
    //public BufferedImage image;
    public Renderer renderer;
    //Player player;
    public BulletEnemy() {
        this.position = new Vector2D();
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/resources-rocket-master/resources/images/circle.png", 5,5);
    }

//    private BufferedImage loadImage(String path) {
//        try {
//            return ImageIO.read(new File(path));
//        } catch (IOException e) {
//            return null;
//        }
//    }

    public void run() {
        this.position.addUp(this.velocity);
    }

    public void render(Graphics graphics) {
        //this.image.
        this.renderer.render(graphics, this.position);
    }
}
