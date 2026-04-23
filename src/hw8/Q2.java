package hw8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Q2 {
	public static void main(String[] args) {

		Train t1 = new Train(202, "普悠瑪", "樹林", "花蓮", 400);
		Train t2 = new Train(1254, "區間", "屏東", "基隆", 700);
		Train t3 = new Train(118, "自強", "高雄", "台北", 500);
		Train t4 = new Train(1288, "區間", "新竹", "基隆", 400);
		Train t5 = new Train(122, "自強", "台中", "花蓮", 600);
		Train t6 = new Train(1222, "區間", "樹林", "七堵", 300);
		Train t7 = new Train(1254, "區間", "屏東", "基隆", 700);
		
		// 1. 只做排序(sort Comparable implements compareto)
		System.out.println("1. 依班次編號由大到小印出 (ArrayList + Collections.sort)");
		List<Train> list = new ArrayList<Train>();
		list.add(t1);
		list.add(t2);
		list.add(t3);
		list.add(t4);
		list.add(t5);
		list.add(t6);
		list.add(t7);
		
		Collections.sort(list);

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		// 2. 只做去重（HashSet 會用 hashCode() 與 equals() 判斷是否重複）
		System.out.println("\n2. 不重複的 Train 物件 (HashSet)");
		Set<Train> tS = new HashSet<Train>(list);
		Iterator<Train> it = tS.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}


		// // 3. 排序且去重（TreeSet 會用 compareTo() 排序，compareTo() == 0 視為重複）
		System.out.println("\n3. 不重複且排序的 Train 物件 (TreeSet)");
		Set<Train> tSs = new TreeSet<Train>(list);
		for (Train t : tSs) {
			System.out.println(t);
		}
		
	}
}