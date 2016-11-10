package com.shenshenff.gameview.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.shenshenff.gameview.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = "s----------s";
    private Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initEvent();
    }

    private void initView() {
        btn1 = (Button) findViewById(R.id.activity_main_btn1);
        btn2 = (Button) findViewById(R.id.activity_main_btn2);
        btn3 = (Button) findViewById(R.id.activity_main_btn3);
        btn4 = (Button) findViewById(R.id.activity_main_btn4);
        btn5 = (Button) findViewById(R.id.activity_main_btn5);
        btn6 = (Button) findViewById(R.id.activity_main_btn6);
        btn7 = (Button) findViewById(R.id.activity_main_btn7);
        btn8 = (Button) findViewById(R.id.activity_main_btn8);
        btn9 = (Button) findViewById(R.id.activity_main_btn9);
        btn10 = (Button) findViewById(R.id.activity_main_btn10);
        btn11 = (Button) findViewById(R.id.activity_main_btn11);
    }

    private void initEvent() {
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn10.setOnClickListener(this);
        btn11.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()){
            case R.id.activity_main_btn1:
                intent.setClass(MainActivity.this, SurfaceViewActivity.class);
                startActivity(intent);
                break;
            case R.id.activity_main_btn2:
                intent.setClass(MainActivity.this, ThreadSurfaceViewActivity.class);
                startActivity(intent);
                break;
            case R.id.activity_main_btn3:
                intent.setClass(MainActivity.this, CanvasTestActivity.class);
                startActivity(intent);
                break;
            case R.id.activity_main_btn4:
                intent.setClass(MainActivity.this, BitmapSurfaceViewActivity.class);
                startActivity(intent);
                break;
            case R.id.activity_main_btn5:
                intent.setClass(MainActivity.this, ClipCanvasActivity.class);
                startActivity(intent);
                break;
            case R.id.activity_main_btn6:
                intent.setClass(MainActivity.this, XfermodesActivity.class);
                startActivity(intent);
                break;
            case R.id.activity_main_btn7:
                intent.setClass(MainActivity.this, AnimationActivity.class);
                startActivity(intent);
                break;
            case R.id.activity_main_btn8:
                intent.setClass(MainActivity.this, BitmapMovieActivity.class);
                startActivity(intent);
                break;
            case R.id.activity_main_btn9:
                intent.setClass(MainActivity.this, FrameMovieActivity.class);
                startActivity(intent);
                break;
            case R.id.activity_main_btn10:
                intent.setClass(MainActivity.this,ClipBitmapMovieActivity.class);
                startActivity(intent);
                break;
            case R.id.activity_main_btn11:
                intent.setClass(MainActivity.this,RectCollisionActivity.class);
                startActivity(intent);
                break;

        }
    }
}
