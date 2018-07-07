import java.awt.*;

public class Background extends GameObject {
    private BackgroundRenderer renderer;

    public Background() {
        this.renderer = new BackgroundRenderer(Color.BLACK,1024,600);
    }



}
