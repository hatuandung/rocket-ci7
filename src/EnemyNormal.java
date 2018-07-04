import java.awt.*;
import java.util.Random;

//EnemyNormal is what can shoot Player
public class EnemyNormal extends Enemy{
    public Random random;
    public GameObjectAttack gameObjectAttack;

    public EnemyNormal() {
        this.gameObjectAttack = new EnemyShoot();
    }

    public void run(){
        super.run();
        this.position.addUp(this.velocity);
        this.gameObjectAttack.run(this);
        this.backToScreen((Enemy) gameObjectAttack);
    }

    @Override
    public void render(Graphics graphics) {
        super.render(graphics);
        ((EnemyShoot) this.gameObjectAttack).bulletEnemies.forEach(bulletPlayer -> bulletPlayer.render(graphics));
    }

    public void backToScreen(GameObject gameObject){
        if (((Enemy) gameObject).position.x < 0) ((Enemy) gameObject).position.set(1024, this.random.nextInt(600));

        if (((Enemy) gameObject).position.x > 1024) ((Enemy) gameObject).position.set(0, this.random.nextInt(600));

        if (((Enemy) gameObject).position.y < 0) ((Enemy) gameObject).position.set(this.random.nextInt(1024), 600);

        if (((Enemy) gameObject).position.y > 600) ((Enemy) gameObject).position.set(this.random.nextInt(1024), 0);
    }
}
