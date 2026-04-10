package hw5Pen;

public class InkBrush extends Pen {
	public InkBrush(String brand,double price) {
		super(brand,price);
	}
	
	public InkBrush() {
		
	}
	
	public void write() {
        System.out.println("沾墨汁再寫");
    }
	
	public double Getterprice() {
		return super.Getterprice()*0.9;
	}

}
