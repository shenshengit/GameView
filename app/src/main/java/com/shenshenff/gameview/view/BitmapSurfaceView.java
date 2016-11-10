package com.shenshenff.gameview.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Log;

import com.shenshenff.gameview.R;

import static android.content.ContentValues.TAG;

/**
 * Created by shenshen on 2016/11/7.
 */

public class BitmapSurfaceView extends ThreadSurfaceView {

    public BitmapSurfaceView(Context context) {
        super(context);

    }

    /**
     * 绘图
     */
    public void myDraw() {
        try {
            Rect rect = new Rect(0, 0, 200, 200);
            canvas = sfh.lockCanvas(rect);
            if (canvas != null) {
                canvas.drawRGB(30, 30, 50);
                canvas.drawLine(screenW / 2, 0, screenW / 2, screenH, paint);
                Bitmap bmp = BitmapFactory.decodeResource(this.getResources(), R.mipmap.ic_launcher);
                int bmpW = bmp.getWidth();
                int bmpH = bmp.getHeight();
                Log.i(TAG, "myDraw: w=" + bmpW + "h" + bmpH);
                //                canvas.drawBitmap(bmp, 0, 0, paint);

                canvas.save();
                canvas.rotate(90, bmpW / 2, bmpH / 2);
                canvas.drawLine(screenW / 2, 0, screenW / 2, screenH, paint);
                canvas.drawBitmap(bmp, 0, 0, paint);
                canvas.restore();
                canvas.drawBitmap(bmp, 300, 0, paint);

                Matrix mx = new Matrix();
                mx.postRotate(30, bmpW / 2, bmpH / 2);
                canvas.drawBitmap(bmp, mx, paint);
                canvas.save();
                canvas.translate(200, 400);
                canvas.drawBitmap(bmp, 0, 0, paint);
                canvas.restore();
                canvas.drawBitmap(bmp, 0, 144, paint);

                canvas.save();
                canvas.scale(2f, -2, screenW/2+ bmpW/2, 700+bmpH/2);
                canvas.drawBitmap(bmp, screenW/2, 700, paint);
                canvas.restore();

                Matrix mx1 = new Matrix();
                mx1.postScale(1.5f,1.5f,bmpW/2,bmpH/2);
//                canvas.translate(screenW/2+100,50);
                mx1.postTranslate(screenW/2 + 100 ,50);
                canvas.drawBitmap(bmp,mx1,paint);

                canvas.drawBitmap(bmp,0,800,paint);

            }
        } catch (Exception e) {

        } finally {
            if (canvas != null) {
                sfh.unlockCanvasAndPost(canvas);
                flag = false;
            }
        }
    }

    @Override
    public void logic() {
        //        super.logic();
    }
}
