package org.academiadecodigo.academyinvaders.GameObjects.System;

import org.academiadecodigo.academyinvaders.GameObjects.Enemy.*;
import org.academiadecodigo.academyinvaders.GameObjects.Enemy.EnemyForm.*;
import org.academiadecodigo.academyinvaders.GameObjects.Grid.*;
import org.academiadecodigo.academyinvaders.GameObjects.Player.Player;

/**
 * The game logic
 */
public class Game {

    //PARAMETERS

    /**
     * Graphical Grid
     */
    private final Grid GAME_GRID;
    private Player player;

    /**
     * Container of Enemies
     */
    private Enemy enemy;

    /**
     * Animation delay
     */
    private final int DELAY;

    /**
     * Constructs a new game
     *
     * @param delay animation delay
     */
    public Game(int delay) {
        GAME_GRID = GridFactory.makeGrid(1024, 768);
        this.DELAY = delay;
    }

    /**
     * Initializes Game Grid
     * Creates Enemies for the level
     */
    public void init() {

        GAME_GRID.init();

        enemy = new Baljeet(GAME_GRID.makeGridPosition(500, 50));

        enemy.setGrid(GAME_GRID);

        player = new Player(GAME_GRID.makeGridPosition(500, 500));
    }

    /**
     * Starts the game
     *
     * @throws InterruptedException
     */
    public void start() throws InterruptedException {

        while (true) {

            // Pause for a while
            Thread.sleep(DELAY);

            /**
             * Insert Game Loop here
             */
        }
    }
}

