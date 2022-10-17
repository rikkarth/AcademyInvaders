package org.academiadecodigo.academyinvaders.GameObjects.SimpleGfx;

import org.academiadecodigo.academyinvaders.GameObjects.Grid.GridDirection;
import org.academiadecodigo.academyinvaders.GameObjects.Grid.Position.AbstractGridPosition;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class SimpleGfxObjectPosition extends AbstractGridPosition {

    private Rectangle object;
    private Picture objectPicture;
    private SimpleGfxGrid grid;

    /**
     * Simple graphics object position constructor
     * It will construct an object at given position
     *
     * @param grid Simple graphics grid
     */
    public SimpleGfxObjectPosition(int width, int height, int sizeX, int sizeY, SimpleGfxGrid grid, SimpleGfxFaceMapper face) {

        super(width, height, grid);

        this.grid = grid;

        //object = new Rectangle(width + grid.getGridX(), height + grid.getGridY(), sizeX, sizeY);
        switch (face) {
            case PLAYER:
                objectPicture = new Picture(width, height, "org/academiadecodigo/academyinvaders/GameObjects/Assets/ShipsPlayerEnemy/player_ship.png");
                break;
            case BULLET:
                //object = new Rectangle(width + grid.getGridX(), height + grid.getGridY(), sizeX, sizeY);
                objectPicture = new Picture(width, height, "org/academiadecodigo/academyinvaders/GameObjects/Assets/Bullets/binary_bullet.png");
                break;
            case BULLETGREEN:
                objectPicture =  new Picture(width, height, "org/academiadecodigo/academyinvaders/GameObjects/Assets/Bullets/greenbullet_energy_small.png");
                break;
            case BALJEET:
                objectPicture = new Picture(width, height, "org/academiadecodigo/academyinvaders/GameObjects/Assets/ShipsPlayerEnemy/monster_octupus.png");
                break;
        }

        show();
    }


    public void moveInDirection(GridDirection direction, int distance) {

        int initialX = getWidth();

        int initialY = getHeight();

        super.moveInDirection(direction, distance);

        int movementX = getWidth() - initialX;

        int movementY = getHeight() - initialY;

        //object.translate(movementX, movementY);
        objectPicture.translate(movementX, movementY);

    }

    public Picture getObject() {
        return objectPicture;
    }

    public void setObject(Picture object) {
        this.objectPicture = object;
    }

    @Override
    public int getObjectWidth() {
        //return object.getWidth();
        return objectPicture.getWidth();
    }

    @Override
    public int getObjectHeight() {
        //return object.getHeight();
        return objectPicture.getHeight();
    }

    @Override
    public int setHeight() {
        return 0;
    }

    @Override
    public void show() {
        //object.fill();
        objectPicture.draw();
    }

    @Override
    public void hide() {
        //object.delete();
        objectPicture.delete();
    }
}
