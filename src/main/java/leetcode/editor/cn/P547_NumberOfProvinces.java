//
// 
// 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连
//。 
// 
// 
//
// 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。 
//
// 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 
//isConnected[i][j] = 0 表示二者不直接相连。 
//
// 返回矩阵中 省份 的数量。 
//
// 
//
// 示例 1： 
// 
// 
//输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
//输出：2
// 
//
// 示例 2： 
// 
// 
//输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 200 
// n == isConnected.length 
// n == isConnected[i].length 
// isConnected[i][j] 为 1 或 0 
// isConnected[i][i] == 1 
// isConnected[i][j] == isConnected[j][i] 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 图 👍 1083 👎 0


package leetcode.editor.cn;

import lombok.Data;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;




/**
 * 省份数量
 *
 * @author chenws
 * @date 2024-01-18 11:40:23
 */
public class P547_NumberOfProvinces {
    public static void main(String[] args) {
        List<ProtocalRate> protocalRateList = new ArrayList<>();
        //定义  key是分组条件
        Map<String, TreeMap<LocalDate, ProtocalRate>> dateMap = new HashMap<>();
        for (ProtocalRate protocalRate : protocalRateList) {//按时间升序排序
            dateMap.computeIfAbsent(protocalRate.uniqueKey, v -> new TreeMap<>(LocalDate::compareTo))
                    .put(protocalRate.startDate, protocalRate);
        }
        //您们系统的数据
        List<ProtocalRate> yourDateList = new ArrayList<>();
        for (ProtocalRate protocalRate : yourDateList) {
            TreeMap<LocalDate, ProtocalRate> map = dateMap.get(protocalRate.uniqueKey);
            //获取比当前值小的 最大值
            Map.Entry<LocalDate, ProtocalRate> entry = map.floorEntry(protocalRate.startDate);
            //构造你需要的对象
            build(entry);
            //---

        }


    }

    private static void build(Map.Entry<LocalDate, ProtocalRate> entry) {
    }

    @Data
    class ProtocalRate {
        private String uniqueKey;
        private LocalDate startDate;
        private LocalDate endDate;


    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Set<Integer>[] g;
        boolean[] vst;

        public int findCircleNum(int[][] isConnected) {
            int ans = 0;
            int len = isConnected.length;
            g = new Set[len];
            vst = new boolean[len];
            Arrays.setAll(g, k -> new HashSet<>());
            for (int i = 0; i < isConnected.length; i++) {
                for (int j = 0; j < isConnected[i].length; j++) {
                    if (isConnected[i][j] == 1) {
                        g[i].add(j);
                    }
                }
            }
            for (int i = 0; i < len; i++) {
                if (!vst[i]) {
                    dfs(i);
                    ans++;
                }
            }
            return ans;

        }

        private void dfs(int idx) {
            vst[idx] = true;
            Set<Integer> set = g[idx];
            for (Integer n : set) {
                if (!vst[n]) {
                    dfs(n);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
