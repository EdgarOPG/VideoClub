/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uach.videoclub.modelos.genericos;

import java.util.Arrays;
import java.util.List;

/**
 * Modelo general de todo el sistema
 *
 * @author edgar
 * @version 1.0
 */
public class Model {
    
    public static final String Q_WHERE_ID = "WHERE id =";
    
    private Integer id;

    public Model() {
    }

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public static String fieldsToQuery(String[] fields){
    String campos = "";
    List<String> fieldsList = Arrays.asList(fields);
    for (String field : fieldsList){
        campos = String.format("%s, %s", campos, field);
    }
    return campos.substring(1);
}
        
}
