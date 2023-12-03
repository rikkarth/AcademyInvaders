package org.codeforall.academyinvaders.grid;

import org.codeforall.academyinvaders.simplegfx.SimpleGfxFaceMapper;
import org.codeforall.academyinvaders.simplegfx.SimpleGfxGrid;

public class GridFactory {

    public static Grid makeGrid(int width, int height, SimpleGfxFaceMapper face) {

       return new SimpleGfxGrid(width, height, face);
    }
}