package lock;

import org.junit.Test;

import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockNumberTest {
    Lock lock = new ReentrantLock();
    Condition con1 = lock.newCondition();
    Condition con2 = lock.newCondition();
    Condition con3 = lock.newCondition();
    int number = 1;

    @Test
    public void Test() {
        //ConCurrentHashMap
        //CopyOnWriteArraySet
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                printA();
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                printB();
            }
        },"B").start();new Thread(()->{
            for (int i = 0; i < 10; i++) {
                printC();
            }
        },"C").start();

    }

    public void printA() {
        lock.lock();
        try {
            while (number != 1) {
                con1.await();
            }
            System.out.println(Thread.currentThread().getName() + "->AAA");
            number = 2;
            con2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printB() {
        lock.lock();
        try {
            while (number != 2) {
                con2.await();
            }
            System.out.println(Thread.currentThread().getName() + "->BBB");
            number = 3;
            con3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printC() {
        lock.lock();
        try {
            while (number != 3) {
                con3.await();
            }
            System.out.println(Thread.currentThread().getName() + "->CCC");
            number = 1;
            con1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
