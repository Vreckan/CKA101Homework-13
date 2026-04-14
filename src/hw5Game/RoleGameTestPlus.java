package hw5Game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

// 將陣列改為動態 List，搭配 CreatAltFile 建立 txt 角色檔並導入 List
public class RoleGameTestPlus {

    public static void main(String[] args) {
        List<Hero> heroList = new LinkedList<>();

        // 原本內建角色
        Hero saber = new SwordMan("亞拉岡", 1, 0);
        Hero archer = new ArrowMan("勒苟拉斯", 1, 0);
        Hero priest = new PriestMan();

        saber.setattack(new AttackSword());
        archer.setattack(new AttackArrow());
        priest.setattack(new AttackMagic());

        heroList.add(saber);
        heroList.add(archer);
        heroList.add(priest);

        // 讀取 txt 新增角色
        String path = System.getProperty("user.dir") + "/src/hw5Game/creatHero.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);   // 目前先讀，不一定要用到
                String name = data[1];
                String job = data[2];
                int level = Integer.parseInt(data[3]);
                int exp = Integer.parseInt(data[4]);

                Hero hero = null;

                if (job.equals("swordman")) {
                    hero = new SwordMan(name, level, exp);
                    hero.setattack(new AttackSword());
                } else if (job.equals("arrowman")) {
                    hero = new ArrowMan(name, level, exp);
                    hero.setattack(new AttackArrow());
                } else if (job.equals("priest")) {
                    hero = new PriestMan(name, level, exp);
                    hero.setattack(new AttackMagic());
                }

                if (hero != null) {
                    heroList.add(hero);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // 執行角色流程
        for (int i = 0; i < heroList.size(); i++) {
            Hero hero = heroList.get(i);
            System.out.print(hero.getName() + " ");

            hero.setmove(new Run());
            hero.run();
            hero.attack();

            if (hero instanceof ArrowMan a)
                a.skillArrow();
            else if (hero instanceof SwordMan s)
                s.skillSword();
            else if (hero instanceof PriestMan p)
                p.skillMagic();

            try {
                hero.setdefend(new ShieldDefend());
            } catch (RoleGameException e) {
                e.printStackTrace();
                try {
                    hero.setdefend(new Defend());
                } catch (RoleGameException e2) {
                    e2.printStackTrace();
                }
            } finally {
                hero.defend();
            }

            System.out.println();
        }
    }
}