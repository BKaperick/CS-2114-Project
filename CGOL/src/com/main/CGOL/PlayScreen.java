package com.main.CGOL;

import android.widget.Button;
import sofia.app.ShapeScreen;
import sofia.graphics.Color;
import sofia.graphics.RectangleShape;
import sofia.util.Timer;

/**
 * // -------------------------------------------------------------------------
 * /** The GUI screen where the game is played
 *
 * @author Parisa
 * @version Apr 18, 2015
 */
public class PlayScreen
    extends ShapeScreen
{

    private float       gridWidth;
    private float       gridHeight;
    private GridOfCells theGrid;
    private float       cellSize;
    private Color       alive;
    private Color       dead;
    private int         width;
    private int         height;
    private int         speed;

    private boolean     playIsClicked;
    private Button      play;
    private Button      pause;
    private Timer       runner;

    public void beforeInitialize()
    {
        super.beforeInitialize();
        alive = Color.white;
        dead = Color.darkGray;
        width = 20;
        height = 25;
    }

    public void initialize()
    {
        alive = Color.white;
        dead = Color.darkGray;
        width = 10;
        height = 10;
        gridWidth = this.getWidth();
        gridHeight = this.getHeight();
        theGrid = new GridOfCells(width, height);
        playIsClicked = false;

        cellSize = (Math.min(gridWidth, gridHeight) / Math.min(width, height));
        for (int i = 0; i < width; i++)
        {
            for (int j = 0; j < height; j++)
            {
                RectangleShape cell =
                    new RectangleShape(i * cellSize, j * cellSize, (i + 1)
                        * cellSize, (j + 1) * cellSize);
                cell.setColor(Color.black);
                cell.setFillColor(dead);
                this.add(cell);
            }
        }
    }

    /**
     * Method should be called when the user enters the playscreen from the
     * settingsscreen.  It takes in data about color, size and speed of game.
     */
    public void updateSettings()
    {
        HashMap<String, Color> colors = new HashMap();
        colors.put("red", Color.red);
        colors.put("blue", Color.blue);
        colors.put("purple", Color.purple);
        colors.put("yellow", Color.yellow);
        colors.put("white", Color.white);
        colors.put("black", Color.black);
        colors.put("grey", Color.gray);

        Bundle extras = getIntent().getExtras();
        ArrayList<String> newSettings;
        if (extras != null)
        {
            String value = extras.getString("settings");
            newSettings = retrieveSettings(value);
            for (String key : colors.keySet())
            {
                if (newSettings.get(0).contains(key))
                {
                    alive = colors.get(key);
                }
                if (newSettings.get(1).contains(key))
                {
                    dead = colors.get(key);
                }
            }
            width = Integer.parseInt(newSettings.get(2));
            height = Integer.parseInt(newSettings.get(3));
            speed = Integer.parseInt(newSettings.get(4));
            initialize();
        }
    }

    /**
     * Method called from updateSettings() which parses the string data and
     * breaks it down into an arraylist.  The data order is as follows:
     * (0) alive, (1) dead, (2) width, (3) height, (4) speed
     * @param unparsed is the string of data from settingsscreen.
     * @return ArrayList<String> of each individual component of data.
     */
    public ArrayList<String> retrieveSettings(String unparsed)
    {
        ArrayList<String> settingAttrs = new ArrayList();
        int lastIndex = 0;
        int item = 0;
        for (int i = 0; i < unparsed.length(); i++)
        {
            char c = unparsed.charAt(i);
            if (c == '$')
            {
                settingAttrs.add(unparsed.substring(lastIndex, i));
                item++;
            }
        }
        return settingAttrs;
    }

    // ----------------------------------------------------------
    /**
     * Updates the gui depending on the grid object
     *
     * @param i the x coord
     * @param j the y coord
     * @param willLive the status of that cell
     */
    public void updateGUI(int i, int j, boolean willLive)
    {
        RectangleShape current =
            getShapes()
                .locatedAt(
                    (cellSize * i) + (cellSize / 2),
                    (cellSize * j) + (cellSize / 2))
                .withClass(RectangleShape.class).front();
        if (willLive)
        {
            current.setFillColor(alive);
        }
        else
        {
            current.setFillColor(dead);
        }
    }


    /**
     * Sets the live cell color
     *
     * @param userColor
     *            The color the user wants the live cells to be
     */
    public void setLiveColor(Color userColor)
    {
        alive = userColor;
    }


    /**
     * Sets the dead cell color
     *
     * @param userColor
     *            The color the user wants the dead cells to be
     */
    public void setDeadColor(Color userColor)
    {
        dead = userColor;
    }


    /**
     * Method for when the user wants to go to the settings page
     */
    public void settingsPlayClicked()
    {
        this.presentScreen(SettingsScreen.class);
    }


    /**
     * Plays the simulation
     */
    public void playClicked()
    {
        if (!playIsClicked)
        {
            playIsClicked = true;
            runner = sofia.util.Timer.callRepeatedly(this, "step", 50);
        }
    }

    /**
     * Pauses the simulation
     */
    public void pauseClicked()
    {
        if (playIsClicked)
        {
            playIsClicked = false;
            runner.stop();
        }
    }

    /**
     * Moves one iteration forward
     *
     */
    public void step()
    {
        GridOfCells nextGen = new GridOfCells(width, height);
        for (int i = 0; i < width; i++)
        {
            for (int j = 0; j < height; j++)
            {
                boolean willLive = theGrid.update(i, j);
                nextGen.getCell(i, j).setAlive(willLive);
                updateGUI(i, j, willLive);
            }
        }
        theGrid.setGrid(nextGen.getGrid());
    }
    /**
     * Moves the game by one step
     */
    public void stepClicked()
    {
        this.step();
    }


    /**
     * Sets the width of the grid
     *
     * @param x
     *            the desired width of the board
     */
    public void setWidth(int x)
    {
        width = x;
    }


    /**
     * Sets the height of the grid
     *
     * @param x
     *            the desired height of the grid
     */
    public void setHeight(int x)
    {
        height = x;
    }


    /**
     * Processes the user's touch
     *
     * @param x the x coord
     * @param y the y coord
     */
    public void processTouch(float x, float y)
    {
        int actualX = (int)(x / cellSize);
        int actualY = (int)(y / cellSize);
        RectangleShape tile =
            this.getShapes().locatedAt(x, y).withClass(RectangleShape.class)
                .front();
        if (theGrid.isAlive(actualX, actualY))
        {
            tile.setFillColor(dead);
            theGrid.getCell(actualX, actualY).setAlive(false);
        }
        else
        {
            tile.setFillColor(alive);
            theGrid.getCell(actualX, actualY).setAlive(true);
        }
    }


    /**
     * Returns the grid
     *
     * @return thegrid
     */
    public GridOfCells getGrid()
    {
        return theGrid;
    }


    /**
     * Toggles the cell state when a cell is touched.
     *
     * @param x
     *            the x-coordinate for the picture
     * @param y
     *            the y-coordinate for the picture
     */
    public void onTouchDown(float x, float y)
    {
        this.processTouch(x, y);
    }


    /**
     * Toggles the cell state with the swipe of a finger.
     *
     * @param x
     *            the x-coordinate for the picture
     * @param y
     *            the y-coordinate for the picture
     */
    public void onTouchMove(float x, float y)
    {
        this.processTouch(x, y);
    }

}
