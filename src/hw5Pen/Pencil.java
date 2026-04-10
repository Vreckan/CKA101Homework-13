package hw5Pen;

public class Pencil extends Pen{
	public Pencil() {
	}
	
	public Pencil(String brand,double price) {
	    super(brand, price);
	}
	
	public double Getterprice() {
		return super.Getterprice()*0.8;
	}
	
	@Override
	public void write() {
		System.out.println("削鉛筆再寫");
	}
}
