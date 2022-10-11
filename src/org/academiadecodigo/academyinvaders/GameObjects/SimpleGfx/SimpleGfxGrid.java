package org.academiadecodigo.academyinvaders.GameObjects.SimpleGfx;

import org.academiadecodigo.academyinvaders.GameObjects.Grid.Grid;
import org.academiadecodigo.academyinvaders.GameObjects.Grid.Position.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class SimpleGfxGrid implements Grid {


    //PROPERTIES
    Rectangle grid;
    private final int PADDING = 10;

    private final int GRID_WIDTH;

    private final int GRID_HEIGHT;


    //CONSTRUCTOR

    /**
     * When instanced, it will create a grid of the size width and height at provided padding
     *
     * @param width  size of the Game Grid
     * @param height size of the Game Grid
     */
    public SimpleGfxGrid(int width, int height) {

        this.GRID_WIDTH = width;
        this.GRID_HEIGHT = height;
        this.grid = new Rectangle(PADDING, PADDING, GRID_WIDTH, GRID_HEIGHT);
    }

    /**
     * Initializes/draws grid
     */
    public void init() {

        grid.draw();
    }

    //GETTERS
    public int getGRID_WIDTH() {
        return this.GRID_WIDTH;
    }

    public int getGRID_HEIGHT() {
        return this.GRID_HEIGHT;
    }

    /**
     * @see Grid#makeGridPosition(int width, int height)
     */
    @Override
    public GridPosition makeGridPosition(int width, int height, int sizeX, int sizeY) {

        return new SimpleGfxObjectPosition(width, height, sizeX, sizeY, this);
    }

    /**
     * Obtains the grid X position in the SimpleGFX canvas
     *
     * @return the x position of the grid
     */
    public int getGridX() {
        return grid.getX();
    }

    /**
     * Obtains the grid Y position in the SimpleGFX canvas
     *
     * @return the y position of the grid
     */
    public int getGridY() {
        return grid.getY();
    }

}