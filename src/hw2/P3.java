package hw2;

public class P3 {
	public static void main(String[] args) {
		char target = 'F';
		for(int i = 0 ; i <= target-'A'; i++) {
			for(int j = 0 ; j <= i ; j++ )
				System.out.print((char)('A'+i));
			System.out.println();
		}
	}
}
