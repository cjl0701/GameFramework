# Framework for shooting game on Android   
슈팅 게임 제작에 활용할 수 있는 프레임워크 제작
>이를 기반으로 game 패키지에 간단한 슈팅 게임 제작   

<br><br>

### 프레임워크 구성 요소   
1. GameView : 화면 갱신. SurfaceView 기반의 빠른 그래픽 처리   
> game 특성상 빠른 그래픽 처리를 위해 surface view 사용   

2. GameViewThread : GameView에 렌더링할 스레드. 게임 루프가 돌아가는 기반   

3. IState 인터페이스 : 각 게임 상태에 State 패턴을 적용하기 위한 인터페이스   

4. GraphicObject : 그래픽을 그리기 위한 메소드를 모아 놓은 클래스   

5. SpriteAnimation : 애니메이션 효과를 표현하기 위한 클래스   

6. AppManager : 자주 쓰이는 뷰와 리소스에 접근하게 해주는 클래스   
> 클래스 구조를 복잡한 graph 구조가 아닌 단순한 tree 구조로 사용하기 위해 AppManager를 만들어 클래스의 인스턴스를 전달
  >- **하나의 인스턴스만 사용해야 하므로 Singleton pattern 적용**   

7. SoundManager : SoundPool 기반의 음향 효과 관련 클래스   

<br>
<br>

### 프레임워크 전체 구조
game의 state에 따라 update, render, event handle 등이 달라짐   
따라서 이를 **동일한 인터페이스로 처리하기 위해 State pattern 사용**   
<br>
![그림3](https://user-images.githubusercontent.com/55947154/113499845-4279c480-9554-11eb-8221-a1e2242767e3.png)



