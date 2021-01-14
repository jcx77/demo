package Model;

public class Person {
    private String name;
    private int age;
    private String lx;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, int age, String lx) {
        this.name = name;
        this.age = age;
        this.lx = lx;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLx() {
        return lx;
    }

    public void setLx(String lx) {
        this.lx = lx;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", lx='" + lx + '\'' +
                '}';
    }
}
