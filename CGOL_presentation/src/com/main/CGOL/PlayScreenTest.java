package com.main.CGOL;

import sofia.graphics.Color;
import sofia.graphics.RectangleShape;
import android.widget.Button;
import sofia.graphics.ShapeView;

/**
 * // -------------------------------------------------------------------------
 * /** Tests the pplay screen class
 *
 * @author Parisa
 * @version Apr 27, 2015
 */
public class PlayScreenTest
    extends student.AndroidTestCase<PlayScreen>
{
    private ShapeView shapeView;
    private int       cellSize;
    private Button    step;
    private Button    play;
    private Button    pause;


    /**
     * Constructor for PlayScreenTest
     */
    public PlayScreenTest()
    {
        super(PlayScreen.class);
    }


    /**
     * sets up testing
     */
    public void setUp()
    {
        getScreen().setAliveColor(Color.white);
        getScreen().setDeadColor(Color.darkGray);
        getScreen().setGridWidth(10);
        getScreen().setGridHeight(10);
        float viewSize = Math.min(shapeView.getWidth(), shapeView.getHeight());
        cellSize = (int)(viewSize / 10);
    }

    /**
     *
     */
    public void testCellAlive()
    {
        Color tile =
            shapeView.getShapes().locatedAt(0, 0)
                .withClass(RectangleShape.class).front().getFillColor();
        Color tile2 =
            shapeView.getShapes().locatedAt(1, 0)
                .withClass(RectangleShape.class).front().getFillColor();
        touchDownCell(0, 0);
        touchMoveCell(1, 0);
        GridOfCells grid = getScreen().getGrid();
        assertTrue(grid.getCell(0, 0).getAlive());
        assertEquals(Color.white, tile2);
        assertTrue(grid.getCell(1, 0).getAlive());
        assertEquals(Color.white, tile);

    }

    /**
     * Tests the grid size
     */
    public void testGridSize()
    {
        GridOfCells grid = getScreen().getGrid();
        assertNull(grid.getCell(10, 10));
    }


    /**
     * Tests the cell dead method
     */
    public void testCellDead()
    {
        clickCell(1, 1);
        clickCell(1, 1);
        GridOfCells grid = getScreen().getGrid();
        assertFalse(grid.isAlive(1, 1));

    }


    /**
     * Tests how the cell becomes alive after it steps
     */
    public void testBecomesAliveAfterStep()
    {
        clickCell(2, 3);
        clickCell(2, 4);
        clickCell(1, 3);
        click(step);
        GridOfCells grid = getScreen().getGrid();
        assertTrue(grid.isAlive(1, 4));
    }


    /**
     * Tests how the cell dies after we step
     */
    public void testDeadAfterStepNoAdj()
    {
        clickCell(0, 0);
        click(play);
        click(pause);
        GridOfCells grid = getScreen().getGrid();
        assertFalse(grid.isAlive(0, 0));
    }


    /**
     * Tests how the cell stays alive
     */
    public void testStayAlive()
    {
        clickCell(0, 0);
        clickCell(0, 1);
        clickCell(1, 0);
        clickCell(1, 1);
        click(step);
        GridOfCells grid = getScreen().getGrid();
        assertTrue(grid.isAlive(0, 0));
        assertTrue(grid.isAlive(1, 0));
        assertTrue(grid.isAlive(0, 1));
        assertTrue(grid.isAlive(1, 1));
    }


    /**
     * Tests how the cell stays alive
     */
    public void testStayAlive2()
    {
        clickCell(0, 0);
        clickCell(0, 1);
        clickCell(1, 0);
        click(step);
        GridOfCells grid = getScreen().getGrid();
        assertTrue(grid.isAlive(0, 0));
        assertTrue(grid.isAlive(1, 0));
        assertTrue(grid.isAlive(0, 1));
    }


    /**
     * Tests how the cell stays alive
     */
    public void testBecomesDeadAfterStep()
    {
        clickCell(0, 0);
        clickCell(1, 0);
        clickCell(0, 1);
        clickCell(1, 1);
        clickCell(2, 0);
        click(step);
        GridOfCells grid = getScreen().getGrid();
        assertFalse(grid.isAlive(1, 1));
    }


    /**
     * Simulates touching down on the middle of the specified cell in the maze.
     */
    private void touchDownCell(int x, int y)
    {
        touchDown(shapeView, (x + 0.5f) * cellSize, (y + 0.5f) * cellSize);
    }


    // ----------------------------------------------------------
    /**
     * Simulates moving the finger instantaneously to the middle of the
     * specified cell in the maze.
     */
    private void touchMoveCell(int x, int y)
    {
        touchMove((x + 0.5f) * cellSize, (y + 0.5f) * cellSize);
    }


    // ----------------------------------------------------------
    /**
     * Simulates clicking the middle of the specified cell in the maze. This is
     * equivalent to calling: touchDownCell(x, y); touchUp();
     */
    private void clickCell(int x, int y)
    {
        touchDownCell(x, y);
        touchUp();
    }

}
