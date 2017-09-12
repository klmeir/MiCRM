package com.example.micrm.models;

/**
 * Created by klmeir on 12/9/2017.
 */

public class Actividad {

    private String descripcion;
    private String tipo;
    private String organizacion;
    private String persona;
    private String negocio;
    private String fecha;
    private String hora;


    public Actividad(String descripcion, String tipo, String organizacion, String persona, String negocio, String fecha, String hora) {
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.organizacion = organizacion;
        this.persona = persona;
        this.negocio = negocio;
        this.fecha = fecha;
        this.hora = hora;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    public String getNegocio() {
        return negocio;
    }

    public void setNegocio(String negocio) {
        this.negocio = negocio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "Actividad{" +
                "descripcion='" + descripcion + '\'' +
                ", tipo='" + tipo + '\'' +
                ", organizacion='" + organizacion + '\'' +
                ", persona='" + persona + '\'' +
                ", negocio='" + negocio + '\'' +
                ", fecha='" + fecha + '\'' +
                ", hora='" + hora + '\'' +
                '}';
    }

}
