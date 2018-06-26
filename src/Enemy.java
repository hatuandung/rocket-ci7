import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Enemy {
    public Vector2D position;
    public BufferedImage image;
    public Vector2D velocity;
    public List<BulletEnemy> bulletEnemies;
    public int countBullet = 0;

    public Enemy() {
        this.position = new Vector2D();
        this.velocity = new Vector2D();
        this.bulletEnemies = new ArrayList<>();
    }

    public void runEnemy() {

        this.position.addUp(this.velocity);
        this.shootBullet(this);
        this.bulletEnemies.forEach(bulletEnemy -> bulletEnemy.run());

    }
    public void shootBullet(Enemy enemy){
        if(countBullet == 6) {
            for (int i = 0; i < 6; i++) {
                BulletEnemy bulletEnemy = new BulletEnemy();
                bulletEnemy.position.set(enemy.position);
                bulletEnemy.velocity.set(new Vector2D(7, 0).rotate(i * 60));
                this.bulletEnemies.add(bulletEnemy);
            }
            countBullet = 0;
        }else countBullet +=1;
    }

    public void render(Graphics graphics) {
        graphics.drawImage(this.image, (int) this.position.x, (int) this.position.y, 10, 10, null);
        this.bulletEnemies.forEach(bulletEnemy -> bulletEnemy.render(graphics));

    }
}
