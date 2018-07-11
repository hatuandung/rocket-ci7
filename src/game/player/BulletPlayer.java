package game.player;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.enemy.EnemyNormal;
import game.enemy.EnemySpecial;
import physic.BoxCollider;
import renderer.ImageRenderer;

public class BulletPlayer extends GameObject {

    public Vector2D velocity;
    public BoxCollider boxCollider;

    public BulletPlayer() {
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/resources-rocket-master/resources/images/circle.png", 8, 8);
        this.boxCollider = new BoxCollider(8, 8);
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.boxCollider.position.set(this.position.x - 4, this.position.y - 4);

        EnemyNormal enemyNormal = GameObjectManager.instance.checkCollision(this);
        if (enemyNormal != null) {
            enemyNormal.isAlive = false;
            this.isAlive = false;
        }

//        EnemySpecial enemySpecial = GameObjectManager.instance.checkCollision(this);
//        if (enemySpecial != null) {
//            enemySpecial.isAlive = false;
//            this.isAlive = false;
//        }
    }

}