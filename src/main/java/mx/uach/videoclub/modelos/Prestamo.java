/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uach.videoclub.modelos;

import java.sql.Date;
import static mx.uach.videoclub.modelos.Pelicula.FIELDS;
import static mx.uach.videoclub.modelos.Pelicula.TABLA;
import mx.uach.videoclub.modelos.genericos.Model;
import static mx.uach.videoclub.modelos.genericos.Model.ID;
import static mx.uach.videoclub.modelos.genericos.Model.fieldsToQuery;
import static mx.uach.videoclub.modelos.genericos.Model.paramsToStatement;
import static mx.uach.videoclub.modelos.genericos.Model.paramsToStatementToCreate;

/**
 * Definicion de los atributos de la clase Prestamo y sus metodos get y set.
 * @author Edgar Omar Peinado Garcia
 * @version 1.0
 */
public class Prestamo extends Model{
    
    public static final String TABLA = "Cintas_fichas";
    
    public static final String[] FIELDS = {"ficha_id","dvd_id", "fecha_entrega", "estatus", 
        "director"};
    
    public static final String Q = String.format("SELECT %s FROM %s",
            fieldsToQuery(FIELDS, Boolean.FALSE), TABLA);
    
    public static final String INSERT_PRESTAMO = 
            String.format("%s %s (%s) VALUES (%s);",
            Model.INSERT, TABLA, fieldsToQuery(FIELDS, Boolean.TRUE),
            paramsToStatement(FIELDS, Boolean.TRUE));
    
    public static final String UPDATE_PRESTAMO = 
            String.format("%s %s SET %s WHERE %s = ?", 
            Model.UPDATE, TABLA, paramsToStatementToCreate(FIELDS, Boolean.TRUE),
            ID);

    public static final String DELETE_PRESTAMO = 
            String.format("%s %s %s ?", Model.DELETE, TABLA, Model.Q_WHRE_ID);

    private Integer fichaId;
    private Integer dvdId;
    private Date fechaEntrega;
    private String estatus;

    public Prestamo() {
    }

    public Prestamo(Integer fichaId, Integer dvdId, Date fechaEntrega, String estatus) {
        this.fichaId = fichaId;
        this.dvdId = dvdId;
        this.fechaEntrega = fechaEntrega;
        this.estatus = estatus;
    }

    public Prestamo(Integer id, Integer fichaId, Integer dvdId, Date fechaEntrega, String estatus) {
        this.fichaId = fichaId;
        this.dvdId = dvdId;
        this.fechaEntrega = fechaEntrega;
        this.estatus = estatus;
        setId(id);
    }

    public Integer getFichaId() {
        return fichaId;
    }

    public void setFichaId(Integer fichaId) {
        this.fichaId = fichaId;
    }

    public Integer getDvdId() {
        return dvdId;
    }

    public void setDvdId(Integer dvdId) {
        this.dvdId = dvdId;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
    
}
