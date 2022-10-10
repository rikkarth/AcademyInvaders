package GameObjects.Enemy;

import org.academiadecodigo.academyinvaders.GameObjects.Grid.Grid;

public abstract class Enemy {

    private GridPosition enemyPosition;
    private Grid grid;
    private GameObjects.Enemy.EnemyType enemyType;
    private boolean destroyed;

    private final int health;

    protected DestructionDetector destructionDetector;

    public Enemy(GridPosition enemyPosition
//                 GameObjects.Enemy.EnemyType enemyType
    ) {

        this.enemyPosition = enemyPosition;
//        this.enemyType = enemyType;
        this.destroyed = false;
        this.health = 150;

        //enemyPosition.setFace(spaceShipType.getFace());
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public GridPosition getEnemyPosition() {
        return enemyPosition;
    }

    public void setDestructionDetector(DestructionDetector destructionDetector) {
        this.destructionDetector = destructionDetector;
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public void setDestroyed() {

        this.destroyed = true;
        //Desaparece... deixa "presente"?
    }

    abstract public void move();
}
