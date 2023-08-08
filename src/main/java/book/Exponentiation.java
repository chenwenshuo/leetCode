package book;

import org.junit.Test;

public class Exponentiation {

    //Check for perfo
    // rmance issues and rewrite the code:
    @Test
    public void test(){
        System.out.println(ex(2,6));
    }
    public long ex(int a, int b) {
        if (b == 0) {
            return 1;
        }
        if (b == 1) {
            return a;
        }
        if (b % 2 == 0) {
            return ex(a * a, b / 2);
        } else {
            return ex(a * a, b / 2) * a;
        }
    }

}
