package org.academiadecodigo.academyinvaders.GameObjects.SimpleGfx;

import org.academiadecodigo.academyinvaders.GameObjects.Grid.Grid;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class SimpleGfxGrid implements Grid {


    //PROPERTIES
    Rectangle grid;
    private final int PADDING = 10;

    private final int width;

    private final int height;


    //CONSTRUCTOR
    public SimpleGfxGrid(int width, int height) {

        this.width = width;
        this.height = height;
        this.grid = new Rectangle(PADDING, PADDING, width, height);
    }

    /**
     * initializes grid
     */

    public void init(){

        grid.draw();
    }

    //GETTERS
    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    /**
     * Obtains the grid X position in the SimpleGFX canvas
     *
     * @return the x position of the grid
     */
    public int gridGetX(){
        return grid.getX();
    }

    /**
     * Obtains the grid Y position in the SimpleGFX canvas
     *
     * @return the y position of the grid
     */
    public int gridGetY(){
        return grid.getY()
    }

    //METHODS


}
