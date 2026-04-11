package hw5Game;

public class RoleGameTest {

	public static void main(String[] args) {
		Hero saber = new SwordMan("亞拉岡", 1, 0);
		Hero archer = new ArrowMan("勒苟拉斯", 1, 0);
		Hero David = new Hero();//預設父類別空建構子name David可以直升法師
		
		Hero [] HeroArray = new Hero[3];
		HeroArray [0] = saber;
		saber.setattack(new AttackSword());
		
		HeroArray  [1] = archer;
		archer.setattack(new AttackArrow());
		
		HeroArray  [2] = David;
		David.setattack(new AttackMagic());

		for(int i = 0 ; i < HeroArray.length ; i ++) {
			HeroArray[i].setdefend(new Defend());
			HeroArray[i].setmove(new Run());
			HeroArray[i].run();
			HeroArray[i].attack();
			HeroArray[i].defend();
			System.out.println();
		}
	}
}
