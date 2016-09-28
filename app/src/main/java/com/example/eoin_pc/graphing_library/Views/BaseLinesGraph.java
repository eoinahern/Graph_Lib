package com.example.eoin_pc.graphing_library.Views;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by eoin_pc on 28/09/2016.
 */
public  abstract class BaseLinesGraph extends View {



    protected int[] xcoords;
    protected int[] ycoords;
    protected int xmin, ymin, xmax, ymax, xcanvas, ycanvas;
    protected boolean subdivisionsset = false;


    public BaseLinesGraph(Context context) {
        super(context);
    }

    public BaseLinesGraph(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseLinesGraph(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public void onDraw(Canvas canvas)
    {

        //calculateCanvasSize();
        //Drawpoints();


    }


    /**
     *  basic x and y axis shape with divisions set.
     *
    ***/

    private void createFrame()
    {

    }

    /**
     * size of canvas needed so i can detemine
     * exact placing of points on the graph.
     *
     */

    private void calculateCanvasSize()
    {



    }


    public abstract void setDivisions(int xmin, int xmax, int ymin, int ymax );
    public abstract void setCoords(int[] x, int[] y);
    public abstract void Drawpoints();
}
