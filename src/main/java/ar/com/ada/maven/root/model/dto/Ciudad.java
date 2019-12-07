package ar.com.ada.maven.root.model.dto;

public class Ciudad {
    private Integer id;
    private String nombre;
    private Pais pais;

    public Ciudad() {}

    public Ciudad(Integer id, String nombre, Pais pais) {
        this.id = id;
        this.nombre = nombre;
        this.pais = pais;
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

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "El id de la ciudad es: " + id +
                ". El nombre de la ciudad es: " + nombre +
                ". El pais es: " + pais ;
    }
}
