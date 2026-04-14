package hw6;

public class CalException extends Exception{
	public CalException() { //無參數建構子 編譯器（compiler）自動補 增加可讀性
		super();//繼承Exception無參數建構子
	}
	public CalException(String s) {//呼叫父類別的建構子並傳入錯誤訊息
		super(s);
	}
}
