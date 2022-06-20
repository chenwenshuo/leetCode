package leetcode.editor.cn.zs;

/**
 * @Author: chenwenshuo
 * @Date: 2022/06/19/11:14 上午
 */
public class Two {
    public static void main(String[] args) {
  int a=68; int b=9;
        System.out.println(test(5,1));


    }

    public static int test(int num, int k){
        if (num<k) return -1;
        if (k==1) return num;
        int c=num/10;
        int ans=0;
        int tem=0;
        int d=num%10;

        if (num<10){
            if (num%k==0);
                return num/k;
        }
        for (int i = 0; i <=c; i++) {
            tem+=k;
            if (tem%10==d){
                ans=i;
                break;
            }
        }

        if (ans==0) return -1;
        return ans+1;
    }
}
