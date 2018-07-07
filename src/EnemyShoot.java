import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EnemyShoot implements GameObjectAttack {

    public FrameCounter frameCounter;
    private Random random;

    public EnemyShoot() {
        this.random = new Random();
        this.frameCounter = new FrameCounter(50);

    }

    @Override
    public void run(GameObject gameObject) {
        if (frameCounter.run()) {
            for (double angle = 0.0; angle < 360.0; angle += 360 / 10.0) {
                BulletEnemy bulletEnemy = new BulletEnemy();
                bulletEnemy.position.set(((Enemy) gameObject).position);
                bulletEnemy.velocity.set(new Vector2D(7.0f, 0).rotate(angle * 1));
                GameObjectManager.instance.add(bulletEnemy);
            }
            frameCounter.reset();
        }

        this.backToScreen((EnemyNormal) gameObject);
    }

    public void backToScreen(GameObject gameObject){
        if (((EnemyNormal) gameObject).position.x < 0) ((EnemyNormal) gameObject).position.set(1024, this.random.nextInt(600));

        if (((EnemyNormal) gameObject).position.x > 1024) ((EnemyNormal) gameObject).position.set(0, this.random.nextInt(600));

        if (((EnemyNormal) gameObject).position.y < 0) ((EnemyNormal) gameObject).position.set(this.random.nextInt(1024), 600);

        if (((EnemyNormal) gameObject).position.y > 600) ((EnemyNormal) gameObject).position.set(this.random.nextInt(1024), 0);
    }
}
