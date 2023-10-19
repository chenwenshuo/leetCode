//现在你总共有 numCourses 门课需要选，记为 0 到 numCourses - 1。给你一个数组 prerequisites ，其中 
//prerequisites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修 bi 。 
//
// 
// 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示：[0,1] 。 
// 
//
// 返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。如果不可能完成所有课程，返回 一个空数组 。 
//
// 
//
// 示例 1： 
//
// 
//输入：numCourses = 2, prerequisites = [[1,0]]
//输出：[0,1]
//解释：总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
// 
//
// 示例 2： 
//
// 
//输入：numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
//输出：[0,2,1,3]
//解释：总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
//因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。 
//
// 示例 3： 
//
// 
//输入：numCourses = 1, prerequisites = []
//输出：[0]
// 
//
// 
//提示：
//
// 
// 1 <= numCourses <= 2000 
// 0 <= prerequisites.length <= numCourses * (numCourses - 1) 
// prerequisites[i].length == 2 
// 0 <= ai, bi < numCourses 
// ai != bi 
// 所有[ai, bi] 互不相同 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 👍 804 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

/**
 * 课程表 II
 *
 * @author chenws
 * @date 2023-08-30 21:46:32
 */
public class P210_CourseScheduleIi {

    public static void main(String[] args) {
        //测试代码
        Solution solution = new P210_CourseScheduleIi().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] findOrder(int numCourses, int[][] prerequisites) {
            Set<Integer>[] nums = new Set[numCourses];
            Arrays.setAll(nums, j -> new TreeSet<Integer>());
            int[] ans = new int[numCourses];
            int k = 0;

            int[] vst = new int[numCourses];
            Arrays.fill(vst, 0);
            for (int[] prerequisite : prerequisites) {
                if (prerequisite[0] == prerequisite[1]) {
                    return new int[]{};
                }
                vst[prerequisite[0]]++;
                nums[prerequisite[1]].add(prerequisite[0]);
            }

            Queue<Integer> queue = new LinkedList<>();

            for (int i = 0; i < nums.length; i++) {
                if (vst[i] == 0) {
                    queue.offer(i);
                }
            }
            if (queue.isEmpty()) {
                return new int[]{};
            }
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    Integer poll = queue.poll();
                    ans[k] = poll;
                    k++;
                    numCourses--;
                    if (nums[poll].size() > 0) {
                        for (int o : nums[poll]) {
                            if (--vst[o] == 0) {
                                queue.offer(o);
                            }
                        }
                    }
                }
            }

            return numCourses == 0 ? ans : new int[]{};

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
