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

	public void setdefend (IDefendBehavior defend) throws RoleGameException{
		this.defend=defend;
		
	}
	protected void run() {
		if(run != null) {
			run.run();
		}else {
			System.out.println(getName() + " 尚未設定跑步方式");
		}
	}
	protected void defend() {
		if(defend != null){
			defend.defend();
	    }else{
	        System.out.println(getName() + " 尚未設定防禦方式");
	    }
	}
	protected void attack() {
		if(attack != null) {
			attack.attack();
		}else {
			System.out.println(getName() + " 尚未設定攻擊方式");
		}
	}
	public String getName() {
		return name;
	}
}
