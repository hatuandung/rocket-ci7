import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreateStar {
    public List<Star> stars;
    public int count = 0;
    private Random random;

    public CreateStar() {
        this.stars = new ArrayList<>();
        this.random = new Random();
    }

    public void create(){
        if (this.count == 20) {
            Star star = new Star();
            star.position.set(1024, this.random.nextInt(600));
            star.velocity.set(this.random.nextInt(3) + 1, 0);
            this.stars.add(star);
            this.count = 0;
        } else this.count += 1;

        this.stars.forEach(star -> star.run());
    }
}
