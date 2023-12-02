package org.academiadecodigo.academyinvaders.grid;

import org.academiadecodigo.academyinvaders.grid.position.GridPosition;
import org.academiadecodigo.academyinvaders.simplegfx.SimpleGfxFaceMapper;

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
    public GridPosition makeGridPosition(int widthPos, int heightPos, int sizeX, int sizeY, SimpleGfxFaceMapper face);
}
