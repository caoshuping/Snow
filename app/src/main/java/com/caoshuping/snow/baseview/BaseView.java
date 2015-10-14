package com.caoshuping.snow.baseview;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by caoshuping on 2015/10/14.
 *
 */
public abstract class BaseView extends View {

    private boolean running = true;
    private MyThread thread;
    public BaseView(Context context) {
        super(context);
    }

    public BaseView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    protected abstract void drawSub(Canvas canvas);

    protected abstract void logic();

    protected abstract void init();

    @Override
    protected final void onDraw(Canvas canvas) {

        super.onDraw(canvas);

        drawSub(canvas);

        if(thread == null)
        {
            thread = new MyThread();
            thread.start();
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        running = false;
        super.onDetachedFromWindow();
    }

    class MyThread extends Thread{
        @Override
        public void run() {

            init();
            while(running)
            {
                logic();
                postInvalidate();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
