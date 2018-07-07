import java.awt.*;

//EnemySpecial is what can follow Player
public class EnemySpecial extends GameObject{
    public GameObjectAttack gameObjectAttack;
    public Vector2D velocity;

    public EnemySpecial() {
        this.renderer = new ImageRenderer("resources/resources-rocket-master/resources/images/circle.png", 15, 15);
        this.velocity = new Vector2D();
        this.gameObjectAttack = new EnemyFollow();
    }
    @Override
    public void run(){
        super.run();
        this.position.addUp(this.velocity);
        this.gameObjectAttack.run(this);

    }
    @Override
    public void render(Graphics graphics){
        super.render(graphics);

    }
}
