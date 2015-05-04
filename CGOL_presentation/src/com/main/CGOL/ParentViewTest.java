package com.main.CGOL;

import sofia.graphics.Color;

// -------------------------------------------------------------------------
/**
 *  Tests Parent view
 *
 *  @author Parisa
 *  @version Apr 27, 2015
 */
public class ParentViewTest extends student.AndroidTestCase<ParentView>
{

    /**
     * Tests parent view
     */
    public ParentViewTest()
    {
        super(ParentView.class);
    }

    public void setUp()
    {
        //nothing to set up
    }

    /**
     * tests setting the alive Color
     */
    public void testSetAliveColor()
    {
        getScreen().setAliveColor(Color.cyan);
        assertEquals(Color.cyan, getScreen().getAliveColor());
    }

    /**
     * tests setting the color of Dead cells
     */
    public void testSetColorDead()
    {
        getScreen().setDeadColor(Color.red);
        assertEquals(Color.red, getScreen().getDeadColor());
    }

    /**
     * tests setting the height of the grid
     */
    public void testSetGridHeight()
    {
        getScreen().setGridHeight(10);
        assertEquals(10, getScreen().getGridHeight());
    }

    /**
     * tests setting the grid Width
     */
    public void testSetGridWidth()
    {
        getScreen().setGridWidth(7);
        assertEquals(7, getScreen().getGridWidth());
    }

    /**
     * tests setting the speed
     */
    public void testSetSpeed()
    {
        getScreen().setSpeed(5);
        assertEquals(5, getScreen().getSpeed());
    }

    /**
     * Tests setting the CallAlive Boolean
     */
    public void testCallAlive()
    {
        getScreen().setCallAlive(false);
        assertFalse(getScreen().getCallAlive());
    }

}
