package com.example.eoin_pc.graphing_library.Views;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;

/**
 * Created by eoin_pc on 28/09/2016.
 */
public class LineGraph extends BaseLinesGraph {


    float xpointmin, xpointmax, ypointmin, ypointmax,
            xsublen , ysublen, yratio, xratio ;

    
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

        if(subdivisionsset) {
            calcSubLengths();
            calcRatio();
        }

        if(xcoords != null && ycoords != null)
            Drawpoints(canvas);

    }

    private void calcSubLengths() {
         xsublen = xpointmax - xpointmin;
         ysublen = ypointmax - ypointmin;
    }

    private void calcRatio()
    {
        xratio = xlen / xsublen;
        yratio = ylen / ysublen;
    }

    @Override
    public void setScale(float xmin, float xmax, float ymin, float ymax) {

        this.xpointmin = xmin;
        this.xpointmax = xmax;
        this.ypointmin = ymin;
        this.ypointmax = ymax;

        subdivisionsset = true;
    }

    /**
     * iterate over each point. check coord item outside range.
     * if not set as coords points. also check same length.
     *
     * @param x
     * @param y
     */

    @Override
    public void setCoords(float[] x, float[] y) {

        if(!subdivisionsset)
            throw new IllegalArgumentException("subdivisions must be set!!!");

        if(!checkWithinBounds(x,y))
            throw new IllegalArgumentException("point outside bounds!!");


        this.xcoords = x;
        this.ycoords = y;


        invalidate();
    }

    @Override
    public void Drawpoints(Canvas canvas) {

        int len = xcoords.length;

        if(len < 2)
            return;

        convCoordHelper();

        for(int i = 0; i <  len -1; i++)
        {
            canvas.drawLine(xcoords[i],ycoords[i],
                    xcoords[i+1], ycoords[i +1], graphpaint);

            drawPoint(canvas, xcoords[i],ycoords[i]);
            drawPoint(canvas, xcoords[i + 1],ycoords[i + 1]);
        }


    }

    private void drawPoint(Canvas canvas, float x, float y)
    {
        canvas.drawCircle(x,y, 12f, graphpaint);
    }


    private void convCoordHelper()
    {
        int len = xcoords.length;

        for(int i = 0 ; i < len; i++)
        {
            xcoords[i] = convXcoord(xcoords[i]);
            ycoords[i] = convYcoord(ycoords[i]);
        }
    }

    /**
     * convert X coord value to correspond to
     * the position it should be on the canvas
     *
     **/

    private float convXcoord(float xin)
    {
        return (xin * xratio)  + xmin;
    }

    /**
     * convert Y coord value to correspond to
     * the position it should be on the canvas
     *
     **/


    private float convYcoord(float yin)
    {
        return  ymin -  (yin * yratio);
    }


    private boolean checkWithinBounds(float[] x, float[] y)
    {
        if(!checkBoundsHelper(x, xpointmin, xpointmax)) {
            Log.d("x ", "out of bounds");
            return false;
        }

        if(!checkBoundsHelper(y, ypointmin, ypointmax)) {
            Log.d("y", "out of bounds");
            return false;
        }

        return true;
    }

    private boolean checkBoundsHelper(float[] coords, float min, float max)
    {
        for(float num : coords)
        {
            if(num < min || num > max )
                return false;
        }

        return true;
    }
}
