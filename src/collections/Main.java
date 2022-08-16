package collections;

import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        Set<Console> consoles = new TreeSet<>();

        Console c1 = new Console("Nes", 1980, "Nintendo");
        Console c2 = new Console("Sega", 1985, "Sega");
        Console c3 = new Console("Psx", 1992, "Playstation");

        consoles.add(c1);
        consoles.add(c2);
        consoles.add(c3);

        for (Console c: consoles) {
            System.out.println(c);
        }
    }
}
