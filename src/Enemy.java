import java.awt.*;
import java.awt.image.BufferedImage;

public class Enemy {
    public Vector2D position;
    public BufferedImage image;
    public int width;
    public int height;
    public Vector2D velocity;

    public Enemy(Vector2D position, BufferedImage image, int width, int height, Vector2D velocity) {
        this.position = position;
        this.image = image;
        this.width = width;
        this.height = height;
        this.velocity = velocity;
    }

    public void runEnemy() {
//        this.positionXEnemy += this.velocityXEnemy;
//        this.positionYEnemy += this.velocityYEnemy;
//
//        if (this.positionXEnemy < 0 || this.positionXEnemy > 1024 -20){
//            this.velocityXEnemy = -this.velocityXEnemy;
//
//        }
//
//        if (this.positionYEnemy < 0 || this.positionYEnemy > 1024 -20){
//            this.velocityYEnemy = -this.velocityYEnemy;
//
//        }
        this.position.addUp(this.velocity);
        if (this.position.x < 0 || this.position.x > 1024 - 20)
            this.velocity.x = -this.velocity.x;
        if (this.position.y < 0 || this.position.y > 1024 - 20)
            this.velocity.y = -this.velocity.y;

    }

    public void render(Graphics graphics) {
        graphics.drawImage(this.image, (int) position.x, (int) position.y, this.width, this.height, null);
    }
}
