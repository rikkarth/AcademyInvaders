package org.academiadecodigo.academyinvaders.GameObjects;

import org.academiadecodigo.academyinvaders.GameObjects.Grid.Grid;
import org.academiadecodigo.academyinvaders.GameObjects.Grid.GridFactory;



public class Main {

    public static void main(String[] args) {


        Grid myGrid = GridFactory.makeGrid(1024,768);
        myGrid.init();

    }
}