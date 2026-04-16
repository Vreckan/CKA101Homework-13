package hw7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//請從無到有試著完成一個方法名為copyFile,這個方法有兩個參數。呼叫此方法時,第一個參數所
//代表的檔案會複製到第二個參數代表的檔案
//嘗試把Data as pathA覆蓋到Sample as pathB;
//這題把例外都丟出去 throws Throwable 所以不try catch
public class Q3 {
	public static void main(String[] args) throws Throwable {
		String JVMpath = System.getProperty("user.dir");
		File fileA = new File(JVMpath,"src/hw7/Data.txt");
		File fileB = new File(JVMpath,"src/hw7/Sample.txt");
		Q3.copyFile(fileA, fileB);
	}
	public static void copyFile(File fileA,File fileB) throws Throwable {
		//讀A覆蓋B
		FileReader frA = new FileReader(fileA);
		FileWriter fwB = new FileWriter(fileB);
		BufferedReader brA = new BufferedReader(frA);
		BufferedWriter bwB = new BufferedWriter(fwB);
		int ch; //用來暫存brA
		//這邊第一時間想到的是一個一個複製
		while((ch=brA.read())!=-1) {
			bwB.write(ch);
		}
		
		//實務上更常使用一行一行讀 
		//String line;
//		while ((line = brA.readLine()) != null) {
//        brB.write(line);
//        bwB.newLine(); // 保留換行
//    }
		
		brA.close();
		bwB.close();
	}
}
