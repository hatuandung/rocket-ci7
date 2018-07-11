package game.enemy;

import base.GameObject;
import base.Vector2D;
import renderer.ImageRenderer;
import renderer.Renderer;

public class BulletEnemy extends GameObject{
    public Vector2D velocity;

    public BulletEnemy() {
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/resources-rocket-master/resources/images/circle.png", 5,5);
    }


    public void run() {
        super.run();
        this.position.addUp(this.velocity);
    }


}
