package com.example.game;

import com.example.gameframework.AppManager;
import com.example.gameframework.R;

public class Enemy_2 extends Enemy {
    public Enemy_2() {
        super(AppManager.getInstance().getBitmap(R.drawable.enemy2));

        hp=20;
        speed=2f;

        //애니메이션 정보 설정
        this.initSpriteData(m_bitmap.getWidth()/6,m_bitmap.getHeight(),5,6);
    }

    @Override
    public void update(long gameTime) {
        super.update(gameTime);
    }
}
