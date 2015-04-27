package com.main.CGOL;

/**
 * // -------------------------------------------------------------------------
 * /** Our class for the main game screen. We still intend to implement multiple
 * activity functionality to support a title screen, settings screen and
 * gameplay screen.
 *
 * @author Parisa Samareh
 * @author Bryan Kaperick
 * @author William Winter
 * @version April 10, 2015
 */
public class GridOfCells

{
    private CellLocation[][] grid;
    private int              gridWidth;
    private int              gridHeight;
    /**
     * The grid that holds the information for the next generation
     */
    GridOfCells              nextGen;


    /**
     * The initialize method sets up the grid.
     *
     * @param x
     *            horizontal dimension of play area
     * @param y
     *            vertical dimension of play area
     */
    public GridOfCells(int x, int y)
    {
        gridWidth = x;
        gridHeight = y;
        nextGen = null;
        grid = new CellLocation[gridWidth][gridHeight];
        for (int i = 0; i < gridWidth; i++)
        {
            for (int j = 0; j < gridHeight; j++)
            {
                grid[i][j] = new CellLocation(i, j);
            }
        }
    }


    /**
     * Returns this grid
     *
     * @return grid
     */
    public CellLocation[][] getGrid()
    {
        return grid;
    }


    /**
     * Defines this grid
     *
     * @param newGrid
     *            the grid we are equating it to
     */
    public void setGrid(CellLocation[][] newGrid)
    {
        grid = newGrid;
    }


    /**
     * Returns the height of the total grid.
     *
     * @return height field value.
     */
    public int height()
    {
        return gridHeight;
    }


    /**
     * Returns the width of the total grid.
     *
     * @return width field value.
     */
    public int width()
    {
        return gridWidth;
    }


    /**
     * Gets the status of the cell's neighbors
     *
     * @param x
     *            coordinate of the cell
     * @param y
     *            coordinate of the cell
     * @return the number of neighbors
     */
    public int getNeighbors(int x, int y)
    {
        int neighs = 0;
        for (int i = x - 1; i < x + 2; i++)
        {
            for (int j = y - 1; j < y + 2; j++)
            {
                int p = i - x;
                int q = j - y;
                System.out.println(p + " " + " " + q);
                if (!(x == i && y == j))
                {
                    System.out.println("\tMade it to the other side");
                    if (this.isAlive(i, j))
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
        if ((x >= 0) && (y >= 0) && (x < width()) && (y < height()))
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
     *
     * @param i
     *            the x coord
     * @param j
     *            the y coord
     * @return the boolean of whether or not the cell is alive
     */
    public boolean update(int i, int j)
    {
        if (this.getCell(i, j).getAlive())
        {
            if (this.getNeighbors(i, j) < 2 || this.getNeighbors(i, j) > 3)
            {
                System.out.println("coords: " + i + " " + j
                    + " alive 2-3 neighbors " + getNeighbors(i, j));
                return false;
            }
            else
            {
                System.out.println("coords: " + i + " " + j
                    + " alive 0-1or4- neighbors " + getNeighbors(i, j));
                return true;
            }
        }
        else
        {
            if (this.getNeighbors(i, j) == 3)
            {
                System.out.println("coords: " + i + " " + j
                    + " dead 3 neighbors " + getNeighbors(i, j));
                return true;
            }
            else
            {
                System.out.println("coords: " + i + " " + j
                    + " dead not 3 neighbors " + getNeighbors(i, j));
                return false;
            }
        }

    }


    public String gridToSaveFormat()
    {
        String output = "";
        for (int i = 0; i < gridWidth; i++)
        {
            for (int j = 0; j < gridHeight; j++)
            {
                if (isAlive(i, j))
                {
                    output += "1";
                }
                else
                {
                    output += "0";
                }
            }
            output += "n";
        }
        return output;
    }

    /**
     * Saving and loading features are not finished.  IE, this method is not finished.
     */
    public void setGridFromSaveFormat(String save)
    {
        int newWidth = save.substring(0, save.indexOf('n')).length();
        int newHeight = save.length() - save.replace("n", "").length();

        CellLocation[][] newGrid = new CellLocation[newWidth][newHeight];
        for (int i = 0; i < save.length(); i++)
        {
            newGrid[i][j] =

        }
    }

}
