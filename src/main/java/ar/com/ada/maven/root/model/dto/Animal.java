package ar.com.ada.maven.root.model.dto;

import java.util.Date;

public class Animal {
    private Integer id;
    private String sex;
    private Date nacimiento;
    private Especie especie;
    private Pais pais;

    public Animal() {}

    public Animal(Integer id, String sex, Date nacimiento, Especie especie, Pais pais) {
        this.id = id;
        this.sex = sex;
        this.nacimiento = nacimiento;
        this.especie = especie;
        this.pais = pais;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "El id de Animal es: " + id +
                ". El sexo es: " + sex +
                ". La fecha de nacimiento: " + nacimiento +
                ". La especie es: " + especie +
                ". El pais es: " + pais;
    }
}
