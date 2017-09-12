package com.example.micrm.models;

/**
 * Created by klmeir on 12/9/2017.
 */

public class Negocio {

    private String titulo;
    private String descripcion;
    private String organizacion;
    private String persona;
    private String valor;
    private String fecha_cierre;
    private String estado;

    public Negocio(String titulo, String descripcion, String organizacion, String persona, String valor, String fecha_cierre, String estado) {
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

    public String getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(String organizacion) {
        this.organizacion = organizacion;
    }

    public String getPersona() {
        return persona;
    }

    public void setPersona(String persona) {
        this.persona = persona;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
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
                ", organizacion='" + organizacion + '\'' +
                ", persona='" + persona + '\'' +
                ", valor='" + valor + '\'' +
                ", fecha_cierre='" + fecha_cierre + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }

}
