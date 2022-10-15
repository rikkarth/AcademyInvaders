package org.academiadecodigo.academyinvaders.GameObjects.Player;

import org.academiadecodigo.academyinvaders.GameObjects.Bullets.PlayerBullet;
import org.academiadecodigo.academyinvaders.GameObjects.Enemy.Enemy;
import org.academiadecodigo.academyinvaders.GameObjects.Grid.Grid;
import org.academiadecodigo.academyinvaders.GameObjects.Grid.GridDirection;
import org.academiadecodigo.academyinvaders.GameObjects.Grid.Position.GridPosition;
import org.academiadecodigo.academyinvaders.GameObjects.SimpleGfx.SimpleGfxFaceMapper;
import org.academiadecodigo.academyinvaders.GameObjects.System.DestructionDetector;
import org.academiadecodigo.academyinvaders.GameObjects.System.Game;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.util.LinkedList;

public class Player implements KeyboardHandler {

    //Properties
    private LinkedList<PlayerBullet> bulletList = new LinkedList<>();
    protected DestructionDetector destructionDetector;
    private GridPosition playerPosition;

    private PlayerBullet playerBullet;
    private PlayerBullet tempBullet;
    private Grid grid;
    private Enemy enemy;
    private int velX = 0;
    private int velY = 0;
    private boolean destroyed;
    private int health;
    private int livesLeft;
    boolean fire = false;


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
    }

    //GETTERS

    public GridPosition getPlayerPosition() {
        return playerPosition;
    }
    public PlayerBullet getPlayerBullet() {
        return playerBullet;
    }
    public boolean isDestroyed() {
        return destroyed;
    }

    //SETTERS
    public void setDestructionDetector(DestructionDetector destructionDetector) {
        this.destructionDetector = destructionDetector;
    }

    public void setDestroyed() {

        this.destroyed = true;
    }

    public void setVelX(int velX) {
        this.velX += velX;
    }

    public void setVelY(int velY) {
        this.velY += velY;
    }

    //METHODS

    /**
     * Where all bullet behaviours come together
     */

    public void shoot(){

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

    /**
     * Adds bullet to LinkedList
     * @param block requires a bullet instance
     */
    private void addBullet(PlayerBullet block) {
        bulletList.add(block);
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
            getPlayerPosition().moveInDirection(GridDirection.LEFT, 10 + velX);
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_D) {
            setVelX(2);
            getPlayerPosition().moveInDirection(GridDirection.RIGHT, 10 + velX);
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {

            fire = true;
            addBullet(new PlayerBullet(Game.GAME_GRID.makeGridPosition(playerPosition.getWidth()+25, playerPosition.getHeight()-150, 7, 10, SimpleGfxFaceMapper.BULLET)));

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

    //@Override
    public void run() {
        shoot();
    }
}



