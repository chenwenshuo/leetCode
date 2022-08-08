package leetcode.editor.cn.zs.Three;

/**
 * @Author: chenwenshuo
 * @Date: 2022/08/07/10:49 上午
 */
public class Three {

    public void Test(){}
    public boolean validPartition(int[] nums) {
        int length = nums.length;
        if (length==2){
            if (nums[1]==nums[0]){
                return true;
            }
            return false;
        }
        if (length==3){
            if ((nums[1]==nums[0]&&nums[2]==nums[0])||(nums[1]-nums[0]==1&&nums[2]-nums[1]==1)){
                return true;
            }
            return false;
        }

        for (int i = 1; i < length; i++) {
            if (nums[i]==nums[i-1]){

            }else if (nums[i]-nums[i-1]==1){
            }else {
                return false;
            }
        }

        return false;
    }
    boolean validPartition1(int[] nums,int n){

        if (nums[n]==nums[n-1]){
            return true;
        }

            if ((nums[n]==nums[n-2]&&nums[n]==nums[n-1])||(nums[n]-nums[n-1]==1&&nums[n-1]-nums[n-2]==1)){
                return true;
            }
            return false;
    }
}
