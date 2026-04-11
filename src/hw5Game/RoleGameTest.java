package hw5Game;

public class RoleGameTest {

	public static void main(String[] args) {
		Hero saber = new SwordMan("亞拉岡", 1, 0);
		Hero archer = new ArrowMan("勒苟拉斯", 1, 0);
		
		Hero [] HeroArray = new Hero[2];
		HeroArray [0] = saber;
		saber.setattack(new AttackSword());
		
		HeroArray  [1] = archer;
		archer.setattack(new AttackArrow());
		
		for(int i = 0 ; i < HeroArray.length ; i ++) {
			HeroArray[i].setdefend(new Defend());
			HeroArray[i].setmove(new Run());
			HeroArray[i].run();
			HeroArray[i].attack();
			HeroArray[i].defend();
		}
	}
}
