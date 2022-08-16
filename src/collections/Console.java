package collections;

import java.util.Objects;

public class Console implements Comparable<Console> {

    private String name;

    private int releaseYear;

    private String owner;

    public Console(String name, int releaseYear, String owner) {
        this.name = name;
        this.releaseYear = releaseYear;
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.name);
    }

    @Override
    public boolean equals(Object obj) {
        Console console = (Console) obj;
        return this.name.equals(console.getName());
    }

    @Override
    public String toString() {
        return "Console{" +
                "name='" + name + '\'' +
                ", releaseYear=" + releaseYear +
                ", owner='" + owner + '\'' +
                '}';
    }


    @Override
    public int compareTo(Console o) {
        return this.releaseYear - o.getReleaseYear();
    }
}
