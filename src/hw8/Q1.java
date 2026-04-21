package hw8;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

//請建立一個Collection物件並將以下資料加入:
//Integer(100)、Double(3.14)、Long(21L)、Short(“100”)、Double(5.1)、“Kitty”、Integer(100)、
//Object物件、“Snoopy”、BigInteger(“1000”)
//
//• 印出這個物件裡的所有元素(使用Iterator, 傳統for與foreach)
//• 移除不是java.lang.Number相關的物件
//• 再次印出這個集合物件的所有元素,觀察是否已將非Number相關的物件移除成功
public class Q1 {
	public static void main(String[] args) {
		List l = new LinkedList<>();
		l.add(100);
		l.add(3.14);
		l.add(21L);
		l.add((short)100);
		l.add(5.1);
		l.add("Kitty");
		l.add(100);
		Object a = new Object(); 
		l.add(a);
		l.add("Snoopy");
		l.add(BigInteger.valueOf(1000));
		
		Iterator objs = l.iterator();
		while(objs.hasNext()) {
			System.out.print(objs.next()+" ");
		} //Iterator 像一個游標 走到最後就指向空
		
		System.out.println();
		for(int i = 0 ; i < l.size(); i++) {
			System.out.print(l.get(i)+" ");
		}
		
		System.out.println();
		for(Object o : l) {
			System.out.print(o+" ");
		}
		
		Iterator objs2 = l.iterator();
		
		while(objs2.hasNext()) {
			Object o = objs2.next();//
			if(!(o instanceof Number)) {//o是objs2的當前物件如果非Number就移除objs2
				objs2.remove();
				
			}
		}
		System.out.println();
		System.out.print(l);
	}
}
