package com.example.game;

import android.graphics.Bitmap;
import android.util.DisplayMetrics;

import com.example.gameframework.AppManager;
import com.example.gameframework.GameActivity;
import com.example.gameframework.SpriteAnimation;

public class Player extends SpriteAnimation {
    public Player(Bitmap bitmap) {
        super(bitmap);
        //애니메이션 정보 설정
        this.initSpriteData(bitmap.getWidth()/6,bitmap.getHeight(),5,6);

        //초기 위치 값을 설정
        int displayWidth = AppManager.getInstance().getDisplayWidth();
        int displayHeight = AppManager.getInstance().getDisplayHeight();
        this.setPosition((displayWidth-bitmap.getWidth()/6)/2, (int)(displayHeight*0.8));
    }
}
