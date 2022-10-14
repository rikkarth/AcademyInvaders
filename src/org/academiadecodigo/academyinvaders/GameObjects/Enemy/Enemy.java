package org.academiadecodigo.academyinvaders.GameObjects.Enemy;

import org.academiadecodigo.academyinvaders.GameObjects.Bullets.EnemyBullet;
import org.academiadecodigo.academyinvaders.GameObjects.Grid.Grid;
import org.academiadecodigo.academyinvaders.GameObjects.Grid.GridDirection;
import org.academiadecodigo.academyinvaders.GameObjects.Grid.Position.GridPosition;
import org.academiadecodigo.academyinvaders.GameObjects.System.DestructionDetector;


public abstract class Enemy {

    private GridPosition enemyPosition;

    private EnemyBullet enemyBullet;

    private Grid grid;

    private EnemyType enemyType;

    private boolean destroyed;

    private final int health;

    protected DestructionDetector destructionDetector;


    public Enemy(GridPosition enemyPosition) {

        this.enemyPosition = enemyPosition;
        this.destroyed = false;
        this.health = 150;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public GridPosition getEnemyPosition() {
        return enemyPosition;
    }

    public void setEnemyPosition(GridPosition enemyPosition) {
        this.enemyPosition = enemyPosition;
    }

    public void setDestructionDetector(DestructionDetector destructionDetector) {
        this.destructionDetector = destructionDetector;
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public void setDestroyed() {

        this.destroyed = true;
    }

    abstract public void move();

    public void movement(GridDirection direction, int distance) {

        getEnemyPosition().moveInDirection(direction, distance);
    }
}
