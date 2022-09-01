package leetcode.editor.cn.zs.Three;

/**
 * @Author: chenwenshuo
 * @Date: 2022/09/01/2:54 下午
 */
public class Target {

    public static void main(String[] args) {
        int[] abcs = test(" ", new char[]{'c', 'i', 'c', ' ', 'c', 'c'});
        int[] s = query("", new char[]{'c', 'i', 'c', ' ', 'c', 'c'});
        for (int i : s) {
            System.out.println(i);
        }
        System.out.println();
        System.out.println();
        for (int abc : abcs) {
            System.out.println(abc);
        }
    }
    public static int[] test(String target ,char[] arr){
        if (arr==null||target==null||target=="")
            return new int[]{};
        char[] chars = target.toCharArray();
        int length = chars.length;
        int arrL = arr.length;

        int start=0;
        int arrStart=0;

        int[]ans=new int[2];
        while (start<length&&arrStart<arrL){
             if (chars[start]==arr[arrStart]){
                 if (start==0){
                     ans[0]=arrStart;
                 }
                 if (start==length-1){
                     ans[1]=arrStart;
                 }
                 start++;
             }
             arrStart++;
        }
        if (start<length) return new int[]{};

        return ans;

    }

    static int[] res =new int[2];
    static int[] res1;
    public  static int[] query(String tar,char[] nums){
        int j=0;
        for (int i=0;i<nums.length;i++){
            if (tar.charAt(j)==nums[i]){
                if (j==0){
                    res[0]=i;
                }
                if (j==tar.length()-1){
                    res[1]=i;
                    return res;
                }
                j++;
            }
        }
        return res1;
    }
}
