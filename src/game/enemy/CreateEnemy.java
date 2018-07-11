package game.enemy;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;

import java.util.Random;

public class CreateEnemy extends GameObject {

    public Random random;
    public FrameCounter frameCounter;

    public CreateEnemy() {
        this.random = new Random();
        this.frameCounter = new FrameCounter(200);
    }

    public void run() {
        //game.enemy.EnemyNormal
        if (this.frameCounter.run()) {
            EnemyNormal enemyNormal = new EnemyNormal();
            enemyNormal.position.set(1024, this.random.nextInt(600));
            enemyNormal.velocity.set(this.random.nextInt(3) + 1, 0);
            GameObjectManager.instance.add(enemyNormal);
            this.frameCounter.reset();
        }

        //game.enemy.EnemySpecial
        if (this.frameCounter.run()) {
            EnemySpecial enemySpecial = new EnemySpecial();
            enemySpecial.position.set(1024, this.random.nextInt(600));
            //enemySpecial.velocity.set(this.random.nextInt(3) + 1, 0);
            GameObjectManager.instance.add(enemySpecial);

            this.frameCounter.reset();
        }
    }
}
