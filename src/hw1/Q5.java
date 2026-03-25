package hw1;

public class Q5 {
	public static void main(String[] args) {
		double money = 1500000;
		int year = 10;
		double rate = 0.02;
		double result = money*Math.pow(1+rate, year);
		System.out.println((int)result);
	}
}
