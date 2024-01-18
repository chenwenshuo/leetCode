package sf;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Dijkstra {

    public static int[] dijkstra(int[][] graph, int startVertex) {
        //初始化 以求出最短路径的点 result[]
        int length = graph.length;
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = -1;
        }
        result[startVertex] = 0;
        // 初始化 未求出最短路径的点 notFound[]
        int[] notFound = new int[length];
        for (int i = 0; i < length; i++) {
            notFound[i] = graph[startVertex][i];
        }
        notFound[startVertex] = -1;
        // 开始 Dijkstra 算法
        for (int i = 1; i < length; i++) {
            //1. 从「未求出最短路径的点」notFound 中取出 最短路径的点
            //1.1 找到最短距离的点
            int min = Integer.MAX_VALUE;
            int minIndex = 0;
            for (int j = 0; j < length; j++) {
                if (notFound[j] > 0 && notFound[j] < min) {
                    min = notFound[j];
                    minIndex = j;
                }
            }
            //1.2 将最短距离的点 取出 放入结果中
            result[minIndex] = min;
            notFound[minIndex] = -1;
            //2. 刷新 「未求出最短距离的点」 notFound[] 中的距离
            //2.1 遍历刚刚找到最短距离的点 (B) 的出度 (BA、BB、BC、BD)
            for (int j = 0; j < length; j++) {
                // 出度可通行(例如 BD:graph[1][3]  > 0)
                // 出度点不能已经在结果集 result中(例如 D: result[3] == -1)
                if (graph[minIndex][j] > 0
                    && result[j] == -1) {
                    int newDistance = result[minIndex] + graph[minIndex][j];
                    //通过 B 为桥梁，刷新距离
                    //（比如`AD = 6 < AB + BD = 4` 就刷新距离）（ -1 代表无限大）
                    if (newDistance < notFound[j] || notFound[j] == -1) {
                        notFound[j] = newDistance;
                    }
                }
            }

        }
        return result;
    }

    /**
     * 测试案例
     */
    public static void main(String[] args) {
        char[] vertices = new char[]{'A', 'B', 'C', 'D'};
        int[][] graph = new int[][]{
            {0, 2, -1, 6}
            , {2, 0, 3, 2}
            , {-1, 3, 0, 2}
            , {6, 2, 2, 0}};
        int[] dijkstra = dijkstra1(graph, 0);
        for (int i : dijkstra) {
            System.out.println(i);
        }
    }

    public static int[] dijkstra1(int[][] graph, int startVertex) {
        int length = graph.length;
        int[] ans = new int[length];
        int[] notFound = new int[length];
        Arrays.fill(ans, -1);
        ans[startVertex] = 0;
        System.arraycopy(graph[startVertex], 0, notFound, 0, length);
        notFound[startVertex] = -1;
        //找到最小距离那个点
        //因为有可能存在A->B=5， A->C:2-》1 C->A:1 虽然此时最小距离为3
        for (int k = 1; k < length; k++) {
            int min = Integer.MAX_VALUE;
            int minIndex = 0;
            for (int i = 0; i < length; i++) {
                if (notFound[i] > 0 && min > notFound[i]) {
                    min = notFound[i];
                    minIndex = i;
                }
            }
            ans[minIndex] = min;
            notFound[minIndex] = -1;
            //找到最小距离到notFound中的最小距离，并且跟已经存在的点比较 更新ans[i]

            for (int i = 0; i < length; i++) {
                if (graph[minIndex][i] > 0 && ans[i] == -1) {
                    int newD = ans[minIndex] + graph[minIndex][i];
                    if (newD < notFound[i] || notFound[i] == -1) {
                        notFound[i] = newD;
                    }
                }
            }
        }
        return ans;

    }

    public static int[] dijkstra12(int[][] graph, int startVertex) {
        int length = graph.length;
        int[] ans = new int[length];
        boolean[] ex = new boolean[length];
        Arrays.fill(ans, Integer.MAX_VALUE);
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int index = poll[0];
            int len = poll[1];
            ex[index] = true;
            for (int i = 0; i < graph[index].length; i++) {
                if (graph[index][i] > 0 && !ex[i] && len + graph[index][i] < ans[i]) {
                    ans[i] = len + graph[index][i];
                    queue.offer(new int[]{i, ans[i]});
                }
            }
        }
        return ans;

    }
}