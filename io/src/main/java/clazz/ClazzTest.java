package clazz;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class ClazzTest {
    @Test
    public void clazz()throws Exception{
        Class clazz =Person.class;
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
}
