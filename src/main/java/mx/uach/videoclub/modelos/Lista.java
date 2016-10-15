/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uach.videoclub.modelos;

import java.sql.Date;
import mx.uach.videoclub.modelos.genericos.Model;
import static mx.uach.videoclub.modelos.genericos.Model.ID;
import static mx.uach.videoclub.modelos.genericos.Model.fieldsToQuery;
import static mx.uach.videoclub.modelos.genericos.Model.paramsToStatement;
import static mx.uach.videoclub.modelos.genericos.Model.paramsToStatementToCreate;

/**
 * Definicion de los atributos de la clase Lista y sus metodos get y set.
 * @author Edgar Omar Peinado Garcia
 * @version 1.0
 */
public class Lista extends Model{
    
    public static final String TABLA = "Listas";
    
    public static final String[] FIELDS = {"id","socio_id", "fecha", "estatus", 
        "pelicula_id"};
    
    public static final String Q = String.format("SELECT %s FROM %s",
            fieldsToQuery(FIELDS, Boolean.FALSE), TABLA);
    
    public static final String INSERT_LISTA = 
            String.format("%s %s (%s) VALUES (%s);",
            Model.INSERT, TABLA, fieldsToQuery(FIELDS, Boolean.TRUE),
            paramsToStatement(FIELDS, Boolean.TRUE));
    
    public static final String UPDATE_LISTA = 
            String.format("%s %s SET %s WHERE %s = ?", 
            Model.UPDATE, TABLA, paramsToStatementToCreate(FIELDS, Boolean.TRUE),
            ID);

    public static final String DELETE_LISTA = 
            String.format("%s %s %s ?", Model.DELETE, TABLA, Model.Q_WHRE_ID);

    private Socio socio;
    private Date fecha;
    private String estatus;
    private Pelicula pelicula;

    public Lista() {
    }

    public Lista(Socio socio, Date fecha, String estatus, Pelicula pelicula) {
        this.socio = socio;
        this.fecha = fecha;
        this.estatus = estatus;
        this.pelicula = pelicula;
    }

    public Lista( Integer id, Socio socio, Date fecha, String estatus, Pelicula pelicula) {
        this(socio, fecha, estatus, pelicula);
        setId(id);
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }
    
}
