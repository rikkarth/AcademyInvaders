package GameObjects.Player;

import org.academiadecodigo.academyinvaders.GameObjects.Bullets.*;
import org.academiadecodigo.academyinvaders.GameObjects.Grid.Grid;

public class Player {

    private GridPosition playerPosition;
    private Grid grid;
    private boolean destroyed;
    private GameObjects.Bullets.PlayerBullet playerBullet;
    private int health;
    private int livesLeft;

    protected DestructionDetector destructionDetector;

    public Player(GridPosition playerPosition) {

        this.playerPosition = playerPosition;
        this.destroyed = false;
        this.health = 100;
        this.livesLeft = 3;

        //enemyPosition.setFace(spaceShipType.getFace());
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public GridPosition getPlayerPosition() {
        return playerPosition;
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

    public void move() {

    }
}
