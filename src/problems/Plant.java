package problems;

import java.util.Objects;

public class Plant {
    private final String name;
    private PlantSize size = PlantSize.FETUS;

    public Plant(String name) {
        this.name = name;
    }

    public Plant(String name, PlantSize plantSize){
        this.name = name;
        this.size = plantSize;
    }

    public String getName() {
        return name;
    }

    public PlantSize getSize() {
        return size;
    }

    public void setSize(PlantSize size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Растение размера " + this.size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Plant plant)) return false;
        return getName().equals(plant.getName()) &&
                getSize() == plant.getSize();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSize());
    }
}
