package hw4;

import java.util.Arrays;

public class Q1 {
	public static void main(String[] args) {
		int [] target = {29, 100, 39, 41, 50, 8, 66, 77, 95, 15} ;
		int sum = 0 ;
		
		for(int i=0 ; i<target.length;i++)
			sum+=target[i];
		
		double avg = (sum/target.length);
		
		System.out.printf("大於平均%.0f:\n",avg);
		
		Arrays.sort(target);
		
		for(int i = 0;i<target.length;i++)
			if(target[i]>avg)
				System.out.print(target[i]+" ");
	}
}
