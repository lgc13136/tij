package org.lgc.tij.holding;

import org.lgc.tij.typeinfo.pets.*;

import java.util.*;

import static net.mindview.util.Print.*;
/**
 * Created by lgc on 16-12-13.
 */
public class ListFeatures {
    public static void main(String[] args) {
        Random rand = new Random();
        ArrayList<Pet> pets = Pets.arrayList(7);
        print("1:" + pets);
        Hamster h = new Hamster();
        pets.add(h);
        print("2:" + pets);
        print("3:" + pets.contains(h)); // 是否包含对象
        pets.remove(h);
        Pet p = pets.get(2);
        print("4:" + p + " " + pets.indexOf(p)); // indexOf返回该对象在List中所处位置的索引编号
        Cymric cymric = new Cymric();
        print("5:" + pets.indexOf(cymric)); // indexOf不存在的对象，返回-1
        print("6:" + pets.remove(cymric)); // 移除不存在的对象，返回false
        print("7:" + pets.remove(p)); // 移除存在的对象，返回true
        print("8:" + pets);
        pets.add(3, new Mouse()); // 在位置3中添加元素，原先位置3之后的元素后移，对于ArrayList来说操作代价大
        print("9:" + pets);
        List<Pet> sub = pets.subList(1, 4); // 取出了位置1,2,3的元素
        print("subList:" + sub);
        print("10:" + pets.containsAll(sub)); // 返回true
        Collections.sort(sub); // 对子表排序
        print("sorted subList:" + sub);
        print("11:" + pets.containsAll(sub)); // 返回true，说明子表的顺序并不影响containsAll的结果
        Collections.shuffle(sub, rand); // 打乱了子表
        print("12:" + pets.containsAll(sub));// 返回true
        ArrayList<Pet> copy = new ArrayList<Pet>(pets);
        sub = Arrays.asList(pets.get(1), pets.get(4));
        print("sub:" + sub);
        copy.retainAll(sub); // 取交集
        print("13:" + copy);
        copy = new ArrayList<Pet>(pets);
        copy.remove(2);// 按索引移除
        print("14:" + copy);
        copy.removeAll(sub); // 在copy中移除所有在sub中的元素
        print("15:" + copy);
        copy.set(1, new Mouse()); // 替换位置1的元素
        print("16:" + copy);
        copy.addAll(2,sub); // 从中间插入元素
        print("17:" + copy);
        print("18:" + pets.isEmpty());
        pets.clear(); // 移除所有的元素
        print("19:" + pets);
        print("20:" + pets.isEmpty());
        pets.addAll(Pets.arrayList(4));
        print("21" + pets);
        Object[] o = pets.toArray(); // toArray无参数版本返回的是Object数组
        print("22:" + o[3]);
        // 向toArray传递目标类型数据，那么它将产生指定类型的数据。
        // 如果参数数组太小，存放不下List中所有的元素，toArray方法将创建一个具有合适尺寸的数组
        Pet[] pa = pets.toArray(new Pet[0]);
        print("23:" + pa[3].id());

    }
}
