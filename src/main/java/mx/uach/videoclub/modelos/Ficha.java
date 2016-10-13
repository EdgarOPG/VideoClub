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
 * Definicion de los atributos de la clase Ficha y sus metodos get y set.
 * @author Edgar Omar Peinado Garcia
 * @version 1.0
 */
public class Ficha extends Model{
    public static final String TABLA = "Fichas";
    
    public static final String[] FIELDS = {"id", "socio_id", "fecha_prestamo"};
    
    public static final String Q = String.format("SELECT %s FROM %s",
            fieldsToQuery(FIELDS, Boolean.FALSE), TABLA);
    
    public static final String INSERT_FICHA = 
            String.format("%s %s (%s) VALUES (%s);",
            Model.INSERT, TABLA, fieldsToQuery(FIELDS, Boolean.TRUE),
            paramsToStatement(FIELDS, Boolean.TRUE));
    
    public static final String UPDATE_FICHA = 
            String.format("%s %s SET %s WHERE %s = ?", 
            Model.UPDATE, TABLA, paramsToStatementToCreate(FIELDS, Boolean.TRUE),
            ID);

    public static final String DELETE_FICHA = 
            String.format("%s %s %s ?", Model.DELETE, TABLA, Model.Q_WHRE_ID);
    
    private Date fechaPrestamo;
    private Socio socio;

    public Ficha() {
    }

    public Ficha(Socio socio,  Date fechaPrestamo) {
        this.socio = socio;
        this.fechaPrestamo = fechaPrestamo;
    }   

    public Ficha(Integer id, Socio socio,  Date fechaPrestamo) {
        this.socio = socio;
        this.fechaPrestamo = fechaPrestamo;
        setId(id);
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }
    
    
}
