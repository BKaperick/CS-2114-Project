package com.main.CGOL;

import sofia.app.Screen;
import android.os.Bundle;

/**
 * // -------------------------------------------------------------------------
/**
 *  The screen to create the title screen
 *
 *  @author Bill and Bryan and Parisa
 *  @version Apr 23, 2015
 */
public class TitleScreen
    extends Screen
{

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.titlescreen);
    }


    /**
     * Access to the settings screen
     */
    public void settingsClicked()
    {
        this.presentScreen(SettingsScreen.class, (Object) this);
        this.finish();
    }
    /**
     * Access to the play screen
     */
    public void startClicked()
    {
        this.presentScreen(PlayScreen.class);
        this.finish();
    }
    /**
     * Access to the play screen
     */
    public void savedClicked()
    {
        this.presentScreen(SavedScreen.class);
        this.finish();
    }
}
