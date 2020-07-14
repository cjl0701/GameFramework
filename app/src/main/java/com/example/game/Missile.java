package com.example.game;

import android.graphics.Bitmap;

import com.example.gameframework.GraphicObject;

public class Missile extends GraphicObject {
    public static final int STATE_NORMAL=0;
    public static final int STATE_OUT=1;
    public int state = STATE_NORMAL;

    public Missile(Bitmap bitmap) {
        super(bitmap);
    }
}
