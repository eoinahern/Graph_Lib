package com.example.eoin_pc.graphing_library.Views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by eoin_pc on 28/09/2016.
 */
public  class BaseLinesGraph extends View {

    protected double[] xcoords;
    protected double[] ycoords;
    protected double xmin, ymin, xmax, ymax;
    float  xcanvas, ycanvas;
    protected boolean subdivisionsset = false;
    protected Paint graphpaint;


    public BaseLinesGraph(Context context) {
        super(context);
        initPaint();
    }

    public BaseLinesGraph(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public BaseLinesGraph(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }


    @Override
    public void onDraw(Canvas canvas)
    {

        //canvas size

        xcanvas = canvas.getWidth();
        ycanvas =  canvas.getHeight();


        float ypercent = ycanvas / 100f;
        double xpercent = xcanvas / 100f;


        Log.d("ycanvas", String.valueOf(ycanvas));
        Log.d("ypercent", String.valueOf(ypercent));
        Log.d("ypercent by 100", String.valueOf(ypercent * 100f));


        //draw circle at point 10% in on x-axis, 10% in on y-axis.
        canvas.drawPoint((float) xpercent * 10,  ypercent * 10f, graphpaint);
        canvas.drawPoint((float) xpercent * 10,  ypercent * 100f, graphpaint);
    }

    public void initPaint()
    {
        graphpaint = new Paint();
        graphpaint.setColor(0xff101010);
        graphpaint.setStyle(Paint.Style.FILL);
        graphpaint.setStrokeWidth(20f);
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


    //public abstract void setDivisions(double xmin, double xmax, double ymin, double ymax );
    //public abstract void setCoords(double[] x, double[] y);
    //public abstract void Drawpoints();
}
