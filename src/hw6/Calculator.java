package hw6;

//請設計三個類別Calculator.java,CalException.java與CalTest.java,在Calculator.java裡有個自訂
//方法為powerXY(int x, int y),功能是會計算x的y次方並回傳結果。 CalTest.java執行後,使用者可
//以輸入x與y的值,請加入例外處理機制,讓程式能解決以下狀況:
//1. x與y同時為0,(產生自訂的CalException例外物件)
//2. y為負值,而導致x的y次方結果不為整數
//3. x與y皆正確情況下,會顯示運算後結果
public class Calculator {
	private int x;
	private int y;

	Calculator(int x, int y) throws CalException {

		if (x == 0 && y == 0)
			throw new CalException("0的0次方無意義");

		else if (y < 0)
			throw new CalException("負指數會產生非整數結果");

		this.x = x;
		this.y = y;
	}

/*	Calculator() {
	} 
 * 本類別不提供無參數建構子，原因如下：
 * 
 * 1. Calculator 的核心功能 powerXY() 依賴成員變數 x 與 y 進行運算。
 * 2. 若提供無參數建構子，物件建立時 x、y 會為預設值 0。
 * 3. 此時呼叫 powerXY() 可能進行 0^0 或其他不具意義的運算，造成邏輯錯誤。
 * 4. 為避免物件處於未初始化（invalid state）的狀態，本類別強制要求
 *    在建構時提供合法的 x 與 y。
 * 
 * 因此，不提供無參數建構子，以確保物件在建立時即為有效狀態。
 * 本類別採用「建構即有效（valid-by-construction）」的設計原則。
 * 
 * 補充：
 * 是否提供無參數建構子，應視物件是否允許未初始化狀態而定，
 * 並非所有情況下都適合搭配 setter 進行後續賦值。
 */
	
	public int powerXY() {
		return (int) (Math.pow(x, y));
	}

}
