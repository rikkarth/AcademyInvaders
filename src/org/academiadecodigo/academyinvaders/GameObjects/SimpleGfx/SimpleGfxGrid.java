package org.academiadecodigo.academyinvaders.GameObjects.SimpleGfx;

import org.academiadecodigo.academyinvaders.GameObjects.Grid.Grid;
import org.academiadecodigo.academyinvaders.GameObjects.Grid.Position.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class SimpleGfxGrid implements Grid {


    //PROPERTIES
    //<<<<<<<<<<<<<<<<<<<<<<<<<<background>>>>>>>>>>>>>>>>>>>>>>>>>>><<<
    private Rectangle screenfiller;
    private Rectangle grid;
    private Picture gridfill;
    private final int PADDING = 10;
    private final int GRID_WIDTH;
    private final int GRID_HEIGHT;

    //<<<<center elements>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    Picture stargame;
    Picture arcadetitle;
    //<<<<<<<<<<<<left side elements<<<<<<<<<<<<<<<<<<<<
    Picture scoreTitle;
    Picture healthPlayer;
    Picture healthStatusBar;
    Picture scoreBar;
    Picture keys;

    //<<<<<<<<<<<right side elements<<<<<
    Picture enemyhealthtitle;
    Picture enemyhealthbar;
    Picture level;


    //CONSTRUCTOR

    /**
     * When instanced, it will create a grid of the size width and height at provided padding
     *
     * @param width  size of the Game Grid
     * @param height size of the Game Grid
     */
    public SimpleGfxGrid(int width, int height, SimpleGfxFaceMapper face) {

        this.GRID_WIDTH = width;
        this.GRID_HEIGHT = height;
        //this.grid = new Rectangle(PADDING, PADDING, GRID_WIDTH, GRID_HEIGHT);

        switch (face) {

            case GAME:

                //<<<<<<<<<<<<<<<<<<<<<<<<<<<background<<<<<<<<<<<<<<<<<<<<<<<<
                this.screenfiller = new Rectangle(0, 0, 1434, 968);
                screenfiller.setColor(Color.BLACK);
                this.grid = new Rectangle(PADDING + 200, PADDING + 100, GRID_WIDTH, GRID_HEIGHT);//GRID YELLOW RECTANGLE ONLY FILL;
                grid.setColor(Color.YELLOW);
                this.gridfill = new Picture(PADDING + 200, PADDING + 100, "org/academiadecodigo/academyinvaders/GameObjects/assets/Backgrounds/blackhole.jpeg");

                //<<<<<<<<<<<<<<<<<<<<<<<<<<<<center elements>>>>>>>>>>>>>>>>>>>><<
                this.arcadetitle = new Picture(474, 0, "org/academiadecodigo/academyinvaders/GameObjects/assets/TitlesAndSubtitles/academytitle.png");
                //<<<<<<<<<<<<<<<<left side elements>>>>>>>>>>>>>>>>>>>>>>>>>>>
                this.scoreTitle = new Picture(17, 200, "org/academiadecodigo/academyinvaders/GameObjects/assets/TitlesAndSubtitles/score_subtitle.png");
                this.healthPlayer = new Picture(15, 400, "org/academiadecodigo/academyinvaders/GameObjects/assets/TitlesAndSubtitles/live_status_title.png");
                this.healthStatusBar = new Picture(10, 480, "org/academiadecodigo/academyinvaders/GameObjects/assets/bar/100percent_bar.png");
                this.scoreBar = new Picture(10, 270, "org/academiadecodigo/academyinvaders/GameObjects/assets/bar/score_box.png");
                //<<<<<<<<<<<<<right side elements<<<<<<<<<<<<<<<<<<<<<<<<<
                this.enemyhealthtitle = new Picture(1250, 400, "org/academiadecodigo/academyinvaders/GameObjects/assets/TitlesAndSubtitles/enemy_heath_subtitle.png");
                this.enemyhealthbar = new Picture(1235, 480, "org/academiadecodigo/academyinvaders/GameObjects/assets/bar/shield_error_bar.png");
                this.level = new Picture(1240, 200, "org/academiadecodigo/academyinvaders/GameObjects/assets/TitlesAndSubtitles/small_level_one.png");
                break;
        }
    }

        /**
         * Initializes/draws grid
         */
        public void init () {
            //background
            screenfiller.fill();
            gridfill.draw();
            //<<center>>
            arcadetitle.draw();
            level.draw();
            grid.draw();
        }

        //GETTERS
        public int getGRID_WIDTH () {
            return this.GRID_WIDTH;
        }

        public int getGRID_HEIGHT () {
            return this.GRID_HEIGHT;
        }

        /**
         * @see Grid#makeGridPosition
         */
        @Override
        public GridPosition makeGridPosition ( int width, int height, int sizeX, int sizeY, SimpleGfxFaceMapper face){

            return new SimpleGfxObjectPosition(width, height, sizeX, sizeY, this, face);
        }

        /**
         * Obtains the grid X position in the SimpleGFX canvas
         *
         * @return the x position of the grid
         */
        public int getGridX () {
            return grid.getX();
        }

        /**
         * Obtains the grid Y position in the SimpleGFX canvas
         *
         * @return the y position of the grid
         */
        public int getGridY () {
            return grid.getY();
        }
    }
