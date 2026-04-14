package hw6;

import java.util.Scanner;

public class CalTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("如要離開請輸入9527");

		while (true) {
			int x, y;

			System.out.println("請輸入x變數");
			if (!sc.hasNextInt()) {
				System.out.println("格式不正確:這不是整數");
				sc.next(); // 把錯誤輸入吃掉
				continue;
			} else {
				x = sc.nextInt();
				if (x == 9527)
					break;
			}

			System.out.println("請輸入y指數");
			if (!sc.hasNextInt()) {
				System.out.println("格式不正確:這不是整數");
				sc.next(); // 把錯誤輸入吃掉
				continue;
			} else {
				y = sc.nextInt();
				if (y == 9527)
					break;
			}

//			try {
				Calculator obj1 = new Calculator();
				System.out.println(obj1.powerXY());
//			} catch (CalException e) {
//				e.printStackTrace();
//			}

		}
		System.out.println("9527終止");
		sc.close(); // 關閉底層資源 (System.in
	}
}