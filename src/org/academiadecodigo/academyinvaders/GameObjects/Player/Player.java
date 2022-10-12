package org.academiadecodigo.academyinvaders.GameObjects.Player;

import org.academiadecodigo.academyinvaders.GameObjects.Bullets.PlayerBullet;
import org.academiadecodigo.academyinvaders.GameObjects.Grid.Grid;
import org.academiadecodigo.academyinvaders.GameObjects.Grid.GridDirection;
import org.academiadecodigo.academyinvaders.GameObjects.Grid.Position.GridPosition;
import org.academiadecodigo.academyinvaders.GameObjects.SimpleGfx.SimpleGfxObjectPosition;
import org.academiadecodigo.academyinvaders.GameObjects.System.DestructionDetector;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Player implements KeyboardHandler {

    private GridPosition playerPosition;

    private Grid grid;

    private boolean destroyed;

    private PlayerBullet playerBullet;

    private int health;

    private int livesLeft;

    protected DestructionDetector destructionDetector;

    /**
     * Player Constructor
     * @param playerPosition provides instance with position in grid
     */
    public Player(GridPosition playerPosition) {

        this.playerPosition = playerPosition;
        this.destroyed = false;
        this.health = 100;
        this.livesLeft = 3;
        initKeyboard();

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

    /**
     * Initializes keyboard
     */
    private void initKeyboard() {

        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent rightPressed = new KeyboardEvent();
        rightPressed.setKey(KeyboardEvent.KEY_D);
        rightPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent leftPressed = new KeyboardEvent();
        leftPressed.setKey(KeyboardEvent.KEY_A);
        leftPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent shootPressed = new KeyboardEvent();
        shootPressed.setKey(KeyboardEvent.KEY_SPACE);
        shootPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(leftPressed);
        keyboard.addEventListener(rightPressed);
        keyboard.addEventListener(shootPressed);
    }

    /**
     * Moves player left and right
     */
    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_A) {

            getPlayerPosition().moveInDirection(GridDirection.LEFT, 5);
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_D) {

            getPlayerPosition().moveInDirection(GridDirection.RIGHT, 5);
        }
    }

    /**
     * Unused
     */
    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}


