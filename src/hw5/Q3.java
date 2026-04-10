package hw5;
public class Q3 {
	public static void main(String[] args) {
		int[][] intArray = {
				{1,6,3},
				{9,5,2}
		};
		double[][] doubleArray= {
				{1.2,3.5,2.2},
				{7.4,2.1,8.2}
		};	
		
		Q3 w = new Q3();
		System.out.println(w.maxElements(intArray));
		System.out.println(w.maxElements(doubleArray));
	}
	public int maxElements(int[][] intArray) {
		int max = intArray[0][0];
		for(int i = 0 ;i < intArray.length;i++)
			for(int j = 0 ;j<intArray[0].length;j++)
				max = Math.max(max,intArray[i][j]);
		return max;
	}
	public double maxElements(double[][] doubleArray) {
		double max = doubleArray[0][0];
		for(int i = 0 ;i < doubleArray.length;i++)
			for(int j = 0 ;j<doubleArray[0].length;j++)
				max = Math.max(max, doubleArray[i][j]);
		return max;
	}
}