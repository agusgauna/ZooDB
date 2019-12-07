package ar.com.ada.maven.root.model.dto;

public class Especie {
    private Integer id;
    private String nombreVulgar;
    private  String nombreCientifico;
    private boolean extincion;
    private Family family;

    public Especie() {}

    public Especie(Integer id, String nombreVulgar, String nombreCientifico, boolean extincion, Family family) {
        this.id = id;
        this.nombreVulgar = nombreVulgar;
        this.nombreCientifico = nombreCientifico;
        this.extincion = extincion;
        this.family = family;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreVulgar() {
        return nombreVulgar;
    }

    public void setNombreVulgar(String nombreVulgar) {
        this.nombreVulgar = nombreVulgar;
    }

    public String getNombreCientifico() {
        return nombreCientifico;
    }

    public void setNombreCientifico(String nombreCientifico) {
        this.nombreCientifico = nombreCientifico;
    }

    public boolean isExtincion() {
        return extincion;
    }

    public void setExtincion(boolean extincion) {
        this.extincion = extincion;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    @Override
    public String toString() {
        return "El id de la especie es: " + id +
                ". El nombre vulgar es: " + nombreVulgar +
                ". El nombre cientifico es: " + nombreCientifico + '\'' +
                ". Esta en peligro de extincion: " + extincion +
                ". La familia que pertenece: " + family;
    }
}
