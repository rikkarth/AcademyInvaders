package org.academiadecodigo.academyinvaders.GameObjects.System;

import org.academiadecodigo.academyinvaders.GameObjects.SimpleGfx.SimpleGfxGrid;

public class Game {

    private Grid grid;
    private Player player;

    private Enemy enemy;

    private int delay;


    Game(int x, int y, int delay) {
        return new SimpleGfxGrid(x, y);
        this.delay = delay;
    }

    public void init() {
        grid.init();
        enemy = new Enemy();

        player = new Player(player.getPlayerPosition());
    }

    public void start() {
        while (true) {
            Thread.sleep(delay);
        }
    }


}
