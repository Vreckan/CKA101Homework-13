package hw5Pen;

public class TestPen {
	public static void main(String[] args) {
		Pen myPencil = new Pencil();//型別晉升
		Pen myInkBrush = new InkBrush("def墨筆",50.0);
		myPencil.Setterbrand("abc鉛筆");
		myPencil.Setterprice(20.0);
		//myPencil = (Pencil)myPencil; ////型別降轉(當要使用子類別特有、父類別沒有的方法時才需要)
		System.out.println("品牌為"+myPencil.Getterbrand());
		System.out.println("價格為"+myPencil.Getterprice());
		myPencil.write();
		System.out.println("品牌為"+myInkBrush.Getterbrand());
		System.out.println("價格為"+myInkBrush.Getterprice());
		myInkBrush.write();
	}
}
