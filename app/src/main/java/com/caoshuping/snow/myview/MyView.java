package com.caoshuping.snow.myview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;

import com.caoshuping.snow.baseview.BaseView;

/**
 * Created by caoshuping on 2015/10/14.
 */
public class MyView extends BaseView {
    private Paint paint;
    private int startX;
    private int startY;
    public MyView(Context context) {
        super(context);
        init();
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init(){
        paint = new Paint();
        paint.setTextSize(30);
        paint.setARGB(255, 255, 255, 255);
        startX = 0;
        startY = 30;
    }



    @Override
    protected void drawSub(Canvas canvas) {
        canvas.drawText("This is a test Text!",startX,startY,paint);
    }

    @Override
    protected void logic() {
        startX+=10;
        if (startX > getWidth())
            startX = -(int)paint.measureText("This is a test Text!");
    }
}
