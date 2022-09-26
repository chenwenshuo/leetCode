package qiusai;

/**
 * @Author: chenwenshuo
 * @Date: 2022/09/24/15:04
 */
public class One {
    //[1,-15,3,14,-1,4,35,36]
    //[-15,32,20,9,33,4,-1,-5]


    //[21,18,18,18,31]
    //[34,32,16,16,17]

    //[-14,7,-19,9,13,40,19,15,-18]
    //[3,16,28,32,25,12,13,-6,4]
    public static void main(String[] args) {
       System.out.println(new One().temperatureTrend(new int[]{1,-15,3,14,-1,4,35,36}, new int[]{-15,32,20,9,33,4,-1,-5}));

       System.out.println(new One().temperatureTrend(new int[]{21,18,18,18,31}, new int[]{34,32,16,16,17}));

        System.out.println(new One().temperatureTrend(
                new int[]{-14,7,-19,9,13,40,19,15,-18},
                new int[]{3,16,28,32,25,12,13,-6,4}));
    }
    public int temperatureTrend(int[] temperatureA, int[] temperatureB) {
        int length = temperatureA.length;
        int[] tema=new int[length];
        int[] temb=new int[length];
        int ans=0;

        for (int i = 1; i < length; i++) {
            tema[i]=temperatureA[i]==temperatureA[i-1]?0:(temperatureA[i]>temperatureA[i-1]?1:-1);
            temb[i]=temperatureB[i]==temperatureB[i-1]?0:(temperatureB[i]>temperatureB[i-1]?1:-1);
        }
        int tem=0;
        for (int i = 2; i < length; i++) {
            if (tema[i]==temb[i]){
                tem++;
            }else tem=0;
            ans=Math.max(ans,tem);
        }

        return ans;
    }
}
