package hw4;

public class Q3 {
	public static void main(String[] args) {
		String [] str={"mercury", "venus", "earth", "mars", "jupiter", "saturn", "uranus", "neptune"};
		
		int count = 0;
		
		for(int i=0; i<str.length;i++) {
			for(int j=0; j<str[i].length();j++) {
				char target = str[i].charAt(j);
				if(target=='a'||target=='e'||target=='i'||target=='o'||target=='u')
					count++;
			}
		}
		
		System.out.println(count+"個母音	");
	}
}
