package proxy;
/**
* @Description: TODO(静态代理 )
* @Param:
* @return:
* @Author: zcx
* @Date: 2021/1/11 10:32
*/
interface Factory{
   void make();
}
class StaticProxyFactory implements Factory{
    private Factory factory;

    public StaticProxyFactory(Factory factory) {
        this.factory = factory;
    }

    public void make() {

        System.out.println("ok1");
        factory.make();
        System.out.println("ok2");
    }
}
class Nike implements Factory{
    public void make() {
        System.out.println("nike");
    }
}
public class StaticProxyTest {
    public static void main(String[] args) {
        Nike n=new Nike();
        new StaticProxyFactory(n).make();
    }

}
