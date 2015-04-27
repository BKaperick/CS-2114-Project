package com.main.CGOL;
/**
 * // -------------------------------------------------------------------------
/**
 * Tests the Cell location class
 *
 * @author Parisa Samareh
 * @author Bryan Kaperick
 * @author William Winter
 *  @version April 10, 2015
 */
public class CellLocationTest extends student.TestCase
{

    // FIELDS ---------------------------------------

    private CellLocation celly;


    // SET UP ---------------------------------------

    /**
     * Sets up testing
     */
    public void setUp()
    {
        celly = new CellLocation(2, 3);

    }


    // METHODS ----------------------------------------
    /**
     * tests making a cell live
     */
    public void testLiveCell()
    {
        //tests initializing a cell as dead
        assertFalse(celly.getAlive());

        //tests making a cell live
        celly.setAlive(true);
        assertTrue(celly.getAlive());

        //tests making the Cell dead again
        celly.setAlive(false);
        assertFalse(celly.getAlive());
    }

    /**
     * tests getting the coordinates
     */
    public void testGetCoordinate()
    {
        assertEquals(2, celly.getXCoord());
        assertEquals(3, celly.getYCoord());
    }
}
