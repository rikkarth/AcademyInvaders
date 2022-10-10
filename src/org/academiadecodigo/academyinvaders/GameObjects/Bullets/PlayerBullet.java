package GameObjects.Bullets;

import org.academiadecodigo.academyinvaders.GameObjects.Bullets.Bullets;

public class PlayerBullet extends Bullets {

    public PlayerBullet(GridPosition bulletPosition) {
        super(bulletPosition);
    }

    @Override
    public void bulletMovement() {
        move.UP;
    }

    @Override
    public boolean hit() {
        return false;
    }
}
