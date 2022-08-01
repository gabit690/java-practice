package generics;

public enum AnimalSpecie {

    MAMMAL, BIRD, REPTILE;

    public String getSpecie() {
        switch (this) {
            case MAMMAL -> {
                return "Mammal";
            }
            case BIRD -> {
                return "Bird";
            }
            case REPTILE -> {
                return "Reptile";
            }
            default -> {
                return null;
            }
        }
    }
}
