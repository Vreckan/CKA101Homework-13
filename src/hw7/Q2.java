	package hw7;
	
	import java.io.BufferedReader;
	import java.io.BufferedWriter;
	import java.io.File;
	import java.io.FileReader;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.util.ArrayList;
	import java.util.HashSet;
	import java.util.List;
	import java.util.Set;
	//請寫一隻程式,能夠亂數產生10個1~1000的整數,並寫入一個名為Data.txt的檔案裡 (請使用
	//append功能讓每次執行結果都能被保存起來)
	
	//不重複的10個整數Set型別的HashSet <>泛型 Number:只要是數字型態都能存取
	//正常知道型別的話使用Integer就行因為這邊存取的是int不然就太泛 這邊故意使用Number練習
	//泛型裡面要放參考型別(記憶體位址) 不能放一般型別(變數)
	
	//存放後再讀取出來目前Data.txt裡所有的Line 轉成 int 全部加總顯示再最後
	//用一個動態陣列Integer去存放從Data.txt讀取出來的Int;
	
	public class Q2 {
		public static void main(String[] args) {
	
			Set<Number> num = new HashSet<>(); //Set型別的泛型Number "num"
	
			while (num.size() < 10) { //當裡面內容<10個 1~1000不重複的整數
				num.add((int) (Math.random() * 1000 + 1));
			}
			
			System.out.println(num);// // 印出 Set num 的所有元素，Set 的 toString() 會自動補上 [] 和 ,
	
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
				for (Number n : num) {// 語法糖 add 時 int 會先自動裝箱成 Integer；因集合型別是 Set<Number>，所以取出時用 Number 接收
					bw.write(n  + " ");
					// n 實際上是 Integer 物件，但這裡以 Number 型別接收；與字串相加時會自動轉成字串寫入檔案
				}
				bw.newLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// 存放是String 日後讀取再用" "去切 然後praseInt 轉成Int
			try{
				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
				List<Integer> dataInt = new ArrayList<>();
				
				String line;
				int sum = 0;
				System.out.println("Data.txt 所有整數：");
				while ((line = br.readLine()) != null) { // 一行一行讀
					String[] arr = line.trim().split("\\s+"); // 用一個以上空白切開
					
					int nextline = 0;
					for (String s : arr) {
						int numValue = Integer.parseInt(s); // 字串轉 int
						dataInt.add(numValue); // 放入動態陣列
						System.out.printf("%4d",numValue);//順便印出來 4d:佔4個位置
						sum += numValue; // 加總
						nextline++;
						if(nextline%10==0) { //每10個自動換行
							System.out.println();
						}
					}
				}
				System.out.println("總和 = "+sum);
			}catch(IOException e) {
				e.printStackTrace();
			}
	
		}
	}
