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
public abstract  class BaseLinesGraph extends View {

    protected float[] xcoords;
    protected float[] ycoords;
    protected float xmin, ymin, xmax, ymax;
    protected float xcanvas, ycanvas, xlen, ylen;
    protected boolean subdivisionsset = false;
    protected Paint graphpaint, textpaint;
    protected float ypercent;
    private Context cont ;
    private String y_label, x_label;


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

        ypercent = ycanvas / 100f;
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

    protected void drawLabels(Canvas canvas)
    { if(x_label == null || y_label == null) return;
        canvas.drawText(x_label, ( xmax / 2) , ymin * (ypercent * 5) , textpaint);
        canvas.drawText(x_label, ( xmin * 2) , ymin * (ypercent * 5) , textpaint); }

    public void initPaint()
    {
        graphpaint = new Paint();
        graphpaint.setColor(ContextCompat.getColor(cont, R.color.middleGrey));
        graphpaint.setStyle(Paint.Style.FILL);
        graphpaint.setStrokeWidth(10f);

        graphpaint.setStyle(Paint.Style.FILL); graphpaint.setStrokeWidth(4f);
        textpaint = new Paint(); textpaint.setColor(ContextCompat.getColor(cont, R.color.lightGrey));
        textpaint.setStyle(Paint.Style.FILL); textpaint.setStrokeWidth(5f); textpaint.setTextSize(40f);
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


    public abstract void setScale(float xmin, float xmax, float ymin, float ymax );
    public abstract void setCoords(float[] x, float[] y);
    public abstract void Drawpoints(Canvas canvas);
}


  
