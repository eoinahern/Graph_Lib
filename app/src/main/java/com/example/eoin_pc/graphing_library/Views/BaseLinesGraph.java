package com.example.eoin_pc.graphing_library.Views;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by eoin_pc on 28/09/2016.
 */
public  abstract class BaseLinesGraph extends View {

    protected double[] xcoords;
    protected double[] ycoords;
    protected double xmin, ymin, xmax, ymax, xcanvas, ycanvas;
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

        //canvas size

        xcanvas = Double.valueOf(canvas.getWidth());
        ycanvas =  Double.valueOf(canvas.getHeight());


        double ypercent = xcanvas / 100.00;
        double xpercent = ycanvas / 100.00;



        //draw circle at point 10% in on x-axis, 10% in on y-axis.






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


    public abstract void setDivisions(double xmin, double xmax, double ymin, double ymax );
    public abstract void setCoords(double[] x, double[] y);
    public abstract void Drawpoints();
}
