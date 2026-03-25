package hw2;

public class p1 {
	public static void main(String[] args) {
		int sum = 0;
		for (int i = 0; i <= 1000; i++) {
			if (i % 2 == 0) {
				sum += i;
			}
		}
		System.out.println(sum);
		int sum1 = 1;
		for (int i = 1; i <= 10; i++) {
			sum1 *= i;
		}
		System.out.println(sum1);
		
		int sum2 = 1;
		int count = 1;
		while (count <= 10) {
			sum2 *= count;
			count++;
		}
		System.out.println(sum2);
		for(int i = 1 ; i <= 10 ; i++) {
			System.out.print(i*i+" ");
		}
	}

}
