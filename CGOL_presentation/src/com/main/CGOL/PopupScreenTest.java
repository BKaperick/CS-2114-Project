package com.main.CGOL;

import android.widget.Button;
import sofia.graphics.Color;
/**
 * // -------------------------------------------------------------------------
/**
 *  Tests our pop up screen
 *
 *  @author Parisa
 *  @version Apr 30, 2015
 */
public class PopupScreenTest extends student.AndroidTestCase<PopupScreen>
{
    /**
     * Calls the super constructor for pop up test
     */
    public PopupScreenTest()
    {
        super(PopupScreen.class);
    }

    private Button grey;
    private Button black;
    private Button red;
    private Button white;
    private Button yellow;
    private Button blue;
    private Button purple;
    public void setUp()
    {
        // nothing to set up
    }

    /**
     * tests changing live cell color to red
     */
    public void testRedClickedAlive()
    {
        getScreen().setCallAlive(true);
        click(red);
        assertEquals(Color.red, getScreen().getAliveColor());
    }

    /**
     * tests changing dead cell color to red
     */
    public void testRedClickedDead()
    {
        getScreen().setCallAlive(false);
        click(red);
        assertEquals(Color.red, getScreen().getDeadColor());
    }

    /**
     * tests changing live cell color to blue
     */
    public void testBlueClickedAlive()
    {
        getScreen().setCallAlive(true);
        click(blue);
        assertEquals(Color.blue, getScreen().getAliveColor());
    }

    /**
     * tests changing dead cell color to red
     */
    public void testBlueClickedDead()
    {
        getScreen().setCallAlive(false);
        click(blue);
        assertEquals(Color.blue, getScreen().getDeadColor());
    }


    /**
     * tests changing live cell color to purple
     */
    public void testPurpleClickedAlive()
    {
        getScreen().setCallAlive(true);
        click(purple);
        assertEquals(Color.purple, getScreen().getAliveColor());
    }

    /**
     * tests changing dead cell color to purple
     */
    public void testPurpleClickedDead()
    {
        getScreen().setCallAlive(false);
        click(purple);
        assertEquals(Color.purple, getScreen().getDeadColor());
    }


    /**
     * tests changing live cell color to yellow
     */
    public void testYellowClickedAlive()
    {
        getScreen().setCallAlive(true);
        click(yellow);
        assertEquals(Color.yellow, getScreen().getAliveColor());
    }

    /**
     * tests changing dead cell color to yellow
     */
    public void testYellowClickedDead()
    {
        getScreen().setCallAlive(false);
        click(yellow);
        assertEquals(Color.yellow, getScreen().getDeadColor());
    }

    /**
     * tests changing live cell color to white
     */
    public void testWhiteClickedAlive()
    {
        getScreen().setCallAlive(true);
        click(white);
        assertEquals(Color.white, getScreen().getAliveColor());
    }


    /**
     * tests changing dead cell color to white
     */
    public void testWhiteClickedDead()
    {
        getScreen().setCallAlive(false);
        click(white);
        assertEquals(Color.white, getScreen().getDeadColor());
    }

    /**
     * tests changing live cell color to black
     */
    public void testBlackClickedAlive()
    {
        getScreen().setCallAlive(true);
        click(black);
        assertEquals(Color.black, getScreen().getAliveColor());
    }

    /**
     * tests changing dead cell color to black
     */
    public void testBlackClickedDead()
    {
        getScreen().setCallAlive(false);
        click(black);
        assertEquals(Color.black, getScreen().getDeadColor());
    }


    /**
     * tests changing live cell color to grey
     */
    public void testGreyClickedAlive()
    {
        getScreen().setCallAlive(true);
        click(grey);
        assertEquals(Color.gray, getScreen().getAliveColor());
    }

    /**
     * tests changing dead cell color to grey
     */
    public void testGreyClickedDead()
    {
        getScreen().setCallAlive(false);
        click(grey);
        assertEquals(Color.gray, getScreen().getDeadColor());
    }
}