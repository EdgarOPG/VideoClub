/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uach.videoclub.dao.jdbc;

import java.lang.reflect.Field;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import mx.uach.videoclub.modelos.Director;

/**
 *
 * @author edgar
 */
public class VideoDaoJDBCDynamic {
    
    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException {
        Director dir = new Director(1, "Edgar");
        VideoDaoJDBCDynamic dyn = new VideoDaoJDBCDynamic();
        dyn.getFields(dir, "Edgar", "Peinado", "Garcia");
    }

    public VideoDaoJDBCDynamic() {
    }
    
    public String getFields(Object obj, String ... args) throws IllegalAccessException, NoSuchFieldException {
        Object objectInstance = new Object();
        String query = "";
        Field table = obj.getClass().getField("TABLA");
        Field fields = obj.getClass().getField("FIELDS");
        ArrayList<String> listFields = new ArrayList<>();
        String value;
        String[] fieldsValues = (String[]) fields.get(obj); 
        System.out.println(table.get(objectInstance));        
        for (String fieldsValue : fieldsValues) {
            value = fieldsValue;
            listFields.add(value);
        }
        query = String.format("%s, %s", query, Arrays.toString(args));
        System.out.println(listFields);
        System.out.println(query);
        return query;
    }
}