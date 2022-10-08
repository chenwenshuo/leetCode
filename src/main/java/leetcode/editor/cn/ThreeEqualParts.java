//给定一个由 0 和 1 组成的数组 arr ，将数组分成 3 个非空的部分 ，使得所有这些部分表示相同的二进制值。 
//
// 如果可以做到，请返回任何 [i, j]，其中 i+1 < j，这样一来： 
//
// 
// arr[0], arr[1], ..., arr[i] 为第一部分； 
// arr[i + 1], arr[i + 2], ..., arr[j - 1] 为第二部分； 
// arr[j], arr[j + 1], ..., arr[arr.length - 1] 为第三部分。 
// 这三个部分所表示的二进制值相等。 
// 
//
// 如果无法做到，就返回 [-1, -1]。 
//
// 注意，在考虑每个部分所表示的二进制时，应当将其看作一个整体。例如，[1,1,0] 表示十进制中的 6，而不会是 3。此外，前导零也是被允许的，所以 [0,
//1,1] 和 [1,1] 表示相同的值。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [1,0,1,0,1]
//输出：[0,3]
// 
//
// 示例 2： 
//
// 
//输入：arr = [1,1,0,1,1]
//输出：[-1,-1] 
//
// 示例 3: 
//
// 
//输入：arr = [1,1,0,0,1]
//输出：[0,2]
// 
//
// 
//
// 提示： 
// 
//
// 
// 3 <= arr.length <= 3 * 104 
// arr[i] 是 0 或 1 
// 
// Related Topics 数组 数学 
// 👍 172 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class ThreeEqualParts {
    public static void main(String[] args) {
        Solution solution = new ThreeEqualParts().new Solution();
        System.out.println(solution.threeEqualParts(new int[]{1,0,1,0,1}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] threeEqualParts(int[] arr) {
        int sum = Arrays.stream(arr).sum();
        int n = arr.length;
        if (sum == 0) return new int[]{0, 2};


        if (sum%3!=0) return new int[]{-1,-1};

        //计算后缀0个数
        int z=0;
        for (int i = arr.length-1; i >=0; i++) {
            if (arr[i]==0){
                z++;
            }else break;
        }

        int tem=sum/3;
        int a=0;
        int pre=1;

        int[] ans=new int[2];
        int nz=0;
        StringBuilder sb=new StringBuilder();
        int y=0;
        int x=0;
        for (int i : arr) {
            if (a==tem){
                ans[x]=i;
                x++;

                y=Integer.parseInt(sb.toString(),2);
                sb=new StringBuilder();
                pre++;
                nz=0;
            }
            if (pre==1&&(a<tem||(a==tem&&nz<z))){
                sb.append(i);
                if (i==1){
                    a++;
                }
                if (a==tem&&i==0||z==0){
                    nz++;
                }else {
                    return new int[]{-1,-1};
                }
            } else if (pre==2&&a<tem){
                sb.append(i);
                if (i==1){
                    a++;
                }
                if (Integer.parseInt(sb.toString(),2)>y){
                    return new int[]{-1,-1};
                }
                if (a==tem&&i==0||z==0){
                    nz++;
                }else {
                    return new int[]{-1,-1};
                }
            }else if (pre==3&&a<tem){
                sb.append(i);
                if (i==1){
                    a++;
                }
                if (Integer.parseInt(sb.toString(),2)>y){
                    return new int[]{-1,-1};
                }
                if (a==tem&&i==0||z==0){
                    nz++;
                }else {
                    return new int[]{-1,-1};
                }
            }
        }
        return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}