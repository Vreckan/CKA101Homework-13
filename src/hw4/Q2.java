package hw4;

public class Q2 {
	public static void main(String[] args) {
		String hi = "	Hello World		";
		String reversed = new StringBuilder(hi).reverse().toString().trim();
		
		System.out.println(reversed);
	}
}
