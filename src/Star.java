import java.awt.*;
import java.awt.image.BufferedImage;

public class Star {

    public int positionXStar;
    public int positionYStar;

    public BufferedImage image;
    public int velocityX;
    public int velocityY;

    public Star(int positionXStar, int positionYStar, BufferedImage image, int velocityX, int velocityY) {
        this.positionXStar = positionXStar;
        this.positionYStar = positionYStar;
        this.image = image;
        this.velocityX = velocityX;
        this.velocityY = velocityY;
    }

    public Star(){

    }

    public void runStar() {
        this.positionXStar += this.velocityX;
        this.positionYStar += this.velocityY;

    }

    public void render(Graphics graphics) {
        graphics.drawImage(this.image, this.positionXStar, this.positionYStar, 5,5,null);
    }

}
