package org.academiadecodigo.academyinvaders.GameObjects.System;

import org.academiadecodigo.academyinvaders.GameObjects.Enemy.*;
import org.academiadecodigo.academyinvaders.GameObjects.Enemy.EnemyForm.*;
import org.academiadecodigo.academyinvaders.GameObjects.Grid.*;
import org.academiadecodigo.academyinvaders.GameObjects.Player.Player;

public class Game {

    //PARAMETERS
    private final Grid GAME_GRID;
    private Player player;

    private Enemy enemy;

    private final int DELAY;

    /**
     * Constructs a new game
     * @param delay animation delay
     */
    public Game(int delay) {
        GAME_GRID = GridFactory.makeGrid(1024, 768);
        this.DELAY = delay;
    }

    public void init() {

        GAME_GRID.init();

        enemy = new Baljeet(GAME_GRID.makeGridPosition(500,50));
        enemy.setGrid(GAME_GRID);

        player = new Player(player.getPlayerPosition());
    }

    public void start() {

    }


}
