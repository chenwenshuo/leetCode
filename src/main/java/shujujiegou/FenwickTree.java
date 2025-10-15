package shujujiegou;

/**
 * 树状数组
 */
public class FenwickTree {
    private int[] tree;
    private int n;

    public FenwickTree(int[] tree,int n ){
        this.tree = tree;
        this.n=n;
    }


    public int lowBit(int i ){
        return i&(-i);
    }

    //单点更新
    //找父节点
    public void update(int i,int v){
        while (i<n){
            tree[i]+=v;
            i+=lowBit(i);
        }
    }
    //找前驱： 8->4->0
    //7->6->4>0
    public int query(int i){
        int sum = 0;
        while (i>0){
            sum+=tree[i];
            i-=lowBit(i);
        }
        return sum;
    }

    //闭区间查询
    public int query(int i,int j){
        return query(j)-query(i-1);
    }
}
