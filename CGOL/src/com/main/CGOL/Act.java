package com.main.CGOL;
/**
 * // -------------------------------------------------------------------------
/**
 *  Creates our the process by which we run through the program by step
 *
 *  @author Parisa
 *  @version Apr 26, 2015
 */
public class Act extends Thread
{
    /**
     * The accessible grid we use in run
     */
    GridOfCells ourGrid;
    /**
     * The accessible screen we use in run
     */
    PlayScreen ourScreen;

    /**
     * The constructor with act, which takes gridofcells and a screen
     * as parameters so that we may access the grid within our run method
     * @param grid the grid passed through
     * @param screen the screen we must modify
     */
    public Act(GridOfCells grid, PlayScreen screen)
    {
        ourGrid = grid;
        ourScreen = screen;
    }
    /**
     * The function that runs by step
     */
    public void run()
    {
        for (int i = 0; i < ourGrid.width(); i++)
        {
            for (int j = 0; j < ourGrid.height(); j++)
            {
                if (ourGrid.getCell(i, j).getAlive())
                {
                    if(ourGrid.getNeighbors(i, j) < 2 || ourGrid.getNeighbors(i, j) > 3)
                    {
                        ourGrid.getCell(i, j).setDead();
                    }
                }
                else
                {
                    if(ourGrid.getNeighbors(i, j) == 3)
                    {
                        ourGrid.getCell(i, j).setAlive();
                    }
                }
            }
        }
    }

}
