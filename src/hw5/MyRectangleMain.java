package hw5;

public class MyRectangleMain {
	public static void main(String[] args) {
		MyRectangle obj1 = new MyRectangle();
		obj1.setWidth(10);
		obj1.setDepth(20);
		
		System.out.println(obj1.getArea());
		
		MyRectangle obj2 = new MyRectangle(10,20);
		System.out.println(obj2.getArea());
	}
}
