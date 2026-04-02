package hw4;

public class Q3 {
	public static void main(String[] args) {
		String str="{“mercury”, “venus”, “earth”, “mars”, “jupiter”, “saturn”, “uranus”, “neptune”}";
		
		int count = 0;
		
		for(int i=0; i<str.length();i++) {
			if(str.charAt(i)=='a'||str.charAt(i)=='e'||str.charAt(i)=='i'
					||str.charAt(i)=='o'||str.charAt(i)=='u')
				count++;
		}
		
		System.out.println(count);
	}
}
