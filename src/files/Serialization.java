package files;

import java.io.*;

public class Serialization {

    public static void main(String[] args) {

        Person user = new Person("Gabit", 32);

        try {

            ObjectOutputStream sender = new ObjectOutputStream(new FileOutputStream("src/files/user.dat"));

            sender.writeObject(user);

            sender.close();

            ObjectInputStream receiver = new ObjectInputStream(new FileInputStream("src/files/user.dat"));

            Person data = (Person) receiver.readObject();

            System.out.println(data.toString());

        } catch (Exception e) {

            System.out.println("Error in Serialization");
        }

    }
}

class Person implements Serializable  {
    private String names;

    private int age;

    public Person(String name, int age) {
        this.names = name;
        this.age = age;
    }

    public String getName() {
        return names;
    }

    public void setName(String name) {
        this.names = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + names + '\'' +
                ", age=" + age +
                '}';
    }
}