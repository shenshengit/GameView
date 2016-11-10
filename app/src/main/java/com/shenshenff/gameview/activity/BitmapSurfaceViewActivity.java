package com.shenshenff.gameview.activity;

import android.app.Activity;
import android.os.Bundle;

import com.shenshenff.gameview.view.BitmapSurfaceView;

/**
 * Created by shenshen on 2016/11/7.
 */

public class BitmapSurfaceViewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new BitmapSurfaceView(this));
    }
}
