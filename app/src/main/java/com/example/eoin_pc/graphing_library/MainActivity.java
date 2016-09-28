package com.example.eoin_pc.graphing_library;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.eoin_pc.graphing_library.Views.BaseLinesGraph;
import com.example.eoin_pc.graphing_library.Views.LineGraph;

public class MainActivity extends AppCompatActivity {


    private LineGraph bsgraph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bsgraph = (LineGraph) findViewById(R.id.dot);

        float[] x = {1f, 2f,3f, 5f};
        float[] y =  {1f, 2f,3f, 5f};
        bsgraph.setScale(0f,10f,0f,10f);
        bsgraph.setCoords(x,y);
    }
}
