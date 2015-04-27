package com.main.CGOL;

/**
 * // -------------------------------------------------------------------------
/**
 *  Supports the characteristics and functionality of each individual cell
 *  location.
 *
 * @author Parisa Samareh
 * @author Bryan Kaperick
 * @author William Winter
 *  @version April 10, 2015
 */
public class CellLocation
{
    private int xCoord;
    private int yCoord;
    private boolean alive;

    /**
     * The constructor for the covertile
     *
     * @param x    x-coordinate of the cell
     * @param y    y-coordinate of the cell
     */
    public CellLocation(int x, int y)
    {
        xCoord = x;
        yCoord = y;
        alive = false;
    }

    /**
     * Makes this cell alive
     * @param isAlive
     */
    public void setAlive(boolean isAlive)
    {
        this.alive = isAlive;
    }

    /**
     * Returns whether or not this cell is alive
     *
     * @return boolean if the cell is alive
     */
    public boolean getAlive()
    {
        return this.alive;
    }

    /**
     * Returns the cell's x coordinate
     *
     * @return xLocation
     */
    public int getXCoord()
    {
        return xCoord;
    }

    /**
     * Returns the cell's x coordinate
     *
     * @return xLocation
     */
    public int getYCoord()
    {
        return yCoord;
    }

}
