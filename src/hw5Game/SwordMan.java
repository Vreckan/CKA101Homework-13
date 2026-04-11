package hw5Game;

public class SwordMan extends Hero {
	
	public SwordMan() {
		super();
	}
	
	public SwordMan(String name, int level, double exp) {
		super(name, level, exp);
	}
	public void skillSword() {
		System.out.println("技能 - 劍氣斬擊");
	}
}
