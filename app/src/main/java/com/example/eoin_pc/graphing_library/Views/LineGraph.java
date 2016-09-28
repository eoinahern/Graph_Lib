package com.example.eoin_pc.graphing_library.Views;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;

/**
 * Created by eoin_pc on 28/09/2016.
 */
public class LineGraph extends BaseLinesGraph {



    public LineGraph(Context context) {
        super(context);
    }

    public LineGraph(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LineGraph(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);




    }

    /*//@Override
    public void setDivisions(float xmin, float xmax, float ymin, float ymax) {

        this.xmin = xmin;
        this.xmax = xmax;
        this.ymin = ymin;
        this.ymax = ymax;

        subdivisionsset = true;
    }*/







    /**
     * iterate over each point. check coord item outside range.
     * if not set as coords points. also check same length.
     *
     * @param x
     * @param y
     */

    //@Override
    public void setCoords(float[] x, float[] y) {

        if(!subdivisionsset)
            throw new IllegalArgumentException("subdivisions must be set!!!");

        if(!checkWithinBounds(x,y))
            throw new IllegalArgumentException("point outside bounds!!");



        this.xcoords = x;
        this.ycoords = y;
    }





    public void Drawpoints() {


    }


    /**
     * convert X coord value to correspond to
     * the position it should be on the canvas
     *
     **/

    private float convXcoord(float xin)
    {
        return 0f;

    }

    /**
     * convert Y coord value to correspond to
     * the position it should be on the canvas
     *
     **/


    private float convYcoord(float yin)
    {
        return 0f;
    }


    private boolean checkWithinBounds(float[] x, float[] y)
    {
        if(!checkBoundsHelper(x, xmin, xmax))
            return false;

        if(!checkBoundsHelper(y, ymin, ymax))
            return false;

        return true;
    }

    private boolean checkBoundsHelper(float[] coords, float min, float max)
    {
        for(double num : coords)
        {
            if(num < min || num > max )
                return false;
        }

        return true;
    }
}
