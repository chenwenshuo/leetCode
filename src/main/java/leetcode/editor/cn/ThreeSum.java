package leetcode.editor.cn;

//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
// Related Topics 数组 双指针 排序 👍 4656 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreeSum{
         public static void main(String[] args) throws InterruptedException {
            Solution solution = new ThreeSum().new Solution();

             Thread thread = new Thread(() -> {
                 try {
                     TimeUnit.SECONDS.sleep(30);
                 } catch (InterruptedException e) {


                 }
             });
             thread.join();
             System.out.println(1);


             //使用单例线程池 保证线程有序执行
             ExecutorService executorService = Executors.newSingleThreadExecutor();
             for (int i = 0; i < 4; i++) {
                 int finalI = i;
                 executorService.submit(()->{
                     //读取数据的逻辑
                     System.out.println(finalI);
                 });

             }

             executorService.shutdown();
         }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> list=new ArrayList<>();

        for (int i = 0; i < length; i++) {
            if (i>0&&nums[i]==nums[i-1]) continue;

            int three=length-1;
            int tag=-nums[i];

            for (int two = i+1; two < nums.length; two++) {
                if (two>i+1&&nums[two]==nums[two-1]) continue;

                //已经排序
                while (two < three && nums[two] + nums[three] > tag) {
                    --three;
                }
                if (two==three) break;

                if (nums[three]+nums[two]==tag){
                   List<Integer> ans= new ArrayList<>();
                   ans.add(nums[i]);
                   ans.add(nums[two]);
                   ans.add(nums[three] );
                   list.add(ans);
                }

            }

        }



        return list;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
