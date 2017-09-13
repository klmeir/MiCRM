package com.example.micrm.models;

/**
 * Created by klmeir on 12/9/2017.
 */

public class Negocio {

    private String titulo;
    private String descripcion;
    private Organizacion organizacion;
    private Persona persona;
    private double valor;
    private String fecha_cierre;
    private String estado;

    public Negocio(String titulo) {
        this.titulo = titulo;
    }

    public Negocio(String titulo, String descripcion, Organizacion organizacion, Persona persona, double valor, String fecha_cierre, String estado) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.organizacion = organizacion;
        this.persona = persona;
        this.valor = valor;
        this.fecha_cierre = fecha_cierre;
        this.estado = estado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Organizacion getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(Organizacion organizacion) {
        this.organizacion = organizacion;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getFecha_cierre() {
        return fecha_cierre;
    }

    public void setFecha_cierre(String fecha_cierre) {
        this.fecha_cierre = fecha_cierre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Negocio{" +
                "titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", organizacion=" + organizacion +
                ", persona=" + persona +
                ", valor=" + valor +
                ", fecha_cierre='" + fecha_cierre + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
