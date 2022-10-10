package org.academiadecodigo.academyinvaders.GameObjects;

import org.academiadecodigo.academyinvaders.GameObjects.Grid.Grid;
import org.academiadecodigo.academyinvaders.GameObjects.Grid.GridFactory;
import org.academiadecodigo.academyinvaders.GameObjects.System.Game;


public class Main {

    public static void main(String[] args) {

            Game newGame = new Game(5);

            newGame.init();
    }
}