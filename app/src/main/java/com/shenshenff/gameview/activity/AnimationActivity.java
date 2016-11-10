package com.shenshenff.gameview.activity;

import android.app.Activity;
import android.os.Bundle;

import com.shenshenff.gameview.view.AnimationSurfaceView;

/**
 * Created by shenshen on 2016/11/8.
 */

public class AnimationActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new AnimationSurfaceView(this));
    }
}
