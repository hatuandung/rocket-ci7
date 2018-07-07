import java.util.Vector;

public class EnemyFollow implements GameObjectAttack {

    @Override
    public void run(GameObject gameObject) {
        Player player = GameObjectManager.instance.findPlayer();
        if (player != null) {
            Vector2D velocity = player.position
                    .subtract(((EnemySpecial)  gameObject).position)
                    .normalize()
                    .multiply(1.5f);
            ((EnemySpecial) gameObject).velocity.set(velocity);
        }


    }
}
