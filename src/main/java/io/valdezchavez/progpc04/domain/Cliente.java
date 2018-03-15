package io.valdezchavez.progpc04.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Cliente implements Serializable {

    private Integer idCliente;
    private String nombres;
    private String apellidos;
    private String nacimiento;

    public Cliente() {}

    public Cliente(String nombres, String apellidos, String nacimiento) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.nacimiento = nacimiento;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(idCliente, cliente.idCliente);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idCliente);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente=" + idCliente +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", nacimiento=" + nacimiento +
                '}';
    }
}
