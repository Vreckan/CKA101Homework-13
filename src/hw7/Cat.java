package hw7;

public class Cat extends Animal implements Speakable{
	private static final long serialVersionUID = 1L;
	
	public Cat(String name) {
		super(name);
	}
	
	public void speak() {
		System.out.println("This is Cat " + super.getName() + " speaking!");
	}
	
	public void sleep() {
		System.out.println("This is Cat " + super.getName() + " sleeping!");
	}
	
}
