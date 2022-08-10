package com.j16.service.impl;

import com.j16.dao.DetailDao;
import com.j16.dao.TypeDao;
import com.j16.service.TypeService;
import com.j16.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.Type;
import java.util.List;

public class TypeServiceImpl implements TypeService {

    public Type getType(int id) {
        SqlSession sqlSession = MyBatisUtil.createSqlSession();
        try {
            TypeDao typeDao = sqlSession.getMapper(TypeDao.class);
            return typeDao.getType(id);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return null;
    }


    public List<Type> getTypeList() {
        SqlSession sqlSession = MyBatisUtil.createSqlSession();
        try {
            TypeDao typeDao = sqlSession.getMapper(TypeDao.class);
            return typeDao.getTypeList();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return null;
    }
}
