package game.enemy;

import base.FrameCounter;
import base.GameObjectAttributes;
import base.GameObjectManager;
import base.Vector2D;
import game.enemy.EnemySpecial;
import game.player.Player;

import java.util.Vector;

public class EnemyFollow implements GameObjectAttributes<EnemySpecial> {

    @Override
    public void run(EnemySpecial gameObject) {
        Player player = GameObjectManager.instance.findPlayer();
        if (player != null) {
            Vector2D velocity = player.position
                    .subtract(gameObject.position)
                    .normalize()
                    .multiply(1.5f);
            gameObject.velocity.set(velocity);
        }


    }
}
