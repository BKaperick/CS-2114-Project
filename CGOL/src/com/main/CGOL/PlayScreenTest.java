package com.main.CGOL;

import android.widget.Button;
import sofia.graphics.ShapeView;

public class PlayScreenTest
    extends student.AndroidTestCase<PlayScreen>
{
    private ShapeView shapeView;
    private int       cellSize;
    private Button step;
    private Button play;
    private Button pause;


    public PlayScreenTest()
    {
        super(PlayScreen.class);
    }


    public void testSomething()
    {
        assertEquals(1, 1 + 3 - 3);
    }



    /**
     * sets up testing
     */
    public void setUp()
    {
        float viewSize = Math.min(shapeView.getWidth(), shapeView.getHeight());
        cellSize = (int)(viewSize / 10);
    }


    public void testCellAlive()
    {
        touchDownCell(0, 0);
        touchMoveCell(1, 0);
        GridOfCells grid = getScreen().getGrid();
        assertTrue(grid.getCell(0, 0).getAlive());
        assertTrue(grid.getCell(1, 0).getAlive());

    }

    public void testGridSize()
    {
        GridOfCells grid = getScreen().getGrid();
        assertNull(grid.getCell(10, 10));
    }


    public void testCellDead()
    {
        clickCell(1, 1);
        clickCell(1, 1);
        GridOfCells grid = getScreen().getGrid();
        assertFalse(grid.isAlive(1, 1));

    }


    public void testBecomesAliveAfterStep()
    {
        clickCell(2, 3);
        clickCell(2, 4);
        clickCell(1, 3);
        click(step);
        GridOfCells grid = getScreen().getGrid();
        assertTrue(grid.isAlive(1, 4));
    }


    public void testDeadAfterStepNoAdj()
    {
        clickCell(0, 0);
        click(play);
        click(pause);
        GridOfCells grid = getScreen().getGrid();
        assertFalse(grid.isAlive(0, 0));
    }


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
