package org.academiadecodigo.academyinvaders.grid;

import org.academiadecodigo.academyinvaders.simplegfx.SimpleGfxFaceMapper;
import org.academiadecodigo.academyinvaders.simplegfx.SimpleGfxGrid;

public class GridFactory {

    public static Grid makeGrid(int width, int height, SimpleGfxFaceMapper face) {

       return new SimpleGfxGrid(width, height, face);
    }
}