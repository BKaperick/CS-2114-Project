package com.main.CGOL;

import android.widget.Button;
import sofia.graphics.Color;
import sofia.app.ShapeScreen;

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
