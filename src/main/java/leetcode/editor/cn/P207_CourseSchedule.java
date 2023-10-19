//你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。 
//
// 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表
//示如果要学习课程 ai 则 必须 先学习课程 bi 。 
//
// 
// 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。 
// 
//
// 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：numCourses = 2, prerequisites = [[1,0]]
//输出：true
//解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。 
//
// 示例 2： 
//
// 
//输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
//输出：false
//解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。 
//
// 
//
// 提示： 
//
// 
// 1 <= numCourses <= 2000 
// 0 <= prerequisites.length <= 5000 
// prerequisites[i].length == 2 
// 0 <= ai, bi < numCourses 
// prerequisites[i] 中的所有课程对 互不相同 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 👍 1677 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

/**
 * 课程表
 *
 * @author chenws
 * @date 2023-08-29 17:34:33
 */
public class P207_CourseSchedule {

    public static void main(String[] args) {
        //测试代码
        Solution solution = new P207_CourseSchedule().new Solution();
        //[[0,2],[1,2],[2,0]]
        //System.out.println(solution.canFinish(2, new int[][]{{1, 0}, {0, 1}}));
        // System.out.println(solution.canFinish(3, new int[][]{{0, 2}, {1, 2}, {2, 0}}));
        //[[0,1],[0,2],[1,2]]
        System.out.println(solution.canFinish(3, new int[][]{{0, 1}, {0, 2}, {1, 2}}));
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //[[0,10],[3,18],[5,5],[6,11],[11,14],[13,1],[15,1],[17,4]]
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            //每次遍历入度为0的 ，并且字迹入度-1 直到为0加入队列
            Set<Integer>[] nums = new Set[numCourses];
            Arrays.setAll(nums, j -> new TreeSet<Integer>());

            int[] vst = new int[numCourses];
            Arrays.fill(vst, 0);
            for (int[] prerequisite : prerequisites) {
                if (prerequisite[0] == prerequisite[1]) {
                    return false;
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
                return false;
            }
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    Integer poll = queue.poll();
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

            return numCourses == 0;

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
