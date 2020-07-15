package com.example.game;

import android.graphics.Bitmap;
import android.graphics.Rect;

import com.example.gameframework.AppManager;
import com.example.gameframework.SpriteAnimation;

public class Enemy extends SpriteAnimation {
    protected int hp;
    protected float speed;
    public static final int MOVE_PATTERN_1 = 0;
    public static final int MOVE_PATTERN_2 = 1;
    public static final int MOVE_PATTERN_3 = 2;
    protected int moveType;
    private int displayHeight;
    private int tp; //패턴의 움직임이 바뀌는 지점

    public static final int STATE_NORMAL = 0;
    public static final int STATE_OUT = 1;
    public int state = STATE_NORMAL;

    Rect m_boundBox = new Rect();
    int width;
    int height;

    public Enemy(Bitmap bitmap) {
        super(bitmap);
        displayHeight = AppManager.getInstance().getDisplayHeight();
        tp = displayHeight / 2 + 40;
    }

    @Override
    public void update(long gameTime) { //이동
        super.update(gameTime); //애니메이션 프레임 변경
        move();
        if (m_y > displayHeight) state = STATE_OUT; //화면 밖에 나가면 삭제
    }

    void move() {
        if (moveType == MOVE_PATTERN_1) {
            if (m_y <= tp) m_y += speed; //중간 지점까지 기본 속도
            else m_y += speed * 2; //중간 지점 이후 빠른 속도

        } else if (moveType == MOVE_PATTERN_2) {
            if (m_y <= tp) m_y += speed; //중간 지점까지 일자로 이동
            else {//중간 지점 이후 대각선 이동
                m_x += speed;
                m_y += speed;
            }
        } else if (moveType == MOVE_PATTERN_3) {
            if (m_y <= tp) m_y += speed; //중간 지점까지 일자로 이동
            else {//중간 지점 이후 대각선 이동
                m_x -= speed;
                m_y += speed;
            }
        }
    }

    void attack() { }
}
