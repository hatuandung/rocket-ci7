package game.powerUp;

import base.GameObject;
import base.Vector2D;
import physic.BoxCollider;
import renderer.ImageRenderer;

import java.awt.*;

public class TripleShootEffect extends GameObject {
    public Vector2D velocity;
    public BoxCollider boxCollider;

    public TripleShootEffect() {
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/resources-rocket-master/resources/images/powerup_triple_shot.png", 20, 20);
    }

    @Override
    public void run() {
        super.run();
        this.position.subtractBy(this.velocity);
    }

}
