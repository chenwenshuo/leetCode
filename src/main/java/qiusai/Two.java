package qiusai;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: chenwenshuo
 * @Date: 2022/09/24/15:49
 */
public class Two {

    public int transportationHub(int[][] path) {

        Set<Integer> set=new HashSet<>();
        for (int i = 0; i < path.length; i++) {
            set.add(path[i][0]);
        }
        Map<Integer,Integer> map=new HashMap<>();
        int ans=0;
        int tem=0;
        for (int i = 0; i < path.length; i++) {
            if (!set.contains(path[i][1])){
                //map.put(path[i][0],map.getOrDefault(path[i][0],0)+1);
                ans=path[i][1];
                tem++;
            }
        }


        return tem!=set.size()?-1:ans;
    }
}
