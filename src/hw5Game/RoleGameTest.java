package hw5Game;

public class RoleGameTest {

	public static void main(String[] args) {
		Hero saber = new SwordMan("亞拉岡", 1, 0);
		Hero archer = new ArrowMan("勒苟拉斯", 1, 0);
		saber.setmove(new Run());
		saber.setdefend(new Defend());
		saber.setattack(new AttackSword());
		saber.run();
		saber.attack();
		
		archer.setmove(new Run());
		archer.setattack(new AttackArrow());
		archer.setdefend(new Defend());
		archer.run();
		archer.attack();
	}
}
