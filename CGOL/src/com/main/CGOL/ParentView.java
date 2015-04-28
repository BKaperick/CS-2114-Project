package com.main.CGOL;

import java.util.ArrayList;
import android.os.Bundle;
import java.util.HashMap;
import android.widget.Button;
import sofia.app.ShapeScreen;
import sofia.graphics.Color;
import sofia.graphics.RectangleShape;
import sofia.util.Timer;

public class ParentView
    extends ShapeScreen
{
    private static Color       alive;
    private static Color       dead;
    private static int         width;
    private static int         height;
    private static int         speed;

    public Color getAlive()
    {
        return alive;
    }

    public Color getDead()
    {
        return dead;
    }

    public int getGridWidth()
    {
        return width;
    }

    public int getGridHeight()
    {
        return height;
    }

    public int getSpeed()
    {
        return speed;
    }


    public void setAlive(Color color)
    {
        alive = color;
    }

    public static void setDead(Color color)
    {
        dead = color;
    }

    public void setGridWidth(int newWidth)
    {
        width = newWidth;
    }

    public void setGridHeight(int newHeight)
    {
        height = newHeight;
    }

    public void setSpeed(int newSpeed)
    {
        speed = newSpeed;
    }


}
