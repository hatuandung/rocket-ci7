import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreateEnemy extends GameObject {
    public EnemyShoot enemyShoot ;
    private Random random;

    public CreateEnemy() {
        this.enemyShoot = new EnemyShoot();
        this.random = new Random();
    }

    public void create(){

    }
}
