package org.academiadecodigo.academyinvaders.GameObjects.Player;

import org.academiadecodigo.academyinvaders.GameObjects.Bullets.PlayerBullet;
import org.academiadecodigo.academyinvaders.GameObjects.Enemy.Enemy;
import org.academiadecodigo.academyinvaders.GameObjects.Grid.Grid;
import org.academiadecodigo.academyinvaders.GameObjects.Grid.GridDirection;
import org.academiadecodigo.academyinvaders.GameObjects.Grid.Position.GridPosition;
import org.academiadecodigo.academyinvaders.GameObjects.System.DestructionDetector;
import org.academiadecodigo.academyinvaders.GameObjects.System.Game;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.util.LinkedList;

public class Player implements KeyboardHandler {

    private GridPosition playerPosition;

    private int velX = 0;
    private int velY = 0;

    private Grid grid;

    private boolean destroyed;

    private PlayerBullet playerBullet;

    private int health;

    private int livesLeft;

    boolean fire = false;

    protected DestructionDetector destructionDetector;

    private Enemy enemy;
    private LinkedList<PlayerBullet> b = new LinkedList<>();

    /**
     * Player Constructor
     *
     * @param playerPosition provides instance with position in grid
     */
    public Player(GridPosition playerPosition, Enemy enemy) {

        this.enemy = enemy;
        this.playerPosition = playerPosition;
        this.destroyed = false;
        this.health = 100;
        this.livesLeft = 3;
        initKeyboard();

        //enemyPosition.setFace(spaceShipType.getFace());
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

    public PlayerBullet getPlayerBullet() {
        return playerBullet;
    }

    private LinkedList<PlayerBullet> bulletList = new LinkedList<>();

    PlayerBullet tempBullet;

    public void tick() {

        for (int i = 0; i < bulletList.size(); i++) {
            tempBullet = bulletList.get(i);

            tempBullet.tick();
            if(tempBullet.collisionDetector(enemy)){
                tempBullet.getBulletPosition().hide();
                bulletList.remove(i);
            }

            if(tempBullet.getBulletPosition().getHeight() == 0){
                tempBullet.getBulletPosition().hide();
                bulletList.remove(i);
            }
        }

    }

    public void render() {
        for (int i = 0; i < bulletList.size(); i++) {
            tempBullet = bulletList.get(i);

            tempBullet.render();

            if(tempBullet.collisionDetector(enemy)){
               tempBullet.getBulletPosition().hide();
            }
            if(tempBullet.getBulletPosition().getHeight() == 0){
                tempBullet.getBulletPosition().hide();
            }
        }
    }

    public void addBullet(PlayerBullet block) {
        bulletList.add(block);
    }

    public void removeBullet(PlayerBullet block) {
        bulletList.add(block);
    }

    public void setVelX(int velX) {
        this.velX += velX;
    }

    public void setVelY(int velY) {
        this.velY += velY;
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

        KeyboardEvent leftReleased = new KeyboardEvent();
        leftReleased.setKey(KeyboardEvent.KEY_A);
        leftReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        KeyboardEvent rightReleased = new KeyboardEvent();
        rightReleased.setKey(KeyboardEvent.KEY_D);
        rightReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        keyboard.addEventListener(leftPressed);
        keyboard.addEventListener(rightPressed);
        keyboard.addEventListener(shootPressed);
        keyboard.addEventListener(rightReleased);
        keyboard.addEventListener(leftReleased);
    }

    /**
     * Moves player left and right
     */
    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {


        if (keyboardEvent.getKey() == KeyboardEvent.KEY_A) {
            setVelX(2);
            System.out.println(velX);
            getPlayerPosition().moveInDirection(GridDirection.LEFT, 10 + velX);
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_D) {
            setVelX(2);
            getPlayerPosition().moveInDirection(GridDirection.RIGHT, 10 + velX);
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {

            fire = true;
            addBullet(new PlayerBullet(Game.GAME_GRID.makeGridPosition(playerPosition.getWidth(), playerPosition.getHeight(), 7, 10)));
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_A) {
            velX = 0;
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_D) {
            velX = 0;

        }

    }
}



