package hw5Game;

public class RoleGameTest {

	public static void main(String[] args) {
		Hero saber = new SwordMan("亞拉岡", 1, 0); // 晉升全部都是Hero型別
		Hero archer = new ArrowMan("勒苟拉斯", 1, 0);
		Hero priest  = new PriestMan();// 設計:父類別第一轉是法師 後續可以轉弓箭/劍士

		Hero[] HeroArray = new Hero[3];

		HeroArray[0] = saber;
		saber.setattack(new AttackSword());

		HeroArray[1] = archer;
		archer.setattack(new AttackArrow());

		HeroArray[2] = priest;
		priest.setattack(new AttackMagic());

		for (int i = 0; i < HeroArray.length; i++) {
			System.out.print(HeroArray[i].getName() + " ");

			HeroArray[i].setdefend(new Defend());
			HeroArray[i].setmove(new Run());
			HeroArray[i].run();
			HeroArray[i].attack();

			if (HeroArray[i] instanceof ArrowMan)
				((ArrowMan) HeroArray[i]).skillArrow();// 型別降轉使用子類別skill
			else if (HeroArray[i] instanceof SwordMan)
				((SwordMan) HeroArray[i]).skillSword();
			else if (HeroArray[i] instanceof PriestMan)
				((PriestMan) HeroArray[i]).skillMagic();
			HeroArray[i].defend();
			System.out.println();
		}
	}
}
