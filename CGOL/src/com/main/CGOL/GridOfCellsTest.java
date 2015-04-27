package com.main.CGOL;

/**
 * // -------------------------------------------------------------------------
/**
 * Tests the Grid class
 *
 * @author Parisa Samareh
 * @author Bryan Kaperick
 * @author William Winter
 *  @version April 10, 2015
 */
public class GridOfCellsTest extends student.TestCase
{

    // FIELDS ------------------------------------
    private GridOfCells grid;



    // SETUP -------------------------------------

    /**
     * sets up testing
     */
    public void setUp()
    {
        grid = new GridOfCells(10, 9);
    }


    // METHODS -----------------------------------

    /**
     * tests the constructor
     */
    public void testConstructor()
    {
        assertEquals(10, grid.width());
        assertEquals(9, grid.height());
        assertNotNull(grid.getCell(0, 0));
        assertFalse(grid.isAlive(0, 0));
    }

    /**
     * tests getting neighbors
     */
    public void  testGetNeighbors()
    {
        grid.getCell(1, 1).setAlive();
        grid.getCell(0, 1).setAlive();
        assertEquals(2, grid.getNeighbors(0, 0));
    }

    /**
     * tests getting cells outside of the grid
     */
    public void testGetCellOutside()
    {
        assertNull(grid.getCell(0, -1));
        assertNull(grid.getCell(-1, 0));
        assertNull(grid.getCell(11, 0));
        assertNull(grid.getCell(0, 11));
    }

    /**
     * tests checking if a cell is alive
     */
    public void testIsAlive()
    {
        assertFalse(grid.isAlive(-1, -1));
        grid.getCell(0, 0).setAlive();
        assertTrue(grid.isAlive(0, 0));
    }

    /**
     * tests getting the dimensions of the board
     */
    public void testDimensions()
    {
        assertEquals(grid.width(), 10);
        assertEquals(grid.height(), 9);
    }



}
