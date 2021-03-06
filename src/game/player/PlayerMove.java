package game.player;

import base.GameObject;
import base.GameObjectAttributes;
import base.Vector2D;
import input.KeyboardListener;

import java.util.Random;

public class PlayerMove implements GameObjectAttributes<Player> {
    public Vector2D velocity;
    public double angle = 0.0;
    private Random random;

    public PlayerMove() {
        this.velocity = new Vector2D();
        this.random = new Random();
    }

    public void run(Player player) {
        //LeftButton
        if (KeyboardListener.instance.isLeft) {
            player.angle -= 5.0;
        }
        //RightButton
        if (KeyboardListener.instance.isRight) {
            player.angle += 5.0;
        }
        //UpButton
        if (KeyboardListener.instance.isUp) {
            player.velocity = new Vector2D(7.0f, 0.0f);
        } else {
            player.velocity = new Vector2D(3.5f, 0.0f);
        }

        //SpaceButton if you holding SpaceButton player will shoot
//        if(KeyboardListener.instance.isSpace){
//            player.isPlayerShoot = true;
//        }



        player.velocity.set(
                player.velocity.rotate(player.angle)
        );

        player.position.addUp(player.velocity);
        this.backToScreen(player);
    }

    public void backToScreen(Player player) {
        if (player.position.x > 1024) {
            player.position.set(0, this.random.nextInt(600));
        }
        if (player.position.y > 600) {
            player.position.set(this.random.nextInt(1024), 0);
        }
        if (player.position.x < 0) {
            player.position.set(1024, this.random.nextInt(600));
        }
        if (player.position.y < 0) {
            player.position.set(this.random.nextInt(1024), 600);
        }
    }
}
