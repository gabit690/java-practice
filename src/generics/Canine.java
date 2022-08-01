package generics;

public class Canine extends Pet implements Collecting {

    public Canine(AnimalSpecie specie, String name) {
        super(specie, name);
    }

    public void bark() {
        System.out.println("<WOOF>");
    }

    @Override
    public void feed() {
        System.out.println("<Canine eating...>");
    }

    @Override
    public void track() {
        System.out.println("<TRACK>>");
    }
}
