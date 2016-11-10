package com.shenshenff.gameview.activity;

import android.app.Activity;
import android.os.Bundle;

import com.shenshenff.gameview.view.ClipCanvasSurfaceView;

/**
 * Created by Felix on 2016/11/8.
 */

public class ClipCanvasActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new ClipCanvasSurfaceView(this));
    }

}
