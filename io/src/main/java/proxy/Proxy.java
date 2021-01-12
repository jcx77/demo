package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Description: TODO(动态代理)
 * @Param:
 * @return:
 * @Author: zcx
 * @Date: 2021/1/11 11:20
 */
public class Proxy {

    public static void main(String[] args) {
        Factory f = (Factory)ProxyFactory.getProxyInstance(new Nike());
        f.make();
    }
}

interface Man {
    void show();
}

class SuperMan implements Man {
    public void show() {
        System.out.println("男");
    }
}

class ProxyFactory {
    public static Object getProxyInstance(Object obj) {
        MyInvocationHander myInvocationHander=new MyInvocationHander();
        myInvocationHander.bind(obj);
        return java.lang.reflect.Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),myInvocationHander);
    }
}

class MyInvocationHander implements InvocationHandler {
    private Object obj;

    public void bind(Object obj) {
        this.obj = obj;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        return method.invoke(obj, args);
    }
}