package org.academiadecodigo.academyinvaders.GameObjects;

import org.academiadecodigo.academyinvaders.GameObjects.Grid.Grid;
import org.academiadecodigo.academyinvaders.GameObjects.Grid.GridFactory;
import org.academiadecodigo.academyinvaders.GameObjects.System.Game;


public class Main {

    public static void main(String[] args) throws InterruptedException {

            Game newGame = new Game(100);

            newGame.init();
            newGame.start();
    }
}