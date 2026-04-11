package hw5Game;


public abstract class Hero {
	// 省略 getter/setter...
	private String name;
	private int level;
	private double exp;
	private AttackBehavior attack;
	private IRunBehavior run;
	private IDefendBehavior defend;
	
	public Hero() {
		this("David", 1, 0);
	}
	
	public Hero(String name, int level, double exp) {
		this.name = name;
		this.level = level;
		this.exp = exp;
	}
	
	public void setattack(AttackBehavior attack) {
		this.attack=attack;
	}
	
	public void setmove(IRunBehavior run) {
		this.run=run;
	}

	public void setdefend(IDefendBehavior defend) {
		this.defend=defend;
		
	}
	protected void run() {
		run.run();
	}
	protected void defend() {
		defend.defend();
	}
	protected void attack() {
		attack.attack();
	}
	public String getName() {
		return name;
	}
}
