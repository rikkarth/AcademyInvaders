package GameObjects.Bullets;

import org.academiadecodigo.academyinvaders.GameObjects.Bullets.Bullets;

public class EnemyBullet extends Bullets {

    public EnemyBullet(GridPosition bulletPosition) {
        super(bulletPosition);
    }

    @Override
    public void bulletMovement() {
        move.DOWN;
    }

    @Override
    public boolean hit() {
//        if(bulletP)
        return false;
    }
}
