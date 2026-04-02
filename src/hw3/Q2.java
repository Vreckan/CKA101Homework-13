package hw3;

import java.util.Scanner;

public class Q2 {
	public static void main(String[] args) {
		int ans = (int) (Math.random() * 101);
		int min = 0;
		int big = 100;
		System.out.println("input 0~100");
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int guess = sc.nextInt();
			if(guess<0||guess>100) {
				System.out.println("please input 0~100");
				continue;
			}
			if (guess > ans) {
				big = guess;
				System.out.println(min + "<" + "ans" + "<" + big);
			} else if (guess < ans) {
				min = guess;
				System.out.println(min + "<" + "ans" + "<" + big);
			}
			else
				System.out.println("bingo the ans is "+ans);
		}
	}
}
