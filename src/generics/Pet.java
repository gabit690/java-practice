package generics;

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
}
