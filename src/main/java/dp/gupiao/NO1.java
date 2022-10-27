package dp.gupiao;

import org.junit.Test;

import java.util.*;

public class NO1 {
    @Test
    public void test(){
        Long a=10L;
        aTest(a);
        System.out.println(a);
    }
    private void aTest(Long a){
        a=100L;
        System.out.println(a);
    }

    public static void main(String[] args) {

      System.out.println(sum(new int[]{3,1,2,-3,0},3));
    }
    public static  int sum(int[] nums, int k) {
        //最大堆 存差值从大到小排序
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>((a,b)->b-a);
        //存差值，与原数组对应关系
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int countOne = countOne(nums[i]);
            //由于差值会重复 选择不覆盖  无所谓
            map.putIfAbsent(nums[i]-countOne,i);
            priorityQueue.add(nums[i]-countOne); }
        //每次取堆里最大值 k次
        //替换原数组值为1的个数
        for (int i = 0; i < k; i++) {
           if (!priorityQueue.isEmpty()){
               Integer peek = priorityQueue.peek();
               Integer pre = map.get(peek);
               nums[pre]=nums[pre]-peek;
               //再次计算 放入堆
               int countOne = countOne(nums[pre]);
               map.putIfAbsent(nums[pre]-countOne,pre);
               priorityQueue.add(nums[pre]-countOne);
           }
        }
        return Arrays.stream(nums).sum();
    }
    static int countOne(int num){
        int count=0;
        while(num>0) {
            if((num&1)==1) {
                count++;
            }
            num >>= 1;
        }

        return count;
    }
}
