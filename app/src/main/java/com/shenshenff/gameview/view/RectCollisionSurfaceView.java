package com.shenshenff.gameview.view;

import android.content.Context;
import android.graphics.Color;
import android.view.MotionEvent;

/**
 * Created by Felix on 2016/11/9.
 */

public class RectCollisionSurfaceView extends ThreadSurfaceView {

    //定义所需的变量：
    //定义两个巨型的宽高坐标
    private int x1 = 100, y1 = 100, w1 = 200, h1 = 200;
    private int x2 = 600, y2 = 100, w2 = 200, h2 = 200;
    //便于观察是否发生了碰撞设置的一个标识位
    private boolean isCollsion;

    public RectCollisionSurfaceView(Context context) {
        super(context);
    }

    @Override
    public void myDraw() {
//        super.myDraw();
        try {
            canvas = sfh.lockCanvas();
            if (canvas != null) {
                canvas.drawRGB(0,0,0);
                //判断是否发生了碰撞
                if (isCollsion) {
                    paint.setColor(Color.RED);
                    paint.setTextSize(50);
                    canvas.drawText("发生碰撞!", getWidth()/2-100, getHeight()-200, paint);
                } else { //没发生碰撞
                    paint.setColor(Color.WHITE);
                }
                //绘制两个矩形
                canvas.drawRect(x1, y1, x1 + w1, y1 + h1, paint);
                canvas.drawRect(x2, y2, x2 + w2, y2 + h2, paint);
            }
        } catch (Exception e) {
        } finally {
            if (canvas != null) {
                sfh.unlockCanvasAndPost(canvas);
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
//        return super.onTouchEvent(event);
        x1 = (int) (event.getX() - w1/2);
        y1 = (int) (event.getY() - h1/2);
        //
        if (isCollsionWithRect(x1, y1, w1, h1, x2, y2, w2, h2)){//当矩形之间发生了碰撞
            isCollsion = true; //设置标识为真
        }else { //当矩形之间没有发生碰撞
            isCollsion = false;//设置标识为假
        }
        return true;
    }



    @Override
    public void logic() {
//        super.logic();
    }

    /**
     *
     * @param x1 第一个矩形的X坐标
     * @param y1 第一个矩形的Y坐标
     * @param w1 第一个矩形的宽
     * @param h1 第一个矩形的高
     * @param x2 第二个矩形的X坐标
     * @param y2 第二个矩形的Y坐标
     * @param w2 第二个矩形的宽
     * @param h2 第二个矩形的高
     * @return
     */
    public boolean isCollsionWithRect(int x1, int y1, int w1, int h1, int x2, int y2, int w2, int h2) {
        if (x1 >= x2 && x1 >= x2 + w2){
            return false;
        } else if (x1 <= x2 && x1 + w1 <= x2){
            return false;
        } else if (y1 >= y2 && y1 >= y2 + h2){
            return false;
        } else if (y1 <= y2 && y1 + h1 <= y2){
            return false;
        }
        //所有不会发生碰撞都不满足时，肯定就是碰撞了
        return true;
    }
}
