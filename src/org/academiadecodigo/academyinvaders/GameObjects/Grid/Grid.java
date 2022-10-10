package org.academiadecodigo.academyinvaders.GameObjects.Grid;

import org.academiadecodigo.academyinvaders.GameObjects.Grid.Position.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public interface Grid {

    /**
     * Initializes the grid
     */
    public void init();

    /**
     * width
     */
    public int getWidth();

    /**
     * height
     */
    public int getHeight();

    /**
     * Create a random grid position
     * the new grid position
     */
    public GridPosition makeGridPosition();

    /**
     * the new grid position
     */
    public GridPosition makeGridPosition(int width, int height);


}