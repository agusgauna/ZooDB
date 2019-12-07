package ar.com.ada.maven.root.model.dto;

public class AnimalXZoo {
    private Integer id;
    private Zoo zoo;
    private Animal animal;

    public AnimalXZoo() {}

    public AnimalXZoo(Integer id, Zoo zoo, Animal animal) {
        this.id = id;
        this.zoo = zoo;
        this.animal = animal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Zoo getZoo() {
        return zoo;
    }

    public void setZoo(Zoo zoo) {
        this.zoo = zoo;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    @Override
    public String toString() {
        return "El id de AnimalxZoo es: " + id +
                ". El zoo es : " + zoo +
                ". El animal es: " + animal;
    }
}
