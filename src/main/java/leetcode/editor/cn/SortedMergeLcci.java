//给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。 
//
// 初始化 A 和 B 的元素数量分别为 m 和 n。 
//
// 示例: 
//
// 输入:
//A = [1,2,3,0,0,0], m = 3
//B = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6] 
//
// 说明: 
//
// 
// A.length == n + m 
// 
// Related Topics 数组 双指针 排序 
// 👍 157 👎 0

package leetcode.editor.cn;
public class SortedMergeLcci {
    public static void main(String[] args) {
        Solution solution = new SortedMergeLcci().new Solution();
        solution.merge(new int[]{1,2,3,0,0,0},3,new int[]{2,5,6},3);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public void merge(int[] A, int m, int[] B, int n) {
            int [] tem=new int[m+n];
            int i=0;
            int m1=0,n1=0;

            while(m1<m&&n1<n){
                if(A[m1]>=B[n1]){
                    tem[i]=B[n1];
                    n1++;
                }else{
                    tem[i]=A[m1];
                    m1++;
                }
                i++;
            }
            while(m1<m){
                tem[i++]=A[m1++];
            }
            while(n1<n){
                tem[i++]=B[n1++];
            }
            for (int i1 = 0; i1 < A.length; i1++) {
                A[i1]=tem[i1];
            }
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}