package jingdian150;

import java.util.Deque;
import java.util.LinkedList;

public class Idto150 {

    //示例 1：
    //
    //输入：tokens = ["2","1","+","3","*"]
    //输出：9
    //解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
    //示例 2：
    //
    //输入：tokens = ["4","13","5","/","+"]
    //输出：6
    //解释：该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6
    //示例 3
    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"4","13","5","/","+"}));
    }
    public static int evalRPN(String[] tokens) {
      //  int ans = Integer.parseInt(tokens[0]);

        Deque<Integer> deque = new LinkedList<>();
        for (String token : tokens) {

            if (deque.isEmpty()) {
                deque.push(Integer.parseInt(token));
                continue;
            }
            // 1 2 2 4* /
            if ("*".equals(token)) {
                int a = deque.poll() * deque.poll();
                deque.push(a);
                continue;
            }
            if ("/".equals(token)) {
                int a = deque.poll();
                int b = deque.poll();
                deque.push(b / a);
                continue;
            }
            if ("+".equals(token)) {
                deque.push(deque.poll() + deque.poll());
                continue;
            }
            if ("-".equals(token)) {
                int a = deque.poll();
                int b = deque.poll();
                deque.push(b - a);
                continue;
            }
            deque.push(Integer.parseInt(token));
        }

        return deque.poll();
    }
}
