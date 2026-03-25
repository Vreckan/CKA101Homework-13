package hw1;
public class Q3 {
	public static void main(String[] args) {
		int sec = 256559;
		int day = 256559/60/24;
		int min = 256559/60%24;
		sec = sec%60;
		System.out.print("256559 為"+day+"天"+min+"分"+sec+"秒");
	}
}
