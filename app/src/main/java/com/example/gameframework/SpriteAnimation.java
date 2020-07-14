package com.example.gameframework;

import android.graphics.Bitmap;
import android.graphics.Rect;

//게임에서 움직임을 표현하는 SpriteAnimation
public class SpriteAnimation extends GraphicObject {

    private Rect m_rect; //그려줄 사각 영역
    private int m_fps; //초당 프레임
    private int m_iFrames; //프레임 개수
    private int m_frameTimer;
    private int m_currentFrame; //최근 프레임
    private int m_spriteWidth; //개별 프레임의 넓이
    private int m_spriteHeight; //개별 프레임의 높이

    public SpriteAnimation(Bitmap bitmap) {
        super(bitmap);
        m_rect = new Rect(0, 0, 0, 0);
        m_frameTimer = 0;
        m_currentFrame = 0;
    }

    public void initSpriteData(int width, int height, int fps, int iFrame){
        m_spriteWidth=width;
        m_spriteHeight=height;
        m_rect.top=0;
        m_rect.bottom=m_spriteHeight;
        m_rect.left=0;
        m_rect.right=m_spriteWidth;
        m_fps=1000/fps; //밀리초 단위 프레임
        m_iFrames = iFrame;
    }
}
