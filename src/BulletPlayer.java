import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class BulletPlayer {
    public Vector2D position;
    public Vector2D velocity;
    public BufferedImage image;
    //Player player;
    public BulletPlayer() {
        this.position = new Vector2D();
        this.velocity = new Vector2D();
        this.image = loadImage("resources/resources-rocket-master/resources/images/circle.png");
    }

    private BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            return null;
        }
    }

    public void run() {

        this.position.addUp(this.velocity);

    }

    public void render(Graphics graphics) {
        //this.image.

        graphics.drawImage(this.image, (int) this.position.x, (int) this.position.y, 3, 3, null);
    }
}
