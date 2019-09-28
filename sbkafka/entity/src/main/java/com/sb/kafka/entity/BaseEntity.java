package com.sb.kafka.entity;

import com.google.gson.Gson;

/**
 * @author : ljl
 * @date : 2019/9/28
 */
public interface BaseEntity {
    Gson gson = new Gson();

    default Object deSerializer(Object s){
        return s==null?null:gson.fromJson(s.toString(), this.getClass());
    }

    default String serializer(){
        return gson.toJson(this);
    }
}
