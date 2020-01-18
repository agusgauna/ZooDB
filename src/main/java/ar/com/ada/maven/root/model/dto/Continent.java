package ar.com.ada.maven.root.model.dto;

public class Continent {
    private Integer id;
    private String nombre;

    public Continent() {}

    public Continent(String nombre) {
        this.nombre = nombre;
    }

    public Continent(Integer id, String nombre) {
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
        return "Continent{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
