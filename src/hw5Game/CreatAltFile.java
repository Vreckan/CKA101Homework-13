package hw5Game;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreatAltFile {

    public static void main(String[] args) {
        String path = System.getProperty("user.dir");
        File file = new File(path + "/src/hw5Game/creatHero.txt");

        try {
            if (file.createNewFile()) {
                System.out.println("檔案建立成功");
            } else {
                System.out.println("檔案已存在");
            }

            FileWriter fw = new FileWriter(file, false); // false = 覆蓋重寫
            BufferedWriter bw = new BufferedWriter(fw); //加入緩衝
            bw.write("4,波羅莫,swordman,1,0\n");
            bw.write("5,羅賓漢,arrowman,1,0\n");
            bw.write("6,梅林,priest,1,0\n");
            bw.close();
            
            System.out.println("角色資料寫入完成");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}