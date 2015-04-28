package com.main.CGOL;

import sofia.graphics.Color;
import sofia.graphics.RectangleShape;
import sofia.util.Timer;

/**
 * // -------------------------------------------------------------------------
 * /** The GUI screen where the game is played
 *
 * @author Parisa
 * @version Apr 18, 2015
 */
public class PlayScreen
    extends ParentView
{


    private GridOfCells theGrid;
    private float       cellSize;


    private boolean     playIsClicked;
    private Timer       runner;

    public void initialize()
    {

        theGrid = new GridOfCells(super.getGridWidth(), super.getGridHeight());
        playIsClicked = false;

        cellSize = (Math.min(this.getWidth(), this.getHeight()) / Math.min(super.getGridWidth(), super.getGridHeight()));
        for (int i = 0; i < super.getGridWidth(); i++)
        {
            for (int j = 0; j < super.getGridHeight(); j++)
            {
                RectangleShape cell =
                    new RectangleShape(i * cellSize, j * cellSize, (i + 1)
                        * cellSize, (j + 1) * cellSize);
                cell.setColor(Color.black);
                cell.setFillColor(super.getDeadColor());
                this.add(cell);
            }
        }
    }


    // ----------------------------------------------------------
    /**
     * Updates the gui depending on the grid object
     *
     * @param i the x coord
     * @param j the y coord
     * @param willLive the status of that cell
     */
    public void updateGUI(int i, int j, boolean willLive)
    {
        RectangleShape current =
            getShapes()
                .locatedAt(
                    (cellSize * i) + (cellSize / 2),
                    (cellSize * j) + (cellSize / 2))
                .withClass(RectangleShape.class).front();
        if (willLive)
        {
            current.setFillColor(super.getAliveColor());
        }
        else
        {
            current.setFillColor(super.getDeadColor());
        }
    }


    /**
     * Method for when the user wants to go to the settings page
     */
    public void settingsPlayClicked()
    {
        this.presentScreen(SettingsScreen.class);
        this.finish();
    }


    /**
     * Plays the simulation
     */
    public void playClicked()
    {
        if (!playIsClicked)
        {
            playIsClicked = true;
            runner = sofia.util.Timer.callRepeatedly(this, "step", 50);
        }
    }

    /**
     * Pauses the simulation
     */
    public void pauseClicked()
    {
        if (playIsClicked)
        {
            playIsClicked = false;
            runner.stop();
        }
    }

    /**
     * Moves one iteration forward
     *
     */
    public void step()
    {
        GridOfCells nextGen = new GridOfCells(super.getGridWidth(), super.getGridHeight());
        for (int i = 0; i < super.getGridWidth(); i++)
        {
            for (int j = 0; j < super.getGridHeight(); j++)
            {
                boolean willLive = theGrid.update(i, j);
                nextGen.getCell(i, j).setAlive(willLive);
                updateGUI(i, j, willLive);
            }
        }
        theGrid.setGrid(nextGen.getGrid());
    }
    /**
     * Moves the game by one step
     */
    public void stepClicked()
    {
        this.step();
    }


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
            this.getShapes().locatedAt(x, y).withClass(RectangleShape.class)
                .front();
        if (theGrid.isAlive(actualX, actualY))
        {
            tile.setFillColor(super.getDeadColor());
            theGrid.getCell(actualX, actualY).setAlive(false);
        }
        else
        {
            tile.setFillColor(super.getAliveColor());
            theGrid.getCell(actualX, actualY).setAlive(true);
        }
    }


    /**
     * Returns the grid
     *
     * @return thegrid
     */
    public GridOfCells getGrid()
    {
        return theGrid;
    }


    /**
     * Toggles the cell state when a cell is touched.
     *
     * @param x
     *            the x-coordinate for the picture
     * @param y
     *            the y-coordinate for the picture
     */
    public void onTouchDown(float x, float y)
    {
        this.processTouch(x, y);
    }


    /**
     * Toggles the cell state with the swipe of a finger.
     *
     * @param x
     *            the x-coordinate for the picture
     * @param y
     *            the y-coordinate for the picture
     */
    public void onTouchMove(float x, float y)
    {
        this.processTouch(x, y);
    }

}
