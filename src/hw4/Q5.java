package hw4;

import java.util.Scanner;

public class Q5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int year, month, day;
		int count = 0;
		
		System.out.print("請輸入年份：");
		year = sc.nextInt();

		System.out.print("請輸入月份：");
		month = sc.nextInt();

		// 檢查月份
		while (month < 1 || month > 12) {
			System.out.print("月份錯誤，請輸入 1~12：");
			month = sc.nextInt();
		}
		int[] days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		// 判斷閏年
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			days[1] = 29;
		}
		
		System.out.print("請輸入日期：");
		day = sc.nextInt();

		// 檢查日期長度不能超過該月份最後一天
		while (day < 1 || day > days[month - 1]) {
			System.out.print("日期錯誤，請輸入 1~" + days[month - 1] + "：");
			day = sc.nextInt();
		}

		for (int i = 0; i < month - 1; i++) {
			count += days[i];
		}

		count += day;
		System.out.println("輸入的日期為該年的第 " + count + " 天");
	}
}