package hw7;

import java.io.*;
import java.util.*;
//extends or interface 擇1 
public class Q4 {
	public static void main(String[] args) throws Exception {

		// 1. 建立資料夾 C:\data
		File dir = new File("C:/data");
		if (!dir.exists()) {
			dir.mkdirs();
		}

		// 2. 檔案位置
		File file = new File(dir, "Object.ser");

		// ===== 寫入物件 =====
		writeObjects(file);

		// ===== 讀取物件並呼叫 speak =====
		readObjects(file);
	}

	// 寫入（用 List）
	public static void writeObjects(File file) throws Exception {
		// Speakable陣列

		List<Speakable> list = new ArrayList<>();

		list.add(new Dog("dog1"));
		list.add(new Dog("dog2"));
		list.add(new Cat("cat1"));
		list.add(new Cat("cat2"));

		// or Animal陣列

		List<Animal> listA = new ArrayList<>();
		listA.add(new Dog("Dog1"));
		listA.add(new Dog("Dog2"));
		listA.add(new Cat("Cat1"));
		listA.add(new Cat("Cat2"));

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {

			oos.writeObject(list); // 一次寫整個 List
			oos.writeObject(listA); // 也把ListA寫入
			System.out.println("兩個 List 寫入完成");
		}
	}

	// 讀取（用 List）
	public static void readObjects(File file) throws Exception {

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {

			List<Speakable> list = (List<Speakable>) ois.readObject();
			List<Animal> listA = (List<Animal>) ois.readObject();

			System.out.println("=== 讀取 Speakable List ===");
			for (Speakable s : list) { //共同介面 Speakable
				s.speak();
			}

			System.out.println("=== 讀取 Animal List ===");
			for (Animal a : listA) { //Overrid 使用子類別sleep 物件是cat/dog 父類別Animal 
				a.sleep();
			}
			System.out.println("讀取完畢");
		}
	}
}