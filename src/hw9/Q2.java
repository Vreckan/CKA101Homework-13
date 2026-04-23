package hw9;

//以下為原題延伸改編版本	
//預設原本卡裡5555元
//每次大熊提款2000~3000元
//每當裡面>3000媽媽就不存款 媽媽每次存3000~4000元

//媽媽平常會巡邏，但因為有延遲(100MS)，通常是大雄先發現沒錢
//大雄沒錢就等
//媽媽下一輪如果看到可匯就匯
//最後大雄領滿 10 次後結束
public class Q2 {
	public static void main(String[] args) {
		Account bigbearCard = new Account(5555);
		Mom mom = new Mom(bigbearCard);
		BigBear bigbear = new BigBear(bigbearCard);
		Thread momT = new Thread(mom);
		Thread bearT = new Thread(bigbear);
		momT.start();
		bearT.start();
		try {
			momT.join();
			bearT.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("這輪大雄成功贓到:" + bigbearCard.getCount() + "元");
	}
}

class Mom implements Runnable {
	private Account acc;
	private int money;

	public Mom(Account acc) {
		this.acc = acc;
	}

	public void run() {
		int i = 1;
		while (!acc.getbearFinished()) {
			System.out.println("媽媽第" + i + "次嘗試匯款");
			money = (int) (Math.random() * 1001 + 3000);
			i++;
			acc.transfer(money);
			try {
			    Thread.sleep(100);
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
		}
	}
}

class BigBear implements Runnable {
	private Account acc;
	private int money;

	public BigBear(Account acc) {
		this.acc = acc;
	}

	public void run() {
		int i = 1;
		while (i <= 10) {
			System.out.println("大熊第" + i + "次嘗試提款");
			money = (int) (Math.random() * 1001 + 2000);
			acc.withDraw(money);
			i++;
			System.out.println();
		}
		acc.setbearFinished();
	}
}

class Account {
	private int money;
	private int count;
	private boolean bigbearFinished = false;

	public synchronized void setbearFinished() {
		this.bigbearFinished = true;
		notifyAll();
	}

	public synchronized boolean getbearFinished() {
		return bigbearFinished;
	}

	public Account(int money) {
		this.money = money; // 初始化int建構子
		System.out.println("大雄卡片初始值: " + money);
	}

	public synchronized void transfer(int money) {
		if (this.money > 3000) {
			System.out.println("媽媽檢查戶頭金額大於3000不轉帳");
			return;
		}

		this.money += money;
		System.out.println("媽媽已轉帳 : " + money + " 目前餘額: " + this.money);
		notifyAll();
	}

	public synchronized void withDraw(int money) {// 提款
		while (this.money < money) {
			System.out.println("餘額不足 : 想提款" + money + " 目前餘額 : " + this.money);
			System.out.println("通知媽媽匯錢");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.money -= money;
		this.count += money;
		System.out.println("大熊成功提款" + money + "元 戶頭剩" + this.money + "元");
		notifyAll();
	}

	public int getCount() {
		return count;
	}
}
