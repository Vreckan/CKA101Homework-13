package hw5Game;

public class ArrowMan extends Hero {
	
	public ArrowMan() {
		super();
	}

	public ArrowMan(String name, int level, double exp) {
		super(name, level, exp);
	}
	public void skillArrow() {
		System.out.println("技能 - 多重箭矢");
	}
}
