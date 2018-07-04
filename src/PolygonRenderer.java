import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class PolygonRenderer implements Renderer{

    public Polygon polygon;
    public double angle = 0.0;
    public Color color;
    public List<Vector2D> vertices;

    public PolygonRenderer(Color color, Vector2D... vertices){ //mảng
        this.color = color;
        this.vertices = Arrays.asList(vertices);
        this.polygon = new Polygon();

    }

    @Override
    public void render(Graphics graphics, Vector2D position) {
        this.polygon.reset();

        Vector2D center = this.vertices
                .stream()
                .reduce(new Vector2D(), (v1, v2) -> v1.add(v2))
                .multiply(1.0f / this.vertices.size())
                .rotate(this.angle);

        Vector2D traslation = position.subtract(center);
        this.vertices.stream()
                .map(vertex -> vertex.rotate(this.angle))
                .map(vertex -> vertex.add(traslation))
                .forEach(vertex -> polygon.addPoint((int) vertex.x, (int) vertex.y));

        graphics.setColor(this.color);
        graphics.fillPolygon(this.polygon);
    }
}
