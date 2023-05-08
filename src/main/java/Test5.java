import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Test5 {

    public static void main(String[] args) {/*
        int i = new Test5().adventureCamp(new String[]{"Alice->Dex", "", "Dex"});
        System.out.println(i);*/
        System.out.println(new Test5().fieldOfGreatestBlessing(new int[][]{{4, 4, 6}, {7, 5, 3}, {1, 6, 2}, {5, 6, 3}}));


    }

    public int adventureCamp(String[] expeditions) {

        Set<String>[] list = new Set[expeditions.length];
        list[0] = Arrays.stream(expeditions[0].split("->")).filter(s -> s != "").collect(Collectors.toSet());
        for (int i = 1; i < expeditions.length; i++) {
            Set<String> tem = new HashSet<>();
            tem.addAll(Arrays.stream(expeditions[i].split("->")).filter(s -> s != "").collect(Collectors.toSet()));
            if (list[i - 1] != null) {
                tem.addAll(list[i - 1]);
            }
        }
        int ans = -1;
        int n = 0;
        for (int i = 1; i < list.length; i++) {
            Set<String> collect = Arrays.stream(expeditions[i].split("->")).filter(s -> s != "").collect(Collectors.toSet());
            Set<String> strings = list[i - 1];
            int a = 0;
            for (String s : collect) {
                if (strings != null && !strings.contains(s)) {
                    a++;
                }
            }
            if (a > n) {
                n = a;
                ans = i;
            }
        }

        return ans;

    }

    public int fieldOfGreatestBlessing(int[][] forceField) {
        List<Rectangle> list =new ArrayList<>();
        for (int[] ints : forceField) {
            float g = Float.valueOf(ints[2])/2;
            float l =ints[0]-g;
            float r = g+ints[0];

            float down = ints[1]-g;
            float up = g+ints[0];
            Rectangle rectangle = new Rectangle(l,up,r,down);
            list.add(rectangle);
        }

        int ans = 0;
        for (int i = 0; i < list.size(); i++) {
            int a= 0;
            Rectangle tem = new Rectangle();
            for (int j = 0; j < list.size(); j++) {
                if (i!=j){
                    Rectangle rectangle = list.get(i);
                    tem =list.get(j);
                    boolean cam = cam(list.get(i), tem);
                if (cam){
                    a++;

                }}
            }
            ans = Math.max(a,ans);
        }
        return  ans+1;
    }

    public boolean ret( Rectangle r1, Rectangle r2){
        Rectangle rectangle = new Rectangle();
        if (r1.PLx<=r2.PLx&&r1.PLy<r2.PLy){

        }
        return false;
    }
    public boolean cam( Rectangle r1, Rectangle r2){
        if(r1.PRy<=r2.PLy&&r1.PLy>=r2.PRy&&r1.PRx>=r2.PLx&&r1.PLx<=r2.PRx){
       return true;
     }

     return false;
    }
    class Rectangle {
        float PLx=0;
        float PLy=0;
        float PRx=0;
        float PRy=0;

        public Rectangle() {
        }

        public Rectangle(float PLx, float PLy, float PRx, float PRy) {
            this.PLx = PLx;
            this.PLy = PLy;
            this.PRx = PRx;
            this.PRy = PRy;
        }
    }
}
