package com.shenshenff.gameview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by Felix on 2016/11/7.
 */

public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback{

    //用于控制SurfaceView
    private SurfaceHolder sfh;
    private Paint paint;
    private int testX,testY;

    public MySurfaceView(Context context) {
        super(context);
        //初始化
        sfh = this.getHolder();
        sfh.addCallback(this);
        paint = new Paint();

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        myDraw();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        testX = (int) event.getX();
        testY = (int) event.getY();
        myDraw();
        return true;
    }

    private void myDraw(){
        Canvas canvas = sfh.lockCanvas();
        paint.setColor(Color.parseColor("#ffcccccc"));
        canvas.drawRect(0, 0, this.getWidth(), this.getHeight(), paint);
//        canvas.drawColor(Color.BLACK);
        paint.setColor(Color.parseColor("#ffffff00"));
        paint.setTextSize(50);
        canvas.drawText("shen", testX, testY, paint);
        sfh.unlockCanvasAndPost(canvas);
    }


}
