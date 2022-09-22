package base;

import org.junit.Test;

/**
 * @Author: chenwenshuo
 * @Date: 2022/09/21/11:19
 */
public class BaseTest {

    @Test
    public void test1(){
        String s="1";
        int a=10;
        Integer i=10;
        test(s,a,i);
        System.out.println(a);
        System.out.println(s);
        System.out.println(i);
    }

    public void test(String s, int a, Integer i){
        s="test1";
        a=78;
        i=78;
        System.out.println(s);
    }
}
