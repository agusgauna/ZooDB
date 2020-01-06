package ar.com.ada.maven.root.model.dto;

public class Family {
    private Integer id;
    private String nombre;

    public Family() {}

    public Family(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "El id de la familia es: " + id +
                ". El nombre de la familia es: " + name;
    }
}
