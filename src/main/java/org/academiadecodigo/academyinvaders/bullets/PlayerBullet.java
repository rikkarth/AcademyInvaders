package org.academiadecodigo.academyinvaders.bullets;

import org.academiadecodigo.academyinvaders.grid.GridDirection;
import org.academiadecodigo.academyinvaders.grid.position.GridPosition;

public class PlayerBullet extends AbstractBullet {

  //Constructor
  public PlayerBullet(GridPosition bulletPosition) {
    super(bulletPosition, 5);
  }

  public void move() {

    this.getBulletPosition().moveInDirection(GridDirection.UP, 5);
  }


}
