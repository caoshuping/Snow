package com.caoshuping.snow.myview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;

import com.caoshuping.snow.baseview.BaseView;
import com.caoshuping.snow.item.RainItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by caoshuping on 2015/10/14.
 */
public class RainView extends BaseView {



    private ArrayList<RainItem> rains = new ArrayList<RainItem>();
    private RainItem rainItem;

    @Override
    protected void init(){
        for(int i = 0; i < 200; i++)
        {
            rainItem = new RainItem(getWidth(),getHeight());
            rains.add(rainItem);
        }
        //rainItem = new RainItem(getWidth(),getHeight());
//        paint.setTextSize(30);
    }

    public RainView(Context context) {
        super(context);
        //init();
    }

    public RainView(Context context, AttributeSet attrs) {
        super(context, attrs);
       // init();
    }

    @Override
    protected void logic() {
        for(RainItem ri:rains)
        {
            ri.move();
        }
    }

    @Override
    protected void drawSub(Canvas canvas) {
        for(RainItem ri:rains)
        {
            ri.drawItem(canvas);
        }
    }

}
