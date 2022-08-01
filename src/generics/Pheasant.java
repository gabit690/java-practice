package generics;

public class Pheasant extends Pet implements Flying {

    public Pheasant(AnimalSpecie specie, String name) {
        super(specie, name);
    }

    public void cackle() {
        System.out.println("<CLUCK>");
    }

    @Override
    public void feed() {
        System.out.println("<Pheasant eating...>");
    }

    @Override
    public void flapWings() {
        System.out.println("<FLAP WINGS>");
    }
}
