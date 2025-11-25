package jingdian150;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

public class Jdto75 {

    //path = "/home/user/Documents/../Pictures"
    //
    //输出："/home/user/Pictures"
    //"/../"
    public String simplifyPath(String path) {

        Deque<String> stack = new LinkedList<>();

        String[] split = path.split("/");
        for (String s : split) {

            if (Objects.equals(s, "")) continue;
            if (".".equals(s)) continue;
            if ("..".equals(s)) {
                stack.poll();
                continue;
            }
            if (stack.isEmpty()) {
                stack.push(s);
                continue;
            }

            stack.push(s);
        }
        StringBuilder ans = new StringBuilder();
        if (stack.isEmpty()) ans=new StringBuilder("/");
        while (!stack.isEmpty()) {
            ans.insert(0, "/" + stack.poll());
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String s = "//ss..//sss//////s";
        System.out.println(Arrays.toString(s.split("/")));
    }
}
