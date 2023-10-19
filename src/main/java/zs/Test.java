package zs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Test {

    @org.junit.Test
    public void test() {
        //"zrmq"
        //"mrzq"
        System.out.println(canBeEqual("zrmq"
            , "mrzq"));
    }

    public boolean canBeEqual(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        char[] charArray = s1.toCharArray();
        char[] charArray1 = s2.toCharArray();
        if (charArray[0] == charArray1[0]) {
            char a = charArray[1];
            charArray[1] = charArray[3];
            charArray[3] = a;
            return s2.equals(new String(charArray));
        }

        char b = charArray[0];
        charArray[0] = charArray[2];
        charArray[2] = b;
        if (s2.equals(new String(charArray))) {
            return true;
        }
        char a = charArray[1];
        charArray[1] = charArray[3];
        charArray[3] = a;
        return s2.equals(new String(charArray));

    }

    public boolean checkStrings(String s1, String s2) {
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        int[] count3 = new int[26];
        int[] count4 = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            char c1 = s2.charAt(i);
            if (i % 2 == 0) {
                count1[c - 'a']++;
                count2[c1 - 'a']++;
            } else {
                count3[c - 'a']++;
                count4[c1 - 'a']++;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (count1[i] != count2[i]) {
                return false;
            }
            if (count3[i] != count4[i]) {
                return false;
            }
        }
        return true;
    }

    public long maxSum(List<Integer> nums, int m, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        long ans = 0;
        long tem = 0;
        for (int i = 0; i < k; i++) {
            map.put(nums.get(i), map.getOrDefault(nums.get(i), 0) + 1);
            tem += nums.get(i);
        }
        for (int i = 0, j = i + k; j < nums.size(); i++, j++) {
            Integer num1 = nums.get(i);
            Integer numj = nums.get(j);
            if (map.size() >= m) {
                ans = Math.max(ans, tem);
            }
            Integer integer = map.get(num1);
            if (integer <= 1) {
                map.remove(num1);
            } else {
                map.put(num1, integer - 1);
            }
            map.put(numj, map.getOrDefault(numj, 0) + 1);
            tem = tem - num1 + numj;
        }
        return map.size() >= m ? Math.max(ans, tem) : ans;
    }

    public int countKSubsequencesWithMaxBeauty(String s, int k) {
        int MOD = 109 + 7;
        Map<Character, Long> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        List<Long> l = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            set.add(c);
            map.put(c, map.getOrDefault(c, 0L) % MOD + 1);

        }
        Map<Long, Set<Character>> map1 = new TreeMap<>();
        for (Character character : set) {
            map1.computeIfAbsent(map.get(character), a -> new HashSet<>()).add(character);
        }
        for (Long aLong : map1.keySet()) {
            Set<Character> set1 = map1.get(aLong);
            if (set1.size()>=k){
                return 0;
            }
        }
        int ans = 0;

        return ans;
    }

    @org.junit.Test
    public void tes1t() {
        //"zrmq"
        //"mrzq"
        //[1,2,1,2,1,2,1]
        //3
        //3
        int[] nums = new int[]{1, 2, 1, 2, 1, 2, 1};
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        System.out.println(maxSum(list, 3, 3));
    }


}
