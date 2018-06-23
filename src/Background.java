import java.awt.*;

public class Background {
    public Color color;
    public int x;
    public int y;
    public int width;
    public int height;


    public Background(Color color, int x, int y, int width, int height) {
        this.color = color;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

    }
    public void render(Graphics graphics){
        graphics.setColor(color);
        graphics.fillRect(x,y,width,height);
    }

}
