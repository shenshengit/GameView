package com.shenshenff.gameview.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.util.Log;
import android.view.SurfaceHolder;

import com.shenshenff.gameview.R;

import static android.content.ContentValues.TAG;

/**
 * Created by Felix on 2016/11/9.
 */

public class BitmapMovieSurfaceView extends ThreadSurfaceView {

    //声明一张波浪位图
    private Bitmap bmp;
    //声明波浪图的X，Y坐标
    private int bmpX, bmpY;
    private int chushi;

    public BitmapMovieSurfaceView(Context context) {
        super(context);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        super.surfaceCreated(holder);
        bmp = BitmapFactory.decodeResource(this.getResources(), R.drawable.t3);
        //让位图初始化X坐标正好充满屏幕
        bmpX = -(bmp.getWidth()/2);
        chushi = bmpX;
        //让位图绘制在画布的最下方，且图片Y坐标正好是（屏幕高-图片高）
        bmpY = this.getHeight() - bmp.getHeight();
    }

    @Override
    public void myDraw() {
        try {
            canvas = sfh.lockCanvas();
            if (canvas != null) {
                canvas.drawColor(Color.WHITE);
                canvas.drawBitmap(bmp, bmpX, bmpY, paint);
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
        super.logic();
        Log.i(TAG, "bmpX="+bmpX);
        bmpX += 5;
        if (bmpX >= 0 ){
            bmpX = chushi;
        }
    }
}
