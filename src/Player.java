import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Player {

    private BufferedImage backBuffered;
    public Vector2D position;
    public Vector2D velocity;
    public Color color;
    public Polygon polygon;
    public List<Vector2D> vertices;
    public List<BulletPlayer> bulletPlayers;
    public Random random;
    public double angle = 0.0;
    private int countBullet = 0;

    public Player() {
        this.position = new Vector2D();
        this.velocity = new Vector2D(3.5f, 0);
        this.color = Color.red;
        this.vertices = Arrays.asList(
                new Vector2D(),
                new Vector2D(0, 16),
                new Vector2D(20, 8)
        );
        this.polygon = new Polygon();
        this.bulletPlayers = new ArrayList<>();

    }


    public void runPlayer() {
        this.position.addUp(this.velocity);

        this.shootBullet(this);
        this.bulletPlayers.forEach(bulletPlayer -> bulletPlayer.run());

//        if (this.position.x > 1024) {
//            this.position.set(0, this.random.nextInt(600));
////            this.position.x = 0;
////            this.position.y = this.random.nextInt(600);
//        }
//        if (this.position.y > 600) {
//            this.position.set(this.random.nextInt(1024), 0);
////            this.position.x = this.random.nextInt(1024);
////            this.position.y = 0;
//        }
//        if(this.position.x < 0){
//            this.position.set(1024, this.random.nextInt(600));
////            this.position.x = 1024;
////            this.position.y = this.random.nextInt(600);
//        }
//        if(this.position.y < 0){
//            this.position.set(this.random.nextInt(1024), 600);
////            this.position.x = this.random.nextInt(1024);
////            this.position.y = 600;
//        }
    }

    public void shootBullet(Player player) {
        if (countBullet == 10) {
            BulletPlayer bulletPlayer = new BulletPlayer();
            bulletPlayer.position.set(player.position);
            //bulletPlayer.image = this.loadImage("resources/resources-rocket-master/resources/images/circle.png");
            bulletPlayer.velocity.set(new Vector2D(5, 0).rotate(player.angle));
            this.bulletPlayers.add(bulletPlayer);
            this.countBullet = 0;
        } else countBullet += 1;
    }


    public void render(Graphics graphics) {
        this.polygon.reset();

        Vector2D center = this.vertices
                .stream()
                .reduce(new Vector2D(), (v1, v2) -> v1.add(v2))
                .multiply(1 / this.vertices.size())
                .rotate(this.angle);

        Vector2D traslation = this.position.subtract(center);
        this.vertices.stream()
                .map(vertex -> vertex.rotate(this.angle))
                .map(vertex -> vertex.add(traslation))
                .forEach(vertex -> polygon.addPoint((int) vertex.x, (int) vertex.y));

        graphics.setColor(Color.red);
        graphics.fillPolygon(this.polygon);

        this.bulletPlayers.forEach(bulletPlayer -> bulletPlayer.render(graphics));


    }
}
