package com.j16.service.impl;

import com.j16.dao.DetailDao;
import com.j16.pojo.Detail;
import com.j16.service.DetailService;
import com.j16.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class DetailServiceImpl implements DetailService {

    public List<Detail> showFlowers() {
        SqlSession sqlSession = MyBatisUtil.createSqlSession();
        try {
            DetailDao detailDao = sqlSession.getMapper(DetailDao.class);
            return detailDao.showFlowers();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return null;
    }

    @Override
    public List<Detail> getFlowers(int typeId) {
        SqlSession sqlSession = MyBatisUtil.createSqlSession();
        try {
            DetailDao detailDao = sqlSession.getMapper(DetailDao.class);
            return detailDao.getFlowers(typeId);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return null;
    }

    @Override
    public int addDetail(Detail detail) {
        SqlSession sqlSession = MyBatisUtil.createSqlSession();
        try {
            DetailDao detailDao = sqlSession.getMapper(DetailDao.class);
            return detailDao.addDetail(detail);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return 0;
    }


}
