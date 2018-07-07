import javax.imageio.ImageIO;
import java.awt.*;
import java.util.Random;

public class Player extends GameObject {

    public Vector2D velocity;
    public Random random;
    public double angle = 0.0;

    public GameObjectAttack gameObjectAttack;

    public Player() {
        this.position = new Vector2D();
        this.velocity = new Vector2D(3.5f, 0);
        this.renderer = new PolygonRenderer(
                Color.red,
                new Vector2D(),
                new Vector2D(0, 16),
                new Vector2D(20, 8)
        );
        this.random = new Random();
        this.gameObjectAttack = new PlayerShoot();
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);

        ((PolygonRenderer)this.renderer).angle = this.angle;
        this.gameObjectAttack.run(this);

        if (this.position.x > 1024) {
            this.position.set(0, this.random.nextInt(600));
        }
        if (this.position.y > 600) {
            this.position.set(this.random.nextInt(1024), 0);
        }
        if(this.position.x < 0){
            this.position.set(1024, this.random.nextInt(600));
        }
        if(this.position.y < 0){
            this.position.set(this.random.nextInt(1024), 600);
        }
    }



}
