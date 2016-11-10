package com.shenshenff.gameview.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.shenshenff.gameview.R;
import com.shenshenff.gameview.view.RectCollisionSurfaceView;

/**
 * Created by Felix on 2016/11/9.
 */

public class RectCollisionActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rect_collision);

        RelativeLayout rl = (RelativeLayout) findViewById(R.id.bg_layout);
        Button btn = (Button) findViewById(R.id.btn);
        rl.addView(new RectCollisionSurfaceView(this));
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
