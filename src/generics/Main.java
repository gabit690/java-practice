package generics;

public class Main {

    public static void main(String[] args) {

        TierGrouping<Pet> animals = new TierGrouping<>();

        Feline cat1 = new Feline(AnimalSpecie.MAMMAL, "Tomas");

        Canine dog21 = new Canine(AnimalSpecie.MAMMAL, "Rambo");
        Canine dog22 = new Canine(AnimalSpecie.MAMMAL, "Jazmin");

        Pheasant chicken = new Pheasant(AnimalSpecie.BIRD, "Patricia");

        Feline cat31 = new Feline(AnimalSpecie.MAMMAL, "Moncho");

        animals.addElement(cat1, 1);

        animals.addElement(dog21, 2);
        animals.addElement(dog22, 2);

        animals.addElement(chicken, 3);

        animals.addElement(cat31, 4);

        System.out.println(animals);

        animals.removeElement(chicken, 3);

        System.out.println(animals);

    }
}
