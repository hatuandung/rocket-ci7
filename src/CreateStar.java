import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreateStar extends GameObject{
    public FrameCounter frameCounter;
    private Random random;

    public CreateStar() {
        this.frameCounter = new FrameCounter(30);
        this.random = new Random();
    }

    public void run(){
        super.run();
        if (this.frameCounter.run()) {
            Star star = new Star();
            star.position.set(1024, this.random.nextInt(600));
            star.velocity.set(this.random.nextInt(3) + 1, 0);
            GameObjectManager.instance.add(star);
            this.frameCounter.reset();
        }

    }

}
