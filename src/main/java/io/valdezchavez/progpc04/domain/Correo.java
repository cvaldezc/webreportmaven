package io.valdezchavez.progpc04.domain;

import java.io.Serializable;
import java.util.Objects;

public class Correo implements Serializable {

    private Integer idcorreo;
    private Cliente cliente;
    private String correo;

    public Correo() {}

    public Correo(String correo) {
        this.correo = correo;
    }

    public Correo(Cliente cliente, String correo) {
        this.cliente = cliente;
        this.correo = correo;
    }

    public Integer getIdcorreo() {
        return idcorreo;
    }

    public void setIdcorreo(Integer idcorreo) {
        this.idcorreo = idcorreo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Correo correo = (Correo) o;
        return Objects.equals(getIdcorreo(), correo.getIdcorreo());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getIdcorreo());
    }

    @Override
    public String toString() {
        return "Correo{" +
                "idcorreo=" + idcorreo +
                ", cliente=" + cliente +
                ", correo='" + correo + '\'' +
                '}';
    }
}
