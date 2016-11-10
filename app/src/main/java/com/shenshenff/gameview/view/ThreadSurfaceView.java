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

public class ThreadSurfaceView extends SurfaceView implements SurfaceHolder.Callback, Runnable {

    protected  SurfaceHolder sfh;
    protected  Paint paint;
    protected  int testX = 10, testY = 10;
    protected  Thread th;
    protected  boolean flag;
    protected  Canvas canvas;
    protected  int screenW, screenH;

    public ThreadSurfaceView(Context context) {
        super(context);
        sfh = this.getHolder();
        sfh.addCallback(this);
        paint = new Paint();
        paint.setColor(Color.WHITE);
        setFocusable(true);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        screenW = this.getWidth();
        screenH = this.getHeight();
        flag = true;
        th = new Thread(this);
        th.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        flag = false;
    }

    @Override
    public void run() {

        while (flag) {
            long start = System.currentTimeMillis();
            myDraw();
            logic();
            long end = System.currentTimeMillis();
            try {
                if (end - start < 50) {
                    Thread.sleep(50 - (end - start));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 触屏
     * @param event
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        testX = (int) event.getX();
        testY = (int) event.getY();
        return true;
    }

    /**
     * 绘图
     */
    public void myDraw() {
        try {
            canvas = sfh.lockCanvas();
            if (canvas != null) {
                canvas.drawRGB(0, 0, 0);
                paint.setTextSize(60);
                canvas.drawText("shen", testX, testY, paint);
            }
        } catch (Exception e) {

        } finally {
            if (canvas != null) {
                sfh.unlockCanvasAndPost(canvas);
            }
        }
    }

    /**
     * 逻辑
     */
    public void logic() {
        if (testX < screenW) {
            testX = testX + 5;
        } else if (testX >= screenW) {
            testX = testX - 5;
        }
        if (testY < screenH) {
            testY = testY + 5;
        } else if (testY >= screenW) {
            testY = testY - 5;
        }
    }
}



