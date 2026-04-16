package hw7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
//請寫一個程式讀取這個Sample.txt檔案,並輸出以下訊息:
//Sample.txt檔案共有xxx個位元組,yyy個字元,zzz列資料

//練習使用java建一個Sample.txt 並覆蓋題目內容
//再讀Sample.txt取檔案輸出
public class Q1 {
	public static void main(String[] args) {
		String path = System.getProperty("user.dir"); // JVM 的工作目錄（程式目前執行的根目錄）
		File dir = new File (path,"src/hw7"); // 指向 src/hw7 資料夾的路徑（File 物件，未必存在）
		File file = new File (dir,"Sample.txt");// 指向 Sample.txt 檔案的路徑（尚未建立）
		
//		// 若檔案存在則刪除，確保每次重新建立新檔案
//		if (file.exists()) {
//		    file.delete();
//		}
//		// 建立檔案（若不存在）
//		try{
//			if(file.exists())
//				System.out.println("檔案已存在");
//			else {
//				file.createNewFile();
//				System.out.println("檔案第一次建立");
//			}
//		}catch(IOException e){
//			e.printStackTrace();
//		}
		//複寫進sample
		try {
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);// 建立 FileWriter（覆寫模式），檔案不存在時會自動建立，所以前面註解步驟可以省略
			fw.write("Java是一種電腦程式設計語言,擁有跨平台、物件導向、泛型程式設計的特性,廣泛應用於企業級Web應用開發和行動應用開發。\r\n"
					+ "任職於昇陽電腦的詹姆斯·高斯林等人於1990年代初開發Java語言的雛形,最初被命名為Oak,目標設定在家用電器等小型系統的程\r\n"
					+ "式語言,應用在電視機、電話、鬧鐘、烤麵包機等家用電器的控制和通訊。由於這些智慧型家電的市場需求沒有預期的高,Sun公\r\n"
					+ "司放棄了該項計劃。隨著1990年代網際網路的發展,Sun公司看見Oak在網際網路上應用的前景,於是改造了Oak,於1995年5月\r\n"
					+ "以Java的名稱正式釋出。Java伴隨著網際網路的迅猛發展而發展,逐漸成為重要的網路程式語言。\r\n"
					+ "Java程式語言的風格十分接近C++語言。繼承了C++語言物件導向技術的核心,Java捨棄了C++語言中容易引起錯誤的指標,改以\r\n"
					+ "參照取代,同時移除原C++與原來運算子多载,也移除多重繼承特性,改用介面取代,增加垃圾回收器功能。在Java SE 1.5版本中\r\n"
					+ "引入了泛型程式設計、類型安全的列舉、不定長參數和自動裝/拆箱特性。昇陽電腦對Java語言的解釋是:「Java程式語言是個簡單、\r\n"
					+ "物件導向、分布式、解釋性、健壯、安全與系統無關、可移植、高效能、多執行緒和動態的語言」");
			fw.close();// 關閉串流，並將緩衝區資料寫入檔案
		}catch(IOException e){
			e.printStackTrace();
		}
		long byteCount = file.length(); // 檔案位元組數
		int charCount = 0; // 字元數
		int lineCount = 0; // 列數
		
		//取出sample單獨char
		try (FileReader fr = new FileReader(file)){
			while(fr.read() != -1) {//
				charCount++;
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//取出sample列數
		try{
			FileReader fw = new FileReader(file);
			BufferedReader br = new BufferedReader(fw);
			while (br.readLine() != null) {
			    lineCount++;
			    
			}
			br.close();
		}catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("Sample.txt共有 :"+byteCount+"個位元組 "+charCount+"個字元數 "+lineCount+"列");
		
	}
}
