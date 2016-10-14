/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uach.videoclub.modelos;

import mx.uach.videoclub.modelos.genericos.Model;

/**
 * Definicion de los atributos de la clase Cinta y sus metodos get y set.
 * @author Edgar Omar Peinado Garcia
 * @version 1.0
 */
public class Cinta extends Model{
    
    public static final String TABLA = "Cintas";
    
    public static final String[] FIELDS = {"id", "pelicula_id", "numero_copia"};
    
    public static final String Q = String.format("SELECT %s FROM %s",
            fieldsToQuery(FIELDS, Boolean.FALSE), TABLA);
    
    public static final String INSERT_CINTA = 
            String.format("%s %s (%s) VALUES (%s);",
            Model.INSERT, TABLA, fieldsToQuery(FIELDS, Boolean.TRUE),
            paramsToStatement(FIELDS, Boolean.TRUE));
    
    public static final String UPDATE_CINTA = 
            String.format("%s %s SET %s WHERE %s = ?", 
            Model.UPDATE, TABLA, paramsToStatementToCreate(FIELDS, Boolean.TRUE),
            ID);

    public static final String DELETE_CINTA = 
            String.format("%s %s %s ?", Model.DELETE, TABLA, Model.Q_WHRE_ID);

    private Integer peliculaId;
    private String numeroCopia;

    public Cinta() {
    }
    
    /**
    * Modelo general de todo el sistema
    * @author Edgar Omar Peinado Garcia
    * @version 1.0
    */
    public Cinta(Integer id) {
        setId(id);
    }

    public Cinta(Integer peliculaId, String numeroCopia) {
        this.peliculaId = peliculaId;
        this.numeroCopia = numeroCopia;
    }

    public Cinta(Integer id, Integer peliculaId, String numeroCopia) {
        this.peliculaId = peliculaId;
        this.numeroCopia = numeroCopia;
        setId(id);
    }

    public Integer getPeliculaId() {
        return peliculaId;
    }

    public void setPeliculaId(Integer peliculaId) {
        this.peliculaId = peliculaId;
    }

    public String getNumeroCopia() {
        return numeroCopia;
    }

    public void setNumeroCopia(String numeroCopia) {
        this.numeroCopia = numeroCopia;
    }
    
    
}
