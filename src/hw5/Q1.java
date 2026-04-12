package hw5;
import java.util.Scanner;
public class Q1 {
	public static void main(String[] args) {
		Q1 target = new Q1();
		target.starSquare();
	}
	
	public void starSquare() {
		Scanner sc = new Scanner(System.in);
		System.out.println("輸入寬與高");
		int column = sc.nextInt();
		int row = sc.nextInt();
		for(int i = 0 ; i < row ; i++ ) {
			for(int j = 0 ; j < column ; j++)
				System.out.print("*");
			System.out.println();
		}
	}
}
