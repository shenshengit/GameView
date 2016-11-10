package com.shenshenff.gameview.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;

import com.shenshenff.gameview.R;

/**
 * Created by shenshen on 2016/11/8.
 */

public class AnimationSurfaceView extends View {

    Animation mAnimation ;

    public AnimationSurfaceView(Context context) {
        super(context);

    }

//    @Override
//    public void myDraw() {
////        super.myDraw();
//        try {
//            canvas = sfh.lockCanvas();
//            if (canvas != null) {
//                canvas.drawRGB(0, 100, 0);
//                paint.setTextSize(60);
//                canvas.drawText("shen", getWidth()/2, getHeight()/2, paint);
//            }
//        } catch (Exception e) {
//
//        } finally {
//            if (canvas != null) {
//                sfh.unlockCanvasAndPost(canvas);
//                flag = false;
//            }
//        }
//    }
//
//    @Override
//    public void logic() {
////        super.logic();
//    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.GREEN);
        Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);

        canvas.drawBitmap(bmp, getWidth()/2 - bmp.getWidth()/2, getHeight()/2- bmp.getHeight()/2, null);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mAnimation = new RotateAnimation(0.0f,3600f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF, 0.5f);
        mAnimation.setDuration(5000);
        this.startAnimation(mAnimation);
        return true;
    }
}
