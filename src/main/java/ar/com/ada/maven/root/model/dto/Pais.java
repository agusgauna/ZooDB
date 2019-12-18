package ar.com.ada.maven.root.model.dto;

public class Pais {
    private Integer id;
    private String nombre;
    private Continent continent;

    public Pais() {}

    public Pais(Integer id, String nombre, Continent continent) {
        this.id = id;
        this.nombre = nombre;
        this.continent = continent;
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

    public Continent getContinent() {
        return continent;
    }

    public void setContinent(Continent continent) {
        this.continent = continent;
    }

    @Override
    public String toString() {
        return "El id del pais es: " + id +
                ". El nombre del pais es :" + nombre +
                ". " + continent;
    }
}
