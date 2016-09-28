package com.example.eoin_pc.graphing_library.Views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

import com.example.eoin_pc.graphing_library.R;

/**
 * Created by eoin_pc on 28/09/2016.
 */
public  class BaseLinesGraph extends View {

    protected float[] xcoords;
    protected float[] ycoords;
    protected float xmin, ymin, xmax, ymax;
    protected float xcanvas, ycanvas, xlen, ylen;
    protected boolean subdivisionsset = false;
    protected Paint graphpaint;
    private Context cont ;


    public BaseLinesGraph(Context context) {
        super(context);
        cont = context;
        initPaint();
    }

    public BaseLinesGraph(Context context, AttributeSet attrs) {
        super(context, attrs);
        cont = context;
        initPaint();
    }

    public BaseLinesGraph(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        cont = context;
        initPaint();
    }


    @Override
    public void onDraw(Canvas canvas)
    {
        //canvas size

        xcanvas = canvas.getWidth();
        ycanvas =  canvas.getHeight();

        float ypercent = ycanvas / 100f;
        float xpercent = xcanvas / 100f;

        //draw circle at point 10% in on x-axis, 10% in on y-axis.

        xmin = xpercent * 10f;
        ymin = ypercent * 90f;
        xmax = xpercent * 90f;
        ymax = ypercent * 10f;


        ylen = ymin - ymax;
        xlen = xmax - xmin;

        canvas.drawLine(xmin, ymax, xmin, ymin, graphpaint);
        canvas.drawLine(xmin, ymin, xmax, ymin, graphpaint);

    }

    public void initPaint()
    {
        graphpaint = new Paint();
        graphpaint.setColor(ContextCompat.getColor(cont, R.color.middleGrey));
        graphpaint.setStyle(Paint.Style.FILL);
        graphpaint.setStrokeWidth(10f);
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


    //public abstract void setDivisions(float xmin, float xmax, float ymin, float ymax );
    //public abstract void setCoords(double[] x, double[] y);
    //public abstract void Drawpoints();
}
