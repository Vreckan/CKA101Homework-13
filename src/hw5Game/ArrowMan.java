package hw5Game;

public class ArrowMan extends Hero{
	
	public ArrowMan() {
		super();
		
	}

	public ArrowMan(String name, int level, double exp) {
		super(name, level, exp);
	}
	public void skillArrow() {
		System.out.println("技能 - 多重箭矢");
	}
	
	public void setdefend(IDefendBehavior defend) throws RoleGameException{
		if (defend instanceof ShieldDefend) {
			//setdefend(new Defend()); fall back
			
			//new → 呼叫建構子 → super(message) → Exception 存 message 
			//→ throw 丟出去 → catch 接住 → getMessage()
	        throw new RoleGameException("弓箭手不能用盾牌！");
	    }
		super.setdefend(defend); //一般防禦
	}
}
