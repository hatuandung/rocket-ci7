import java.awt.*;
import java.util.Random;

//EnemyNormal is what can shoot Player
public class EnemyNormal extends GameObject{
    public Random random;
    public GameObjectAttack gameObjectAttack;
    public Vector2D velocity;

    public EnemyNormal() {

        this.renderer = new ImageRenderer("resources/resources-rocket-master/resources/images/circle.png", 15, 15);
        this.velocity = new Vector2D();
        this.gameObjectAttack = new EnemyShoot();
    }

    public void run(){
        super.run();
        this.position.addUp(this.velocity);
        this.gameObjectAttack.run(this);
    }



}
