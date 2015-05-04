package com.main.CGOL;
import sofia.app.ShapeScreen;
import sofia.graphics.Color;

// -------------------------------------------------------------------------
/**
 *  The Super class that holds all screens
 *
 *  @author Parisa
 *  @version Apr 27, 2015
 */
public class ParentView
    extends ShapeScreen
{
    private static Color       aliveColor;
    private static Color       deadColor;
    private static int         width;
    private static int         height;
    private static int         speed;
    private static boolean     callAlive;

    /**
     * Sets calling alive
     * @param thestatus status of calling alive
     */
    public void setCallAlive(Boolean thestatus)
    {
        callAlive = thestatus;
    }
    /**
     * Gets calling alive
     * @return thestatus
     */
    public Boolean getCallAlive()
    {
        return callAlive;
    }
    /**
     * Returns the alive color
     *
     * @return Color
     */
    public Color getAliveColor()
    {
        return aliveColor;
    }

    /**
     * Returns the dead color
     * @return Color
     */
    public Color getDeadColor()
    {
        return deadColor;
    }

    /**
     * Returns the grid width
     * @return int
     */
    public int getGridWidth()
    {
        return width;
    }

    /**
     * Returns the grid height
     * @return int
     */
    public int getGridHeight()
    {
        return height;
    }

    /**
     * Returns the speed
     *
     * @return speed
     */
    public int getSpeed()
    {
        return speed;
    }

    /**
     * Sets the alive color
     *
     * @param color the alive color
     */
    public void setAliveColor(Color color)
    {
        aliveColor = color;
    }

    /**
     * Sets the dead color
     *
     * @param color
     */
    public void setDeadColor(Color color)
    {
        deadColor = color;
    }

    /**
     * Sets the grid width
     * @param newWidth the new width
     */
    public void setGridWidth(int newWidth)
    {
        width = newWidth;
    }

    /**
     * Sets the grid height
     * @param newHeight
     */
    public void setGridHeight(int newHeight)
    {
        height = newHeight;
    }

    /**
     * Sets the speed
     * @param newSpeed
     */
    public void setSpeed(int newSpeed)
    {
        speed = newSpeed;
    }
}
