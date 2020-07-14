package com.example.game;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;

import com.example.gameframework.AppManager;
import com.example.gameframework.GraphicObject;
import com.example.gameframework.IState;
import com.example.gameframework.R;

import java.util.ArrayList;
import java.util.Random;

public class GameState implements IState {
    private Player m_player;
    private int m_playerSpeed;
    private BackGround m_backGround;
    ArrayList<Enemy> m_enemyList = new ArrayList<>();
    ArrayList<Missile_Player> m_pmsList = new ArrayList<>();
    long lastRegenEnemy = System.currentTimeMillis();
    Random randEnemy = new Random();
    private int displayWidth;
    private int characterSize;

    @Override
    public void init() {
        Bitmap player = AppManager.getInstance().getBitmap(R.drawable.player);
        m_player = new Player(player);
        m_playerSpeed = 5;
        m_backGround = new BackGround(0);
        //m_keypad=new GraphicObject(AppManager.getInstance().getBitmap(R.drawable.keypad));
        //m_keypad.setPosition(0,460-120);

        displayWidth = AppManager.getInstance().getDisplayWidth();
        characterSize = player.getWidth() / 6;
    }

    @Override
    public void destroy() {
    }

    @Override
    public void update() {
        //애니메이션 동작을 위해
        long gameTime = System.currentTimeMillis();
        m_player.update(gameTime);
        m_backGround.update(gameTime);

        for (int i = m_pmsList.size() - 1; i >= 0; i--) {
            Missile_Player pms = m_pmsList.get(i);
            pms.update(); //미사일 발사
            //화면 밖으로 나간 객체를 각 리스트에서 제거
            if (pms.state == Missile.STATE_OUT) m_pmsList.remove(i);
        }

        for (int i = m_enemyList.size() - 1; i >= 0; i--) {
            Enemy enemy = m_enemyList.get(i);
            enemy.update(gameTime); //이동
            //화면 밖으로 나간 객체를 각 리스트에서 제거
            if (enemy.state == Enemy.STATE_OUT) m_enemyList.remove(i);
        }

        makeEnemy();
    }

    @Override
    public void render(Canvas canvas) {
        m_backGround.draw(canvas);
        for (Missile_Player pms : m_pmsList) pms.draw(canvas);
        for (Enemy enemy : m_enemyList) enemy.draw(canvas);
        m_player.draw(canvas);
        //m_keypad.draw(canvas);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //키 입력에 따른 플레이어 이동
        int x = m_player.getX();
        int y = m_player.getY();

        if (keyCode == KeyEvent.KEYCODE_DPAD_LEFT)
            m_player.setPosition(x - m_playerSpeed, y);
        if (keyCode == KeyEvent.KEYCODE_DPAD_RIGHT)
            m_player.setPosition(x + m_playerSpeed, y);
        if (keyCode == KeyEvent.KEYCODE_DPAD_UP)
            m_player.setPosition(x, y - m_playerSpeed);
        if (keyCode == KeyEvent.KEYCODE_DPAD_DOWN)
            m_player.setPosition(x, y + m_playerSpeed);
        if (keyCode == KeyEvent.KEYCODE_SPACE)
            m_pmsList.add(new Missile_Player(x, y + 30)); //미사일이 플레이어 위에

        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return false;
    }

    public void makeEnemy() {
        if (System.currentTimeMillis() - lastRegenEnemy >= 3000) { //생성 시점 이후 3초가 넘으면
            lastRegenEnemy = System.currentTimeMillis();

            int enemyType = randEnemy.nextInt(3);
            Enemy enemy = null;
            if (enemyType == 0) enemy = new Enemy_1();
            else if (enemyType == 1) enemy = new Enemy_2();
            else if (enemyType == 2) enemy = new Enemy_3();

            enemy.setPosition(randEnemy.nextInt(displayWidth - characterSize), -60);
            enemy.moveType = randEnemy.nextInt(3);

            m_enemyList.add(enemy);
        }
    }
}
