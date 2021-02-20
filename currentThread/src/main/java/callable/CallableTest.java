package callable;

import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {
//    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        FutureTask fu = new FutureTask(new MyThread());
//        new Thread(fu, "b").start();
//        String o = (String) fu.get();
//        System.out.println(o);
//    }

}

class MyThread implements Callable<String> {

    @Override
    public String call() throws Exception {
        return "ok";
    }
}

class Demo {
    class Super {
        int flag = 1;

        Super() {
            test();
        }

        void test() {
            System.out.println("Super.test() flag=" + flag);
        }
    }

    class Sub extends Super {
        Sub(int i) {
            flag = i;
            System.out.println("Sub.Sub()flag=" + flag);
        }

        void test() {
            System.out.println("Sub.test()flag=" + flag);
        }
    }
    //@Test
    public static void main(String[] args) {
        new Demo().new Sub(5);
    }
}
