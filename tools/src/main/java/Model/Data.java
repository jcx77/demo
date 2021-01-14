package Model;

import com.github.javafaker.Faker;

import java.util.*;

public class Data {
    private static List<Person> list =new ArrayList<>();
    static Map<String,Object> map=new HashMap<>();
    static {
        Faker fk=new Faker(Locale.SIMPLIFIED_CHINESE);
        for (int i = 0; i < 10000; i++) {
            list.add(new Person(fk.name().name(), fk.number().randomDigit(),"1"));
        }
        for (int i = 0; i < 10; i++) {
            list.add(new Person(fk.name().name(), fk.number().randomDigit(),"2"));
        }
        for (int i = 0; i < 10; i++) {
            list.add(new Person(fk.name().name(), fk.number().randomDigit(),"3"));
        }
    }

    public List<Person> getList(){
        return this.list;
    }
    public static void main(String[] args) {
        Faker fk=new Faker( Locale.SIMPLIFIED_CHINESE);
        System.out.println(fk.name().name());
    }
}
