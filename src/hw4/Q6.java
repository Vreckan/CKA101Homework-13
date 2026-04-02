package hw4;

import java.util.Arrays;

public class Q6 {
	public static void main(String[] args) {
		int[][] scores = {
			    {10, 35, 40, 100, 90, 85, 75, 70},
			    {37, 75, 77, 89, 64, 75, 70, 95},
			    {100, 70, 79, 90, 75, 70, 79, 90},
			    {77, 95, 70, 89, 60, 75, 85, 89},
			    {98, 70, 89, 90, 75, 90, 89, 90},
			    {90, 80, 100, 75, 50, 20, 99, 75}
			};
		
		int [] num = new int [8];
		
		for(int times = 0 ; times < scores.length ; times++ ) {
			int max = scores[times][0] ;
			
			for (int number = 0; number < scores[0].length ; number++)
				if(scores[times][number] > max) {
					max = scores[times][number];
				}
			
			for (int number = 0; number < scores[0].length ; number++)
				if(scores[times][number] == max)
					num[number]++;
		}
		
//		System.out.print(Arrays.toString(num));
		for(int i = 0 ; i < scores[0].length;i++)
			System.out.println(i+1+"號得分最高"+num[i]+"次");//i 為index
	}
}
