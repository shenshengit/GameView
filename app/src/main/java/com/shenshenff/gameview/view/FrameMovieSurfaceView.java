package com.shenshenff.gameview.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;

import com.shenshenff.gameview.R;

/**
 * Created by Felix on 2016/11/9.
 */

public class FrameMovieSurfaceView extends ThreadSurfaceView {

    Bitmap bmp[] = new Bitmap[8];
    int currentFrame;

    public FrameMovieSurfaceView(Context context) {
        super(context);
        for (int i = 0; i < bmp.length; i++){
            bmp[i] = BitmapFactory.decodeResource(this.getResources(), R.drawable.f01 + i);
        }
    }

    @Override
    public void myDraw() {
//        super.myDraw();
        try {
            canvas = sfh.lockCanvas();
            if (canvas != null) {
                canvas.drawColor(Color.WHITE);
                canvas.drawBitmap(bmp[currentFrame],getWidth()/2 - bmp[0].getWidth()/2,100,paint);
            }
        } catch (Exception e) {

        } finally {
            if (canvas != null) {
                sfh.unlockCanvasAndPost(canvas);
            }
        }
    }
    @Override
    public void logic() {
//        super.logic();

        currentFrame++;
        if (currentFrame >= bmp.length){
            currentFrame=0;
        }
    }

    @Override
    public void run() {

        while (flag) {
            long start = System.currentTimeMillis();
            myDraw();
            logic();
            long end = System.currentTimeMillis();
            try {
                if (end - start < 300) {
                    Thread.sleep(300 - (end - start));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
