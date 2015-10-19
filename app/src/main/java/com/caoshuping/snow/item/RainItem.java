package com.caoshuping.snow.item;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.Random;

/**
 * Created by caoshuping on 2015/10/14.
 */
public class RainItem extends BaseItem{

    private int startX;
    private int startY;
    private int stopX;
    private int stopY;
    private int rainSizeX;
    private int rainSizeY;
    private int screenWidth;
    private int screenHeight;
    //private float maxRainRapid;
    private float rainRapid;
    private Paint paint;
    private Random random;
    private int rainSize;

    private void randomRain(){
        random = new Random();
        startX = random.nextInt(screenWidth);
        startY = random.nextInt(screenHeight/2);
        rainSizeX = -5 + random.nextInt(rainSize);
        rainSizeY = 10 + random.nextInt(rainSize);
        rainRapid = 0.2f + random.nextFloat();
    }
    private void init() {
        randomRain();
        stopX = startX + rainSizeX;
        stopY = startY + rainSizeY;
        paint = new Paint();
        paint.setARGB(255, 255, 255, 255);
    }

    public RainItem(int screenWidth, int screenHeight) {

        rainSize = 10;
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        init();
    }

    public RainItem(int rainSize, int screenWidth, int screenHeight) {
        this.rainSize = rainSize;
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        init();
    }

    @Override
    public void drawItem(Canvas canvas) {
        canvas.drawLine(startX,startY,stopX,stopY,paint);

    }

    @Override
    public void move() {
        startY += rainSizeY*rainRapid;
        stopY += rainSizeY*rainRapid;

        startX += rainSizeX*rainRapid;
        stopX += rainSizeX*rainRapid;
        if(startY > screenHeight)
        {
            randomRain();
            stopX = startX + rainSizeX;

            stopY = startY + rainSizeY;
        }
    }
}
