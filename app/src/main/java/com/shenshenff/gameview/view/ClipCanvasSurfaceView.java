package com.shenshenff.gameview.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;

import com.shenshenff.gameview.R;

/**
 * Created by Felix on 2016/11/8.
 */

public class ClipCanvasSurfaceView extends ThreadSurfaceView {

    Bitmap bmp ;

    public ClipCanvasSurfaceView(Context context) {
        super(context);
        bmp = BitmapFactory.decodeResource(this.getResources(), R.drawable.i_1);
    }

    @Override
    public void myDraw() {
//        super.myDraw();
        try {
            canvas = sfh.lockCanvas();
            if (canvas != null) {
                //画布抗锯齿
                PaintFlagsDrawFilter pfd = new PaintFlagsDrawFilter(0, Paint.ANTI_ALIAS_FLAG | Paint.FILTER_BITMAP_FLAG);
                canvas.setDrawFilter(pfd);
                paint.setAntiAlias(true);
                canvas.drawRGB(100, 0, 0);
                paint.setTextSize(50);
                canvas.drawText("AAA",100,100,paint);

                canvas.save();
                canvas.clipRect(300, 100, 800, 300);
//                canvas.drawRect(0, 0, this.getWidth(), this.getHeight(), paint);
                canvas.drawBitmap(bmp, screenW/2-bmp.getWidth()/2, -100, paint);
                canvas.restore();

                canvas.save();
                Path path = new Path();
                path.addCircle(screenW/2,600,200, Path.Direction.CCW);
                canvas.clipPath(path);
                canvas.drawBitmap(bmp, screenW/2-bmp.getWidth()/2, 600-bmp.getHeight()/2, paint);
                canvas.restore();

                canvas.save();
                RectF rectF = new RectF(100,800,300,1000);
                canvas.clipRect(rectF);
                canvas.drawBitmap(bmp, 0, 800, paint);
                canvas.restore();

                canvas.save();
                Region region = new Region();
                region.op(new Rect(20,20,100,100),Region.Op.UNION);//显示相交部分，其他不显示
                region.op(new Rect(40,20,80,150), Region.Op.XOR);//相交部分不现实，其他部分显示
                canvas.clipRegion(region);
                canvas.drawBitmap(bmp,0,0, paint);
                canvas.restore();

                int ss = canvas.saveLayer(screenW/2-bmp.getWidth()/2,1400-bmp.getHeight()/2,screenW/2+bmp.getWidth()/2,1400+bmp.getHeight()/2,null,Canvas.ALL_SAVE_FLAG);
                canvas.drawBitmap(bmp,screenW/2-bmp.getWidth()/2, 1400-bmp.getHeight()/2, null);
                Bitmap mask = Bitmap.createBitmap(bmp.getWidth(),bmp.getHeight(), Bitmap.Config.ARGB_8888);
                Canvas cvs = new Canvas(mask);
                paint.setColor(Color.RED);
//                cvs.drawColor(Color.parseColor("#ff222222"));
                cvs.drawCircle(bmp.getWidth()/2, bmp.getHeight()/2, 120, paint);
                paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
                canvas.drawBitmap(mask,screenW/2-bmp.getWidth()/2, 1400-bmp.getHeight()/2, paint);
                canvas.restoreToCount(ss);

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
