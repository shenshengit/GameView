package com.shenshenff.gameview.activity;

import android.app.Activity;
import android.os.Bundle;

import com.shenshenff.gameview.view.MySurfaceView;

/**
 * Created by Felix on 2016/11/7.
 */

public class SurfaceViewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MySurfaceView(this));
    }
}
