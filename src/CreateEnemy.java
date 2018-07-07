import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreateEnemy extends GameObject {
    //    public EnemyNormal enemyNormal;
//    public EnemySpecial enemySpecial;
    public List<EnemyNormal> enemyNormals;
    public List<EnemySpecial> enemySpecials;
    public Random random;
    public FrameCounter frameCounter;
    public CreateEnemy() {

//        this.enemyNormal = new EnemyNormal();
//        this.enemySpecial = new EnemySpecial();
        this.random = new Random();
        this.enemyNormals = new ArrayList<>();
        this.enemySpecials = new ArrayList<>();
        this.frameCounter = new FrameCounter(20);
    }

    public void create() {
        //EnemyNormal
        if (this.frameCounter.run()) {
            EnemyNormal enemyNormal = new EnemyNormal();
            enemyNormal.position.set(1024, this.random.nextInt(600));
            enemyNormal.velocity.set(this.random.nextInt(3) + 1, 0);
            this.enemyNormals.add(enemyNormal);
            this.frameCounter.reset();
        }

        this.enemyNormals.forEach(enemyNormal -> enemyNormal.run());
        //EnemySpecial
        if (this.frameCounter.run()) {
            EnemySpecial enemySpecial = new EnemySpecial();
            enemySpecial.position.set(1024, this.random.nextInt(600));
            //enemySpecial.velocity.set(this.random.nextInt(3) + 1, 0);
            this.enemySpecials.add(enemySpecial);
            this.frameCounter.reset();
        }

        this.enemySpecials.forEach(enemySpecial -> enemySpecial.run());
    }
}
