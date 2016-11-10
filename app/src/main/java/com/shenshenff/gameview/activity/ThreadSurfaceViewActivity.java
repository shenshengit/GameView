package com.shenshenff.gameview.activity;

import android.app.Activity;
import android.os.Bundle;

import com.shenshenff.gameview.view.ThreadSurfaceView;

/**
 * Created by Felix on 2016/11/7.
 */

public class ThreadSurfaceViewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new ThreadSurfaceView(this));
    }
}
