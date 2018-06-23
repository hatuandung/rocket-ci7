import java.awt.*;
import java.awt.image.BufferedImage;

public class Enemy {
    public int positionXEnemy;
    public int positionYEnemy;

    public BufferedImage image;
    public int velocityXEnemy;
    public int velocityYEnemy;

    public Enemy(int positionXEnemy, int positionYEnemy, BufferedImage image, int velocityXEnemy, int velocityYEnemy) {
        this.positionXEnemy = positionXEnemy;
        this.positionYEnemy = positionYEnemy;
        this.image = image;
        this.velocityXEnemy = velocityXEnemy;
        this.velocityYEnemy = velocityYEnemy;
    }

    public void runEnemy() {
        this.positionXEnemy += this.velocityXEnemy;
        this.positionYEnemy += this.velocityYEnemy;

        if (this.positionXEnemy < 0 || this.positionXEnemy > 1024 -20){
            this.velocityXEnemy = -this.velocityXEnemy;

        }

        if (this.positionYEnemy < 0 || this.positionYEnemy > 1024 -20){
            this.velocityYEnemy = -this.velocityYEnemy;

        }

    }

    public void render(Graphics graphics) {
        graphics.drawImage(this.image, this.positionXEnemy, this.positionYEnemy, 10,10,null);
    }
}
