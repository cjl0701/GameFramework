package com.example.game;

import android.graphics.Bitmap;

import com.example.gameframework.AppManager;
import com.example.gameframework.R;

public class Missile_Player extends Missile{

    public Missile_Player(int x, int y) {
        super(AppManager.getInstance().getBitmap(R.drawable.missile_1));
        this.setPosition(x,y); //x, y는 미사일 발사 위치
    }

    public void update(){
        m_y-=3; //미사일이 위로 발사되는 효과를 준다
        if(m_y<0) state=STATE_OUT; //화면 밖을 벗어나면 제거
    }
}
