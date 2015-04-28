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

    private Button Dead;
    private Button liveColor;
    private Button returnToPrevious;

    private TextView settingsTitle;
    private TextView gridWidthLabel;
    private TextView gridHeightLabel;
    private TextView speedLabel;

    private EditText gridWidth;
    private EditText gridHeight;
    private EditText speed;


    private boolean callingAlive;

    public void initialize()
    {
        setBackgroundColor(Color.getRandomColor());
    }

    public void DeadClicked(View view)
    {
        super.setCallingAlive(true);
        presentScreen(PopupScreen.class);
    }

    public void liveColorClicked(View view)
    {
        super.setCallingAlive(true);
        presentScreen(PopupScreen.class);
    }

    public void returnToPreviousClicked(View view)
    {
        presentScreen(PlayScreen.class);
    }

    public void gridWidthCompleted()
    {
        super.setGridWidth(Integer.parseInt(gridWidth.getText().toString()));
    }

    public void gridHeightLabelCompleted()
    {
        super.setGridHeight(Integer.parseInt(gridHeight.getText().toString()));
    }

    public void speedCompleted()
    {
        super.setSpeed(Integer.parseInt(speed.getText().toString()));
    }
}
