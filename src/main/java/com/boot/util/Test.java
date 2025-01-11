package com.boot.util;

import com.boot.entity.user.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cglib.core.ReflectUtils;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args) {

        String date = "2023-12-11";

        LocalDate localDate = LocalDate.parse(date);

        System.out.println("date string : " + date + " ::: LocalDate : " + localDate);

        Field[] fields = User.class.getDeclaredFields();

        User user = new User(11L, "Ambuj", "Pathak", null, "ambuj@gmail.com", "Bangalore");

        Map<String, Object> res = jsonToMap(user);

        res.forEach((x, y) -> System.out.println(x+" :: "+y));// ::: "+y.getClass().getTypeName()));

        /*Arrays.stream(fields).forEach(f -> System.out.println(f.getInt(1)));


        User user = new User();
        System.out.println (ReflectUtils.get(user,"firstValue"));*/


    }

    public static Map<String, Object> jsonToMap(Object obj) {
        Map<String, Object> map = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        String jsonMessage = null;
        try {
            jsonMessage = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
            map = mapper.readValue(jsonMessage, new TypeReference<HashMap<String, Object>>() {});
            System.out.println(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    /*public static String queryBuilder(Map<String, Object> map, String tableName){
        StringBuilder query = new StringBuilder();
        query.append("SELECT * FROM "+tableName);
        int count = 0;
        if(!map.isEmpty()){
            map.forEach((k, v) -> {
                if(v != null && count == 0){
                    query.append(" ").append("where").append(" ").append(k).append(" ").append("=").append(valueBasedOnDatatype(v));
                } else if (v == null) {
                    query.append(" ").
                }
            });
        }
    }

    public static String valueBasedOnDatatype(Object obj){
        String objType = obj.getClass().getTypeName();
        if(objType.contains("String") && objType.contains("Date"))
            return "'"+obj+"'";
        else
            return obj.toString();
    }*/
}
