package org.academiadecodigo.academyinvaders.GameObjects.Bullets;

import org.academiadecodigo.academyinvaders.GameObjects.Grid.Position.GridPosition;

public abstract class Bullets {
    private final int DAMAGE;
    private final int SPEED;
    private GridPosition bulletPosition;

    public Bullets(GridPosition bulletPosition) {
        this.SPEED = 5; // passível de alteração
        this.DAMAGE = 10;
        this.bulletPosition = bulletPosition;
    }

    public abstract void bulletMovement();

    public abstract boolean hit();
}
