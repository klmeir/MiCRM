package com.example.micrm.models;

/**
 * Created by klmeir on 12/9/2017.
 */

public class Actividad {

    private String descripcion;
    private String tipo;
    private Organizacion organizacion;
    private Persona persona;
    private Negocio negocio;
    private String fecha;
    private String hora;

    public Actividad(String descripcion) {
        this.descripcion = descripcion;
    }

    public Actividad(String descripcion, String tipo, Organizacion organizacion, Persona persona, Negocio negocio, String fecha, String hora) {
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

    public Negocio getNegocio() {
        return negocio;
    }

    public void setNegocio(Negocio negocio) {
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
