package com.shenshenff.gameview.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.shenshenff.gameview.R;

/**
 * Created by Felix on 2016/11/9.
 */

public class ClipBitmapMovieSurfaceView extends ThreadSurfaceView {

    Bitmap bmp ;
    int cureentFrame;
    int x;
    int y;

    public ClipBitmapMovieSurfaceView(Context context) {
        super(context);
        bmp = BitmapFactory.decodeResource(this.getResources(), R.drawable.jj1);

    }

    @Override
    public void myDraw() {
        //super.myDraw();
        x = getWidth()/2-(bmp.getWidth()/5)/2;
        y = getHeight()/2 - bmp.getHeight()/2;
        try {
            canvas = sfh.lockCanvas();
            if (canvas != null) {
                canvas.drawRGB(255, 255, 255);
                canvas.save();
                canvas.clipRect(x,y,x+bmp.getWidth()/5,y+bmp.getHeight());
                canvas.drawBitmap(bmp, x-cureentFrame*bmp.getWidth()/5,y,paint);
                canvas.restore();
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
        cureentFrame ++;
        if (cureentFrame >= 6){
            cureentFrame=0;
        }
    }

    @Override
    public void run() {
//        super.run();
        while (flag) {
            long start = System.currentTimeMillis();
            myDraw();
            logic();
            long end = System.currentTimeMillis();
            try {
                if (end - start < 150) {
                    Thread.sleep(150 - (end - start));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
