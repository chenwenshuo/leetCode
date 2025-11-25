package jingdian150;

public class Jd16to134 {
    //输入: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
    //输出: 3
    //解释:
    //从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
    //开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
    //开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
    //开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
    //开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
    //开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
    //因此，3 可为起始索引。

    //gas =
    //[3,1,1]
    //cost =
    //[1,2,2]
    //
    //添加到测试用例
    //输出
    //1
    //预期结果
    //0
    public static void main(String[] args) {
        //System.out.println(canCompleteCircuit(new int[]{1,2,3,4,5},new int[]{3,4,5,1,2}));
        //System.out.println(canCompleteCircuit(new int[]{5,1,2,3,4},new int[]{4,4,1,5,1}));
        //System.out.println(canCompleteCircuit(new int[]{5,8,2,8},new int[]{6,5,6,6}));
        System.out.println(canCompleteCircuit(new int[]{3, 1, 1}, new int[]{1, 2, 2}));
    }

    //gas =
    //[5,1,2,3,4]
    //cost =
    //[4,4,1,5,1]
    //
    //添加到测试用例
    //输出
    //-1
    //预期结果
    //4
    //[5,8,2,8]
    //cost =
    //[6,5,6,6]
    //
    //添加到测试用例
    //输出
    //-1
    //预期结果
    //3
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int ans = 0;
        int minS = 0; // 最小油量
        int s = 0; // 油量
        for (int i = 0; i < gas.length; i++) {
            s += gas[i] - cost[i]; // 在 i 处加油，然后从 i 到 i+1
            if (s < minS) {
                minS = s; // 更新最小油量
                ans = i + 1; // 注意 s 减去 cost[i] 之后，汽车在 i+1 而不是 i
            }
        }
        // 循环结束后，s 即为 gas 之和减去 cost 之和
        return s < 0 ? -1 : ans;

    }
}
