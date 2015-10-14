package com.caoshuping.snow.myview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;

import com.caoshuping.snow.baseview.BaseView;
import com.caoshuping.snow.item.RainItem;

/**
 * Created by caoshuping on 2015/10/14.
 */
public class RainView extends BaseView {



    private RainItem rainItem;

    @Override
    protected void init(){
        rainItem = new RainItem(getWidth(),getHeight());
//        paint.setTextSize(30);
    }

    public RainView(Context context) {
        super(context);
        init();
    }

    public RainView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    @Override
    protected void logic() {
        rainItem.move();
    }

    @Override
    protected void drawSub(Canvas canvas) {
        rainItem.drawItem(canvas);

    }

}
