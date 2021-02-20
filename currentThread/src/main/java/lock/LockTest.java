package lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    @org.junit.Test
    public void test() {
        Ticket1 t = new Ticket1();
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
     * @Description: TODO(使用lock 保证线程同步)
     * @Param:
     * @return:
     * @Author: zcx
     * @Date: 2021/2/7 8:42
     */
    class Ticket1 {
        Lock lock = new ReentrantLock();
        private int num;

        public void setNum(int num) {
            this.num = num;
        }

        public void sell() {
            lock.lock();
            try {
                if (num > 0) {
                    num--;
                    System.out.println(Thread.currentThread().getName() + "剩余" + num);
                }
            } finally {
                lock.unlock();
            }
        }
    }
}
