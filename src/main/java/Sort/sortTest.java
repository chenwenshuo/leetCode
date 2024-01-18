package Sort;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class sortTest {
    public static void main(String[] args) throws ParseException {
        List<Inventory> list = new ArrayList<>();
        list.add(new Inventory("01/01/2021", "01/01/2022"));
        list.add(new Inventory("02/01/2022", "01/01/2023"));
        list.add(new Inventory("01/01/2023", "01/01/2025"));
        list.add(new Inventory("02/01/2022", "01/01/2026"));
        //调用sort方法
        list.sort((o1, o2) -> {
            //按照start升序排列
            if (o1.getStart().after(o2.getStart())) {
                return 1;
            } else if (o1.getStart().before(o2.getStart())) {
                return -1;
            } else {
                if (o1.getEnd().after(o2.getEnd())) {
                    return 1;
                } else if (o1.getEnd().before(o2.getEnd())) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        Set<Inventory> success = new HashSet<>();
        Set<Inventory> error = new HashSet<>();
        Inventory old = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            Inventory now = list.get(i);
            if (old.getStart().compareTo(now.getEnd()) <= 0 && now.getStart().compareTo(old.getEnd()) <= 0) {
                error.add(now);
                error.add(old);
            }
            if (!error.contains(old)) {
                success.add(old);
            }
            if (now.getEnd().after(old.getEnd())) {
                old = now;
            }
        }
        if (!error.contains(old)) {
            success.add(old);
        }
        list.clear();
        ;
        //新建5个inventory对象 并添加到list2中
        List<Inventory> list2 = new ArrayList<>();
        list2.add(new Inventory("01/01/2021", "01/01/2021"));
        list2.add(new Inventory("01/01/2022", "01/01/2022"));
        list2.add(new Inventory("01/01/2023", "01/01/2023"));
        list2.add(new Inventory("01/01/2024", "01/01/2024"));
        list2.add(new Inventory("01/01/2025", "01/01/2025"));
        //调用sort方法
        list2.sort((o1, o2) -> {
            //按照start升序排列
            if (o1.getStart().after(o2.getStart())) {
                return 1;
            } else if (o1.getStart().before(o2.getStart())) {
                return -1;
            } else {
                //如果start相等 则按照end升序排列
                if (o1.getEnd().after(o2.getEnd())) {
                    return -1;
                } else if (o1.getEnd().before(o2.getEnd())) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        int x = list.size();
        int y = list2.size();
        int a = 0, b = 0;
        Inventory db1 = list2.get(0);
        while (a < x) {
            if (list.get(a).getStart().before(db1.getStart())) {
                error.add(list.get(a));
                a++;
                continue;
            }
            break;
        }
        while (a < x && b < y) {
            Inventory inventory = list.get(a);
            Inventory inventory1 = list2.get(b);
            //完全覆盖
            if (inventory.getStart().after(inventory1.getStart())&&inventory.getEnd().before(inventory1.getEnd())){
               a++;
            }
            //区间内
            if (inventory.getStart().before(inventory1.getEnd())){
                //inventory1 截断
                inventory1.setStart(inventory.getEnd());
                b++;
            }
            //区间外
            if (inventory.getEnd().before(inventory1.getStart())){
                //add inventory
                a++;
            }
            if (inventory1.getEnd().after(inventory1.getStart())){
                // inventory截断？
                a++;
            }
        }
    }
}
