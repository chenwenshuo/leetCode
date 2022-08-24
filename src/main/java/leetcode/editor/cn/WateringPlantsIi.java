package leetcode.editor.cn;

//Alice 和 Bob 打算给花园里的 n 株植物浇水。植物排成一行，从左到右进行标记，编号从 0 到 n - 1 。其中，第 i 株植物的位置是 x = 
//i 。 
//
// 每一株植物都需要浇特定量的水。Alice 和 Bob 每人有一个水罐，最初是满的 。他们按下面描述的方式完成浇水： 
//
// 
// Alice 按 从左到右 的顺序给植物浇水，从植物 0 开始。Bob 按 从右到左 的顺序给植物浇水，从植物 n - 1 开始。他们 同时 给植物浇水。 
//
// 如果没有足够的水 完全 浇灌下一株植物，他 / 她会立即重新灌满浇水罐。 
// 不管植物需要多少水，浇水所耗费的时间都是一样的。 
// 不能 提前重新灌满水罐。 
// 每株植物都可以由 Alice 或者 Bob 来浇水。 
// 如果 Alice 和 Bob 到达同一株植物，那么当前水罐中水更多的人会给这株植物浇水。如果他俩水量相同，那么 Alice 会给这株植物浇水。 
// 
//
// 给你一个下标从 0 开始的整数数组 plants ，数组由 n 个整数组成。其中，plants[i] 为第 i 株植物需要的水量。另有两个整数 
//capacityA 和 capacityB 分别表示 Alice 和 Bob 水罐的容量。返回两人浇灌所有植物过程中重新灌满水罐的 次数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：plants = [2,2,3,3], capacityA = 5, capacityB = 5
//输出：1
//解释：
//- 最初，Alice 和 Bob 的水罐中各有 5 单元水。
//- Alice 给植物 0 浇水，Bob 给植物 3 浇水。
//- Alice 和 Bob 现在分别剩下 3 单元和 2 单元水。
//- Alice 有足够的水给植物 1 ，所以她直接浇水。Bob 的水不够给植物 2 ，所以他先重新装满水，再浇水。
//所以，两人浇灌所有植物过程中重新灌满水罐的次数 = 0 + 0 + 1 + 0 = 1 。 
//
// 示例 2： 
//
// 
//输入：plants = [2,2,3,3], capacityA = 3, capacityB = 4
//输出：2
//解释：
//- 最初，Alice 的水罐中有 3 单元水，Bob 的水罐中有 4 单元水。
//- Alice 给植物 0 浇水，Bob 给植物 3 浇水。
//- Alice 和 Bob 现在都只有 1 单元水，并分别需要给植物 1 和植物 2 浇水。
//- 由于他们的水量均不足以浇水，所以他们重新灌满水罐再进行浇水。
//所以，两人浇灌所有植物过程中重新灌满水罐的次数 = 0 + 1 + 1 + 0 = 2 。 
//
// 示例 3： 
//
// 
//输入：plants = [5], capacityA = 10, capacityB = 8
//输出：0
//解释：
//- 只有一株植物
//- Alice 的水罐有 10 单元水，Bob 的水罐有 8 单元水。因此 Alice 的水罐中水更多，她会给这株植物浇水。
//所以，两人浇灌所有植物过程中重新灌满水罐的次数 = 0 。 
//
// 
//
// 提示： 
//
// 
// n == plants.length 
// 1 <= n <= 10⁵ 
// 1 <= plants[i] <= 10⁶ 
// max(plants[i]) <= capacityA, capacityB <= 10⁹ 
// 
//
// Related Topics 数组 双指针 模拟 👍 9 👎 0

public class WateringPlantsIi{
         public static void main(String[] args) {
            Solution solution = new WateringPlantsIi().new Solution();
             System.out.println(solution.minimumRefill(new int[]{726,739,934,116,643,648,473,984,482,85,850,806,146,764,156,66,186,339,985,237,662,552,800,78,617,
                     933,481,652,796,594,151,82,183,241,525,221,951,732,799,483,368,354,776,175,974,187,913,842},1439,1207));
 }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {

        int l=0;
        int r=plants.length-1;

        int temA=capacityA;
        int temB=capacityB;
        int ans=0;
        while (l<=r){
            if (l==r){
               if (temA<plants[l]&&temB<plants[l]){
                   ans++;

               }
                break;
            }
            if (temA<plants[l]){
                temA=capacityA-plants[l];
                ans++;
            }else {
                temA-=plants[l];
            }
            if (temB<plants[r]){
                temB=capacityB-plants[r];
                ans++;
            }else {
                temB-=plants[r];
            }

            l++;
            r--;

        }


        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
