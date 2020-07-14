package com.example.game;

import android.graphics.Bitmap;
import android.util.DisplayMetrics;

import com.example.gameframework.AppManager;
import com.example.gameframework.R;

public class Enemy_1 extends Enemy {
    public Enemy_1() {
        super(AppManager.getInstance().getBitmap(R.drawable.enemy1));

        hp = 10;
        speed = 3f;

        //애니메이션 정보 설정
        this.initSpriteData(m_bitmap.getWidth() / 6, m_bitmap.getHeight(), 5, 6);
    }

    @Override
    public void update(long gameTime) {
        super.update(gameTime);
    }
}
