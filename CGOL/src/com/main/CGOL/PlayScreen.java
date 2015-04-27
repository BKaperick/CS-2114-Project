package com.main.CGOL;
import sofia.app.ShapeScreen;
import sofia.graphics.Color;
import sofia.graphics.RectangleShape;

/**
 * // -------------------------------------------------------------------------
/**
 *  The GUI screen where the game is played
 *
 *  @author Parisa
 *  @version Apr 18, 2015
 */
public class PlayScreen
    extends ShapeScreen
{
    private float        gridWidth;
    private float        gridHeight;
    private GridOfCells  theGrid;
    private float        cellSize;
    private Color        live;
    private Color        dead;
    private int          width;
    private int          height;


    public void initialize()
    {
        live = Color.white;
        dead = Color.darkGray;
        width = 20;
        height = 25;
        gridWidth = this.getWidth();
        gridHeight = this.getHeight();
        theGrid = new GridOfCells(width, height);
        cellSize = (Math.min(gridWidth, gridHeight) / width);
        for (int i = 0; i < width; i++)
        {
            for (int j = 0; j < height; j++)
            {
                RectangleShape cell =
                    new RectangleShape(
                        i * cellSize,
                        j * cellSize,
                        (i + 1) * cellSize,
                        (j + 1) * cellSize);
                cell.setColor(Color.black);
                cell.setFillColor(dead);
                this.add(cell);
            }
        }
        Act process = new Act(theGrid, this);

    }

    public GridOfCells getGrid()
    {
        return theGrid;
    }

//    /**
//     * The method that runs when the class is called
//     *
//     * @param nothing the necessary param that we will do nothing with
//     */
//    public static void main(String[] nothing)
//    {
//        Act process = new Act(theGrid, this);
//    }

    /**
     * Sets the live cell color
     *
     * @param userColor The color the user wants the live cells to be
     */
    public void setLiveColor(Color userColor)
    {
        live = userColor;
    }

    /**
     * Sets the dead cell color
     *
     * @param userColor The color the user wants the dead cells to be
     */
    public void setDeadColor(Color userColor)
    {
        dead = userColor;
    }

    /**
     * Method for when the user wants to go to the settings page
     */
    public void settingsPlayClicked()
    {
        this.presentScreen(SettingsScreen.class);
    }

    /**
     * Sets the width of the grid
     *
     * @param x    the desired width of the board
     */
    public void setWidth(int x)
    {
        width = x;
    }

    /**
     * Sets the height of the grid
     *
     * @param x      the desired height of the grid
     */
    public void setHeight(int x)
    {
        height = x;
    }

    /**
     * Plays the simulation
     */
    public void playPauseClicked()
    {

    }

    /**
     * Time step method to run simulation
     */


    /**
     * Processes the user's touch
     *
     * @param x the x coord
     * @param y the y coord
     */
    public void processTouch(float x, float y)
    {
        int actualX = (int)(x / cellSize);
        int actualY = (int)(y / cellSize);
        RectangleShape tile =
            this.getShapes().locatedAt(x, y).
            withClass(RectangleShape.class).front();
        if (theGrid.getCell(actualX, actualY).getAlive())
        {
            tile.setFillColor(dead);
            theGrid.getCell(actualX, actualY).setDead();
        }
        else
        {
            tile.setFillColor(live);
            theGrid.getCell(actualX, actualY).setAlive();
        }
    }


    /**
     * Toggles the cell state when a cell is touched.
     *
     * @param x the x-coordinate for the picture
     * @param y the y-coordinate for the picture
     */
    public void onTouchDown(float x, float y)
    {
        this.processTouch(x, y);
    }


    /**
     * Toggles the cell state with the swipe of a finger.
     *
     * @param x the x-coordinate for the picture
     * @param y the y-coordinate for the picture
     */
    public void onTouchMove(float x, float y)
    {
        this.processTouch(x, y);
    }

}
