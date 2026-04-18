package hw7;

public class Dog extends Animal implements Speakable{
	private static final long serialVersionUID = 1L;
	
	public Dog(String name) {
		super(name);
	}
	
	public void speak() {
		System.out.println("This is Dog " + super.getName() + " speaking.");
	}
	
	public void sleep() {
		System.out.println("This is Dog " + super.getName() + " sleeping!");
	}
	
}
