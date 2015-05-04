package com.main.CGOL;
import android.widget.ImageView;
import android.widget.Button;
import android.widget.TextView;
import student.AndroidTestCase;

public class TitleScreenTest extends student.AndroidTestCase<TitleScreen>
{

    private TextView title;
    private Button start;
    private ImageView logo;
    private ImageView imageView;

    public TitleScreenTest()
    {
        super(TitleScreen.class);
        // TODO Auto-generated constructor stub
    }

    public void setUp()
    {

    }

    public void testTitle()
    {
        assertEquals("Conway's Game of Life", title.getText().toString());
    }

    public void testChangeScreen()
    {

        click(start);
        assertEquals(PlayScreen.class, this.getScreen().getClass());
    }
}
