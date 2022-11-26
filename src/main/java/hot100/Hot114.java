package hot100;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class Hot114 {
    public static class MultiThread {

       volatile int num = 0;

        public static void main(String[] args) throws InterruptedException {
            MultiThread multiThread = new MultiThread();

            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10000; i++) {
                        multiThread.method1();
                    }
                }
            });
            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10000; i++) {
                        multiThread.method2();
                    }
                }
            });

            Thread t3 = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10000; i++) {
                        multiThread.method3();
                    }
                }
            });

            t1.start();
            t2.start();
            t3.start();

            TimeUnit.SECONDS.sleep(10);
            System.out.println(multiThread.num);
        }

        synchronized void method1() {
            num++;
        }

        void method2() {
            synchronized (this) {
                num++;
                //System.out.println(num);
            }
        }

        void method3() {
            synchronized (MultiThread.class) {
                num++;
            }
        }
    }
}
