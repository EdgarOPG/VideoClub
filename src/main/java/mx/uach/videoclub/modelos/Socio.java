/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uach.videoclub.modelos;

import mx.uach.videoclub.modelos.genericos.Model;
import static mx.uach.videoclub.modelos.genericos.Model.ID;
import static mx.uach.videoclub.modelos.genericos.Model.fieldsToQuery;
import static mx.uach.videoclub.modelos.genericos.Model.paramsToStatement;
import static mx.uach.videoclub.modelos.genericos.Model.paramsToStatementToCreate;

/**
 * Definicion de los atributos de la clase Socio y sus metodos get y set.
 * @author Edgar Omar Peinado Garcia
 * @version 1.0
 */
public class Socio extends Model{
    
    public static final String TABLA = "Socios";
    
    public static final String[] FIELDS = {"id", "nombre", "direccion", 
        "telefono"};
    
    public static final String Q = String.format("SELECT %s FROM %s",
            fieldsToQuery(FIELDS, Boolean.FALSE), TABLA);
    
    public static final String INSERT_SOCIO = 
            String.format("%s %s (%s) VALUES (%s);",
            Model.INSERT, TABLA, fieldsToQuery(FIELDS, Boolean.TRUE),
            paramsToStatement(FIELDS, Boolean.TRUE));
    
    public static final String UPDATE_SOCIO = 
            String.format("%s %s SET %s WHERE %s = ?", 
            Model.UPDATE, TABLA, paramsToStatementToCreate(FIELDS, Boolean.TRUE),
            ID);

    public static final String DELETE_SOCIO = 
            String.format("%s %s %s ?", Model.DELETE, TABLA, Model.Q_WHRE_ID);

    private String nombre;
    private String direccion;
    private String telefono;

    public Socio() {
    }

    public Socio(String nombre, String Direccion, String Telefono) {
        this.nombre = nombre;
        this.direccion = Direccion;
        this.telefono = Telefono;
    }

    public Socio(Integer id, String nombre, String Direccion, String Telefono) {
        this.nombre = nombre;
        this.direccion = Direccion;
        this.telefono = Telefono;
        this.setId(id);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String Direccion) {
        this.direccion = Direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String Telefono) {
        this.telefono = Telefono;
    }

    
    
}
