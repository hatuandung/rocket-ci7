import java.awt.*;
import java.awt.image.BufferedImage;

public class Star extends GameObject {

    public Vector2D velocity;

    public Star() {
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/resources-rocket-master/resources/images/star.png", 5, 5);
    }

    @Override
    public void run() {
        super.run();
        this.position.subtractBy(this.velocity);
    }


}
