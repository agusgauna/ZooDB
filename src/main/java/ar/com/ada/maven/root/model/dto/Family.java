package ar.com.ada.maven.root.model.dto;

public class Family {
    private Integer id;
    private String name;

    public Family() {}

    public Family(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "El id de la familia es: " + id +
                ". El nombre de la familia es: " + name;
    }
}
