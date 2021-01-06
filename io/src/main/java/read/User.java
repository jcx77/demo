package read;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private B b;

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

    public User() {
    }

    public User(String name, B b) {
        this.name = name;
        this.b = b;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", b=" + b.toString() +
                '}';
    }
}
class B implements Serializable{
    private static final long serialVersionUID = 1L;
    int a;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public B(int a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "B{" +
                "a=" + a +
                '}';
    }
}
