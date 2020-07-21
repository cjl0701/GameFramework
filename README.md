# Android - GameFramework
### 슈팅 게임 제작에 활용할 수 있는 프레임워크 제작
##### 이를 기반으로 game 패키지에 간단한 슈팅 게임 제작

* game 특성상 빠른 그래픽 처리를 위해 surface view 사용
* game의 state에 따라 update, render, event handle 등이 달라짐  
  -동일한 인터페이스로 처리하기 위해 Design pattern 중 State pattern 사용
* 클래스 구조를 복잡한 graph 구조가 아닌 단순한 tree 구조로 사용하기 위해 AppManager를 만들어 클래스의 인스턴스를 전달
  -하나의 인스턴스만 사용해야 하므로 Singleton pattern 적용

