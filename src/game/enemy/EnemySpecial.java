package game.enemy;

import base.GameObject;
import base.Vector2D;
import physic.BoxCollider;
import renderer.ImageRenderer;

import java.awt.*;

//EnemySpecial is what can follow Player
public class EnemySpecial extends GameObject {
    public Vector2D velocity;

    public EnemySpecial() {
        this.renderer = new ImageRenderer("resources/resources-rocket-master/resources/images/circle.png", 10, 10);
        this.velocity = new Vector2D();
        this.attributes.add(new EnemyFollow());
        this.boxCollider = new BoxCollider(10,10);

    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.boxCollider.position.set(this.position.x - 10, this.position.y - 10);

    }

    @Override
    public void render(Graphics graphics) {
        super.render(graphics);

    }
}
