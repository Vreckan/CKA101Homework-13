package hw7;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
//請寫一隻程式,能夠亂數產生10個1~1000的整數,並寫入一個名為Data.txt的檔案裡 (請使用
//append功能讓每次執行結果都能被保存起來)

//不重複的10個整數Set型別的HashSet <>泛型 Number:只要是數字型態都能存取
//正常知道型別的話使用Integer就行因為這邊存取的是int不然就太泛 這邊故意使用Number練習
//泛型裡面要放參考型別(記憶體位址) 不能放一般型別(變數)

public class Q2 {
	public static void main(String[] args) {

		Set<Number> num = new HashSet<>(); //Set型別的泛型Number "num"

		while (num.size() < 10) { //當裡面內容<10個 1~1000不重複的整數
			num.add((int) (Math.random() * 1000 + 1));
		}
		System.out.print(num);// 印出Set num 的所有元素

		String path = System.getProperty("user.dir"); // 透過 static 方法 JVM 的工作目錄（程式目前執行的根目錄）
		File dir = new File(path, "src/hw7"); // 在jvm路徑下的src/hw7資料夾(dir)路徑

		if (!dir.exists()) {// dir hw7 不存在的話建一個
			dir.mkdirs();
		}
		File file = new File(dir, "Data.txt");// dir路徑下的Data.txt檔案(file)路徑

		// 必須確保 hw7 資料夾存在，否則 createNewFile() 會失敗 (需dir.mkdir 多個資料夾建立:mk.dirs

		try {// 嘗試在檔案路徑file 建立檔案"Data.txt"
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try (FileWriter fw = new FileWriter(file, true); // 低階IO鍊
				BufferedWriter bw = new BufferedWriter(fw);) {// 低接引給高階
			for (Number n : num) {// 語法糖 拿出每個Set裡的 Number ! 這裡抽出來的n是Number型別而非Integer型別 裝箱晉升
				bw.write(n.intValue() + " ");// 將Number轉型成int
			}
			bw.newLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
