package ar.com.ada.maven.root.model.dto;

public class Zoo {
    private Integer id;
    private String nombre;
    private String tamaño;
    private Integer presupuesto;
    private Ciudad ciudad;

    public Zoo() {}

    public Zoo(Integer id, String nombre, String tamaño, Integer presupuesto, Ciudad ciudad) {
        this.id = id;
        this.nombre = nombre;
        this.tamaño = tamaño;
        this.presupuesto = presupuesto;
        this.ciudad = ciudad;
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

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    public Integer getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(Integer presupuesto) {
        this.presupuesto = presupuesto;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return "El id del Zoo: " + id +
                ". El nombre del Zoo es: " + nombre +
                ". El tamaño del Zoo es: " + tamaño +
                ". El presupuesto es: " + presupuesto +
                ". La ciudad es: " + ciudad;
    }
}
