package com.shenshenff.gameview.view;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;

import static android.content.ContentValues.TAG;

/**
 * Created by Felix on 2016/11/7.
 */

public class CanvasSurfaceView extends ThreadSurfaceView {

    int i = 1256;

    public CanvasSurfaceView(Context context) {
        super(context);
    }

    @Override
    public void myDraw() {
        //super.myDraw();
        try {
            canvas = sfh.lockCanvas();
            if (canvas != null) {
                canvas.drawRGB(0, 0, 0);
                canvas.setDrawFilter(new PaintFlagsDrawFilter(0, Paint.ANTI_ALIAS_FLAG | Paint.FILTER_BITMAP_FLAG));
                //                paint.setAntiAlias(true);
                //绘制文本
                paint.setTextSize(60);
                canvas.drawText("AAA", 50, 50, paint);
                //绘制像素点
                canvas.drawPoint(100, 100, paint);
                //绘制多个像素点
                canvas.drawPoints(new float[]{100, 110, 110, 110}, paint);
                //绘制直线
                canvas.drawLine(100, 140, 500, 140, paint);
                //绘制多条直线
                canvas.drawLines(new float[]{100, 200, 200, 200, 300, 200, 400, 200, 500, 200, 600, 220}, paint);
                //绘制矩形
                canvas.drawRect(100, 250, 300, 350, paint);
                //绘制矩形2
                Rect rect = new Rect(100, 400, 400, 600);
                canvas.drawRect(rect, paint);
                //绘制圆角矩形
                RectF rectF = new RectF(100, 650, 400, 800);
                canvas.drawRoundRect(rectF, 60, 60, paint);
                //绘制圆形
                canvas.drawCircle(200, 900, 100, paint);
                //绘制弧形
                canvas.drawArc(new RectF(100, 1050, 300, 1250), 180, 90, true, paint);
                //绘制椭圆
                canvas.drawOval(new RectF(100, 1250, 300, 1350), paint);

                //                paint.setStyle(Paint.Style.STROKE);
                //绘制指定路径图形
                Path path = new Path();
                //设置路径起点
                path.moveTo(100, 1400);
                //线路1
                path.lineTo(200, 1400);
                //线路2
                path.lineTo(150, 1450);
                //路径结束
                path.close();
                canvas.drawPath(path, paint);

                //绘制指定路径图形
                Path pathCircle = new Path();
                //添加一个圆形的路径
                pathCircle.addCircle(screenW/2,1500, 200, Path.Direction.CCW);
                //Path.Direction.CW 文字在路径外面
                //Path.Direction.CCW 文字在路径里面
                //绘制带圆形的路径文本
                canvas.drawTextOnPath("shenshenshenshenshenshenshenshen", pathCircle, i, 0, paint);

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
        i = i-5;
        Log.i(TAG, "logic: " + i);
        if (i < -1200 ){
            i = 1256;
        }
    }
}
