package com.example.eoin_pc.graphing_library;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.eoin_pc.graphing_library.Views.BaseLinesGraph;

public class MainActivity extends AppCompatActivity {


    private BaseLinesGraph bsgraph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bsgraph = (BaseLinesGraph) findViewById(R.id.dot);
    }
}
