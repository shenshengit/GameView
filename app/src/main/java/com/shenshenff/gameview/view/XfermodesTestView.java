package com.shenshenff.gameview.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.Log;
import android.view.View;

import com.shenshenff.gameview.R;

import static android.content.ContentValues.TAG;

/**
 * Created by Felix on 2016/11/8.
 */

public class XfermodesTestView extends View {

    int screenW, screenH;
    int itemW;
    Paint mPaint;
    Bitmap mBitmap;
    Canvas mCanvas;

    public XfermodesTestView(Context context) {
        super(context);
        mPaint = new Paint();

        mPaint.setStrokeWidth(5);
        mPaint.setAntiAlias(true);
        mBitmap = Bitmap.createBitmap(600, 600, Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(mBitmap);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        screenW =  canvas.getWidth();
        screenH = canvas.getHeight();
        itemW = screenW/4;
        Log.i(TAG, "屏幕宽度： "+canvas.getWidth());
        Log.i(TAG, "屏幕高度： "+canvas.getHeight());

        //1.原始画布canvas
        //2.新建一个层
        //3.在层里画下底层Bitmap
        //4.创建一个Bitmap实例对象，并用这里对象创建一个新的Canvas画布实例
        //5.在新的画布里画出遮罩图形
        //6.设置模式
        //7.在原始画布中把带有图形和画布的Bitmap实例对象画入
        //8.提交层
        Bitmap background = BitmapFactory.decodeResource(getResources(), R.drawable.i_1);
        Bitmap mask = Bitmap.createBitmap(itemW, itemW, Bitmap.Config.ARGB_8888);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
        Canvas cc = new Canvas(mask);

        int sc = canvas.saveLayer(0, 0, itemW-5, itemW-5, null, Canvas.ALL_SAVE_FLAG);
        canvas.save();
        canvas.scale(0.3f, 0.3f);
        canvas.drawBitmap(background, 0, 0, null);
        canvas.restore();
//        cc.drawColor(Color.parseColor("#ffbbbbbb")); //如果设置 bitmap创建的画布 背景色就会出错
        cc.drawCircle(itemW/2, itemW/2, itemW/3, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        canvas.drawBitmap(mask, 0f, 0f, paint);
        paint.setXfermode(null);
        canvas.restoreToCount(sc);

        int sc1 = canvas.saveLayer(itemW, 0, itemW*2-5, itemW-5, null, Canvas.ALL_SAVE_FLAG);
        canvas.save();
        canvas.scale(0.3f, 0.3f,itemW,0);
        canvas.drawBitmap(background, itemW, 0, null);
        canvas.restore();
        cc.drawCircle(itemW/2, itemW/2, itemW/3, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST));
        canvas.drawBitmap(mask, itemW, 0f, paint);
        paint.setXfermode(null);
        canvas.restoreToCount(sc1);

        int sc2 = canvas.saveLayer(itemW*2, 0, itemW*3-5, itemW-5, null, Canvas.ALL_SAVE_FLAG);
        canvas.save();
        canvas.scale(0.3f, 0.3f,itemW*2,0);
        canvas.drawBitmap(background, itemW*2, 0, null);
        canvas.restore();
        cc.drawCircle(itemW/2, itemW/2, itemW/3, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
        canvas.drawBitmap(mask, itemW*2, 0f, paint);
        paint.setXfermode(null);
        canvas.restoreToCount(sc2);

        int sc3 = canvas.saveLayer(itemW*3, 0, itemW*4-5, itemW-5, null, Canvas.ALL_SAVE_FLAG);
        canvas.save();
        canvas.scale(0.3f, 0.3f,itemW*3,0);
        canvas.drawBitmap(background, itemW*3, 0, null);
        canvas.restore();
        cc.drawCircle(itemW/2, itemW/2, itemW/3, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        canvas.drawBitmap(mask, itemW*3, 0f, paint);
        paint.setXfermode(null);
        canvas.restoreToCount(sc3);

        int sc4 = canvas.saveLayer(0, itemW, itemW-5, itemW*2-5, null, Canvas.ALL_SAVE_FLAG);
        canvas.save();
        canvas.scale(0.3f, 0.3f,0,itemW);
        canvas.drawBitmap(background, 0, itemW, null);
        canvas.restore();
        cc.drawCircle(itemW/2, itemW/2, itemW/3, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(mask, 0f, itemW, paint);
        paint.setXfermode(null);
        canvas.restoreToCount(sc4);

        int sc5 = canvas.saveLayer(itemW, itemW, itemW*2-5, itemW*2-5, null, Canvas.ALL_SAVE_FLAG);
        canvas.save();
        canvas.scale(0.3f, 0.3f,itemW,itemW);
        canvas.drawBitmap(background, itemW, itemW, null);
        canvas.restore();
        cc.drawCircle(itemW/2, itemW/2, itemW/3, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        canvas.drawBitmap(mask, itemW, itemW, paint);
        paint.setXfermode(null);
        canvas.restoreToCount(sc5);

        int sc6 = canvas.saveLayer(itemW*2, itemW, itemW*3-5, itemW*2-5, null, Canvas.ALL_SAVE_FLAG);
        canvas.save();
        canvas.scale(0.3f, 0.3f,itemW*2,itemW);
        canvas.drawBitmap(background, itemW*2, itemW, null);
        canvas.restore();
        cc.drawCircle(itemW/2, itemW/2, itemW/3, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT));
        canvas.drawBitmap(mask, itemW*2, itemW, paint);
        paint.setXfermode(null);
        canvas.restoreToCount(sc6);

        int sc7 = canvas.saveLayer(itemW*3, itemW, itemW*4-5, itemW*2-5, null, Canvas.ALL_SAVE_FLAG);
        canvas.save();
        canvas.scale(0.3f, 0.3f,itemW*3,itemW);
        canvas.drawBitmap(background, itemW*3, itemW, null);
        canvas.restore();
        cc.drawCircle(itemW/2, itemW/2, itemW/3, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        canvas.drawBitmap(mask, itemW*3, itemW, paint);
        paint.setXfermode(null);
        canvas.restoreToCount(sc7);

        int sc8 = canvas.saveLayer(0, itemW*2, itemW-5, itemW*3-5, null, Canvas.ALL_SAVE_FLAG);
        canvas.save();
        canvas.scale(0.3f, 0.3f,0,itemW*2);
        canvas.drawBitmap(background, 0, itemW*2, null);
        canvas.restore();
        cc.drawCircle(itemW/2, itemW/2, itemW/3, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
        canvas.drawBitmap(mask, 0f, itemW*2, paint);
        paint.setXfermode(null);
        canvas.restoreToCount(sc8);

        int sc9 = canvas.saveLayer(itemW, itemW*2, itemW*2-5, itemW*3-5, null, Canvas.ALL_SAVE_FLAG);
        canvas.save();
        canvas.scale(0.3f, 0.3f,itemW,itemW*2);
        canvas.drawBitmap(background, itemW, itemW*2, null);
        canvas.restore();
        cc.drawCircle(itemW/2, itemW/2, itemW/3, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
        canvas.drawBitmap(mask, itemW, itemW*2, paint);
        paint.setXfermode(null);
        canvas.restoreToCount(sc9);

        int sc10 = canvas.saveLayer(itemW*2, itemW*2, itemW*3-5, itemW*3-5, null, Canvas.ALL_SAVE_FLAG);
        canvas.save();
        canvas.scale(0.3f, 0.3f,itemW*2,itemW*2);
        canvas.drawBitmap(background, itemW*2, itemW*2, null);
        canvas.restore();
        cc.drawCircle(itemW/2, itemW/2, itemW/3, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.XOR));
        canvas.drawBitmap(mask, itemW*2, itemW*2, paint);
        paint.setXfermode(null);
        canvas.restoreToCount(sc10);

        int sc11 = canvas.saveLayer(itemW*3, itemW*2, itemW*4-5, itemW*3-5, null, Canvas.ALL_SAVE_FLAG);
        canvas.save();
        canvas.scale(0.3f, 0.3f,itemW*3,itemW*2);
        canvas.drawBitmap(background, itemW*3, itemW*2, null);
        canvas.restore();
        cc.drawCircle(itemW/2, itemW/2, itemW/3, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DARKEN));
        canvas.drawBitmap(mask, itemW*3, itemW*2, paint);
        paint.setXfermode(null);
        canvas.restoreToCount(sc11);

        int sc12 = canvas.saveLayer(0, itemW*3, itemW*1-5, itemW*4-5, null, Canvas.ALL_SAVE_FLAG);
        canvas.save();
        canvas.scale(0.3f, 0.3f,0,itemW*3);
        canvas.drawBitmap(background, 0, itemW*3, null);
        canvas.restore();
        cc.drawCircle(itemW/2, itemW/2, itemW/3, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.LIGHTEN));
        canvas.drawBitmap(mask, 0, itemW*3, paint);
        paint.setXfermode(null);
        canvas.restoreToCount(sc12);

        int sc13 = canvas.saveLayer(itemW*1, itemW*3, itemW*2-5, itemW*4-5, null, Canvas.ALL_SAVE_FLAG);
        canvas.save();
        canvas.scale(0.3f, 0.3f,itemW*1,itemW*3);
        canvas.drawBitmap(background, itemW*1, itemW*3, null);
        canvas.restore();
        cc.drawCircle(itemW/2, itemW/2, itemW/3, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
        canvas.drawBitmap(mask, itemW*1, itemW*3, paint);
        paint.setXfermode(null);
        canvas.restoreToCount(sc13);

        int sc14 = canvas.saveLayer(itemW*2, itemW*3, itemW*3-5, itemW*4-5, null, Canvas.ALL_SAVE_FLAG);
        canvas.save();
        canvas.scale(0.3f, 0.3f,itemW*2,itemW*3);
        canvas.drawBitmap(background, itemW*2, itemW*3, null);
        canvas.restore();
        cc.drawCircle(itemW/2, itemW/2, itemW/3, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SCREEN));
        canvas.drawBitmap(mask, itemW*2, itemW*3, paint);
        paint.setXfermode(null);
        canvas.restoreToCount(sc14);

        int sc15 = canvas.saveLayer(itemW*3, itemW*3, itemW*4-5, itemW*4-5, null, Canvas.ALL_SAVE_FLAG);
        canvas.save();
        canvas.scale(0.3f, 0.3f,itemW*3,itemW*3);
        canvas.drawBitmap(background, itemW*3, itemW*3, null);
        canvas.restore();
        cc.drawCircle(itemW/2, itemW/2, itemW/3, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        canvas.drawBitmap(mask, itemW*3, itemW*3, paint);
        paint.setXfermode(null);
        canvas.restoreToCount(sc15);
    }
}
