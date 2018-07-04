public class EnemyFollow implements GameObjectAttack {
    public Player player;

    @Override
    public void run(GameObject gameObject) {
        Player player = new Player();
        this..forEach(enemy -> enemy.velocity.set(this.player.position
//                .subtract(enemy.position)
//                .normalize()
    }
}
