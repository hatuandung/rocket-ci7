package game.powerUp;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;

import java.util.Random;

public class CreatePowerUp extends GameObject {
    public FrameCounter frameCounter;
    private Random random;

    public CreatePowerUp() {
        this.frameCounter = new FrameCounter(100);
        this.random = new Random();
    }

    public void run() {
        super.run();
        if (this.frameCounter.run()) {
            if (random.nextInt() % 2 == 0) {
                TripleShootEffect tripleShoot = new TripleShootEffect();
                tripleShoot.position.set(this.random.nextInt(1024), this.random.nextInt(600));
                tripleShoot.velocity.set((this.random.nextInt(3) + 1), 0);
                GameObjectManager.instance.add(tripleShoot);
                //this.frameCounter.reset();
                //System.out.println("powerup created");
            } else {
                ShieldEffect shield = new ShieldEffect();
                shield.position.set(this.random.nextInt(1024), this.random.nextInt(600));
                shield.velocity.set((this.random.nextInt(3) + 1), 0);
                GameObjectManager.instance.add(shield);
            }
            this.frameCounter.reset();
        }
    }
}
