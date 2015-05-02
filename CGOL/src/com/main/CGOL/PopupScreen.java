package com.main.CGOL;

import sofia.graphics.RectangleShape;
import android.widget.Button;
import sofia.graphics.Color;

/**
 * // -------------------------------------------------------------------------
/**
 *  The PopupScreen
 *
 *  @author Parisa
 *  @version Apr 30, 2015
 */
public class PopupScreen
    extends ParentView
{
    private Button red;
    private Button blue;
    private Button purple;
    private Button yellow;
    private Button white;
    private Button black;
    private Button grey;

    private boolean alive;

    public void initialize()
    {
        setBackgroundColor(Color.magenta);
    }

    public void redClicked()
    {
        if (super.getCallAlive())
        {
            super.setAliveColor(Color.red);
        }
        else
        {
            super.setDeadColor(Color.red);
        }
        presentScreen(SettingsScreen.class);
        this.finish();
    }

    public void blueClicked()
    {
        if (super.getCallAlive())
        {
            super.setAliveColor(Color.blue);
        }
        else
        {
            super.setDeadColor(Color.blue);
        }
        presentScreen(SettingsScreen.class);
        this.finish();
    }

    public void purpleClicked()
    {
        if (super.getCallAlive())
        {
            super.setAliveColor(Color.purple);
        }
        else
        {
            super.setDeadColor(Color.purple);
        }
        presentScreen(SettingsScreen.class);
        this.finish();
    }

    public void yellowClicked()
    {
        if (super.getCallAlive())
        {
            super.setAliveColor(Color.yellow);
        }
        else
        {
            super.setDeadColor(Color.yellow);
        }
        presentScreen(SettingsScreen.class);
        this.finish();
    }

    public void whiteClicked()
    {
        if (super.getCallAlive())
        {
            super.setAliveColor(Color.white);
        }
        else
        {
            super.setDeadColor(Color.white);
        }
        presentScreen(SettingsScreen.class);
        this.finish();
    }

    public void blackClicked()
    {
        if (super.getCallAlive())
        {
            super.setAliveColor(Color.black);
        }
        else
        {
            super.setDeadColor(Color.black);
        }
        presentScreen(SettingsScreen.class);
        this.finish();
    }

    public void greyClicked()
    {
        if (super.getCallAlive())
        {
            super.setAliveColor(Color.gray);
        }
        else
        {
            super.setDeadColor(Color.gray);
        }
        presentScreen(SettingsScreen.class);
        this.finish();
    }
}
