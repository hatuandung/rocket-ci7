import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player {
//    public int x;
//    public int y;
//    public Color color;
//    private Polygon polygon;
    public Vector2D position ;
    public Vector2D velocity;
    public Color color;
    public Polygon polygon;
    //public List<Vector2D> vertices;

    public Player(Vector2D position, Vector2D velocity, Color color) {
        this.position = position;
        this.velocity = velocity;
        this.color = color;
        this.polygon = new Polygon();
        this.polygon.addPoint(200,200);
        this.polygon.addPoint(200,216);
        this.polygon.addPoint(220,208);
    }
    //    public Player(int x, int y, Color color) {
//        this.x = x;
//        this.y = y;
//        this.color = color;
//        this.polygon = new Polygon();
//        this.polygon.addPoint(0,0);
//        this.polygon.addPoint(0,16);
//        this.polygon.addPoint(20,8);
//    }

//    public void runPlayer(){
////
////    }

    public void render(Graphics graphics) {
        graphics.setColor(this.color);
        graphics.fillPolygon(this.polygon);
    }
}
