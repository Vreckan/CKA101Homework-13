package hw3;
import java.util.Arrays;
import java.util.Scanner;
public class Q3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("輸入討厭的數字: 0~9");
		int heat = sc.nextInt();
		int target = 6;
		int []putnum = new int[49];
		int []ans = new int [target];
		int count = 0 ;
		for(int i = 1;i <= 49; i++) {
			if(i%10==heat||i/10==heat)
				continue;
			putnum[count]=i;
			count++;
			System.out.print(i+"\t");
			if(count%6==0)
				System.out.println();
		}
		System.out.println("總共"+count+"個");
		for(int i = 0 ; i< target ; i++) {
			int num = (int)(Math.random()*(count-i));//count-i個位置
			int swap = putnum[num];
			putnum[num]=putnum[count-i-1];//index
			ans[i]=swap;
		}
		Arrays.sort(ans);
		System.out.println("\n隨機六碼為"+Arrays.toString(ans));
	}
}
