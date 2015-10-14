package com.caoshuping.snow.item;

import android.graphics.Canvas;

/**
 * Created by caoshuping on 2015/10/14.
 */
public abstract class BaseItem {

    private int startX;
    private int startY;
    private int stopX;
    private int stopY;

    public BaseItem() {
        this.startX = 0;
        this.startY = 0;
        this.stopX = 0;
        this.stopY = 0;
    }

    public abstract void drawItem(Canvas canvas);

    public abstract void move();


}
