import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EnemyShoot implements GameObjectAttack {

    public List<BulletEnemy> bulletEnemies;
    private int countBullet = 0;
    private Random random;

    public EnemyShoot() {
        this.bulletEnemies = new ArrayList<>();
        this.random = new Random();
    }

    @Override
    public void run(GameObject gameObject) {
        if (countBullet == 50) {
            for (double angle = 0.0; angle < 360.0; angle += 360 / 10.0) {
                BulletEnemy bulletEnemy = new BulletEnemy();
                bulletEnemy.position.set(((Enemy) gameObject).position);
                bulletEnemy.velocity.set(new Vector2D(7.0f, 0).rotate(angle * 1));
                this.bulletEnemies.add(bulletEnemy);
            }
            countBullet = 0;
        } else countBullet += 1;

        this.bulletEnemies.forEach(bulletEnemy -> bulletEnemy.run());
        //this.backToScreen((Enemy) gameObject);
    }

//    public void backToScreen(GameObject gameObject){
//        if (((Enemy) gameObject).position.x < 0) ((Enemy) gameObject).position.set(1024, this.random.nextInt(600));
//
//        if (((Enemy) gameObject).position.x > 1024) ((Enemy) gameObject).position.set(0, this.random.nextInt(600));
//
//        if (((Enemy) gameObject).position.y < 0) ((Enemy) gameObject).position.set(this.random.nextInt(1024), 600);
//
//        if (((Enemy) gameObject).position.y > 600) ((Enemy) gameObject).position.set(this.random.nextInt(1024), 0);
//    }
}
