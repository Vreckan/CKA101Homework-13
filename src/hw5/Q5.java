package hw5;

public class Q5 {
	public static void main(String[] args) {
		Q5 target = new Q5();
		char[] code = target.getAuthCode();
		for (int i = 0; i < 8; i++) {
			System.out.print(code[i]);
		}
		String pool = "0123456789abcdefghijklmnopqrstuvwxyz";
		System.out.println(pool.charAt(36));
	}

	public char[] getAuthCode() {
		int random;
		char[] code = new char[8];
		
		for (int i = 0; i < 8; i++) {
			
			random = (int)(Math.random() * 3) + 1;
			
			if (random == 1)
				code[i] = (char)('0' + (int)(Math.random() * 10));
			else if (random == 2)
				code[i] = (char)('a' + (int)(Math.random() * 26));
			else
				code[i] = (char)('A' + (int)(Math.random() * 26));
		}
		return code;
	}
}