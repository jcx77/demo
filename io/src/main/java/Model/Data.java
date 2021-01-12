package Model;

import com.github.javafaker.Faker;

import java.util.*;

public class Data {
    private List<Person> list =new ArrayList<>();
    static Map<String,Object> map=new HashMap<>();
    {
        Faker fk=new Faker( Locale.SIMPLIFIED_CHINESE);
        list.add(new Person(fk.name().name(), fk.number().randomDigit()));
        list.add(new Person(fk.name().name(), fk.number().randomDigit()));
        list.add(new Person(fk.name().name(), fk.number().randomDigit()));
        list.add(new Person(fk.name().name(), fk.number().randomDigit()));
        list.add(new Person(fk.name().name(), fk.number().randomDigit()));
        list.add(new Person(fk.name().name(), fk.number().randomDigit()));
        list.add(new Person(fk.name().name(), fk.number().randomDigit()));
        list.add(new Person(fk.name().name(), fk.number().randomDigit()));
    }

    public List<Person> getList(){
        return this.list;
    }
    public static void main(String[] args) {
        Faker fk=new Faker( Locale.SIMPLIFIED_CHINESE);
        System.out.println(fk.name().name());
    }
}
