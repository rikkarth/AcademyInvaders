package org.academiadecodigo.academyinvaders.GameObjects.Bullets;

import org.academiadecodigo.academyinvaders.GameObjects.Grid.GridDirection;
import org.academiadecodigo.academyinvaders.GameObjects.Grid.Position.GridPosition;
import org.academiadecodigo.academyinvaders.GameObjects.System.Game;

public class PlayerBullet extends AbstractBullet {

    //Constructor
    public PlayerBullet(GridPosition bulletPosition) {
        super(bulletPosition);
    }

    public void tick() {

            this.getBulletPosition().moveInDirection(GridDirection.UP, 5);
    }

    public void render() {

        this.getBulletPosition().show();
    }
}
