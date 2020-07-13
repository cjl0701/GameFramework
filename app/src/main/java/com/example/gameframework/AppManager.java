package com.example.gameframework;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

//이 프레임워크를 사용하는 애플리케이션을 관리
//AppManager를 통해 어느 클래스에서도 뷰와 리소스 등에 접근할 수 있도록
//SingleTon 패턴을 적용
public class AppManager {
    private static AppManager s_instance;

    private GameView m_gameView; //Main GameView
    private Resources m_resources; //Main GameView의 Resources

    private AppManager() { //외부에서 new 연산자로 인스턴스 생성 불가능
        super();
    }

    public static AppManager getInstance(){
        if(s_instance==null)
            s_instance=new AppManager();
        return s_instance;
    }

    //자주 쓰이는 비트맵 관련 기능 추가
    public Bitmap getBitmap(int r){
        return BitmapFactory.decodeResource(m_resources, r);
    }

    public GameView getGameView() {
        return m_gameView;
    }

    public void setGameView(GameView gameView) {
        this.m_gameView = gameView;
    }

    public Resources getResources() {
        return m_resources;
    }

    public void setResources(Resources resources) {
        this.m_resources = resources;
    }
}
