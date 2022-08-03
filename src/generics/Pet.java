package generics;

import java.util.Objects;

public abstract class Pet {

    private AnimalSpecie _specie;

    private String _name;

    public Pet(AnimalSpecie specie, String name) {
        this._specie = specie;
        this._name = name;
    }

    public abstract void feed();

    public void setSpecie(AnimalSpecie specie) {
        this._specie = specie;
    }

    public AnimalSpecie getSpecie() {
        return this._specie;
    }

    public void setName(String name) {
        this._name = name;
    }

    public String getName() {
        return this._name;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this._name) + Objects.hashCode(this.getSpecie());
    }

    @Override
    public boolean equals(Object obj) {
        Pet p = (Pet) obj;
        return this._name.equals(p.getName()) && this._specie.equals(p.getSpecie());
    }

    @Override
    public String toString() {
        return "Pet{" +
                "_specie=" + _specie +
                ", _name='" + _name + '\'' +
                '}';
    }
}
