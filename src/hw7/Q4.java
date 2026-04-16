package hw7;

import java.io.*;
import java.util.*;

//!@#!@#!@#!@#!@#!#@!#!@這題還不太會 周末要用gameplus練習

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

        List<Speakable> list = new ArrayList<>();

        list.add(new Dog("dog1"));
        list.add(new Dog("dog2"));
        list.add(new Cat("cat1"));
        list.add(new Cat("cat2"));

        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(file))) {

            oos.writeObject(list); // 一次寫整個 List
            System.out.println("List寫入完成");
        }
    }

    // 讀取（用 List）
    public static void readObjects(File file) throws Exception {

        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(file))) {

            List<Speakable> list =
                    (List<Speakable>) ois.readObject();

            for (Speakable s : list) {
                s.speak(); // 多型
            }

            System.out.println("讀取完畢");
        }
    }
}