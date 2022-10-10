package org.academiadecodigo.academyinvaders.GameObjects.Grid;

import org.academiadecodigo.academyinvaders.GameObjects.Grid.Position.GridPosition;

public interface Grid {

    /**
     * Initializes the grid
     */
    public void init();

    /**
     * width
     */
    public int getGRID_WIDTH();

    /**
     * height
     */
    public int getGRID_HEIGHT();

    /**
     * creates position in grid at width and height
     */
    public GridPosition makeGridPosition(int widthPos, int heightPos, int sizeX, int sizeY);


}
