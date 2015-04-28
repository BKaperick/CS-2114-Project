package com.main.CGOL;

//import android.appwidget.AppWidgetManager;
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
    extends ShapeScreen
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

    private Color aliveColor;
    private Color deadColor;
    private String gridWidthVal;
    private String gridHeightVal;
    private String speedVal;

    private boolean callingAlive;

    public void initialize()
    {
        setBackgroundColor(Color.getRandomColor());
        //int widgetIDs[] = AppWidgetManager.getInstance(getApplication());
    }

    public void DeadClicked(View view)
    {
        callingAlive = false;
        ShowPopUp showPopUp = new ShowPopUp();
    }

    public void liveColorClicked(View view)
    {
        callingAlive = true;
        ShowPopUp showPopUp = new ShowPopUp();
    }

    public void returnToPreviousClicked(View view)
    {
        Object obj = new Object();
        finish(obj);
        Intent i = new Intent(getApplicationContext(), PlayScreen.class);
        i.putExtra("settings", aliveColor.toString() + "$" +
            deadColor.toString() + "$" + gridWidthVal + "$" + gridHeightVal +
                "$" + speedVal);
        presentScreen(PlayScreen.class);
    }

    public void gridWidthCompleted()
    {
        gridWidthVal = gridWidth.getText().toString();
    }

    public void gridHeightLabelCompleted()
    {
        gridHeightVal = gridHeight.getText().toString();
    }

    public void speedCompleted()
    {
        speedVal = speed.getText().toString();
    }

    private class ShowPopUp extends Activity
    {
        private PopupWindow popup;
        private LinearLayout layout;
        private LinearLayout mainLayout;
        private LayoutParams params;

        private TextView chooseColor;
        private Button red;
        private Button blue;
        private Button purple;
        private Button yellow;
        private Button white;
        private Button black;
        private Button grey;

        private boolean alive;


        public void onCreate(Bundle savedInstanceState)
        {
            popup = new PopupWindow(this);
            layout = new LinearLayout(this);
            chooseColor = new TextView(this);
            red.setBackgroundColor(Color.red);
            blue.getBackground().setColorFilter(Color.blue);//.setBackgroundColor(Color.blue);
            purple.setFillColor(Color.purple);
            yellow.setBackgroundColor(Color.yellow);
            white.setBackgroundColor(Color.white);
            green.setBackgroundColor(Color.green);
            black.setBackgroundColor(Color.black);
            grey.setBackgroundColor(Color.gray);

            alive = callingAlive;

        }

        public void redClicked()
        {
            if (alive)
            {
                aliveColor = Color.red;
            }
            else
            {
                deadColor = Color.red;
            }
            popup.dismiss();
        }

        public void blueClicked()
        {
            if (alive)
            {
                aliveColor = Color.blue;
            }
            else
            {
                deadColor = Color.blue;
            }
            popup.dismiss();
        }

        public void purpleClicked()
        {
            if (alive)
            {
                aliveColor = Color.purple;
            }
            else
            {
                deadColor = Color.purple;
            }
            popup.dismiss();
        }

        public void yellowClicked()
        {
            if (alive)
            {
                aliveColor = Color.yellow;
            }
            else
            {
                deadColor = Color.yellow;
            }
            popup.dismiss();
        }

        public void whiteClicked()
        {
            if (alive)
            {
                aliveColor = Color.white;
            }
            else
            {
                deadColor = Color.white;
            }
            popup.dismiss();
        }

        public void blackClicked()
        {
            if (alive)
            {
                aliveColor = Color.black;
            }
            else
            {
                deadColor = Color.black;
            }
            popup.dismiss();
        }

        public void greyClicked()
        {
            if (alive)
            {
                aliveColor = Color.gray;
            }
            else
            {
                deadColor = Color.gray;
            }
            popup.dismiss();
        }

    }


    public void Save(String filename, String data)
    {
        FileOutputStream outputStream;

        try
        {
            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(data.getBytes());
            outputStream.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

}
