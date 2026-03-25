package hw2;
public class P2 {
	public static void main(String[] args) {
		int num = 49;
		int count = 0;

		for(int i = 1; i <= num; i++) {
			if(i % 10 != 4 && i / 10 != 4) {
				count++;
				System.out.print(i + " ");
			}
		}
		System.out.println("\n共" + count + "個"+"\n");
		
		for(int i = 10 ; i > 0 ; i--) {
			for(int j = 1 ; j <= i ; j++)
				System.out.print(j);
			System.out.println();
		}
	}
}