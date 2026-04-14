package hw6;

import java.util.Scanner;

public class CalTest {
//	final static int EXIT= 9527;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		final int EXIT= 9527;
		
		System.out.println("如要離開請輸入"+EXIT);

		while (true) {
			int x = readInt(sc,"請輸入x變數");
			if(x==EXIT) break;
			
			int y = readInt(sc,"請輸入y變數");
			if(y==EXIT) break;
			
			try {
				Calculator obj1 = new Calculator(x, y);
				System.out.println(obj1.powerXY());
			} catch (CalException e) {
				e.printStackTrace();
			}
		}
		System.out.println("終止");
		sc.close(); // 關閉底層資源 (System.in
	}
	
	public static int readInt(Scanner sc,String str) {
		while(true) {
			System.out.println(str);
			if(sc.hasNextInt()) {
				return sc.nextInt();
			}else {
				System.out.println("格式不正確　：　這不是整數");
				sc.next();
			}
		}
	}
}
