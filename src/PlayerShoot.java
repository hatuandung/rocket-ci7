import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class PlayerShoot implements GameObjectAttack {
    public List<BulletPlayer> bulletPlayers;
    private int countBullet = 0;

    public PlayerShoot() {
        this.bulletPlayers = new ArrayList<>();
    }


    @Override
    public void run(GameObject gameObject) {
        if (countBullet == 30) {
            BulletPlayer bulletPlayer = new BulletPlayer();
            bulletPlayer.position.set(((Player) gameObject).position);
            bulletPlayer.velocity.set(((Player) gameObject).velocity.copy().multiply(1.5f));
            this.bulletPlayers.add(bulletPlayer);
            this.countBullet = 0;
        } else countBullet += 1;

        this.bulletPlayers.forEach(bulletPlayer -> bulletPlayer.run());
    }
}
