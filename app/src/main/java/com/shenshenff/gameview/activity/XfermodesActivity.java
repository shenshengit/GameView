package com.shenshenff.gameview.activity;

import android.app.Activity;
import android.os.Bundle;

import com.shenshenff.gameview.view.XfermodesTestView;

/**
 * Created by Felix on 2016/11/8.
 */

public class XfermodesActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new XfermodesTestView(this));
    }
}
