import java.util.Random;

public class PlayerMove {
    public Vector2D velocity;
    public double angle = 0.0;
    private Random random;

    public PlayerMove() {
        this.velocity = new Vector2D();
        this.random = new Random();
    }

    public void run(Player player) {
        if (KeyboardListener.instance.leftPressed) {
            this.angle -= 5.0;
        }
        if (KeyboardListener.instance.rightPressed) {
            this.angle += 5.0;
        }
        Vector2D vector2D = new Vector2D(3.5f, 0.0f);
        this.velocity.set(vector2D.rotate(angle));

        player.position.addUp(this.velocity);
        this.backToScreen(player);
    }

    public void backToScreen(Player player) {
        if (player.position.x > 1024) {
            player.position.set(0, this.random.nextInt(600));
        }
        if (player.position.y > 600) {
            player.position.set(this.random.nextInt(1024), 0);
        }
        if (player.position.x < 0) {
            player.position.set(1024, this.random.nextInt(600));
        }
        if (player.position.y < 0) {
            player.position.set(this.random.nextInt(1024), 600);
        }
    }
}
