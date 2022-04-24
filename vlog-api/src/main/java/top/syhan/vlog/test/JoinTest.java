package top.syhan.vlog.test;

/**
 * @program: vlog-api
 * @description:
 * @author: SYH
 * @create: 2022-04-23 20:19
 **/
public class JoinTest {

    public static void main(String[] args) {
        try {
            ThreadA t1 = new ThreadA("t1");
            t1.start();
            t1.join();
            System.out.printf("%s finish\n", Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class ThreadA extends Thread {
        public ThreadA(String name) {
            super(name);
        }

        @Override
        public void run() {
            System.out.printf("%s start\n", this.getName());
            for (int i = 0; i < 1000000; i++)
                ;
            System.out.printf("%s finish\n", this.getName());
        }
    }
}
