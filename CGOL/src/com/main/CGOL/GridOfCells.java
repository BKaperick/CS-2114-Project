package com.main.CGOL;


/**
 * // -------------------------------------------------------------------------
 * /** Our class for the main game screen.
 * We still intend to implement multiple activity functionality to support
 * a title screen, settings screen and gameplay screen.
 *
 * @author Parisa Samareh
 * @author Bryan Kaperick
 * @author William Winter
 * @version April 10, 2015
 */
public class GridOfCells

{
    private CellLocation[][] grid;
    private int gridWidth;
    private int gridHeight;


    /**
     * The initialize method sets up the grid.
     * @param x     horizontal dimension of play area
     * @param y     vertical dimension of play area
     */
    public GridOfCells(int x, int y)
    {
        gridWidth = x;
        gridHeight = y;
        grid = new CellLocation[gridWidth][gridWidth];
        for (int i = 0; i < gridWidth; i++)
        {
            for (int j = 0; j < gridWidth; j++)
            {
                grid[i][j] = new CellLocation(i, j);
            }
        }
    }

    /**
     * Returns the height of the total grid.
     * @return height field value.
     */
    public int height()
    {
        return gridHeight;
    }

    /**
     * Returns the width of the total grid.
     * @return width field value.
     */
    public int width()
    {
        return gridWidth;
    }


    /**
     * Gets the status of the cell's neighbors
     *
     * @param x coordinate of the cell
     * @param y coordinate of the cell
     * @return the number of neighbors
     */
    public int getNeighbors(int x, int y)
    {
        int neighs = 0;
        for (int i = x - 1; i < x + 2; i++)
        {
            for (int j = y - 1; j < y + 2; j++)
            {
                if (this.getCell(i, j) != null)
                {
                    if (this.getCell(i, j).getAlive())
                    {
                        neighs++;
                    }
                }
            }
        }
        return neighs;
        // Method to get the current amount of live cells out of the
        // 8 neighboring cells.
    }


    /**
     * Returns the specified cell
     *
     * @return cell the cell we want
     * @param x
     *            the coordinate for the cell we want
     * @param y
     *            the coordinate for the cell we want
     */
    public CellLocation getCell(int x, int y)
    {
        if ((x > -1) && (y > -1) && (x < width()) && (y < height()))
        {
            return grid[x][y];
        }
        else
        {
            return null;
        }
    }


    /**
     * Runs the program
     *
     * @param x
     *            coordinate of the cell
     * @param y
     *            coordinate of the cell
     * @return boolean
     */
    public boolean isAlive(int x, int y)
    {
        if (this.getCell(x, y) == null)
        {
            return false;
        }
        else
        {

            return this.getCell(x, y).getAlive();
        }
    }

    /**
     * Updates the grid cells depending on their state of living
     */
    public void update()
    {
        for (int i  = 0 ; i < grid.length; i++)
        {
            for (int j = 0; j < grid[0].length; j++)
            {
                if (this.getCell(i, j).getAlive())
                {
                    if(this.getNeighbors(i, j) < 2 || this.getNeighbors(i, j) > 3)
                    {
                        this.getCell(i, j).setDead();
                    }
                }
                else
                {
                    if(this.getNeighbors(i, j) == 3)
                    {
                        this.getCell(i, j).setAlive();
                    }
                }
            }
        }
    }


}