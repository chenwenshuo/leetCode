package zs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.Test;

public class Test2 {

    public List<Integer> toList() {
        int[] ints = {3,1,9,6};
        List<Integer> list = new ArrayList();
        for (int anInt : ints) {
            list.add(anInt);
        }
        return list;
    }

    @Test
    public void test() {

        //[3,1,9,6]
        //3
        //0
        //输出：
        //1
        //预期：
        //2
        System.out.println(countInterestingSubarrays(toList(),3,0));
    }

    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        int n = nums.size();
        int cnt = 0;
        long ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < n; i++) {
            int a = nums.get(i) % modulo;
            if (a == k) {
                cnt += 1;
            }

            int b = cnt % modulo;
            int aim = (b - k + modulo ) %modulo;
            ans += map.getOrDefault(aim, 0);
            map.put(b, map.getOrDefault(b, 0) + 1);
        }

        return ans;
    }

    public int minimumOperations1(String num) {

        return 0;
    }

    public int minimumOperations(String num) {

        if (num.equals("0")) {
            return 0;
        }
        //00 25 50 或者0
        Set<String> set = new HashSet<>();
        set.add("00");
        set.add("25");
        set.add("50");
        set.add("75");
        for (String s : set) {
            if (num.endsWith(s)) {
                return 0;
            }
        }

        char[] charArray = num.toCharArray();
        int length = num.length();
        int l2 = length;
        if (num.contains("0")) {
            l2 = length - 1;
        }
        if (length == 1) {
            return 1;
        }
        int f = 0;
        int z = 0;
        int t = 0;

        boolean y = false;
        boolean l = false;
        for (int i = length - 1; i >= 0; i--) {
            char c = charArray[i];

            if (c == '0' && !y) {
                y = true;
                continue;
            }
            if (!y) {
                z++;
                continue;
            }
            if (c != '0') {
                z++;

            }
            if (c == '0') {
                l = true;
                break;
            }
        }
        if (!l) {
            z = length;
        }

        y = false;
        l = false;
        for (int i = length - 1; i >= 0; i--) {
            char c = charArray[i];

            if (c == '0' && !y) {
                y = true;
                continue;
            }
            if (!y) {
                f++;
                continue;
            }
            if (c != '5') {
                f++;
            }
            if (c == '5') {
                l = true;
                break;
            }
        }
        if (!l) {
            f = length;
        }

        y = false;
        l = false;
        for (int i = length - 1; i >= 0; i--) {
            char c = charArray[i];

            if (c == '5' && !y) {
                y = true;
                continue;
            }
            if (!y) {
                t++;
                continue;
            }
            if (c != '2') {
                t++;
            }
            if (c == '2') {
                l = true;
                break;
            }
        }
        if (!l) {
            t = length;
        }

        y = false;
        l = false;
        int m = 0;
        for (int i = length - 1; i >= 0; i--) {
            char c = charArray[i];

            if (c == '5' && !y) {
                y = true;
                continue;
            }
            if (!y) {
                m++;
                continue;
            }
            if (c != '7') {
                m++;
            }
            if (c == '7') {
                l = true;
                break;
            }
        }
        if (!l) {
            t = length;
        }
        return Math.min(m, Math.min(z, Math.min(t, Math.min(f, l2))));
    }

    public int countSymmetricIntegers(int low, int high) {

        int ans = 0;
        for (int i = low; i <= high; i++) {
            String s = String.valueOf(i);
            int length = s.length();
            if (length % 2 != 0) {
                continue;
            }
            int mid = length / 2;
            int x = i;
            int tem = 0;
            int k = 0;
            for (int j = 0; j < mid; j++) {
                tem += x % 10;
                x = x / 10;
            }
            for (int j = 0; j < mid; j++) {
                k += x % 10;
                x = x / 10;
            }
            if (k == tem) {
                ans++;

            }
        }
        return ans;
    }
}
