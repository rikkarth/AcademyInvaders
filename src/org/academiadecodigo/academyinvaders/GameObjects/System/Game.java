package org.academiadecodigo.academyinvaders.GameObjects.System;

import org.academiadecodigo.academyinvaders.GameObjects.Bullets.EnemyBullet;
import org.academiadecodigo.academyinvaders.GameObjects.Enemy.*;
import org.academiadecodigo.academyinvaders.GameObjects.Enemy.EnemyForm.*;
import org.academiadecodigo.academyinvaders.GameObjects.Grid.*;
import org.academiadecodigo.academyinvaders.GameObjects.Player.Player;
import org.academiadecodigo.academyinvaders.GameObjects.SimpleGfx.SimpleGfxFaceMapper;

/**
 * The game logic
 */
public class Game implements Runnable {

    //PARAMETERS

    /**
     * Graphical Grid
     */
    public static final Grid GAME_GRID = GridFactory.makeGrid(1024, 768, SimpleGfxFaceMapper.GAME);
    private Player player;
    private Enemy baljeet;

    private Thread thread;
    private Thread threadTwo;

    private EnemyBullet enemyBullet;


    /**
     * Constructs a new game
     */
    public Game() {
        //GAME_GRID = GridFactory.makeGrid(1024, 768);
        init();
    }

    /**
     * Initializes Game Grid
     * Creates Enemies for the level
     */
    public void init() {

        GAME_GRID.init();

        //baljeet = new Baljeet(GAME_GRID.makeGridPosition(500, 50, 50, 50));


        //player = new Player(GAME_GRID.makeGridPosition(500, 700, 50, 50), baljeet);

    }

    /**
     * runs the game
     */

    public void shoot(){

    }

    public void run() {



    }
}

