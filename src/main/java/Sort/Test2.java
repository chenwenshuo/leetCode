package Sort;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.Test;

public class Test2 {

    @Test
    public  void test() {
        Good good =new Good("a","b");
        Good good1 =new Good("a","b");
        Good good2 =new Good("f","b");
        List<Good> list =new ArrayList<>();
        list.add(good1);
        list.add(good2);
        list.add(good);
       list.sort((a,b)->{
           if (a.a.equals("a")){
               return -1;
           }
           if (b.a.equals("a")){
               return 1;
           }
           return  0;
       });
        System.out.println(list.get(0));
    }

    private void update(Good good) {
        good.setA("g");
        good=new Good("c","d");

    }

    class Good{

        private  String a;

        private String b;

        public String getA() {
            return a;
        }

        public void setA(String a) {
            this.a = a;
        }

        public String getB() {
            return b;
        }

        public void setB(String b) {
            this.b = b;
        }

        public Good(String a, String b) {
            this.a = a;
            this.b = b;
        }
    }

}
