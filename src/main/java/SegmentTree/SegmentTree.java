package SegmentTree;


import org.junit.Test;

import java.util.Arrays;

public class SegmentTree {
    int[] nums, tree;
    int n;

    public SegmentTree() {

    }

    public SegmentTree(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        // 线段树结点数不超过 4*n
        this.tree = new int[4 * n];
        build(0, n - 1, 1);
    }

    private void build(int l, int r, int i) {
        if (l == r) {
            tree[i] = nums[l];
            return;
        }
        int c = l + r >> 1;
        build(l, c, 2 * i);
        build(c + 1, r, 2 * i + 1);
        pushUp(i);
    }

    // update tree i
    public void pushUp(int i) {
        tree[i] = tree[2 * i] + tree[2 * i + 1];
    }


    // 单点修改(驱动): nums[i] += x
    public void add(int i, int x){
        add(i, x, 0, n - 1, 1);
    }

    // 单点修改: nums[idx] += x
    private void add(int idx, int x, int s, int t, int i){
        if(s == t) {
            tree[i] += x; // 增量更新
            return;
        }
        int c = s + (t - s) / 2;
        if(idx <= c) {
            add(idx, x, s, c, i * 2);
        } else {
            add(idx, x, c + 1, t, i * 2 + 1);
        }
        pushUp(i);
    }
    // 单点修改(驱动): nums[i] = x
    public void update(int i, int x){
        update(i, x, 0, n - 1, 1);
    }
    private void update(int idx, int x, int s, int t, int i){
        if(s == t) {
            tree[i] = x; // 覆盖更新
            return;
        }
        int c = s + (t - s) / 2;
        if(idx <= c) {
            update(idx, x, s, c, i * 2);
        } else {
            update(idx, x, c + 1, t, i * 2 + 1);
        }
        pushUp(i);
    }

    // 单点查询 (驱动): 查询 nums[i]
    public int query(int i){
        return query(i, 0, n - 1, 1);
    }
    // 单点查询 (具体): 查询 nums[i]，尾递归
    private int query(int idx, int s, int t, int i){
        if(s == t) {
            return tree[i];
        }
        int c = s + (t - s) / 2;
        if(idx <= c) {
            return query(idx, s, c, i * 2);
        } else {
            return query(idx, c + 1, t, i * 2 + 1);
        }
    }

    // 区间查询(驱动): nums[l]~nums[r]之和
    public int sum(int l, int r){
        return sum(l, r, 0, n - 1, 1);
    }
    // 区间查询: nums[l]~nums[r]之和
    private int sum(int l, int r, int s, int t, int i){
        if(l <= s && t <= r) {
            return tree[i]; // 当前结点区间在所求范围之间
        }
        int c = s + (t - s) / 2, sum = 0;
        if(l <= c) {
            sum += sum(l, r, s, c, i * 2); // 递归累加目标区间落在c左侧(含c)的区间和
        }
        if(r > c) {
            sum += sum(l, r, c + 1, t, i * 2 + 1); // 递归累加目标区间落在c右侧的区间和
        }
        return sum;
    }



    public static void main(String[] args) {
        SegmentTree segmentTree = new SegmentTree(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        System.out.println(Arrays.toString(segmentTree.tree));

    }

}
