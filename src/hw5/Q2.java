package hw5;
public class Q2 {
	public static void main(String[]args) {
		System.out.print(randAvg());
	}
	public static double randAvg() {
		int[] num = new int [10];
		int sum = 0;
		for(int i = 0 ; i <10 ; i++) {
			num[i]=(int)(Math.random()*100+1);
			System.out.print(num[i]+" ");
			sum+=num[i];		
		}
		System.out.println();
		return sum/10.0;
	}
}
