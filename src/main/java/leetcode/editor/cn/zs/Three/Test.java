package leetcode.editor.cn.zs.Three;

import java.util.Map;
import java.util.Scanner;

/**
 * @Author: chenwenshuo
 * @Date: 2022/08/31/5:57 下午
 */
public class Test {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int res=0;
            for (int i=0;i<n;i++){
                int num=n-i;
                while (num!=0){
                    res++;
                    num/=2;
                }
            }
            System.out.println(res);



                int res1 = 0;
                int mask = 1;
                int val = 1;
                while (mask <= n) {
                    int next = mask << 1;
                    res1 += (Math.min(next, n + 1) - mask) * val;
                    val++;
                    mask = next;
                }
                System.out.println(res1);
            }

        }








