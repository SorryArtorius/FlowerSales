package com.j16.service;

import java.lang.reflect.Type;
import java.util.List;

public interface TypeService {


    /**
     * 用于多对一
     * @param id
     * @return
     */
    Type getType(int id);


    /**
     * 获取所有类型
     * @return
     */
    List<Type> getTypeList();
}
