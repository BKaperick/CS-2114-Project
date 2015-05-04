package com.main.CGOL;

//import android.appwidget.AppWidgetManager;
import sofia.app.Screen;
import android.content.Context;
import java.io.FileOutputStream;
import sofia.graphics.Color;
import android.app.Activity;
import sofia.app.ShapeScreen;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.*;

/**
 * Extra imports for popup window
 */
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;

// -------------------------------------------------------------------------
/**
 *  Screen that gives the user options with respect to view and game style.
 *
 *  @author Bryan Kaperick (bryanjk)
 *  @author Parisa Samareh (psamareh)
 *  @author William Winter (wwinter)
 *  @version Apr 25, 2015
 */
public class SettingsScreen
    extends ParentView
{
    /**
     * Where the user inserts the grid width
     */
    private EditText gridWidth;
    /**
     * Where the user inserts the gridheight
     */
    private EditText gridHeight;
    /**
     * Where the user inserts the speed
     */
    private EditText speed;
//
//    private boolean callingAlive;

    public void initialize()
    {
        setBackgroundColor(Color.getRandomColor());
    }
    /**
     * Method for when the user wants to change the color of dead cells
     * @param v theview
     */
    public void deadColorClicked(View v)
    {
        super.setCallAlive(false);
        presentScreen(PopupScreen.class);
        this.finish();
    }
    /**
     * Method for when the user wants to change the color of live cells
     * @param v view
     */
    public void liveColorClicked(View v)
    {
        super.setCallAlive(true);
        presentScreen(PopupScreen.class);
        this.finish();
    }
    /**
     * Returns the user to the play screen
     */
    public void returnToPreviousClicked()
    {
        presentScreen(PlayScreen.class);
        this.finish();
    }
    /**
     * Sets the desired grid width
     */
    public void gridWidthCompleted()
    {
        super.setGridWidth(Integer.parseInt(gridWidth.getText().toString()));
    }
    /**
     * Sets the desired grid height
     */
    public void gridHeightCompleted()
    {
        super.setGridHeight(Integer.parseInt(gridHeight.getText().toString()));
    }
    /**
     * Sets the desired speed
     */
    public void speedCompleted()
    {
        super.setSpeed(Integer.parseInt(speed.getText().toString()));
    }
}
