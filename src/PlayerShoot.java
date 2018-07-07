

public class PlayerShoot implements GameObjectAttack {

    private FrameCounter frameCounter;


    public PlayerShoot() {
        this.frameCounter = new FrameCounter(30);
    }


    @Override
    public void run(GameObject gameObject) {
        if (this.frameCounter.run()) {
            BulletPlayer bulletPlayer = new BulletPlayer();
            bulletPlayer.position.set(((Player) gameObject).position);
            bulletPlayer.velocity.set(((Player) gameObject).velocity.copy().multiply(1.5f));
            GameObjectManager.instance.add(bulletPlayer);
            this.frameCounter.reset();
        }

    }
}
