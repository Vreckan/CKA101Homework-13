package hw3;

import java.util.Scanner;

public class Q1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("請輸入三個正整數");
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int sum = a + b + c;
		int max = Math.max(a, Math.max(c, b));
		int min = Math.min(a, Math.min(c, b));
		int mid = sum-max-min;
		
		if (a <= 0 || b <= 0 || c <= 0)
			System.out.println("不是三角形");
		else if (a == b && b == c)
				System.out.println("是正三角形");
		else if (max>= sum - max) { //=是直線	
			System.out.println("無法組成三角形");
		}
		else if(Math.pow(max, 2)==Math.pow(min, 2)+Math.pow(mid, 2))
			if(a==b||b==c||c==a)
				System.out.println("等腰直角三角形");
			else
				System.out.println("直角三角形");
		else if(a==b||b==c||c==a)
			System.out.println("等腰三角形");
		else
			System.out.println("其它三角形");
	}
}
