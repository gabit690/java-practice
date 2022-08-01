package generics;

public class Feline extends Pet implements Climbing {

    public Feline(AnimalSpecie specie, String petName) {
        super(specie, petName);
    }

    public void meow() {
        System.out.println("<MEOW>");
    }

    @Override
    public void feed() {
        System.out.println("<Feline eating...>");
    }

    @Override
    public void goUp() {
        System.out.println("<GO UP>");
    }

    @Override
    public void goDown() {
        System.out.println("<GO DOWN>");
    }
}
