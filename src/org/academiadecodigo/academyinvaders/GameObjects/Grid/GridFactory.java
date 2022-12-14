package org.academiadecodigo.academyinvaders.GameObjects.Grid;

import org.academiadecodigo.academyinvaders.GameObjects.SimpleGfx.SimpleGfxFaceMapper;
import org.academiadecodigo.academyinvaders.GameObjects.SimpleGfx.SimpleGfxGrid;

public class GridFactory {

    public static Grid makeGrid(int width, int height, SimpleGfxFaceMapper face) {

       return new SimpleGfxGrid(width, height, face);
    }
}