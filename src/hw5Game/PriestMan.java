package hw5Game;

public class PriestMan extends Hero{
	public PriestMan() {
		super();
	}

	public PriestMan(String name, int level, double exp) {
		super(name, level, exp);
	}
	public void skillMagic() {
		System.out.println("技能 - 大火球術");
	}

}
