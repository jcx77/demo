package clazz;

import Model.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
* @Description: TODO(反射)
* @Param: 
* @return: 
* @Author: zcx
* @Date: 2021/1/6 15:18
*/
public class ClazzTest {
    @Test
    public void clazz()throws Exception{
        Class clazz = Person.class;
        Constructor con = clazz.getConstructor(String.class, int.class);
        Object zxc = con.newInstance("zxc", 23);
        System.out.println(zxc);
        Field age = clazz.getDeclaredField("age");
        age.set(zxc,123);
        System.out.println(zxc);


        System.out.println("********************");
        Constructor cd = clazz.getDeclaredConstructor(String.class);
        cd.setAccessible(true);
        Person ss =(Person) cd.newInstance("ss");
        System.out.println(ss);
    }
    /**
    * @Description: TODO(通过反射获取权限修饰符)
    * @Param: []
    * @return: void
    * @Author: zcx
    * @Date: 2021/1/7 9:43
    */
    @Test
    public void getDeclared(){
        Class clazz =Person.class;
        Field[] df = clazz.getDeclaredFields();
        for (Field f : df) {
            int m = f.getModifiers();
            System.out.println(Modifier.toString(m));
        }
    }
    /**
    * @Description: TODO(获取class方法)
    * @Param: []
    * @return: void
    * @Author: zcx
    * @Date: 2021/1/7 9:56
    */
    @Test
    public void getMethods(){
        Class clazz =Person.class;
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
    }
}
