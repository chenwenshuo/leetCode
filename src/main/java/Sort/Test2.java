package Sort;



import org.junit.Test;

public class Test2 {

    @Test
    public  void test() {
        Good good =new Good("a","b");

        update(good);
        System.out.println(good.getA());
        System.out.println(good.getB());
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
