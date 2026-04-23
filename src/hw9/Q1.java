package hw9;

import java.util.concurrent.CountDownLatch;

//• 開啓2個執行緒模擬饅頭人與詹姆士參加快胃王比賽所做的
//競賽過程。
//• 每個動作都以 Thread.sleep()暫停一下,以達到顯示效果。
//Sleep時間由亂數產生500~3000之間的毫秒數,如圖所示
//• 參考範例:CounterRunnable.java
//• 需留意主執行緒執行順序
//使用java.util.concurrent.CountDownLatch+awit+join 達到統一執行+等待+主程序等P1P2執行續完成
//當static winner為空時放入第一個吃完10碗的String
//建立一個static final object lock物件來決定誰有更改winner的權利(鑰匙)用來synchronized一次只有一個人有使用權 
public class Q1 {
	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(1); //int n  代表還需要n次CountDounLatch才放行
		System.out.println("大胃王比賽選手註冊 :饅頭人&詹姆士 ");
		CounterRunnable C1 = new CounterRunnable("饅頭人",latch);
		CounterRunnable C2 = new CounterRunnable("詹姆士",latch);
		Thread P1 = new Thread(C1); //建立執行續放入實作runnable的物件
		Thread P2 = new Thread(C2);
		P1.start();
		P2.start();//並未真的開始因為有latch
		System.out.println("大胃王比賽準備開始 主程序main 倒數3秒: ");
		for(int i = 3 ; i>0 ; i--) {
			System.out.println(i); //倒數321
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("比賽開始");
		latch.countDown();
		
		try {//讓主程序等P1P2程序執行完
			P1.join();
			P2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("比賽結束贏家是:"+CounterRunnable.getwinner());
	}
}
class CounterRunnable implements Runnable{
	private int eat = 0;
	private String name;
	private CountDownLatch latch;
	private static String winner = null;
	private static final Object LOCK = new Object();
	
	public CounterRunnable(String name , CountDownLatch latch) {
		this.name=name;
		this.latch=latch;
	}
	public void run(){
		try {
			latch.await();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		while(eat<10) {
			int sleep = (int)(Math.random()*2501+500);
			try {
				Thread.sleep(sleep);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			eat++;
			System.out.println(name+"已經吃完第"+eat+"碗");
			if(eat==10) {
				synchronized(LOCK) {
					System.out.println(name+"全吃完");
					if(winner == null)
						winner = name;
				}
			}
		}
	}
	public static String getwinner() {
		return winner;
	}
}