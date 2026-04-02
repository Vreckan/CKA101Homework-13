package hw4;
import java.util.Scanner;
public class Q4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int [][] target = {{25,2500},{32,800},{8,500},{19,1000},{27,1200}};
		
		System.out.println("輸入想借的金額");
		
		int want = sc.nextInt();
		int count = 0;
		
		System.out.print("員工編號:");
		
		for(int i=0;i<target.length;i++) {
			if(target[i][1]>want) {
				count++;
				System.out.print(target[i][0]+" ");
			}
		}
		
		System.out.print("共"+count+"人");
	}
}
