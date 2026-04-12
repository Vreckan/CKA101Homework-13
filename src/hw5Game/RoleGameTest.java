package hw5Game;

public class RoleGameTest {

	public static void main(String[] args) {
		Hero saber = new SwordMan("亞拉岡", 1, 0); // 晉升全部都是Hero型別
		Hero archer = new ArrowMan("勒苟拉斯", 1, 0);
		Hero priest = new PriestMan();

		Hero[] HeroArray = new Hero[3];

		HeroArray[0] = saber;
		saber.setattack(new AttackSword());

		HeroArray[1] = archer;
		archer.setattack(new AttackArrow());

		HeroArray[2] = priest;
		priest.setattack(new AttackMagic());

		for (int i = 0; i < HeroArray.length; i++) {
			System.out.print(HeroArray[i].getName() + " ");
			
			Hero hero = HeroArray[i];
			
			hero.setmove(new Run());
			hero.run();
			hero.attack();
		    // 故意不 override skill，改用 instanceof + 向下轉型展示子類別特有技能
			if (hero instanceof ArrowMan)
				((ArrowMan)hero).skillArrow();// 型別降轉使用子類別skill
			
			// 另一種寫法當 hero 是 SwordMan 時，instanceof 在判斷成立的同時，
			// 會自動完成安全的向下轉型，並將結果指派給變數 s（JDK16 pattern matching）
			// s 是已轉型完成的 SwordMan 參考變數，可直接呼叫子類別方法
			
			else if (hero instanceof SwordMan s)
			    s.skillSword();
			else if (hero instanceof PriestMan p)
				p.skillMagic();
			
			//無論如何都進行防禦
			try {
				hero.setdefend(new ShieldDefend());
			}catch(RoleGameException e){
				e.printStackTrace();
				try {
					hero.setdefend(new Defend());
				}catch(RoleGameException e2){
					e2.printStackTrace();
				}
			}finally{
				hero.defend();
			}
			System.out.println();
		}
	}
}
