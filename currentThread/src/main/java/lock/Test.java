package lock;

import sun.security.krb5.internal.Ticket;

public class Test {
    public static void main(String[] args) {
        System.out.println(1);

    }

    /**
     * @Description: TODO()
     * @Param: []
     * @return: void
     * @Author: zcx
     * @Date: 2021/2/7 8:41
     */
    @org.junit.Test
    public void test() {
        Ticket t = new Ticket();
        t.setNum(20);
        new Thread(() -> {
            for (int i = 1; i < 40; i++) {
                t.sell();
            }
        }, "1").start();
        new Thread(() -> {
            for (int i = 1; i < 40; i++) {
                t.sell();
            }
        }, "2").start();
        new Thread(() -> {
            for (int i = 1; i < 40; i++) {
                t.sell();
            }
        }, "3").start();
    }

    /**
     * @Description: TODO(使用synchronized 保证线程同步)
     * @Param:
     * @return:
     * @Author: zcx
     * @Date: 2021/2/7 8:42
     */
    class Ticket {
        private int num;

        public void setNum(int num) {
            this.num = num;
        }

        public synchronized void sell() {
            if (num > 0) {
                num--;
                System.out.println(Thread.currentThread().getName() + "剩余" + num);
            }

        }
    }

}
