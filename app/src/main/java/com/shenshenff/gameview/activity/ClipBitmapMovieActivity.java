package com.shenshenff.gameview.activity;

import android.app.Activity;
import android.os.Bundle;

import com.shenshenff.gameview.view.ClipBitmapMovieSurfaceView;


/**
 * Created by Felix on 2016/11/9.
 */

public class ClipBitmapMovieActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new ClipBitmapMovieSurfaceView(this));
    }
}
