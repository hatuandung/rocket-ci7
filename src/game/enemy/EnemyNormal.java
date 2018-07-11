package game.enemy;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.player.Player;
import physic.BoxCollider;
import renderer.ImageRenderer;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//EnemyNormal is what can shoot Player
public class EnemyNormal extends GameObject {
    public Random random;
    public Vector2D velocity;
    public BoxCollider boxCollider;

    public EnemyNormal() {

        this.renderer = new ImageRenderer("resources/resources-rocket-master/resources/images/circle.png", 20, 20);
        this.velocity = new Vector2D();
        this.attributes.add(new EnemyShoot());
        this.boxCollider = new BoxCollider(20, 20);

    }

    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.boxCollider.position.set(this.position.x - 10, this.position.y - 10);

    }


}
