import java.awt.*;

public class Background extends GameObject {
    private BackgroundRenderer renderer;

    public Background() {
        this.renderer = new BackgroundRenderer(Color.black,1024,600);
    }

    @Override
    public void render(Graphics graphics) {
        this.renderer.render(graphics, this.position);
    }

}
