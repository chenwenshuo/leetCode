package jingdian150;

public class Jd11to274 {

    //示例 1：
    //
    //输入：citations = [3,0,6,1,5]
    //输出：3
    //解释：给定数组表示研究者总共有 5 篇论文，每篇论文相应的被引用了 3, 0, 6, 1, 5 次。
    //     由于研究者有 3 篇论文每篇 至少 被引用了 3 次，其余两篇论文每篇被引用 不多于 3 次，所以她的 h 指数是 3。
    //示例 2：
    //
    //输入：citations = [1,3,1]
    //输出：1
    public int hIndex(int[] citations) {
        int r = citations.length;
        int l = 0;
        int ans = 0;

        while (l<=r){
            int mid = l+r>>1;
            if (check(citations,mid)){
                ans = mid;
                l=mid+1;
            }else {
                r = mid-1;
            }

        }
        return ans;

    }

    private boolean check(int[] citations, int mid) {
        int t = 0;
        for (int i = 0; i < citations.length; i++) {
            if (citations[i]>=mid) t++;
        }
        return mid<=t;
    }

}
